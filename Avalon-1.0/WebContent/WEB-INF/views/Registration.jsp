<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.inputfield{

           margin:4px;
           height:20px;
}
.input{
height:25px;
width:400px;
float:right;


}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='<%=request.getContextPath() %>/css/bootstrap.css'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/FormValidation.js"></script>
<title>Registration</title>

</head>

<body>

<script type="text/javascript">

function Register()
{	
var form=$("#register").serialize();	
alert(form);
$.ajax({
	url:"setDetail",
	type:"post",
	data:form,
	success:function(res)
	{
   if(res=="success")
	alert("done");
	},
	
	error:function(res)
	{

	}
});
}
</script>

<div class ="container text-center">
<div class="col-xs-20" style="border:2px solid black ; margin:50px" >
<form id="register">
<div class="col-xs-36 inputfield"><b>Enter First Name : </b><input  class="input" type="text" name="empfname" placeholder="Enter First Name"></div>
<div class="col-xs-36 inputfield"><b>Enter Last Name : </b><input  class="input" type="text" name="emplname" placeholder="Enter Last Name"></div>
<div class="col-xs-36 inputfield" ><b>Enter Mobile Number : </b><input  class="input" type="text" name="empmobile" placeholder="Enter Mobile No."></div>
<div class="col-xs-36 inputfield"><b>Enter Mail Address : </b><input class="input" type="text" name="empmail" placeholder="Enter Mail Add."></div>
<div class="col-xs-36 inputfield"><b>Enter Address : </b><input class="input" type="text" name="empadd" placeholder="Enter Address "></div>
<div class="col-xs-36 inputfield"><b>Enter Desigantion : </b><input class="input" type="text" name="empdeg" placeholder="Enter Desigantion"></div>
<div class="col-xs-36 inputfield"><b>Enter Department : </b><input  class="input" type="text" name="empdepart" placeholder="Enter DEpart. Id "></div>
<div class="col-xs-36 inputfield"><b>Enter State : </b><input class="input" type="text" name="empstate" placeholder="Enter State"></div>
<div class="col-xs-36 text-center inputfield" ><input class="button" type="button" onclick="Register()" value="submit"></div>
</form>
</div>
</div>
</body>
</html>