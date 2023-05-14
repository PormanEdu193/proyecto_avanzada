<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="modelo.Empleado" %>
    <%Empleado empleadoEdit = (Empleado)request.getAttribute("empleadoEdit");%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=ç, initial-scale=1.0">
    <link rel="stylesheet" href="styles/styleEditar.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+3:ital,wght@0,200;0,300;0,400;0,500;0,600;0,800;1,200;1,300;1,700;1,800&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="form_body" >
            <form action="Controlador?menu=empleados" method="POST">
                <label for="txt_dni">DNI</label>
                <input type="text" value="${empleadoEdit.getDni()}" name="txt_editDni" class="text" readonly>
                <label for="txt_name">Nombres</label>
                <input type="text" value="${empleadoEdit.getNombre()}" name="txt_editName" class="text" readonly>
                <label for="txt_name">Telefono</label>
                <input type="text" value="${empleadoEdit.getTelefono()}" name="txt_editPhone" class="text">
                <label for="txt_name">Estado</label>
                <input type="text" value="${empleadoEdit.getEstado()}" name="txt_editState" class="text">
                <label for="txt_name">Usuario</label>
                <input type="text" value="${empleadoEdit.getUser()}" name="txt_editUser" class="text">
                <div class="button_container">
                    <input type="submit" name="action" value="Actualizar" class="button">
                </div>
            </form>
        </div>
    </div>
</body>
</html>