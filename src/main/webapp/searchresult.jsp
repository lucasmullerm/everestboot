<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.*" %> 
<%@ page import="java.lang.String" %>  
<%
	String type = (String) request.getAttribute("type");
	//List<IHyperlink> result = (List<IHyperlink>) request.getAttribute("result");
	List<String> idList      = (List<String>) request.getAttribute("idList");
	List<String> nameList    = (List<String>) request.getAttribute("nameList");
	List<String> urlList     = (List<String>) request.getAttribute("urlList");
	List<String> tagList     = (List<String>) request.getAttribute("tagList");
	List<String> commentList = (List<String>) request.getAttribute("commentList");
	pageContext.setAttribute("type", type);

%>


<html>
<head>
<%
	if (type.equals("search")) {
%>
	<title>Busca por Nome</title>
<%
	}
	else if (type.equals("tagged")){
%>
	<title>Busca por Tag</title>
<%
	}
	else {
%>
	<title>Busca por Comentário</title>
<%
	}
%>
	<link rel="stylesheet" type="text/css" href="/stylesheets/main.css">
	<style type="text/css">
		table {
		    width:100%;
		    table-layout: fixed;
		}
		table, th, td {
		    border: 1px solid black;
		    border-collapse: collapse;
		}
		th, td {
		    padding: 5px;
		    text-align: center;
		    width: 200px;
		    height: 50px;
		    word-wrap: break-word;
		}
		table#t01 tr:nth-child(even) {
		    background-color: #eee;
		}
		table#t01 tr:nth-child(odd) {
		   background-color:#fff;
		}
		table#t01 th	{
		    background-color: black;
		    color: white;
		}
	</style>
</head>


<body>
<div>
	<h1>Resultado</h1><br><br>
	<table id="t01">
	<tr>
		<th>Nome</th>
		<th>URL</th>
		<th>Tags</th>
		<th>Comentários</th>
	</tr>
<%
	for (int i = 0; i < nameList.size(); i++) {
		String id      = idList.get(i);
		String name    = nameList.get(i);
		String url     = urlList.get(i);
		String tag     = tagList.get(i);
		String comment = commentList.get(i);
		pageContext.setAttribute("id", id);
		pageContext.setAttribute("name", name);
		pageContext.setAttribute("url", url);
		pageContext.setAttribute("tag", tag);
		pageContext.setAttribute("comment", comment);
%>
		<tr>
			<td>${fn:escapeXml(name)}</td>
			<td>${fn:escapeXml(url)}</td>
			<td>${fn:escapeXml(tag)}</td>
			<td>${fn:escapeXml(comment)}</td>
			<td><a href="/edit/?id=${fn:escapeXml(id)}">Editar</a></td>
			<td><a href="/remove/?id=${fn:escapeXml(id)}">Remover</a></td>
		</tr>
<%
	}
%>
	</table>
</div>

<br><br>
<a href="javascript:window.history.back();">Voltar</a>

</body>
</html>