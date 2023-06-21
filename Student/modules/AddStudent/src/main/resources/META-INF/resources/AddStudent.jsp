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
<liferay-portlet:resourceURL var="checkDuplicateUrl" >
    <liferay-portlet:param name="task" value="checkDuplicate"/>
</liferay-portlet:resourceURL>
<body>
<a href="#" onclick="callServeResource()">This is resource URL</a>
	<h1 class="text-center p-3">Add Student</h1>
	<span id="fname-error" class="text-center p-3"></span>
	
	<div class="container">

		<aui:form action="<%=addStudentURL%>" method="post">
			<aui:input name="enrollmentNo">
				<aui:validator name="required" />
				<aui:validator name="alphanum" />
			</aui:input>

			<aui:input name="firstName" onblur="checkFname()">
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
<!-- <script src="js/jquery-2.2.4.min.js"></script>
<script>
$(document).ready(function(){
		$("#fname").blur(function(){
			var firstname=$('#fname').val();
			alert(firstname);
			$.ajax({url: "demo_test.txt", success: function(result){
			    $("#div1").html(result);
			  }});
		});
	});
</script> -->

</body>

<script type="text/javascript">

function checkFname(){
 var myname=document.getElementsByName("_com_aspire_addstudent_AddStudentPortlet_INSTANCE_zmbq_firstName");
   /* alert("Cursor is on the input box"); 
   alert(myname[0].value); */
   var fname=myname[0].value;
   AUI().use('aui-io-request', function(A){
	    A.io.request('${checkDuplicateUrl}', {
	           method: 'post',
	           data: {
	               <portlet:namespace />param2: fname,
	           },
	           on: {
	                success: function() {
	                alert(this.get('responseData'));
	                var data=this.get('responseData');
	                const jsonData = JSON.parse(data);
	                alert(jsonData.duplicate);
	                if(jsonData.duplicate==true)
	                	{
	                		console.log("jsonData duplicate "+jsonData.duplicate);
	                		document.getElementById("fname-error").innerHTML +="Firstname is already taken";
	                		document.getElementsByName("_com_aspire_addstudent_AddStudentPortlet_INSTANCE_zmbq_firstName").value = "";
	                		//myname.focus()
	                	}
	                else{
	                		document.getElementById("fname-error").innerHTML +="";
	                	}
	               }
	          }
	    });

	});
} 

function callServeResource(){
	var myname=document.getElementById("fnameinput");
	   alert("Cursor is on the input box");
	  var input=myname.value;
	  console.log("Input value: " + input);
	
AUI().use('aui-io-request', function(A){
    A.io.request('${checkDuplicateUrl}', {
           method: 'post',
           data: {
               <portlet:namespace />param2: 'value2',
           },
           on: {
                success: function() {
                alert(this.get('responseData'));
               }
          }
    });

});
}
</script>
</html>