package modelo;

import java.time.LocalDateTime;

public class Venta {
	
	int item,codigo,cantidad,idVenta,idVendedor,idCliente,idDetalle,idProducto;
	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	Double precio,subtotal,total;
	String descripcion,estado;
	LocalDateTime fechaVenta;
	
	public  Venta() {
	}

	public Venta(int item, int codigo, int cantidad, int idVenta, int idVendedor, int idCliente, Double precio,
			Double subtotal, Double total, String descripcion, String estado, LocalDateTime fechaVenta) {
		super();
		this.item = item;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.idVenta = idVenta;
		this.idVendedor = idVendedor;
		this.idCliente = idCliente;
		this.precio = precio;
		this.subtotal = subtotal;
		this.total = total;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaVenta = fechaVenta;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
}
