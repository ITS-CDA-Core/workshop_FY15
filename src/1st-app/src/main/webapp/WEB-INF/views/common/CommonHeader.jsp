<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<div class="ui fixed menu">
		<div class="container">
			<sec:authorize access="isAnonymous()">
				<div class="item">ITS-CDA BBS</div>
				<div class="menu right">
					<div class="item">未ログイン</div>
					<div class="ui buttons">
						<div class="ui button"><a href="<c:url value="/UserInfoInput"/>">Sign up</a></div>
						<div class="or"></div>
						<div class="ui button"><a href="<c:url value="/login"/>">Login</a></div>
					</div>
				</div>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal.user" var="user" />
				<div class="item">ITS-CDA BBS</div>
				<div class="menu right">
					<div class="item">
						<div class="ui list">
							<div class="item">
							<img class="ui mini rounded image" src="/static/image/Avatar/Small/${user.avatarId}.jpg" />
							<div class="content">${user.userName}</div>
							</div>
						</div>
					</div>
					<form:form action="/logout" method="post" class="item">
						<input type="submit" value="Logout" class="ui button">
					</form:form>
				</div>
			</sec:authorize>
		</div>
	</div>
