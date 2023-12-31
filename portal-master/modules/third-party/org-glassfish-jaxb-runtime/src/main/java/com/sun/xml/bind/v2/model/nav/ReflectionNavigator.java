/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.sun.xml.bind.v2.model.nav;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collection;

import com.sun.xml.bind.v2.runtime.Location;

/**
 * {@link Navigator} implementation for {@code java.lang.reflect}.
 *
 */
/*package*/final class ReflectionNavigator implements Navigator<Type, Class, Field, Method> {

//  ----------  Singleton -----------------
    private static final ReflectionNavigator INSTANCE = new ReflectionNavigator();

    /*package*/static ReflectionNavigator getInstance() {
        return INSTANCE;
    }

    private ReflectionNavigator() {
    }
//  ---------------------------------------

    public Class getSuperClass(Class clazz) {
        if (clazz == Object.class) {
            return null;
        }
        Class sc = clazz.getSuperclass();
        if (sc == null) {
            sc = Object.class;        // error recovery
        }
        return sc;
    }

    private static final TypeVisitor<Type, Class> baseClassFinder = new TypeVisitor<Type, Class>() {

        public Type onClass(Class c, Class sup) {
            // t is a raw type
            if (sup == c) {
                return sup;
            }

            Type r;

            Type sc = c.getGenericSuperclass();
            if (sc != null) {
                r = visit(sc, sup);
                if (r != null) {
                    return r;
                }
            }

            for (Type i : c.getGenericInterfaces()) {
                r = visit(i, sup);
                if (r != null) {
                    return r;
                }
            }

            return null;
        }

        public Type onParameterizdType(ParameterizedType p, Class sup) {
            Class raw = (Class) p.getRawType();
            if (raw == sup) {
                // p is of the form sup<...>
                return p;
            } else {
                // recursively visit super class/interfaces
                Type r = raw.getGenericSuperclass();
                if (r != null) {
                    r = visit(bind(r, raw, p), sup);
                }
                if (r != null) {
                    return r;
                }
                for (Type i : raw.getGenericInterfaces()) {
                    r = visit(bind(i, raw, p), sup);
                    if (r != null) {
                        return r;
                    }
                }
                return null;
            }
        }

        public Type onGenericArray(GenericArrayType g, Class sup) {
            // not clear what I should do here
            return null;
        }

        public Type onVariable(TypeVariable v, Class sup) {
            return visit(v.getBounds()[0], sup);
        }

        public Type onWildcard(WildcardType w, Class sup) {
            // not clear what I should do here
            return null;
        }

        /**
         * Replaces the type variables in {@code t} by its actual arguments.
         *
         * @param decl
         *      provides a list of type variables. See {@link GenericDeclaration#getTypeParameters()}
         * @param args
         *      actual arguments. See {@link ParameterizedType#getActualTypeArguments()}
         */
        private Type bind(Type t, GenericDeclaration decl, ParameterizedType args) {
            return binder.visit(t, new BinderArg(decl, args.getActualTypeArguments()));
        }
    };

    private static class BinderArg {

        final TypeVariable[] params;
        final Type[] args;

        BinderArg(TypeVariable[] params, Type[] args) {
            this.params = params;
            this.args = args;
            assert params.length == args.length;
        }

        public BinderArg(GenericDeclaration decl, Type[] args) {
            this(decl.getTypeParameters(), args);
        }

        Type replace(TypeVariable v) {
            for (int i = 0; i < params.length; i++) {
                if (params[i].equals(v)) {
                    return args[i];
                }
            }
            return v;   // this is a free variable
        }
    }
    private static final TypeVisitor<Type, BinderArg> binder = new TypeVisitor<Type, BinderArg>() {

        public Type onClass(Class c, BinderArg args) {
            return c;
        }

        public Type onParameterizdType(ParameterizedType p, BinderArg args) {
            Type[] params = p.getActualTypeArguments();

            boolean different = false;
            for (int i = 0; i < params.length; i++) {
                Type t = params[i];
                params[i] = visit(t, args);
                different |= t != params[i];
            }

            Type newOwner = p.getOwnerType();
            if (newOwner != null) {
                newOwner = visit(newOwner, args);
            }
            different |= p.getOwnerType() != newOwner;

            if (!different) {
                return p;
            }

            return new ParameterizedTypeImpl((Class<?>) p.getRawType(), params, newOwner);
        }

        public Type onGenericArray(GenericArrayType g, BinderArg types) {
            Type c = visit(g.getGenericComponentType(), types);
            if (c == g.getGenericComponentType()) {
                return g;
            }

            return new GenericArrayTypeImpl(c);
        }

        public Type onVariable(TypeVariable v, BinderArg types) {
            return types.replace(v);
        }

        public Type onWildcard(WildcardType w, BinderArg types) {
            // TODO: this is probably still incorrect
            // bind( "? extends T" ) with T= "? extends Foo" should be "? extends Foo",
            // not "? extends (? extends Foo)"
            Type[] lb = w.getLowerBounds();
            Type[] ub = w.getUpperBounds();
            boolean diff = false;

            for (int i = 0; i < lb.length; i++) {
                Type t = lb[i];
                lb[i] = visit(t, types);
                diff |= (t != lb[i]);
            }

            for (int i = 0; i < ub.length; i++) {
                Type t = ub[i];
                ub[i] = visit(t, types);
                diff |= (t != ub[i]);
            }

            if (!diff) {
                return w;
            }

            return new WildcardTypeImpl(lb, ub);
        }
    };

    public Type getBaseClass(Type t, Class sup) {
        return baseClassFinder.visit(t, sup);
    }

    public String getClassName(Class clazz) {
        return clazz.getName();
    }

    public String getTypeName(Type type) {
        if (type instanceof Class) {
            Class c = (Class) type;
            if (c.isArray()) {
                return getTypeName(c.getComponentType()) + "[]";
            }
            return c.getName();
        }
        return type.toString();
    }

    public String getClassShortName(Class clazz) {
        return clazz.getSimpleName();
    }

    public Collection<? extends Field> getDeclaredFields(final Class clazz) {
        Field[] fields = AccessController.doPrivileged(new PrivilegedAction<Field[]>() {
            @Override
            public Field[] run() {
                return clazz.getDeclaredFields();
            }
        });
        return Arrays.asList(fields);
    }

    public Field getDeclaredField(final Class clazz, final String fieldName) {
        return AccessController.doPrivileged(new PrivilegedAction<Field>() {
            @Override
            public Field run() {
                try {
                    return clazz.getDeclaredField(fieldName);
                } catch (NoSuchFieldException e) {
                    return null;
                }
            }
        });
    }

    public Collection<? extends Method> getDeclaredMethods(final Class clazz) {
        Method[] methods =
            AccessController.doPrivileged(new PrivilegedAction<Method[]>() {
                @Override
                public Method[] run() {
                    return clazz.getDeclaredMethods();
                }
            });
        return Arrays.asList(methods);
    }

    public Class getDeclaringClassForField(Field field) {
        return field.getDeclaringClass();
    }

    public Class getDeclaringClassForMethod(Method method) {
        return method.getDeclaringClass();
    }

    public Type getFieldType(Field field) {
        if (field.getType().isArray()) {
            Class c = field.getType().getComponentType();
            if (c.isPrimitive()) {
                return Array.newInstance(c, 0).getClass();
            }
        }
        return fix(field.getGenericType());
    }

    public String getFieldName(Field field) {
        return field.getName();
    }

    public String getMethodName(Method method) {
        return method.getName();
    }

    public Type getReturnType(Method method) {
        return fix(method.getGenericReturnType());
    }

    public Type[] getMethodParameters(Method method) {
        return method.getGenericParameterTypes();
    }

    public boolean isStaticMethod(Method method) {
        return Modifier.isStatic(method.getModifiers());
    }

    public boolean isFinalMethod(Method method) {
        return Modifier.isFinal(method.getModifiers());
    }

    public boolean isSubClassOf(Type sub, Type sup) {
        return erasure(sup).isAssignableFrom(erasure(sub));
    }

    public Class ref(Class c) {
        return c;
    }

    public Class use(Class c) {
        return c;
    }

    public Class asDecl(Type t) {
        return erasure(t);
    }

    public Class asDecl(Class c) {
        return c;
    }
    /**
     * Implements the logic for {@link #erasure(Type)}.
     */
    private static final TypeVisitor<Class, Void> eraser = new TypeVisitor<Class, Void>() {

        public Class onClass(Class c, Void v) {
            return c;
        }

        public Class onParameterizdType(ParameterizedType p, Void v) {
            // TODO: why getRawType returns Type? not Class?
            return visit(p.getRawType(), null);
        }

        public Class onGenericArray(GenericArrayType g, Void v) {
            return Array.newInstance(
                    visit(g.getGenericComponentType(), null),
                    0).getClass();
        }

        public Class onVariable(TypeVariable tv, Void v) {
            return visit(tv.getBounds()[0], null);
        }

        public Class onWildcard(WildcardType w, Void v) {
            return visit(w.getUpperBounds()[0], null);
        }
    };

    /**
     * Returns the runtime representation of the given type.
     *
     * This corresponds to the notion of the erasure in JSR-14.
     *
     * <p>
     * Because of the difference in the way Annotation Processing and the Java reflection
     * treats primitive type and array type, we can't define this method
     * on {@link Navigator}.
     *
     * <p>
     * It made me realize how difficult it is to define the common navigation
     * layer for two different underlying reflection library. The other way
     * is to throw away the entire parameterization and go to the wrapper approach.
     */
    public <T> Class<T> erasure(Type t) {
        return eraser.visit(t, null);
    }

    public boolean isAbstract(Class clazz) {
        return Modifier.isAbstract(clazz.getModifiers());
    }

    public boolean isFinal(Class clazz) {
        return Modifier.isFinal(clazz.getModifiers());
    }

    /**
     * Returns the {@link Type} object that represents {@code clazz<T1,T2,T3>}.
     */
    public Type createParameterizedType(Class rawType, Type... arguments) {
        return new ParameterizedTypeImpl(rawType, arguments, null);
    }

    public boolean isArray(Type t) {
        if (t instanceof Class) {
            Class c = (Class) t;
            return c.isArray();
        }
        if (t instanceof GenericArrayType) {
            return true;
        }
        return false;
    }

    public boolean isArrayButNotByteArray(Type t) {
        if (t instanceof Class) {
            Class c = (Class) t;
            return c.isArray() && c != byte[].class;
        }
        if (t instanceof GenericArrayType) {
            t = ((GenericArrayType) t).getGenericComponentType();
            return t != Byte.TYPE;
        }
        return false;
    }

    public Type getComponentType(Type t) {
        if (t instanceof Class) {
            Class c = (Class) t;
            return c.getComponentType();
        }
        if (t instanceof GenericArrayType) {
            return ((GenericArrayType) t).getGenericComponentType();
        }

        throw new IllegalArgumentException();
    }

    public Type getTypeArgument(Type type, int i) {
        if (type instanceof ParameterizedType) {
            ParameterizedType p = (ParameterizedType) type;
            return fix(p.getActualTypeArguments()[i]);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isParameterizedType(Type type) {
        return type instanceof ParameterizedType;
    }

    public boolean isPrimitive(Type type) {
        if (type instanceof Class) {
            Class c = (Class) type;
            return c.isPrimitive();
        }
        return false;
    }

    public Type getPrimitive(Class primitiveType) {
        assert primitiveType.isPrimitive();
        return primitiveType;
    }

    public Location getClassLocation(final Class clazz) {
        return new Location() {

            @Override
            public String toString() {
                return clazz.getName();
            }
        };
    }

    public Location getFieldLocation(final Field field) {
        return new Location() {

            @Override
            public String toString() {
                return field.toString();
            }
        };
    }

    public Location getMethodLocation(final Method method) {
        return new Location() {

            @Override
            public String toString() {
                return method.toString();
            }
        };
    }

    public boolean hasDefaultConstructor(Class c) {
        try {
            c.getDeclaredConstructor();
            return true;
        } catch (NoSuchMethodException e) {
            return false; // todo: do this WITHOUT exception throw
        }
    }

    public boolean isStaticField(Field field) {
        return Modifier.isStatic(field.getModifiers());
    }

    public boolean isPublicMethod(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    public boolean isPublicField(Field field) {
        return Modifier.isPublic(field.getModifiers());
    }

    public boolean isEnum(Class c) {
        return Enum.class.isAssignableFrom(c);
    }

    public Field[] getEnumConstants(Class clazz) {
        try {
            Object[] values = clazz.getEnumConstants();
            Field[] fields = new Field[values.length];
            for (int i = 0; i < values.length; i++) {
                fields[i] = clazz.getField(((Enum) values[i]).name());
            }
            return fields;
        } catch (NoSuchFieldException e) {
            // impossible
            throw new NoSuchFieldError(e.getMessage());
        }
    }

    public Type getVoidType() {
        return Void.class;
    }

    public String getPackageName(Class clazz) {
        String name = clazz.getName();
        int idx = name.lastIndexOf('.');
        if (idx < 0) {
            return "";
        } else {
            return name.substring(0, idx);
        }
    }

    @Override
    public Class loadObjectFactory(Class referencePoint, String pkg) {
        ClassLoader cl = SecureLoader.getClassClassLoader(referencePoint);
        if (cl == null)
            cl = SecureLoader.getSystemClassLoader();

        try {
            return cl.loadClass(pkg + ".ObjectFactory");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public boolean isBridgeMethod(Method method) {
        return method.isBridge();
    }

    public boolean isOverriding(Method method, final Class base) {
        // this isn't actually correct,
        // as the JLS considers
        // class Derived extends Base<Integer> {
        //   Integer getX() { ... }
        // }
        // class Base<T> {
        //   T getX() { ... }
        // }
        // to be overrided. Handling this correctly needs a careful implementation

		if ((base == Object.class) || _isSkipOverriding(base.getName())) {
			return false;
		}

        final String name = method.getName();
        final Class[] params = method.getParameterTypes();

        return AccessController.doPrivileged(
                new PrivilegedAction<Boolean>() {

                    @Override
                    public Boolean run() {
                        Class clazz = base;
                        while (clazz != null) {
                            try {
                                Method m = clazz.getDeclaredMethod(name, params);
                                if (m != null) {
                                    return Boolean.TRUE;
                                }
                            } catch (NoSuchMethodException ignored) {
                                // recursively go into the base class
                            }
                            clazz = clazz.getSuperclass();
                        }
                        return Boolean.FALSE;
                    }
                }
        );
    }

    public boolean isInterface(Class clazz) {
        return clazz.isInterface();
    }

    public boolean isTransient(Field f) {
        return Modifier.isTransient(f.getModifiers());
    }

    public boolean isInnerClass(Class clazz) {
        return clazz.getEnclosingClass() != null && !Modifier.isStatic(clazz.getModifiers());
    }

    @Override
    public boolean isSameType(Type t1, Type t2) {
        return t1.equals(t2);
    }

    /**
     * JDK 5.0 has a bug of creating {@link GenericArrayType} where it shouldn't.
     * fix that manually to work around the problem.
     *
     * See bug 6202725.
     */
    private Type fix(Type t) {
        if (!(t instanceof GenericArrayType)) {
            return t;
        }

        GenericArrayType gat = (GenericArrayType) t;
        if (gat.getGenericComponentType() instanceof Class) {
            Class c = (Class) gat.getGenericComponentType();
            return Array.newInstance(c, 0).getClass();
        }

        return t;
    }

	private boolean _isSkipOverriding(String name) {
		if (_skipOverridingPackageNames.length == 0) {
			return false;
		}

		String packageName = name;

		int index = name.lastIndexOf('.');

		if (index != -1) {
			packageName = name.substring(0, index);
		}

		index = Arrays.binarySearch(_skipOverridingPackageNames, packageName);

		if (index >= 0) {
			return true;
		}

		index = -index - 1;

		if ((index == 0) ||
			!packageName.startsWith(_skipOverridingPackageNames[index - 1])) {

			return false;
		}

		return true;
	}

	private static final String[] _skipOverridingPackageNames;

	static {
		String packageNames = System.getProperty(
			"javax.xml.bind.runtime.glassfish.skip.overriding.packages");

		if ((packageNames == null) || packageNames.isEmpty()) {
			_skipOverridingPackageNames = new String[0];
		}
		else {
			_skipOverridingPackageNames = packageNames.split(",");

			for (int i = 0; i < _skipOverridingPackageNames.length; i++) {
				_skipOverridingPackageNames[i] =
					_skipOverridingPackageNames[i].trim();
			}

			Arrays.sort(_skipOverridingPackageNames);
		}
	}
}
/* @generated */