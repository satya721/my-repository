<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link href='<%=request.getContextPath() %>/css/bootstrap.css'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/FormValidation.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>

function openupdate()
{
	
	window.open("OpenUpdateEmp","_self");	
}



</script>

<body>
<div class="col-xs-36" id="Detail" style="height:300px;margin:0px;padding:0px" onclick="openupdate()">
<div class="col-xs-4 clm" ><h4><b> ${em.empId}</b></h4></div>
<div class="col-xs-10 clm"><h4><b> ${em.fName}  ${em.lName} </b></h4></div>
<div class="col-xs-6 clm"><h4><b> ${em.designation}</b></h4></div>
<div class="col-xs-6 clm"><h4><b>${em.mobile}</b></h4></div>
<div class="col-xs-10 clm"><h4><b>${em.email}</b></h4></div>


</div>

</body>
</html>