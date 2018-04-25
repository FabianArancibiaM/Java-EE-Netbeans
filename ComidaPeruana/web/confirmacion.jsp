<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : confirmacion
    Created on : 19-nov-2017, 17:59:43
    Author     : Desarrollo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <h2>Confirma tu pedido</h2>
        <table style="border: 1">
            <th>Plato</th>
            <th>Bebida</th>
            <th>Valor total</th>
            <th>Accion</th>
            <c:forEach var="pedido" items="${pedidoCompleto}">
                <tr>
                <td><c:out value="${pedido.plato}"></c:out></td>
                <td><c:out value="${pedido.bebida}"></c:out></td>
                <td><c:out value="${pedido.total}"></c:out></td>
                <td>
                    <form action="ServletBuscarIdModificar">
                        <input type="hidden" name="modificar_id" value="${pedido.id_pedido}"> 
                        <input type="submit" value="Modificar">
                    </form>
                    <form action="ServletEliminar">
                        <input type="hidden" name="cliente" value="${usuario}" />
                        <input type="hidden" name="eliminar_id" value="${pedido.id_pedido}"> 
                        <input type="submit" value="Eliminar">
                    </form>
                </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3">
                    total
                </td>
                <td>
            <c:out value="${totalPedido}"></c:out>
        </td>
    </tr>
    <tr>
        <td colspan="4">
            <form action="pedidoConfirmado.jsp">
                <input type="submit" value="Confirmar">
            </form>
            <form action="ServletCargarPedido">
                <input type="hidden" name="cliente" value="${usuario}" />
                <input type="submit" value="Añadir Pedido" />
            </form>
            <form action="ServletCargarHistorialPedidos">
                <input type="hidden" name="cliente" value="${usuario}" />
                <input type="submit" value="Ver Historial de pedidos" />
            </form>
            </td>
    </tr>
</table>

</body>
</html>
