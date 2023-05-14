<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="modelo.Cliente" %>
   <%Cliente clienteEdit = (Cliente)request.getAttribute("clienteEdit");%>
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
            <form action="Controlador?menu=clientes" method="POST">
                <label for="txt_clienteEditDni">DNI</label>
                <input type="text" value="${clienteEdit.getDni()}" name="txt_clienteEditDni" class="text" readonly>
                <label for="txt_clienteEditName">Nombres</label>
                <input type="text" value="${clienteEdit.getNombre()}" name="txt_clienteEditName" class="text" readonly>
                <label for="txt_clienteEditAdress">Dirección</label>
                <input type="text" value="${clienteEdit.getDireccion()}" name="txt_clienteEditAdress" class="text">
                <label for="txt_clienteEditState">Estado</label>
                <input type="text" value="${clienteEdit.getEstado()}" name="txt_clienteEditState" class="text">
                <div class="button_container">
                    <input type="submit" name="action" value="Actualizar" class="button">
                </div>
            </form>
        </div>
    </div>
</body>
</html>