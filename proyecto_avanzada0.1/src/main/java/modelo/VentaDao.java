package modelo;

import java.util.Random;

import recourses.Conexion;

public class VentaDao {
	Conexion conexion = new Conexion();
	public int generateSerie() {
		int serieInt;
		Random random= new Random();
		serieInt = random.nextInt(900000)+ 100000;
		return serieInt;
	}
//CRUD
	public void add(Venta venta) {
		String consultaSqlString = "INSERT INTO ventas (IdVentas,IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado) VALUES (?,?,?,?,?,?,?)";
		
		try {
			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
			conexion.preparedStatement.setInt(1, venta.getIdVenta());
			conexion.preparedStatement.setInt(2, venta.getIdCliente());
			conexion.preparedStatement.setInt(3, venta.getIdVendedor());
			conexion.preparedStatement.setInt(4,venta.getCodigo());
			conexion.preparedStatement.setObject(5,venta.getFechaVenta());
			conexion.preparedStatement.setDouble(6,venta.getTotal());
			conexion.preparedStatement.setString(7,venta.getEstado());
			conexion.preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al agregar... "+e);
		}
	}
	
	public void addDetalle(Venta venta) {
		String consultaSqlString = "INSERT INTO detalle_ventas (IdVentas,IdProducto,Cantidad,PrecioVenta) VALUES (?,?,?,?)";
		
		try {
			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
			conexion.preparedStatement.setInt(1, venta.getIdVenta());
			conexion.preparedStatement.setInt(2, venta.getIdProducto());
			conexion.preparedStatement.setInt(3,venta.getCantidad());
			conexion.preparedStatement.setObject(4,venta.getPrecio());
			conexion.preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al agregar detalle... "+e);
		}
	}
}
