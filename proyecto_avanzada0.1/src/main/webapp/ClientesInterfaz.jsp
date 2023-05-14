<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="modelo.Cliente" %>
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
            <form action="Controlador?menu=clientes" method="POST">
            	<div>
            		<label for="txt_dniClient">DNI</label>
                    <input type="text" name="txt_dniClient" class="text">
                </div>
                <div>
                	<label for="txt_nameClient">Nombres</label>
                     <input type="text" name="txt_nameClient" class="text">
                </div>
                <div>
               		<label for="txt_adressClient">Dirección</label> 
                    <input type="text" name="txt_adressClient" class="text">
                </div>
                <div>
                 	<label for="txt_stateClient">Estado</label>
                    <input type="text"  name="txt_stateClient" class="text">  
                </div>
                <input type="submit" name="action" value="Agregar cliente" class="button"> 
            </form>
        </div>
        <div class="table_body in-flex">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>DNI</th>
                        <th>Nombres</th>
                        <th>Dirección</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
						<% List<Cliente> clients = (List<Cliente>) request.getAttribute("clients");%>
						<%for(Cliente client : clients){ %>
                                <td><%=client.getIdCliente()%></td>
                                <td><%=client.getDni()%></td>
                                <td><%=client.getNombre()%></td>
                                <td><%=client.getDireccion() %></td>
                                <td><%=client.getEstado() %></td>	
                                <td>
                                	<a  href="Controlador?menu=clientes&action=edit&id=<%=client.getIdCliente()%>">Editar</a>
                           		 	<a  href="Controlador?menu=clientes&action=delete&id=<%=client.getIdCliente()%>">Eliminar</a>
                            	</td> 
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>