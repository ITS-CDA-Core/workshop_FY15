<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>add Chat Room</div>
		<div>login</div>
		<div>sign up</div>
	</div>
	<div>
		<h1>Chat Room List</h1>
		<p>${message}</p>
		<form method="post" action="/post">
			<input type="text" name="text1"/>
			<input type="submit"/>
		</form>
	</div>
</body>
</html>