<%@ include file="/init.jsp"%>
<%@page import="com.aspire.studentservice.model.student"%>
<%@page import="java.util.List"%>
<%@page import="com.aspire.studentservice.model.studentModel"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<portlet:defineObjects />

<portlet:renderURL var="redirectAddStudentUrl">
	<portlet:param name="mvcPath" value="/AddStudent.jsp" />
</portlet:renderURL>

<portlet:actionURL var="fetchStudentURL" name="ViewStudentList">
	<portlet:param name="javax.portlet.action" value="fetchStudent" />
</portlet:actionURL>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.4/css/dataTables.jqueryui.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/scroller/2.1.1/css/scroller.jqueryui.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.13.4/js/dataTables.jqueryui.min.js"></script>
<script
	src="https://cdn.datatables.net/scroller/2.1.1/js/dataTables.scroller.min.js"></script>

</head>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable({
			deferRender : true,
			scrollY : 200,
			scrollCollapse : true,
			scroller : true
		});
	});

	$('#myModal').on('shown.bs.modal', function() {
		$('#myInput').trigger('focus')
	})
	
	
	
</script>


<%
	List<student> studentList = (List) request.getAttribute("studentList");
	
	String msg=(String)request.getAttribute("Message");
	
	Boolean role=(Boolean)request.getAttribute("Role");
%>
<body>
	<p>
		<b><liferay-ui:message key="addstudent.caption" /></b>
	</p>
	<%if(msg!=null){ %>
	<span class="success-msg" ><%= msg %></span>
	<%} %>
	<p>Welcome</p>

	<div class="mb-5 p-3">
		<a href="${redirectAddStudentUrl}"
			class="btn  btn-primary btn-default float-right"> <i
			class="glyphicon glyphicon-plus"></i> Add Student
		</a>
	</div>

	<table id="example" class="display nowrap" style="width: 100%">
		<thead>
			<tr>
				<th>Enrollment No</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Contact No</th>
				<th>City</th>
				
				<th>Edit</th>
			
				<%if(role==true){ %>
				<th>Delete</th>
					<%} %>
			</tr>
		</thead>

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
		<tbody>
		 <c:forEach items="${studentList}" var="student">  
			<tr>
				<td>${student.getEnrollmentno()}</td>
				<td>${student.getFname()}</td>
				<td>${student.getLname()}</td>
				<td>${student.getContactno()}</td>
				<td>${student.getCity()}</td>

			 	<%-- <portlet:actionURL var="updateStudentUrl" name="updateStudent">
				<portlet:param name="mvcPath" value="/UpdateStudent.jsp" />
					<portlet:param name="studentId" value="${student.getId()}" />
				</portlet:actionURL>  --%>
				
			 	<portlet:actionURL var="updateStudentUrl" name="editStudent">
				  <%-- <portlet:param name="mvcPath" value="/UpdateStudent.jsp" />   --%>
					<portlet:param name="studentId" value="${student.getId()}" />
				</portlet:actionURL> 

				<td class="text-center" style="width: 50px"><a
					href="<%=updateStudentUrl%>"
					class="btn  btn-primary btn-default btn-sm px-2 py-1"> <i
						class="glyphicon glyphicon-edit">Edit</i>
				</a></td>
				
				<%if(role==true){ %>	
				<portlet:actionURL var="deleteStudentUrl" name="deleteStudent">
					<portlet:param name="studentId" value="${student.getId()}" />
				</portlet:actionURL>

				<td class="text-center" style="width: 50px"><a
					href="<%=deleteStudentUrl%>"
					class="btn  btn-primary btn-default btn-sm px-2 py-1"> <i
						class="glyphicon glyphicon-remove">Delete</i>
				</a></td>
				<%}%>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- Button trigger modal -->
	<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Launch demo modal
</button>
 -->
	<!-- Modal -->
	<!-- <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div> -->
</body>

</html>