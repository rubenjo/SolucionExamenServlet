<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado Consolas</title>
</head>
<body>
	<form action="consoleList" method="post">
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
			<c:forEach var="console" items="${listAllConsoles}">
				<tr>
					<td><c:out value="${console.name}" /></td>
					<td><c:out value="${console.company}" /></td>
					<td><a href="/delete?consola=${console.console}">borrar</a></td>
					<jsp:include page="/confirmation.jsp" flush="true"></jsp:include>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<select>
		<c:forEach var="console" items="${listAllConsoles}">
			<option value="${console.name}">${console.name}</option>
		</c:forEach>
	</select>
</body>
</html>