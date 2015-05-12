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
	<title>CDA BBS</title>
	<c:import url="common/CommonImport.jsp"/>
<style type="text/css">
</style>
</head>
<body>
	<c:import url="common/CommonHeader.jsp"/>
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
	<c:import url="common/CommonFooter.jsp"/>
</body>
</html>