	package controlador;
	
	import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
	import jakarta.servlet.ServletContext;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import modelo.Cliente;
	import modelo.ClienteDao;
	import modelo.Empleado;
	import modelo.EmpleadoDao;
	import modelo.ProductoDao;
	import modelo.Venta;
	import modelo.VentaDao;
	import modelo.Producto;

	import java.awt.Desktop.Action;
	import java.io.IOException;
	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	
	
	public class Controlador extends HttpServlet {
		private static final long serialVersionUID = 1L;
		Empleado empleado = new Empleado();
		Producto producto = new Producto();
		Cliente cliente = new Cliente();
		EmpleadoDao empleadoDao = new EmpleadoDao();
		ProductoDao productoDao = new ProductoDao();
		ClienteDao clienteDao = new ClienteDao();
		Venta venta = new Venta();
		VentaDao ventaDao = new VentaDao();
		
		int idInt,itemInt;
		List<Venta> listVentas = new ArrayList<>();
		double totalDouble;
		String serieString,idEmpledoIngresadoString;
	    public Controlador() {
	    }
	    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	    	String menu = request.getParameter("menu");
			String action = request.getParameter("action");
			String actionEdit = request.getParameter("actionEdit");
			String ingreso = request.getParameter("ingreso");
			if(ingreso != null) {
				idEmpledoIngresadoString=request.getParameter("idEmpleado");
			}
			System.out.println(menu+" "+action+" "+actionEdit+" "+idEmpledoIngresadoString);
			
			if(menu.equals("edit") && actionEdit!=null) {
				switch (actionEdit) {
				case "empleado":
					request.getRequestDispatcher("EditarInterfaz.jsp").forward(request, response);
					break;
				case "producto":
					request.getRequestDispatcher("EditarProductoInterfaz.jsp").forward(request, response);
				case "clientes":
					request.getRequestDispatcher("EditarClienteInterfaz.jsp").forward(request, response);
				default:
					break;
				}
				
			}
			if (menu.equals("principal")) {
				request.getRequestDispatcher("principal.jsp").forward(request, response);
			}
			
			if (menu.equals("producto") && action!=null) {
				switch (action) {
				case "list":{
					List list = productoDao.list();
					request.setAttribute("products", list);
					break;
				}
				case "Agregar producto":{
					String nameProString = request.getParameter("txt_nameProduct");
					Double priceProDouble = Double.parseDouble(request.getParameter("txt_priceProduct"));
					int stockProInt = Integer.parseInt(request.getParameter("txt_stockProduct"));
					String stateProString = request.getParameter("txt_stateProduct");
					producto.setNombre(nameProString);
					producto.setPrecio(priceProDouble);
					producto.setStock(stockProInt);
					producto.setEstado(stateProString);
					productoDao.add(producto);
					request.getRequestDispatcher("Controlador?menu=producto&action=list").forward(request, response);
					break;
				}
				case "delete":{
					idInt = Integer.parseInt(request.getParameter("id"));
					productoDao.delete(idInt);
					request.getRequestDispatcher("Controlador?menu=producto&action=list").forward(request, response);
					break;
				}
				case "edit":{
					idInt = Integer.parseInt(request.getParameter("id"));
					Producto productoEdit = productoDao.edit(idInt);
					request.setAttribute("productoEdit", productoEdit);
					request.getRequestDispatcher("Controlador?menu=edit&actionEdit=producto").forward(request, response);
					break;
				}
				case "Actualizar producto":{
					String NewNameString = request.getParameter("txt_nameEditProduct");
					Double NewPriceDouble = Double.parseDouble(request.getParameter("txt_priceEditProduct"));
					int NewStockInt = Integer.parseInt(request.getParameter("txt_stockEditProduct"));
					String NewEstadoString =request.getParameter("txt_stateEditProduct");
					producto.setNombre(NewNameString);
					producto.setPrecio(NewPriceDouble);
					producto.setStock(NewStockInt);
					producto.setEstado(NewEstadoString);
					producto.setIdProducto(idInt);
					productoDao.update(producto);
					request.getRequestDispatcher("Controlador?menu=producto&action=list").forward(request, response);
					break;
				}
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
				request.getRequestDispatcher("ProductoInterfaz.jsp").forward(request, response);
			}
			if (menu.equals("empleados")&& action!=null) {
			switch (action) {
				case "list": {
					List list =empleadoDao.list();
					request.setAttribute("empleados", list);
					break;
				}
				case "Agregar": {
					String dniString = request.getParameter("txt_dni");
					String nameString = request.getParameter("txt_name");
					String phoneString = request.getParameter("txt_phone");
					String stateString = request.getParameter("txt_state");
					String userString = request.getParameter("txt_user");
					empleado.setDni(dniString);
					empleado.setNombre(nameString);
					empleado.setTelefono(phoneString);
					empleado.setEstado(stateString);
					empleado.setUser(userString);
					empleadoDao.add(empleado);
					request.getRequestDispatcher("Controlador?menu=empleados&action=list").forward(request, response);
					break;
				}
				case "Actualizar":{
					String newDniString = request.getParameter("txt_editDni");
					String newNameString = request.getParameter("txt_editName");
					String newPhoneString = request.getParameter("txt_editPhone");
					String newStateString = request.getParameter("txt_editState");
					String newUserString = request.getParameter("txt_editUser");
					empleado.setDni(newDniString);
					empleado.setNombre(newNameString);
					empleado.setTelefono(newPhoneString);
					empleado.setEstado(newStateString);
					empleado.setUser(newUserString);
					empleado.setIdEmpleado(idInt);
					empleadoDao.update(empleado);
					request.getRequestDispatcher("Controlador?menu=empleados&action=list").forward(request, response);
					break;
				}
				case "edit": {
					idInt = Integer.parseInt(request.getParameter("id"));
					Empleado empleadoEdit = empleadoDao.edit(idInt);
					request.setAttribute("empleadoEdit", empleadoEdit);
					request.getRequestDispatcher("Controlador?menu=edit&actionEdit=empleado").forward(request, response);
					break;
				}
				case "delete": {
					int idInt = Integer.parseInt(request.getParameter("id"));
					empleadoDao.delete(idInt);
					request.getRequestDispatcher("Controlador?menu=empleados&action=list").forward(request, response);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
				request.getRequestDispatcher("EmpleadosInterfaz.jsp").forward(request, response);
					
			}
			
			if (menu.equals("clientes")&& action!=null) {
				switch (action) {
					case "list":
						List list = clienteDao.list();
						request.setAttribute("clients", list);
						break;
					case "Agregar cliente":
						String clientDniString = request.getParameter("txt_dniClient");
						String clientNameString = request.getParameter("txt_nameClient");
						String clientAdressString = request.getParameter("txt_adressClient");
						String clientStateString = request.getParameter("txt_stateClient");
						cliente.setDni(clientDniString);
						cliente.setNombre(clientNameString);
						cliente.setDireccion(clientAdressString);
						cliente.setEstado(clientStateString);
						clienteDao.add(cliente);
						request.getRequestDispatcher("Controlador?menu=clientes&action=list").forward(request, response);
						break;
					case "delete":
						idInt = Integer.parseInt(request.getParameter("id"));
						clienteDao.delete(idInt);
						request.getRequestDispatcher("Controlador?menu=clientes&action=list").forward(request, response);
						break;
					case "edit":
						System.out.println("Entre a editar");
						idInt = Integer.parseInt(request.getParameter("id"));
						Cliente clienteEdit = clienteDao.edit(idInt);
						request.setAttribute("clienteEdit", clienteEdit);
						request.getRequestDispatcher("Controlador?menu=edit&actionEdit=clientes").forward(request, response);
						break;
					case "Actualizar":
						String newDniString = request.getParameter("txt_clienteEditDni");
						String newNameString = request.getParameter("txt_clienteEditName");
						String newAdressString = request.getParameter("txt_clienteEditAdress");
						String newStateString = request.getParameter("txt_clienteEditState");
						cliente.setDni(newDniString);
						cliente.setNombre(newNameString);
						cliente.setDireccion(newAdressString);
						cliente.setEstado(newStateString);
						cliente.setIdCliente(idInt);
						clienteDao.update(cliente);
						request.getRequestDispatcher("Controlador?menu=clientes&action=list").forward(request, response);
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + action);
					}
				
				request.getRequestDispatcher("ClientesInterfaz.jsp").forward(request, response);
			}
			if (menu.equals("nueva_venta")&& action!=null) {
				switch (action) {
					case "buscarCliente":
						String dniString = request.getParameter("txt_clientCode");
						cliente = clienteDao.search(dniString);
						
						request.setAttribute("clienteBuscar", cliente);
						request.setAttribute("listVentas", listVentas);
						request.setAttribute("total", totalDouble);
						request.setAttribute("productoBuscar", producto);
						request.setAttribute("listVentas", listVentas);
						request.setAttribute("serie", serieString);
						break;
					case "buscarProducto":
						request.setAttribute("clienteBuscar", cliente);
						idInt = Integer.parseInt(request.getParameter("txt_productCode"));
						Producto producto = productoDao.edit(idInt);
						producto.setIdProducto(idInt);
						request.setAttribute("productoBuscar", producto);
						request.setAttribute("total", totalDouble);
						request.setAttribute("listVentas", listVentas);
						request.setAttribute("total", totalDouble);
						request.setAttribute("serie", serieString);
						break;
					case "Agregar":
						request.setAttribute("clienteBuscar", cliente);
						totalDouble = 0.0;
						
						double subtotal; 
						int codigoInt = Integer.parseInt(request.getParameter("txt_productCode"));
						String descripcionString = request.getParameter("txt_productData");
						int stockInt = Integer.parseInt(request.getParameter("txt_stock"));
						Double precioDouble = Double.parseDouble(request.getParameter("txt_productPrice"));
						int cantidadInt = Integer.parseInt(request.getParameter("txt_productAmount"));
						if(stockInt == 0) {
							 request.setAttribute("mensajeAlerta", "No hay stock disponible.");
							System.out.println("No hay stock");
						}
						else {
							if(listVentas.isEmpty()) {
								Venta venta = new Venta();
								itemInt++;
								venta.setItem(itemInt);
								venta.setCodigo(codigoInt);
								venta.setDescripcion(descripcionString);
								venta.setPrecio(precioDouble);
								venta.setCantidad(cantidadInt);
								subtotal = venta.getCantidad()*venta.getPrecio();
								venta.setSubtotal(subtotal);
								totalDouble = totalDouble + venta.getSubtotal();
								listVentas.add(venta);
							}else {
								int flag = 0;
								for(Venta venta: listVentas) {
									if(venta.getDescripcion().equals(descripcionString)) {
										venta.setCantidad(venta.getCantidad()+cantidadInt);
										subtotal = venta.getCantidad()*venta.getPrecio();
										venta.setSubtotal(subtotal);
										itemInt=listVentas.size();
										flag=1;
									}
									totalDouble = totalDouble + venta.getSubtotal();
								}
								if(flag != 1) {
									Venta venta = new Venta();
									itemInt++;
									venta.setItem(itemInt);
									venta.setCodigo(codigoInt);
									venta.setDescripcion(descripcionString);
									venta.setPrecio(precioDouble);
									venta.setCantidad(cantidadInt);
									subtotal = venta.getCantidad()*venta.getPrecio();
									venta.setSubtotal(subtotal);
									totalDouble = totalDouble + venta.getSubtotal();
									listVentas.add(venta);
								}
							}
						}	
							request.setAttribute("listVentas", listVentas);
							request.setAttribute("total", totalDouble);
							request.setAttribute("serie", serieString);
							break;
						
					case "generarVenta":
						//actualizar stock
						for (int i = 0; i < listVentas.size(); i++) {
							int idProducto = listVentas.get(i).getCodigo();
							int cantidadVenta = listVentas.get(i).getCantidad();
							Producto productoVenta = new Producto();
							productoVenta = productoDao.searchProducto(idProducto);
							productoDao.upDateStock(idProducto, productoVenta.getStock()-cantidadVenta);
						}
						//guardar venta
						LocalDateTime fecha = LocalDateTime.now();
				        int idVentasInt = ventaDao.generateSerie();
				        int idClienteInt = cliente.getIdCliente();
				        int idEmpleadoInt = Integer.parseInt(idEmpledoIngresadoString);	
				        int numeroSerieInt = Integer.parseInt(serieString);
				        venta.setIdVenta(idVentasInt);
				        venta.setIdCliente(idClienteInt);
				        venta.setIdVendedor(idEmpleadoInt);
				        venta.setCodigo(numeroSerieInt);
				        venta.setFechaVenta(fecha);
				        venta.setTotal(totalDouble);
				        venta.setEstado("1");
				        ventaDao.add(venta);
				        //guardar detalle
				        for (int i = 0; i < listVentas.size(); i++) {
				        	venta = new Venta();
							venta.setIdVenta(idVentasInt);
							venta.setIdProducto(listVentas.get(i).getCodigo());
							venta.setCantidad(listVentas.get(i).getCantidad());
							venta.setPrecio(listVentas.get(i).getPrecio());
							ventaDao.addDetalle(venta);
						}
				        listVentas.clear();
				        totalDouble=0.0;
				        itemInt=0;
				        
					case "cancelar":
						totalDouble = 0.0;
						listVentas.clear();
						itemInt=0;
						totalDouble=0.0;
						request.setAttribute("serie", serieString);
						break;	
					case "delete":
						request.setAttribute("clienteBuscar", cliente);
						request.setAttribute("serie", serieString);
						int id = Integer.parseInt(request.getParameter("id"));
						for (int i=0; i < listVentas.size();i++) {
							if(listVentas.get(i).getCodigo()==id) {
								totalDouble = totalDouble-listVentas.get(i).getSubtotal();	
								if(listVentas.get(i).getItem()==itemInt) {
									itemInt--;
								}else{
									for(int j=i+1;j<listVentas.size()-i;j++) {
										itemInt=listVentas.get(j).getItem()-1;
									}
									itemInt++;
								}
								listVentas.remove(i);
							}
						}
						request.setAttribute("listVentas", listVentas);
						request.setAttribute("total", totalDouble);
						break;
					default:
						int serie = ventaDao.generateSerie();
						serieString = String.valueOf(serie);
						request.setAttribute("serie", serieString);
						totalDouble = 0.0;
						listVentas.clear();
						break;
				}
				
				request.getRequestDispatcher("NuevaVentaInterfaz.jsp").forward(request, response);
			}
			else if(menu.equals("nueva_venta")) {
				request.getRequestDispatcher("Controlador?menu=nueva_venta&action=default").forward(request, response);
			}
			
			if (menu.equals("home")) {
				request.getRequestDispatcher("HomeInterfaz.jsp").forward(request, response);
			}
			response.getWriter().append("Served at: ").append(request.getContextPath());
	    }
	
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 processRequest(request, response);
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}
	
	}
