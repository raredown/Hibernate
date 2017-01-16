<%-- 
    Document   : index
    Created on : 10-ene-2017, 11:34:58
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="Controlador">Ir</a>
        <form method="post" action="Controlador">
           Nombre <input type="text" name="nombre" >
            Apellido <input type="text" name="ape1" >
            Segundo apellido<input type="text" name="ape2" >
            <input type="submit" value="enviar">
        </form>
    </body>
</html>
