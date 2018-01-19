<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado videojuegos</title>
</head>
<body>
	<form action="listadoVideojuegos" method="post">
		<input type="submit" value="ver listado">
	</form>
	<table border="1">
		<thead>
			<tr>
				<td>Titulo</td>
				<td>Edad_Recomendada</td>
				<td>Fecha_Lanzamiento</td>
				<td>Consola</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="game" items="${games}">
				<tr>
					<td><c:out value="${game.titulo}" /></td>
					<td><c:out value="${game.edadRecomendada}" /></td>
					<td><c:out value="${game.fechaLanzamiento}" /></td>
					<td><c:out value="${game.nom_Consola}" /></td>
					<td><a href="/delete?titulo=${game.titulo}">borrar</a></td>
					<jsp:include page="/confirmation.jsp" flush="true"></jsp:include>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<select>
		<c:forEach var="game" items="${games}">
			<option value="${game.titulo}">${game.titulo}</option>
		</c:forEach>
	</select>
</body>
</html>