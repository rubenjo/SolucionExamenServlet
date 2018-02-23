@@ -0,0 +1,14 @@
+create table IF NOT EXISTS EMPRESAS(
+	nombre varchar(25) PRIMARY KEY,
+	fechaCreacion date
+);
+create table IF NOT EXISTS CONSOLAS(
+	nombre varchar(25) PRIMARY KEY,
+	empresa varchar(25)
+);
+create table IF NOT EXISTS VIDEOJUEGOS(
+	titulo varchar(25) PRIMARY KEY,
+	edadRecomendada varchar(25),
+	fechaLanzamiento date,
+	nombreConsola varchar(25)
+);