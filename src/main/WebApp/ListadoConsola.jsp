<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado Consolas</title>
</head>
<body>
	<form action="cargarListado" method="post">
		<input type="submit" value="ver listado">
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>Consola</td>
				<td>Empresa</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="consola" items="${consolas}">
				<tr>
					<td><c:out value="${consolas.consola}" /></td>
					<td><c:out value="${consolas.nom_Empresa}" /></td>
					<td><a href="/delete?consola=${consolas.consola}">borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<select>
		<c:forEach var="consola" items="${consolas}">
			<option value="${consolas.consola}">${consolas.consola}</option>
		</c:forEach>
	</select>
</body>
</html>