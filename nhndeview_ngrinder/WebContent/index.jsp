<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NHN Deview Fake Target Machine.</title>
<style type="text/css">
	div {
		font-size:80px;
	}
	#count_div span { 
		font-size:150px;
	}
	
	#submit_div span { 
		font-size:150px;
	}
	
	#complete_div span { 
		font-size:150px;
	}
	
	#total_div span { 
		font-size:100px;
	}
	form {
		float : left;
	}
	
</style>
</head>
<body>
<div id="count_div">
	Register request : <span><%= request.getAttribute("register") %> </span>called
</div>

<div id="submit_div">
	Submit request : <span><%= request.getAttribute("submit") %> </span>called
</div>

<div id="complete_div">
	Complete request : <span><%= request.getAttribute("complete") %> </span>called
</div>

<div id="total_div">
	TOTAL : <span><%= request.getAttribute("count") %></span>
</div>

<form action="/register" method="GET">
	<input type="submit" value="Request register"/>
</form>
<form action="/submit" method="POST">
	<input type="submit" value="Request submit"/>
</form>
<form action="/complete" method="GET">
	<input type="submit" value="Request complete"/>
</form>
<form action="/reset" method="GET">
	<input type="submit" value="Reset"/>
</form>

</body>
</html>