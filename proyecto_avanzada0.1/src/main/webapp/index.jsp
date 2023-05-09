<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/styleLogin.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+3:ital,wght@0,200;0,300;0,400;0,500;0,600;0,800;1,200;1,300;1,700;1,800&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<body>
   <div class="container">
        <div class="login">
            <div class="login-body">
                <label class="title"><b>Login</b></label>
                <img src="https://i.ibb.co/fFRh9Ds/carrito-de-compras.png" alt="Logo">
                <label><b>Bienvenido al sistema</b></label>
            <form action="Validar" method="POST"> 
                <label  for="user_txt">Usuario</label>
                <input type="text" name="user_txt" id="user_txt" class="txt" placeholder="Ingrese nombre de usuario">
                <label  for="pass_txt">Contraseña</label>
                <input type="password" name="pass_txt" id="pass_txt" class="txt" placeholder="Ingrese contraseña">
                <input type="submit" name="action" value="Ingresar" class="button">            
            </form>
            </div>      
        </div>
   </div> 
</body>
</html>