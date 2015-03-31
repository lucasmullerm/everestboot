<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
	<title>Editar Hyperlink</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/main.css">
</head>

<body>
<div>
	<h1>Editar Hyperlink</h1>
</div>

<%
	String id      = (String) request.getAttribute("id");
	String name    = (String) request.getAttribute("name");
	String url     = (String) request.getAttribute("url");
	String tag     = (String) request.getAttribute("tag");
	String comment = (String) request.getAttribute("comment");

	pageContext.setAttribute("id", id);
	pageContext.setAttribute("name", name);
	pageContext.setAttribute("url", url);
	pageContext.setAttribute("tag", tag);
	pageContext.setAttribute("comment", comment);

%>

<div>
	<form action="/add/" method="post">
	 					 <input type="hidden" name="id" value="${fn:escapeXml(id)}" />
		            Nome:  <input type="text" name="name" value="${fn:escapeXml(name)}" /><br>
		            URL:   <input type="text" name="url" value="${fn:escapeXml(url)}" /><br>
		        Comentário:  <textarea name="comment" cols="50" rows="5" >${fn:escapeXml(comment)}</textarea><br>
		Tags(Utilize vírgula como separador): <input type="text" name="tags" value="${fn:escapeXml(tag)}" /><br>
												<input type="submit" name="add" value="Editar Hyperlink" /><br>
	</form>
</div>	
<br>
<a href="javascript:window.history.back();">Voltar</a>

</body>
</html>