<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : EditarPedido
    Created on : 22-nov-2017, 8:15:04
    Author     : Desarrollo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        rut: ${usuario} 
        <br>
        fecha : ${fecha} 
        <br>
        pedido : ${idPedido}
        <br>
        <h2>Ingrese su pedido</h2>
        <form action="ServletModificarPedido">
            <input type="hidden" name="rutModif" value="${usuario}" />
            <input type="hidden" name="idModif" value="${idPedido}" />
            <br>
            <table>
                <tr>
                    <td>
                        Plato Seleccionado ${platoSelec} * volver a seleccionar para confirmar
                    </td>                    
                </tr>
                <tr>
                    <td>
                        <select name="platoModif">
                            <c:forEach var="p" items="${listaPlatos}">
                                <option value="${p.nombre}"><c:out value="${p.nombre}-${p.precio}"></c:out></option>
                            </c:forEach>
                        </select>
                    </td>

                </tr>
                <tr>
                    <td>
                        Bebida Seleccionada ${bebidaSelec} * volver a seleccionar para confirmar
                    </td>                    
                </tr>
                <tr>
                    <td>
                        <select name="bebidaModif">
                            <c:forEach var="b" items="${listaBebidas}">
                                <option value="${b.nombre}"><c:out value="${b.nombre}-${b.precio}"></c:out></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        ¿Despacho a domicilio? Seleccionado ${aDomicilioSelec} * volver a seleccionar para confirmar
                    </td>                    
                </tr>
                <tr>
                    <td>
                        <select name="despachoModif">
                            <option value="1">Si </option>
                            <option value="0">No </option>
                        </select> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="boton" value="Modificar">
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <form action="ServletSinCambios">
            <input type="hidden" name="alCarro" value="${usuario}" /><br>
            <input type="submit" value="Ir al Carro" />
        </form>
    </body>
</html>
