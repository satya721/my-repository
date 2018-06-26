<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link href='<%=request.getContextPath() %>/css/bootstrap.css'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/FormValidation.js"></script>
<title>Insert title here</title>
</head>
<script>

</script>

<body>


<div class="col-xs-36" id="Detail" style="height:300px;margin:0px;padding:0px" >

<c:forEach var="run" items="${emd}">
<div class="col-xs-4 clm"><h4><b> ${run.empId}</b></h4></div>
<div class="col-xs-10 clm" onclick="openupdate(${run.empId})"><h4><b> ${run.fName}  ${run.lName} </b></h4></div>
<div class="col-xs-6 clm"><h4><b> ${run.designation}</b></h4></div>
<div class="col-xs-6 clm"><h4><b>${run.mobile}</b></h4></div>
<div class="col-xs-10 clm"><h4><b>${run.email}</b></h4></div>
</c:forEach>
</div>

</body>
</html>