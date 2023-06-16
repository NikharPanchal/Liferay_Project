<%@page import="com.aspire.studentservice.model.student"%>
<%@page import="java.util.List"%>
<%@page import="com.aspire.studentservice.model.studentModel"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<portlet:defineObjects />

<portlet:renderURL var="redirectAddStudentUrl">
	<portlet:param name="mvcPath" value="/AddStudent.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="fetchStudentURL" name="ViewStudentList">
  <portlet:param name="javax.portlet.action" value="fetchStudent" />
</portlet:actionURL>

<%List<student> studentList=(List)request.getAttribute("studentList");%>
<p>Welcome</p>

<div class="mb-5">
    <a href="${redirectAddStudentUrl}" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"></i> Add Student
    </a>
</div>
studentList------> ${studentList }
<div class="mb-5">
    <a href="${fetchStudentURL}" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"></i> Fetch Student
    </a>
</div>
<table class="table table-striped">
    <tr>
        <th>Enrollment No</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Contact No</th>
        <th>City</th>
        <th colspan="2" style="width: 100px">Action</th>
    </tr>
    <c:forEach items="${studentList}" var="student">  
    
    <!--    <portlet:renderURL var="updateStudentRenderURL">
            <portlet:param name="mvcPath" value="/update-student.jsp"/>
            <portlet:param name="enrollmentNo" value="${student.enrollmentNo}"/>
            <portlet:param name="firstName" value="${student.firstName}"/>
            <portlet:param name="lastName" value="${student.lastName}"/>
            <portlet:param name="contactNo" value="${student.contactNo}"/>
            <portlet:param name="city" value="${student.city}"/>
            <portlet:param name="studentId" value="${student.studentId}"/>
        </portlet:renderURL>
        
        <portlet:actionURL name="deleteStudent" var="deleteStudentActionURL">
            <portlet:param name="studentId" value="${student.getStudentId()}"/>
        </portlet:actionURL> !-->
                
        <tr> 
            <td>${student.getEnrollmentNo()}</td>
            <td>${student.getFirstName()}</td>
            <td>${student.getLastName()}</td>
            <td>${student.getContactNo()}</td>
            <td>${student.getCity()}</td>
            <td class="text-center" style="width: 50px">
                <a href="#" class="btn  btn-primary btn-default btn-sm px-2 py-1" >
                <i class ="glyphicon glyphicon-edit">Edit</i>
                </a>
            </td> 
            <td class="text-center" style="width:50px">
                <a href="#" 
                    class="btn  btn-primary btn-default btn-sm px-2 py-1"
                    onclick="return confirm('Are you sure you want to delete this item?');"> 
                    <i class ="glyphicon glyphicon-remove">Delete</i>
                </a>
            </td>                                     
         </tr>
    </c:forEach>
</table>