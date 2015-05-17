<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url="common/CommonTopOfHeadTag.jsp"/>
	<title>ユーザ情報登録</title>
	<c:import url="common/CommonImport.jsp"/>
	<link type="text/css" rel="stylesheet" href="/static/css/UserInfoInput.css" />
</head>
<body>
	<c:import url="common/CommonHeader.jsp"/>
	<div class="container">
		<h1>ユーザ情報登録</h1>
		<sec:authorize access="isAuthenticated()">
			<div>すでにログイン済みです。</div>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<form:form action="/UserInfoInput" method="post">
				<div class="ui corner labeled input">
					<div class="ui label">User Name</div>
					<input type="text" name="userName" placeholder="User Name...">
					<div class="ui corner label">
						<i class="asterisk icon"></i>
					</div>
				</div>
				<div class="ui hidden divider"></div>
				<div class="ui corner labeled input">
					<div class="ui label">Password</div>
					<input type="password" name="password" placeholder="Password...">
					<div class="ui corner label">
						<i class="asterisk icon"></i>
					</div>
				</div>
				<div class="ui hidden divider"></div>
				<div class="AvatarSelector">
					<div>Avatar</div>
					<c:forEach var="avaterId" items="${avaterIdList}">
						<input type="radio" name="avatarId" id="${avaterId}" value="${avaterId}" />
						<label class="AvatarImage" for="${avaterId}"><img src="/static/image/Avatar/Large/${avaterId}.jpg" /></label>
					</c:forEach>
				</div>
				<input type="submit" class="ui submit button" value="Submit"/>
			</form:form>
		</sec:authorize>
	</div>
	<c:import url="common/CommonFooter.jsp"/>
</body>
</html>