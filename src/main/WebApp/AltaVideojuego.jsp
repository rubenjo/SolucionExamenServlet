<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta Videojuego</title>
</head>
<body>
	<form action="gameRegister" method="post">
		<span>title:</span> 
		<input type="text" name="title"> <br/>
		<span>Recommended Age:</span>
		<input type="text" name="recommendedAge"> <br/>
		<span>Console Name:</span>
		<input type="text" name="consoleName"> <br/>
		<span>Release Date:</span> 
		<input type="text" name="releaseDate"><br/>
		<input type="submit">
	</form>
</body>
</html>