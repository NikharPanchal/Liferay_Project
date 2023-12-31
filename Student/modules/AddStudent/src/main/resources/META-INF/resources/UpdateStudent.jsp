<%@page import="com.aspire.studentservice.model.student"%>
<%@page import="com.liferay.taglib.portlet.ActionURLTag"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="java.util.List"%>
<portlet:defineObjects />
<portlet:actionURL var="updateStudentURL" name="updateStudentAction">
	<portlet:param name="javax.portlet.action" value="updateStudentDetails" />
</portlet:actionURL>

<html>
<head>
<title>Update Student</title>
</head>

<%
	student stud = (student) request.getAttribute("stud");
%>
<body>
	<h1 class="text-center p-3">Edit Student</h1>
	<div class="container">

		<aui:form action="<%=updateStudentURL%>"  method="post">
			
			 <aui:input name="studentId" type="hidden" value="${stud.getPrimaryKey()}">
				
			</aui:input>
		 
			<aui:input name="enrollmentNo" value="${stud.getEnrollmentno()}">
				<aui:validator name="required"/>
				<aui:validator name="alphanum" />
			</aui:input>

			<aui:input name="firstName"  value="${stud.getFname()}">
				<aui:validator name="required" />
				<aui:validator name="alpha" />
			</aui:input>

			<aui:input name="lastName" value="${stud.getLname()}">
				<aui:validator name="required" />
				<aui:validator name="alpha" />
			</aui:input>

			<aui:input name="contactNo" value="${stud.getContactno()}">
				<aui:validator name="required" />
				<aui:validator name="string" />
			</aui:input>

			<aui:input name="city" value="${stud.getCity()}">
				<aui:validator name="required" />
				<aui:validator name="alpha" />
			</aui:input>
		
			<div class="text-center w-100">
				<aui:button type="submit" value="Update"></aui:button>
			</div>
			
		</aui:form>
	</div>
	<br>
	<br>


</body>
</html>