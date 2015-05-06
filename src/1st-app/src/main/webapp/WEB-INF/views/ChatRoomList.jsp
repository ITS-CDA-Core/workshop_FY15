<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>A Channel</title>
	<link type="text/css" rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css" />
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
</head>
<body>
	<div>
		<sec:authorize access="isAnonymous()">
			<div>未ログイン</div>
			<div><a href="<c:url value="/login"/>">Login</a></div>
			<div>Sign up</div>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.user" var="user" />
			<div>ログイン済：${user.userName}</div>
			<div>add Chat Room</div>
			<div>
				<form:form action="/logout" method="post">
					<input type="submit" value="Logout">
				</form:form>
			</div>
		</sec:authorize>
		
	</div>
	<div>
		<h1>Chat Room List</h1>
		<ul>
			<c:forEach var="chatRoom" items="${chatRoomList}" varStatus="status">
				<li><c:out value="${status.count}"/>: <c:out value="${chatRoom.title}"/><br/>
					(by <c:out value="${chatRoom.createdBy}"/>, at <c:out value="${chatRoom.createdAt}"/>)</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>