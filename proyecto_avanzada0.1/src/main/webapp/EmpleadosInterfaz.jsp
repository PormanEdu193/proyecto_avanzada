<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="modelo.Empleado" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">	
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/styleEmpleados.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+3:ital,wght@0,200;0,300;0,400;0,500;0,600;0,800;1,200;1,300;1,700;1,800&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="form_body in-flex" >
            <form action="">
                <label for="txt_dni">DNI</label>
                <input type="text" name="txt_dni" class="text">
                <label for="txt_name">Nombres</label>
                <input type="text" name="txt_name" class="text">
                <label for="txt_name">Telefono</label>
                <input type="text" name="txt_phone" class="text">
                <label for="txt_name">Estado</label>
                <input type="text" name="txt_state" class="text">
                <label for="txt_name">Usuario</label>
                <input type="text" name="txt_user" class="text">
                <input type="submit" name="action" value="Agregar" class="button">
            </form>
        </div>
        <div class="table_body in-flex">
            <table>
                <thead>
                    <tr>
                    	<th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>TELEFONO</th>
                        <th>ESTADO</th>
                        <th>USER</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                	<tr>
                		<% List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados"); %>
                		 <% for(Empleado empleado : empleados) { %>
  								<td><%=empleado.getIdEmpleado()%></td>
                        		<td><%=empleado.getDni()%></td>
                        		<td><%=empleado.getNombre()%></td>
                        		<td><%=empleado.getTelefono()%></td>
                        		<td><%=empleado.getEstado()%></td>
                        		<td><%=empleado.getUser()%></td>
                        <td>
                        	<a>Editar</a>
                        	<a>Eliminar</a>
                        </td>  
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
    
</body>
</html>