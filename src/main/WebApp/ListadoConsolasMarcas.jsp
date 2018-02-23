<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Consolas Marca</title>
</head>
<body>
	<form action="listConsolesByCompany" method="post">
+		<input type="submit" value="Mostrar lista"/><br/>
+		
+		<select name="selectCompany">
+			<c:forEach var="company" items="${listAllCompanies}">
+				<option value="<c:out value="${company.name}" />"><c:out value="${company.name}" /></option>
+			</c:forEach>
+		</select>
	</form>
+	<br/>
+	<table border="1">
+		<thead>
+			<tr>
+				<td>Nombre</td>
+				<td>Empresa</td>
+			</tr>
+		</thead>
+		<tbody>
+			<c:forEach var="console" items="${listAllConsoles}">
+				<tr>
+					<td><c:out value="${console.name}" /></td>
+					<td><c:out value="${console.company.name}" /></td>
+				</tr>
+			</c:forEach>
+		</tbody>
+	</table>
</body>
</html>