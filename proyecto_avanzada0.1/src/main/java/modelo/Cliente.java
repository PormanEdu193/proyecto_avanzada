package modelo;

public class Cliente {
	private String dni,nombre,direccion,estado;
	private int idCliente; 
	
	public Cliente() {
		
	}

	public Cliente(String dni, String nombre, String direccion, String estado, int idCliente) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.estado = estado;
		this.idCliente = idCliente;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}
