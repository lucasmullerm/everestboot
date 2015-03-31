<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
	<title>Add Hyperlink</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/main.css">
</head>

<body>
<div>
	<h1>Adicionar Hyperlink</h1>
</div>

<div>
	<form action="/add/" method="post">
		                          Nome:  <input type="text" name="name" /><br>
		                          URL:   <input type="text" name="url" /><br>
		                          Comentário:  <input type="textarea" name="comment" /><br>
		Tags(Utilize vírgula como separador): <input type="text" name="tags" value="ex1,ex2" /><br>
												<input type="submit" name="add" value="Adicionar Hyperlink" /><br>
	</form>
</div>	
<br>
<a href="javascript:window.history.back();">Voltar</a>

</body>
</html>