<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : RegistroUsuario
    Created on : 19-nov-2017, 17:19:38
    Author     : Desarrollo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de clientes</title>
    </head>
    <body>
        <h2>Ingrese sus datos</h2>
        <form action="ServletAgregarCliente">
            <table>
                <tr>
                    <td>
                        <label>
                            RUN                            
                        </label>
                    </td>
                    <td>
                        <input type="text" name="rut_cliente" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>
                            Nombre completo                            
                        </label>
                    </td>
                    <td>
                        <input type="text" name="nombre" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>
                            Clave                            
                        </label>
                    </td>
                    <td>
                        <input type="text" name="clave" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>
                            Comuna                            
                        </label>
                    </td>
                    <td>
                        <select name="comunaid">
                            <c:forEach var="comuna" items="${listaComunas}">
                                <option value="${comuna.id}"><c:out value="${comuna.nombre}"></c:out></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>
                            Direccion                            
                        </label>
                    </td>
                    <td>
                        <input type="text" name="direccion" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>
                            Telefono                            
                        </label>
                    </td>
                    <td>
                        <input type="text" name="telefono" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Registrar">
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <c:if test="${not empty mensaje}">
            ${mensaje}
        </c:if>
        <br>
        <a href="index.html">Volver al Inicio</a>
    </body>
</html>