<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="modelo.Venta" %>
	<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/styleVenta.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+3:ital,wght@0,200;0,300;0,400;0,500;0,600;0,800;1,200;1,300;1,700;1,800&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <div class="container">

        <div class="form_body">
            <form action="Controlador?menu=nueva_venta" method="POST">
                <label for="">Datos Cliente</label>
                <div class="container-formItem">
                    <div class="search-cliente">
                        <input type="text" value="${clienteBuscar.getDni()}" placeholder="Codigo" class="text" name="txt_clientCode">
                        <button type="submit" value="buscarCliente" name="action" class="search-btn">Buscar</button>
                    </div>
                    <input type="text" placeholder="Datos Cliente"  value="${clienteBuscar.getNombre()}" class="text" name="txt_clientData" readonly>
                </div>
                <label for="">Datos Producto</label>
                <div class="container-formItem"> 
                    <div class="container-formItem-left">
                        <div class="first-item">
                            <input type="text" value="${productoBuscar.getIdProducto()}" placeholder="Codigo"  name="txt_productCode" class="text">
                            <button type="submit" value="buscarProducto" name="action" class="search-btn">Buscar</button>
                        </div>
                        <input type="text" value="${productoBuscar.getPrecio()}" name="txt_productPrice" placeholder="$0.00" class="text" readonly>
                    </div>  
                    <div class="container-formItem-rigth">
                        <input type="text" value="${productoBuscar.getNombre()}" placeholder="Datos Producto" class="text" name="txt_productData" readonly>
                        <div class="first-item">
                            <input type="number" value="1"  name="txt_productAmount" class="text">
                            <input type="text" value="${productoBuscar.getStock()}" placeholder="Stock" class="text" name="txt_stock" readonly>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Agregar" name="action" class="btn_agregar">
            </form>     
        </div>

        <div class="table_body">
            <label>Numero de serie</label>
            <input  value="${serie}" type="text" class="text" readonly>
            <table>
                <thead>
                    <tr>
                        <th>Nro</th>
                        <th>Código</th>
                        <th>Descripción</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                     <% List<Venta> ventas = (List<Venta>) request.getAttribute("listVentas");%>
                     <%if(ventas!=null) { %>
                     <% for(Venta venta : ventas){ %>
                                <td><%=venta.getItem()%></td>
                                <td><%=venta.getCodigo() %></td>
                                <td><%=venta.getDescripcion()%></td>
                                <td><%=venta.getPrecio()%></td>
                                <td><%=venta.getCantidad()%></td>
                                <td><%=venta.getSubtotal()%></td>
                        <td>
                            <a  href="">Eliminar</a>
                        </td>  
                    </tr>
                    <%}%>
                   <%}%>
                </tbody>
            </table>
            <div class="buttons">
            
            <form action="Controlador?menu=nueva_venta" method="POST">
             	<button type="submit" class="btn_generar" name="action" value="generarVenta">Generar venta</button>
                <button type="submit"  value="cancelar" class="btn_cancelar" name="action">Cancelar</button>
                <button class="btnImprimir">Imprimir</button>
            </form>
               
                <input type="text" placeholder="Total" value="${total}" name="txt_total" class="text" readonly>
            </div>
        </div>
    </div>
</body>
</html>