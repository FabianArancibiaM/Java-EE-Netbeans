<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : pedido
    Created on : 19-nov-2017, 17:39:31
    Author     : Desarrollo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresa tu pedido</title>
    </head>
    <body>
        rut: ${usuario} 
        <br>
        fecha : ${fecha} 
        <br>
        <h2>Ingrese su pedido</h2>
        <form action="ServletPedidos">
            <input type="hidden" name="fecha" value=" ${fecha} " />
            <input type="hidden" name="rut" value="${usuario}" />
            <br>
            <table>
                <tr>
                    <td>
                        Plato
                    </td>                    
                </tr>
                <tr>
                    <td>
                        <select name="plato">
                            <c:forEach var="p" items="${listaPlatos}">
                                <option value="${p.nombre}"><c:out value="${p.nombre}-${p.precio}"></c:out></option>
                            </c:forEach>
                        </select>
                    </td>

                </tr>
                <tr>
                    <td>
                        Bebida
                    </td>                    
                </tr>
                <tr>
                    <td>
                        <select name="bebida">
                            <c:forEach var="b" items="${listaBebidas}">
                                <option value="${b.nombre}"><c:out value="${b.nombre}-${b.precio}"></c:out></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        ¿Despacho a domicilio?
                    </td>                    
                </tr>
                <tr>
                    <td>
                        <select name="despacho">
                            <option value="1">Si </option>
                            <option value="0">No </option>
                        </select> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Agregar al carro">
                    </td>
                </tr>
            </table>
        </form><br>
        <form action="ServletSinCambios">
            <input type="hidden" name="alCarro" value="${usuario}" /><br>
            <input type="submit" value="Ir al Carro" />
        </form>
    </body>
</html>
