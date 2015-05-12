<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>CDA BBS</title>
	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/1.12.2/semantic.css" />
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/1.12.2/semantic.js"></script>
<style type="text/css">
</style>
</head>
<body>
	<div>
		<sec:authorize access="isAnonymous()">
			<div>未ログイン</div>
			<div class="ui buttons">
				<div class="ui button">Sign up</div>
				<div class="or"></div>
				<div class="ui button"><a href="<c:url value="/login"/>">Login</a></div>
			</div>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.user" var="user" />
			<div>ログイン済：${user.userName}</div>
			<div>add Chat Room</div>
			<div>
				<form:form action="/logout" method="post">
					<input type="submit" value="Logout" class="ui button">
				</form:form>
			</div>
		</sec:authorize>
		
	</div>
	<div>
		<h1>Chat Room List</h1>
		<div class="ui comments">
			<c:forEach var="chatRoom" items="${chatRoomList}" varStatus="status">
				<div class="comment">
					<a class="avatar">
						<img src="/static/image/Avatar/Small/01.jpg"/>
					</a>
					<div class="content">
						<div class="text"><c:out value="${chatRoom.title}"/></div>
						<div class="author"><c:out value="${chatRoom.createdBy}"/></div>
						<div class="metadata"><c:out value="${chatRoom.createdAt}"/></div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
ライセンス表記：<a href="http://jp.freepik.com/free-photos-vectors/人">人 Freepikによるベクターデザイン</a>
</body>
</html>