	package controlador;
	
	import jakarta.servlet.ServletException;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import modelo.Cliente;
	import modelo.ClienteDao;
	import modelo.Empleado;
	import modelo.EmpleadoDao;
	import modelo.ProductoDao;
	import modelo.Producto;

	import java.awt.Desktop.Action;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	
	
	public class Controlador extends HttpServlet {
		private static final long serialVersionUID = 1L;
		Empleado empleado = new Empleado();
		Producto producto = new Producto();
		Cliente cliente = new Cliente();
		EmpleadoDao empleadoDao = new EmpleadoDao();
		ProductoDao productoDao = new ProductoDao();
		ClienteDao clienteDao = new ClienteDao();
		
		
		int idInt;
	    public Controlador() {
	   
	    }
	    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String menu = request.getParameter("menu");
			String action = request.getParameter("action");
			String actionEdit = request.getParameter("actionEdit");
			System.out.println(menu+" "+action+" "+actionEdit);
			if(menu.equals("edit")) {
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
			if (menu.equals("producto")) {
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
			if (menu.equals("empleados")) {
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
			
			if (menu.equals("clientes")) {
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
			if (menu.equals("nueva_venta")) {
				request.getRequestDispatcher("NuevaVentaInterfaz.jsp").forward(request, response);
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
