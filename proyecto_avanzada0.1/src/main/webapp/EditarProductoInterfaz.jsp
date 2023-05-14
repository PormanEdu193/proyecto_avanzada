<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="modelo.Producto" %>
    <%Producto productoEdit = (Producto)request.getAttribute("productoEdit");%>
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
            <form action="Controlador?menu=producto" method="POST">
                <label for="txt_nameEditProduct">Nombre producto</label>
                <input type="text" value="${productoEdit.getNombre()}" name="txt_nameEditProduct" class="text">
                <label for="txt_priceEditProduct">Precio</label>
                <input type="number" value="${productoEdit.getPrecio()}" name="txt_priceEditProduct" class="text">
                <label for="txt_stockEditProduct">Stock</label>
                <input type="number" value="${productoEdit.getStock()}" name="txt_stockEditProduct" class="text">
                <label for="txt_stateEditProduct">Estado</label>
                <input type="text" value="${productoEdit.getEstado()}" name="txt_stateEditProduct" class="text">
                <div class="button_container">
                    <input type="submit" name="action" value="Actualizar producto" class="button">
                </div>
            </form>
        </div>
    </div>
</body>
</html>