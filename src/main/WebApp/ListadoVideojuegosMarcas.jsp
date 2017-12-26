<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Videojuegos Marcas</title>
</head>
<body>
	<form action="cargarListado" method="post">
		<input type="submit" value="ver listado">
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>Titulo</td>
				<td>Consola</td>
				<td>Empresa</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="videojuego" var="consola" items="${videojuegos}">
				<tr>
					<td><c:out value="${videojuego.titulo}" /></td>
					<td><c:out value="${videojuego.nom_Consola}" /></td>
					<td><c:out value="${consola.nom_Empresa}" /></td>
					<td><a href="/delete?consola=${videojuego.titulo}">borrar</a></td>
					<jsp:include page="/confirmation.jsp" flush="true"></jsp:include>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<select>
		<c:forEach var="videojuego" items="${videojuegos}">
			<option value="${videojuego.titulo}">${videojuego.titulo}</option>
		</c:forEach>
	</select>
</body>
</html>