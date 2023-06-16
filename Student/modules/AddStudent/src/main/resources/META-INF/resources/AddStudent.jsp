<%@page import="com.aspire.studentservice.model.student"%>
<%@page import="com.liferay.taglib.portlet.ActionURLTag"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="java.util.List"%>
<portlet:defineObjects />

<portlet:actionURL var="addStudentURL" name="addStudentAction">
	<portlet:param name="javax.portlet.action" value="addStudent" />
</portlet:actionURL>

<html>
<head>
<title>Add Student</title>
</head>


<body>
	<h1 class="text-center p-3">Add Student</h1>
	<div class="container">

		<aui:form action="<%=addStudentURL%>" method="post">
			<aui:input name="enrollmentNo">
				<aui:validator name="required" />
				<aui:validator name="alphanum" />
			</aui:input>

			<aui:input name="firstName">
				<aui:validator name="required" />
				<aui:validator name="alpha" />
			</aui:input>

			<aui:input name="lastName">
				<aui:validator name="required" />
				<aui:validator name="alpha" />
			</aui:input>

			<aui:input name="contactNo">
				<aui:validator name="required" />
				<aui:validator name="string" />
			</aui:input>

			<aui:input name="city">
				<aui:validator name="required" />
				<aui:validator name="alpha" />
			</aui:input>

			<div class="text-center w-100">
				<aui:button type="submit" value="Submit"></aui:button>
			</div>

		</aui:form>
	</div>
	<br>
	<br>
</body>
</html>