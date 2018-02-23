<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Videojuegos Marcas</title>
</head>
<body>
	<form action="listVideogamesByConsole" method="post">
+		<input type="submit" value="Mostrar lista"/><br/>
+		<span>SELECCIONA LA CONSOLA:</span><br/>
+		<select name="selectConsole">
+			<c:forEach var="console" items="${listAllConsoles}">
+				<option value="<c:out value="${console.name}"/>"><c:out value="${console.name}" /></option>
+			</c:forEach>
+		</select>
+	</form>
+	<br>
+	
+	<table border="1">
+		<thead>
+			<tr>
+				<td>Nombre</td>
+				<td>Fecha de creacion</td>
+			</tr>
+		</thead>
+		<tbody>
+			<c:forEach var="videogame" items="${listAllVideogames}">
+				<tr>
+					<td><c:out value="${videogame.tittle}" /></td>
+					<td><c:out value="${videogame.recommendedAge}" /></td>
+					<td><c:out value="${videogame.releaseDate}" /></td>
+					<td><c:out value="${videogame.consoleName}" /></td>
+				</tr>
+			</c:forEach>
+		</tbody>
+	</table>
</body>
</html>