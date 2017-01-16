<%-- 
    Document   : resultado
    Created on : 10-ene-2017, 17:33:38
    Author     : Daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:out value="${requestScope.profesor.id}"/>,<c:out value="${requestScope.profesor.nombre}"/>,<c:out value="${requestScope.profesor.ape1}"/>,<c:out value="${requestScope.profesor.ape2}"/>
    </body>
</html>
