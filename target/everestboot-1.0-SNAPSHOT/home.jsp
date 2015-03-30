<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
	<title>Test page</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/main.css">
</head>
<body>

<h1>O que deseja fazer?</h1>

<br><br>

<a href="/add/">Adicionar hyperlink</a><br>
<a href="/search/">Pesquisar por nome</a><br>
<a href="/tagged/">Pesquisar por tag</a><br>
<a href="/delete/">Deletar hyperlink</a><br>


<%

	String var = request.getParameter("var");
	if (var == null) {
		var = "default";
	}
	//pageContext.setAttribute("var", var);
	

%>

<h1>${fn:escapeXml(var)}</h1>>

</body>
</html>
