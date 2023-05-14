<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="modelo.Producto" %>
	<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/styleVentanas.css">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="form_body">
            <form action="Controlador?menu=producto" method="POST">
            	<div>
            		<label for="txt_nameProduct">Nombre Producto</label>
                    <input type="text" name="txt_nameProduct" class="text">
                </div>
                <div>
                	<label for="txt_priceProduct">Precio</label>
                     <input type="number" name="txt_priceProduct" class="text">
                </div>
                <div>
               		<label for="txt_stockProduct">Stock</label> 
                    <input type="number" name="txt_stockProduct" class="text">
                </div>
                <div>
                 	<label for="txt_stateProduct">Estado</label>
                    <input type="text"  name="txt_stateProduct" class="text">  
                </div>
                <input type="submit" name="action" value="Agregar producto" class="button"> 
            </form>
        </div>
        <div class="table_body in-flex">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
						<% List<Producto> products = (List<Producto>) request.getAttribute("products"); %>
						<% for(Producto product : products) { %>
                                <td><%=product.getIdProducto()%></td>
                                <td><%=product.getNombre()%></td>
                                <td><%=product.getPrecio()%></td>
                                <td><%=product.getStock()%></td>
                                <td><%=product.getEstado()%></td>
                                <td>
                                	<a  href="Controlador?menu=producto&action=edit&id=<%=product.getIdProducto()%>">Editar</a>
                           		 	<a  href="Controlador?menu=producto&action=delete&id=<%=product.getIdProducto()%>">Eliminar</a>
                            	</td> 
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>