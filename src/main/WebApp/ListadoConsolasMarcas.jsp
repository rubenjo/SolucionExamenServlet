<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Consolas Marca</title>
</head>
<body>
	<form action="listadoConsolaMarca" method="post">
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
					<td><c:out value="${consola.consola}" /></td>
					<td><c:out value="${consola.nom_Empresa}" /></td>
					<td><a href="/delete?consola=${consola.consola}">borrar</a></td>
					<jsp:include page="/confirmation.jsp" flush="true"></jsp:include>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<select>
		<c:forEach var="consola" items="${consolas}">
			<option value="${consola.consola}">${consola.consola}</option>
		</c:forEach>
	</select>
</body>
</html>