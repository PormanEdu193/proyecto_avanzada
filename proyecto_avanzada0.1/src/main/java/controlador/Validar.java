package controlador;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Empleado;
import modelo.EmpleadoDao;


import java.io.IOException;


public class Validar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Empleado empleado = new Empleado();
       EmpleadoDao empleadoDao = new EmpleadoDao();
    public Validar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionString = request.getParameter("action");
		if(actionString.equalsIgnoreCase("Ingresar")) {
			String userString = request.getParameter("user_txt");
			String passString = request.getParameter("pass_txt");
			empleado = empleadoDao.Validar(userString, passString);
			String url ="Controlador?menu=principal&ingreso=1&idEmpleado="+empleado.getIdEmpleado();
			
			if(empleado.getUser()!=null) {
				request.setAttribute("user", empleado);
				request.getRequestDispatcher(url).forward(request, response);
				
			}else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
