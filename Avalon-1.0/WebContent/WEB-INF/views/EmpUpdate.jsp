<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.inputfield{

           margin:5px;
           height:25px;
}
.input1{
height:30px;
width:400px;
float:right;
}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='<%=request.getContextPath() %>/css/bootstrap.css' rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/FormValidation.js"></script>
<title>Registration</title>



<script type="text/javascript">

function Update(v)
{
	
	
	var form=$("#update").serialize();	
	alert(form);
	$.ajax({
		url:"UpdateEmployee",
		type:"post",
		data:form,
		success:function(res)
		{
	   if(res=="success")
		alert("done");
	   $(".input1").attr("disabled",true);
		},
		
		error:function(res)
		{
alert("gadbad hai");
		}
	});
	
}

document.ready($(".input1").attr("disabled", true));


function edit()
{
	alert("g");
	$(".input1").attr("disabled",false);
	
}

</script>
</head>

<body>
<div class ="text-center">
<div class="col-xs-36 " style="border:2px solid black ; margin:0px;height:500px" >
<form id="update">
<input class="col-xs-33" type="text" name="empid" value="${em.empId}" style="visibility:hidden"><span  style="margin: 2px" class="btn btn-info btn-sm" onclick="edit()">
          
          <span class="glyphicon glyphicon-pencil"></span> Edit </span>

<div class="col-xs-36 inputfield"><b>     First Name     :</b><input id="ccc"  class="input1" type="text" name="empfname" value="${em.fName}" ></div>
<div class="col-xs-36 inputfield"><b>Last Name      :</b><input  class="input1" type="text" name="emplname" value="${em.lName}"></div>
<div class="col-xs-36 inputfield" ><b>Mobile Number : </b><input  class="input1" type="text" name="empmobile" value="${em.mobile}"></div>
<div class="col-xs-36 inputfield"><b>Mail Address   :</b><input class="input1" type="text" name="empmail" value="${em.email}"></div>
<div class="col-xs-36 inputfield"><b>Address        :</b><input class="input1" type="text" name="empadd" value="${em.cAddress}"></div>
<div class="col-xs-36 inputfield"><b>Desigantion    :</b><input class="input1" type="text" name="empdeg" value="${em.designation}"></div>
<div class="col-xs-36 inputfield"><b>Department     :</b><input  class="input1" type="text" name="empdepart" value ="${em.departId}"></div>
<div class="col-xs-36 inputfield"><b>State          :</b><input class="input1" type="text" name="empstate" value="${em.cState}"></div>
<div class="col-xs-36 text-center inputfield" ><input class="button" type="button" onclick="Update()" value="Update"></div>
</form>
</div>
</div>
</body>
</html>