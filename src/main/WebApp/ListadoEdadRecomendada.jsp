<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de edad</title>
</head>
<body>
	<form action="listByRecommendedAge" method="post">
+		<span>Edad recomendada:</span> 
+		<select name="recommendedAge" id="recommendedAge">
+			<option name="TP" value="TP">TP</option>
+            <option name="+7" value="+7">+7</option>
+            <option name="+13" value="+13">+13</option>
+            <option name="+18" value="+18">+18</option>
+		</select><br/>
+		<input type="submit" value="Ver listado" name="enviar" >
+	</form>
+	<br/>
+	<table border="1">
+		<thead>
+			<tr>
+				<form action="orderVideogames" method="post">
+					<input type="text" value="<c:out value="${recommendedAge}" />" name="selectedAge">
+					<select name="order" id="order">
+						<option name="orderByTitle" value="orderByTitle">Ordenar por alfabeticamente por su titulo</option>
+				    	<option name="orderByReleaseDate" value="orderByReleaseDate">Ordenar segun la fecha</option>
+					</select>
+					<input type="submit" value="Ordenar" name="enviar" >
+				</form>
+			</tr>
+			<tr>
+				<td>Titulo</td>
+				<td>Fecha de lanzamiento</td>
+				<td>Consola</td>
+				<td>Edad recomendada</td>
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