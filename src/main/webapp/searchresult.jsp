<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	String name = request.getAttribute("type");
	List<IHyperlink> result = (List<IHyperlink>) request.getAttribute("result");
	pageContext.setAttribute("type", type);

%>


<html>
<head>
<%
	if (type == "search") {
%>
	<title>Busca por Search</title>
<%
	}
	else {
%>
	<title>Busca por Tag</title>
<%
	}
%>
	<link rel="stylesheet" type="text/css" href="/stylesheets/main.css">
</head>


<body>
<div>
	<h1>Resultado</h1><br><br>
	<table style="width:100%">
	<tr>
		<td>Nome</td>
		<td>URL</td>
		<td>Tags</td>
		<td>Comentários</td>
	</tr>
<%
	for (IHyperlink h : result) {
		pageContext.setAttribute("h", h);
		String tags = "";
		for (String s : h.getTags()) {
			if (tags == "") {
				tags += s;
			}
			else {
				tags += "," + s;
			}
		}
		pageContext.setAttribute("tags", tags);
%>
		<tr>
			<td>${fn:escapeXml(h.getName()}</td>
		</tr>
		<tr>
			<td>${fn:escapeXml(h.getURL()}</td>
		</tr>
		<tr>
			<td>${fn:escapeXml(tags}</td>
		</tr>
		<tr>
			lixo
			<!--td>${fn:escapeXml(h.getName()}</td-->
		</tr>
<%
	}
%>
	</table>
</div>


<a href="javascript:window.history.back();">Voltar</a>

</body>
</html>