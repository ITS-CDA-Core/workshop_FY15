<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url="common/CommonTopOfHeadTag.jsp"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>ユーザ情報登録</title>
	<c:import url="common/CommonImport.jsp"/>
</head>
<body>
	<c:import url="common/CommonHeader.jsp"/>
	<div>
		<h1>ユーザ情報確認</h1>
		<sec:authorize access="isAuthenticated()">
			<div>すでにログイン済みです。</div>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<form:form action="/UserInfoConfirm" method="post">
				<div class="ui segment">
					<div class="ui horizontal label">User Name</div>
					${userName}
				</div>
				<input type="hidden" name="userName" value="${userName}"/>
				<input type="hidden" name="password" value="${password}"/>
				<input type="submit" class="ui submit button" value="Submit"/>
			</form:form>
		</sec:authorize>
	</div>
<c:import url="common/CommonFooter.jsp"/>
</body>
</html>