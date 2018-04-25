<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : historial
    Created on : 23-11-2017, 23:32:18
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar pedido</title>
        <style>
table, th, td {
    border: 1px solid black;
}
</style>
    </head>
    <body>
        ${usuario}
        <h2>Historial de pedido</h2>
        <table style="border: 1">
            <th>Fecha</th>
            <th>Plato</th>
            <th>Bebida</th>
            <th>Valor total</th>
            <th>Accion</th>
            <c:forEach var="pedido" items="${listaHistorial}">
                <tr>
                <td><c:out value="${pedido.fecha}"></c:out></td>
                <td><c:out value="${pedido.plato}"></c:out></td>
                <td><c:out value="${pedido.bebida}"></c:out></td>
                <td><c:out value="${pedido.total}"></c:out></td>
                </tr>
            </c:forEach>
    <tr>
        <td colspan="4">
            <form action="ServletSinCambios">
                <input type="hidden" name="alCarro" value="${usuario}" />
                <input type="submit" value="Volver">
            </form>
        </td>
    </tr>
</table>
    </body>
</html>
