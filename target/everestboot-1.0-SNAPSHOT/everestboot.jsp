<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
	<title>Test page</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/main.css">
</head>
<body>
<%
	String name = request.getParameter("name");
	if (name == null) {
		name = "default";
	}
	pageContext.setAttribute("name", name);
	UserService userService = UserServiceFactory.getUserService();
	User user = userService.getCurrentUser();
	if (user != null) {
		pageContext.setAttribute("user", user);
%>
<p>Hello, ${fn:escapeXml(user.nickname)}! (You can 
		<a href="<%= userService.createLogoutURL(request.getRequestURI())%>">sign out</a>.)
</p>

<%
} else {
%>
<p>Hello!
	<a href="<%= userService.createLoginURL(request.getRequestURI())%>">Sign in</a> 
	to include your name.</p>
<%
	}
%>
<form action="/everestboot.jsp" method="get">
	<div><input type="text" name="name" value="${fn:escapeXml(name)}"/></div>
	<div><input type="submit" value="Switch name" /></div>
</form>


</body>
</html>
