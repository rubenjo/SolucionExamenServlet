<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado videojuegos</title>
</head>
<body>
	<form action="gameRegister" method="post">
		<input type="submit" value="ver listado">
	</form>
	<table border="1">
		<thead>
			<tr>
				<td>Titulo</td>
				<td>Edad Recomendada</td>
				<td>Fecha Lanzamiento</td>
				<td>Consola</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="game" items="${listAllGames}">
				<tr>
					<td><c:out value="${game.tittle}" /></td>
					<td><c:out value="${game.recommendedAge}" /></td>
					<td><c:out value="${game.releaseDate}" /></td>
					<td><c:out value="${game.consoleName}" /></td>
					<td><a href="/delete?titulo=${game.tittle}">borrar</a></td>
					<jsp:include page="/confirmation.jsp" flush="true"></jsp:include>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<select>
		<c:forEach var="game" items="${listAllGames}">
			<option value="${game.tittle}">${game.tittle}</option>
		</c:forEach>
	</select>
</body>
</html>