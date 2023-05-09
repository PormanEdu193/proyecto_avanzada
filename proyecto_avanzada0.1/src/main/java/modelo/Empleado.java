package modelo;

import java.util.List;

public class Empleado {
	int  idEmpleado;
	String dni,nombre, telefono, estado,user;	
	
	public Empleado() {
	}

	public Empleado(int idEmpleado, String dni, String nombre, String telefono, String estado, String user) {
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.estado = estado;
		this.user = user;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
