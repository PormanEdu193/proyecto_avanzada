package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Empleado;
import modelo.EmpleadoDao;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.List;


public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empleado empleado = new Empleado();
	EmpleadoDao empleadoDao = new EmpleadoDao();
    public Controlador() {
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu = request.getParameter("menu");
		String action = request.getParameter("action");
		if (menu.equals("producto")) {
			request.getRequestDispatcher("ProductoInterfaz.jsp").forward(request, response);
		}
		if (menu.equals("empleados")) {
			switch (action) {
			case "list": {
				List list =empleadoDao.list();
				request.setAttribute("empleados", list);
				break;
			}
			case "add": {
				
				break;
			}
			case "edit": {
				
				break;
			}
			case "delete": {
				
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
			request.getRequestDispatcher("EmpleadosInterfaz.jsp").forward(request, response);
				
		}
		if (menu.equals("clientes")) {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu = request.getParameter("menu");
		if (menu.equals("principal")) {
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}
	}

}
