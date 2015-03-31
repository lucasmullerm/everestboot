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

<div>
	<a href="/add/">Adicionar hyperlink</a><br>
</div>
<div>
	Pesquisar por nome:<br>
	<form action="/search/" method="post">
		<input type="text" name="name" />
		<input type="submit" name="submit" value="Pesquisar" />
	</form>
</div>
<div>
	Pesquisar por tag:<br>
	<form action="/tagged/" method="post">
		<input type="text" name="name" />
		<input type="submit" name="submit" value="Pesquisar" />
	</form>
</div>

</body>
</html>
