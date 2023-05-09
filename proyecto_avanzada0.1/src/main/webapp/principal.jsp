<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/stylePrincipal.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+3:ital,wght@0,200;0,300;0,400;0,500;0,600;0,800;1,200;1,300;1,700;1,800&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <header>
        <nav class="navigaton_bar">
            <ul class="nav_items">
                <li class="nav_item">
                    <a href="Controlador?menu=home" target="page_frame" class="logo">
                        <img src="https://i.ibb.co/fFRh9Ds/carrito-de-compras.png" alt="logo">
                        <p class="logo_name">Sistema de ventas<p>
                    </a>
                </li>
                <li class="nav_item"><a href="Controlador?menu=home" target="page_frame">Home</a></li>
                <li class="nav_item"><a href="Controlador?menu=producto" target="page_frame">Producto</a></li>
                <li class="nav_item"><a href="Controlador?menu=empleados&action=list" target="page_frame">Empleado</a></li>
                <li class="nav_item"><a href="Controlador?menu=clientes" target="page_frame">Clientes</a></li>
                <li class="nav_item"><a href="Controlador?menu=nueva_venta" target="page_frame">Nueva Venta</a></li>
                <li class="nav_item">
                    <a class="desplegable">
                        <button type="button" disabled>${user.getNombre()}</button>
                        <div class="user">
                          <img src="https://i.ibb.co/SfH41Gd/technician.png" alt="empelado">
                          <p class="usuario">${user.getUser()}</p>
                          <p class="correo">email@example.com</p>
                          <form action="Validar" method="POST">
                          	<button name="action" value="salir">Salir</button>
                          </form>
                        </div> 
                      </a>
                </li> 
            </ul>
        </nav>
    </header>
    <div class="frame-container">
        <iframe class="page_frame" name="page_frame">
        </iframe>
    </div>
</body>
</html>