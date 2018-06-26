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

<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/json2.js"></script>

<style>
 .clm_hed
        {
            border-style: groove;
            height:48px;
            background-color:#cfd6d3;
        	`
        }
        .clm{
            border-style: groove;height:42px;
            overflow-y:auto;
            }
       .date1{
             margin:5px;     
       
       } 
.width1
{
width:200px;
float:left;
}

</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function getEmployeeDetail()
{
	alert("Ok");
var empId=$("#epId").val();	
	
$.ajax({
	url:"getDetail",
	type:"post",
	data:{Id:empId},
	
	success:function(res)
	{
	
	$("#Detail").html(res);	
	},
	
	error:function(res)
	{

	}
});

}


function getCourse()
{
	
	
	var domId=$("#dId").val();	
	alert(domId);	
	$.ajax({
		url:"getCourse",
		type:"post",
		data:{domainId:domId},
		
		success:function(res)
		{
		
		$("#cId").html(res);	
		},
		
		error:function(res)
		{

		}
	});	
	

}

function Search()
{
	alert("Ok");

	var sr=$("#text").val();	
	
	$.ajax({
		url:"searchByKeyword",
		type:"post",
		data:{serkey:sr},
		
		success:function(res)
		{
			$("#Detail").html(res);
		},
		
		error:function(res)
		{
        alert(" Sorry!!!..Data not found.");
		}
	});

}

function openupdate(v)
{
	alert(v)
	$.ajax({
		url:"OpenUpdateEmp",
		type:"post",
		data:{VI:v},
		success:function(res)
		{
		 
		  $("#Detail").html(res);
			
		},
		
		error:function(res)
		{
	
		}
	});
}

function SearchByDate()
{
	
var from=$("#fromdate").val();
var to=	$("#todate").val();
	alert(from);
	alert(to);
	
	$.ajax({
		url:"SearchByDate",
		type:"post",
		data:{From:from,To:to},
		success:function(res)
		{
		 
		  $("#serId").html(res);
			
		},
		
		error:function(res)
		{
	
		}
	});

}


function GetTodayDate() 
{
	  
	var d = new Date();
    var month = d.getMonth()+1;
	var day = d.getDate();
     var currentDate = d.getFullYear() + '-' +
	    (month<10 ? '0' : '') + month + '-' +
	    (day<10 ? '0' : '') + day;
	  
	return currentDate;
}
function SearchByToday()
{
	   var from=GetTodayDate();
	   var to=GetTodayDate();
	   
	   	alert(from);
	   	alert(to);
	   	
	   	$.ajax({
	   		url:"SearchByDate",
	   		type:"post",
	   		data:{From:from,To:to},
	   		success:function(res)
	   		{
	   		 
	   		  $("#serId").html(res);
	   			
	   		},
	   		
	   		error:function(res)
	   		{
	   	
	   		}
	   	});

	}



function getTable()
{
	alert("Ok");
	var tabname=$("#ByTable").val();	
	return tabname;
}


function SearchByTable()
{
	alert("searchByTable");
var selectTab = getTable();
var keyname=$("#bytab").val();

	
	$.ajax({
		url:"SearchByTable",
		type:"post",
		data:{tabnam:selectTab,sernam:keyname},
		success:function(res)
		{
		 
		  $("#serId").html(res);
			
		},
		
		error:function(res)
		{
	
		}
	});
}
/* Excel Fiile upload part*/

var files=[];
function emport(event)
{
	files=event.target.files;
	alert(files);
	}

function fileupload()
{
	alert(files);
	var myform=new FormData();
	myform.append("file",files[0]);
    alert("myform");
		
		$.ajax({
			url:"fileupload",
			type:"post",
			data:myform,
			enctype:'multipath/form-data',
			processData:false,
			contentType:false,
			success:function(res)
			{
			 
        		alert(res);
				
			},
			
			error:function(res)
			{
		  alert("File not upload");
			}
		});
}

//file upload part
function add()
{
     
        $(".inc").append('<div class="controls">\
                <input  type="text" class="width1" name="text" placeholder="Document Name" style="border:1px solid black;width:210px">\
                <input  type="file"  class="width1" name="url" placeholder="Upload" style="border:1px solid black;width:210px;margin-left:10px">\
                <a href="#" class="remove_this"><span class="glyphicon glyphicon-minus"></span></a>\
                <br>\
                <br>\
            </div>');
    
}

    jQuery(document).on('click', '.remove_this', function() 
    		{
        jQuery(this).parent().remove();
        if(photourl.length >=0)
        photourl.pop();
        if(photoname.length>=0)
            photoname.pop();
        return false;
        });
  
   
function   upload1()
{
	 var name=[];
		var url=[];
	
	$(".controls").each(function() {
		
	   name.push ($(this).children("input[name='text']").val());
	    url.push("images/"+$(this).children("input[name='url']").val().replace(/^.*\\/,""));
	    alert(name);
	    alert(url);
	});	
	
	$.ajax({
		
        url: "FileImageUpload",
        type: "POST",
        data:{myArray:url,myArray1:name},
        success: function (res) 
        {
            alert("File/Image are  uploaded successfully");
        },
        
    	error:function(res)
		{
	  alert("File/Image not upload");
		}
        
        
    });
	
}

//image upload part

function   image1()
{
	
	alert("image1");
	$.ajax({
		
        url: "FileImageUpload",
        type: "POST",
        data:{myArray:photourl,myArray1:photoname},
        success: function (res) 
        {
            alert("File/Image are  uploaded successfully");
        },
        
    	error:function(res)
		{
	  alert("File/Image not upload");
		}
        
        
    });
	
}
var photoname=[];
var  photourl=[];
function setprview()
{
	alert("onchange");
	var path="images/"+$("#photo1").val().replace(/^.*\\/,"");
	photourl.push(path);
	photoname.push("photo");
	 $(".imagebox").append('<div class="col-xs-9" style="margin:2px">\<img src='+path+' style="height:60px;width:60px">\
			 <a href="#" class="remove_this"><span class="glyphicon glyphicon-minus"></span></a>\
	 </div>');

}
</script>
</head>
<body>
<div class="container" style="padding:8px">
<div class="col-xs-8"> 
<select onchange="getEmployeeDetail()" id="epId" style="height:22px;border:1px solid black" >
<option>Select FName</option>
<c:forEach var="e" items="${emp}">
<option value="${e.empId}"> ${e.fName} </option>
</c:forEach>
</select>
</div>

<div class="col-xs-10"><input type="text" placeholder="Enter Keyword" id="text"><input type="button" id="search" onclick="Search()" value="Search"></div>

<div class="col-xs-5">

<select   style="height:22px;border:1px solid black" >
<option>Manager ID</option>
<c:forEach var="m" items="${empma}">
<option > ${m}</option>
</c:forEach>
</select>

</div>

<div class="col-xs-10"> 
<select onchange="getCourse()" id="dId" style="height:22px;border:1px solid black" >
<option>Select Domain</option>
<c:forEach var="e"  items="${empdo}">
<option value="${e.domainId}"> ${e.domainName} </option>
</c:forEach>
</select>

<select  id="cId" style="height:22px;border:1px solid black" >
<option>Select Course</option>
</select>
</div>



<br>
<br>

<div class="col-xs-26" style="margin-top:15px;padding:0px;border:2px solid black;border-bottom:0px">


<div class="col-xs-4 clm_hed"><h4><b>Emp Id</b></h4></div>
<div class="col-xs-10 clm_hed"><h4><b>Employee Name's</b></h4></div>
<div class="col-xs-6 clm_hed"><h4><b>Designation</b></h4></div>
<div class="col-xs-6 clm_hed"><h4><b>Mobile No.</b></h4></div>
<div class="col-xs-10 clm_hed"><h4><b>Email</b></h4></div>


</div>
<div class="col-xs-26" id="Detail" style="border:2px solid black;height:500px;font-size:15px;padding:0px;overflow:scroll"></div>

<div class="col-xs-8 text-center" style="border:2px solid black ;margin-left:20px;padding:15px">

<h4><b><i>Upload Employee Data</i></b></h4>
<input type="file"  style="border:1px solid black" id="xlsfile" onchange="emport(event)">
<br>
<input type="button" value="Upload" id="upload" onclick="fileupload()">

</div>

<div class="col-xs-8 text-center" style="border:2px solid black;height:200px;margin:20px;padding:22px">
<h4><b><i>Search Employee</i></b></h4>
<div class="col-xs-36 date1"><b>From :</b><input type="date" id="fromdate"></div>
<div class="col-xs-36 date1"><b>TO :</b><input type="date" id="todate"></div>
<div class="col-xs-10 date1" style="margin-left:20px"><input type="button" value="Today" onclick="SearchByToday()"></div>
<div class="col-xs-10 date1" style="margin-left:10px"><input type="button" value="Search By Date" onclick="SearchByDate()"></div>
</div>

<div class="col-xs-5" style="margin:8px">

<select id="serId" style="height:22px;border:1px solid black"  value="Emp Name">
<option>Emp Name</option>
</select>
</div>



<div class="col-xs-8" style="border:2px solid black;height:200px;margin:20px;padding:5px">
<h4><b><i>Search Employee</i></b></h4>
<div class="col-xs-12">
<select id="ByTable"  style="height:22px;border:1px solid black">
<option value="all">All</option>
<option value="enquiry">Enquiry</option>
<option value="web">Web</option>
<option value="refer">Refer</option>
<option value="student">Student</option>
</select>
</div>


<div class="col-xs-15" style="margin-left:15px"><input type="text" placeholder="Enter Keyword" id="bytab" style="width:100px">
</div>

<div class="col-xs-10" style="margin:15px;margin-left:65px">
<input type="button" id="searchbytab" onclick="SearchByTable()" value="Search">
</div>

</div>

<div class="col-xs-18" style="border:2px solid black;height:300px;font-size:15px;padding:0px">
<h2><b><i>Upload File</i></b></h2>



    <div class="control-group">
        <div class="inc">
            <div class="controls">
                
                <input type="text"  name="text" placeholder="Document Name" class="width1"  style="border:1px solid black;width:210px"> 
                <input type="file" class="width1" name="url"  style="border:1px solid black;width:210px;margin-left:10px">
                <button style="margin-left:5px" class="btn btn-info"onclick="add()"><span class="glyphicon glyphicon-plus"></span></button>
                <br>
                <br>
            </div>
        </div>
        <input type="button" class="btn btn-info" name="submit" value="submit" onclick="upload1()"/> 
    </div>

</div>


<div class="col-xs-8" style="border:2px solid black;height:300px;font-size:15px;padding:0px">
<h2><b><i>Upload photo</i></b></h2>
 <input type="file" id="photo1" onchange="setprview()" style="border:1px solid black;width:230px">
   <input type="button" class="btn-info"  value="Upload" onclick="image1()" style="margin:10px">
<div class="imagebox">

</div>
</div>

</div>

</body>
</html>