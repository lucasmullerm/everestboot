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
	<form action="/" method="post">
		Nome: 									<input type="text" name="name" />
		URL: 									<input type="text" name="url" />
		Comentário: 							<input type="textarea" name="comment" />
		Tags(Utilize vírgula como separador): 	<input type="text" name="tags" value="ex1,ex2" />
												<input type="submit" name="add" value="Adicionar Hyperlink" />
	</form>
</div>	
<br>
<a href="javascript:window.history.back();">Voltar</a>

</body>
</html>