<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*" %>
<html>
<head>
<%@ page isELIgnored="false" %>

<style type="text/css">
	.tableClass{
		border:1px solid red;
	}
	table, th, td {
    		border: 1px solid black;
	}
	
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
	<h1>Spring MVC Hello World Example</h1>

	<h2>${msg}</h2>
	
	<table class="tableClass">
		<tr style="border:1px solid red;">
		  <th>Name</th>
		  <th>Family</th> 
		  <th>Age</th>
		</tr>
		<c:forEach items="${users}" var="user" varStatus="status">
	        <tr>
	            <td>${user.id}</td>
	            <td>${user.fname}</td>
	            <td>${user.lname}</td>
	            <td>${user.accountCout}</td>
	        </tr>
	    </c:forEach>
	</table>
	<div>
		<select id="mySelect" onchange="changePage()">
		  <option value="1">Page1</option>
		  <option value="2">Page2</option>
		  <option value="3">Page3</option>
		  <option value="n">PageN</option>
		</select>
	</div>
	
	<div>
		<label><a href="#" onclick="changeList()">UpdateUserList</a></label>
		<select id="mylist">
		</select>
		
	</div>
	
	
	<div>
		<iframe id="iframe" src="/CounterWebApp/mypage.htm?id=1">
	  		<p>Your browser does not support iframes.</p>
		</iframe>
	</div>

   
  <script>
  	function changePage() {
	    var value = document.getElementById("mySelect").value;
	    var iframe = document.getElementById("iframe");
	    iframe.src = "/CounterWebApp/mypage.htm?id="+value;
	    
	}
  	
  	function changeList(){
  		debugger
  		deletePreviousData();
  		RestGet();
  	}
  	
  	var RestGet = function() {
  		        $.ajax({
  		        type: 'GET',
  		        url:  'http://localhost:8080/CounterWebApp/userId.htm',
  		        dataType: 'json',
  		        async: true,
  		        success: function(result) {
  		        	 	var selectList = document.getElementById("mylist");
  		        	 	debugger
  		        	 	//console.log(result);
  		        	 	if ( result ){
  		        	 		var i = 0;
  		        	 		for (i; i < result.length; i++){
  	  		        	 	    var option = document.createElement("option");
  	  	  		            option.text = result[i];
  	  	  		      		selectList.add(option);	
  	  		        	 	}  		        	 		
  		        	 	}
  		     /*    	console.log("AJAX done!");    
  		            alert('At ' + result); */
  		        },
  		        error: function(jqXHR, textStatus, errorThrown) {
  		            alert(jqXHR.status + ' ' + jqXHR.responseText);
  		        }
  		   });
  		}

  	function makeRequest() {
  		var xmlHttpRequest = getXMLHttpRequest();
  	}
	
  	function deletePreviousData(){
	  	document.getElementById("mylist").options.length = 0;		           	
  	} 
	
  </script>   
     
</body>
</html>