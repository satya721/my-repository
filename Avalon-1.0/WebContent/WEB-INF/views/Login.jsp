<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%request.getServletContext().setAttribute("ctxPath", request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link href='<%=request.getContextPath() %>/css/bootstrap.css'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/FormValidation.js"></script>
</head>
<c:if test="${admin != null }">
	<c:redirect url="/Master"></c:redirect>
</c:if>

<script type="text/javascript">
$(document).ready(function()
		{
    $("#empName,#empId").hover(function(){
        $(this).css("background-color", "yellow");
        }, function(){
        $(this).css("background-color", "white");
    });
});
function login()
{
	var name=$("#empName").val();
	var id=$("#empId").val();
	alert("Ok");
	$.ajax({
		url:"emplogin",
		type:"post",
		data:{empCode:name,empPin:id},
		
		success:function(res)
		{
		if(res=="fail")
			{
			$("#error").fadeIn();
			$("#error").html("<b>Invalid data</b>");
			$("#error").delay(5000).fadeOut();
			}
		else
			{
					
			window.open("Layout","_self");
			
			}
			
		},
		
		error:function(res)
		{
	
		}
	});
	
	

}
function Go()
{
	
     window.open("Register","_self");
}
	
</script>
<body id='body' style="background-image: url('<%=request.getContextPath()%>/images/startup-photos-400x267.jpg');background-repeat:no-repeat;background-size:cover">
	<input type="hidden" value="<%=request.getContextPath()%>" id='ctxPath'>
	<center></center>
	<br>
	<br>
	
	<div class ="text-center" style="font-family:Comic Sans MS;color:#1515c6"><h2><b>E-Days</b> </h2></div>
	<div class ="text-center"style="font-family:Comic Sans MS;color:#1515c6;opacity:.6"><h3><i>Make Your Work Easy </i></h3></div>
	<br>
	<br>
	<br>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class='container'>

		<div class='row'>
			<div class='col-xs-23'></div>
			
			<div class="col-xs-8" style="margin-left:16px;padding:0px;background-color:#09049b; padding: 15px;border:3px solid black;height:150px ;opacity:.6;border-radius:8px">
				<div  style="color:white;font-size:15px;height:15px"> <p id="error"></div>
                <div class="input-lg"><input type="text" placeholder="Emp_Name" id="empName" style="color:black"></div>
                <div class="input-lg"><input type="text" placeholder="Emp_Id" id="empId"></div>
				<button class='btn btn-primary btn-sm' onclick="Go()" style="margin:4px">Registration</button>
				<button class='btn btn-primary btn-sm' onclick="login()" style="margin:2px"><i class='glyphicon glyphicon-lock'></i> Secure Login</button>
						
		
	
	</div>




</body>
</html>