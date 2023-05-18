package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import recourses.Conexion;

public class ProductoDao {
	Conexion conexion = new Conexion();
	ResultSet resultSet;
	int result;
	
	public Producto searchProducto(int id) {
		Producto producto = new Producto();
		String consultaSqlString = "SELECT * FROM producto WHERE IdProducto="+id;
		try {
			conexion.connect();
			conexion.preparedStatement=conexion.getConnection().prepareStatement(consultaSqlString);
			resultSet = conexion.preparedStatement.executeQuery();
			while (resultSet.next()) {
				producto.setIdProducto(resultSet.getInt(1));
				producto.setNombre(resultSet.getString(2));
				producto.setPrecio(resultSet.getDouble(3));
				producto.setStock(resultSet.getInt(4));
				producto.setEstado(resultSet.getString(5));
			}
		} catch (Exception e) {
			System.out.println("Error al buscar producto... "+e);
		}
		return producto;
	}
	
	public void upDateStock(int id, int stock) {
		String consultaSqlString = "UPDATE producto SET Stock=? WHERE IdProducto=?";
		try {
			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
			conexion.preparedStatement.setInt(1, stock);
			conexion.preparedStatement.setInt(2, id);
			conexion.preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar stock... "+e);
		}
	}
	//CRUD
	
		public List list() {
			String consultaSqlString = "SELECT * FROM producto";
			List<Producto> list= new ArrayList<>();
			try {
				conexion.connect();
				conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
				resultSet=conexion.preparedStatement.executeQuery();
				while (resultSet.next()) {
					Producto product = new Producto();
					product.setIdProducto(resultSet.getInt(1));
					product.setNombre(resultSet.getString(2));
					product.setPrecio(resultSet.getDouble(3));
					product.setStock(resultSet.getInt(4));
					product.setEstado(resultSet.getString(5));
					list.add(product);
				}
			} catch (Exception e) {
				System.out.println("Error al listar... "+e);
			}
			return list;
		}
		
		public void add(Producto product) {
			String consultaSqlString = "INSERT INTO producto (Nombres,Precio,Stock,Estado) VALUES (?,?,?,?)";
			
			try {
				conexion.connect();
				conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
				conexion.preparedStatement.setString(1, product.getNombre());
				conexion.preparedStatement.setDouble(2, product.getPrecio());
				conexion.preparedStatement.setInt(3, product.getStock());
				conexion.preparedStatement.setString(4, product.getEstado());
				conexion.preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println("Error al agregar... "+e);
			}
		}
		public Producto edit(int id) {
			String connsultaSqlString = "SELECT * FROM producto WHERE IdProducto ="+id;
			Producto producto = new Producto();
			try {
				conexion.connect();
				conexion.preparedStatement = conexion.getConnection().prepareStatement(connsultaSqlString);
				resultSet = conexion.preparedStatement.executeQuery();
				while (resultSet.next()) {
					producto.setNombre(resultSet.getString(2));
					producto.setPrecio(resultSet.getDouble(3));
					producto.setStock(resultSet.getInt(4));
					producto.setEstado(resultSet.getString(5));
				}
			} catch (Exception e) {
				System.out.println("Error al editar... "+e);
			}
			return producto;
		}
		
		public int update(Producto product) {
			String consultaSqlString= "UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE IdProducto = "+product.getIdProducto();
			try {
				conexion.connect();
				conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
				conexion.preparedStatement.setString(1, product.getNombre());
				conexion.preparedStatement.setDouble(2, product.getPrecio());
				conexion.preparedStatement.setInt(3, product.getStock());
				conexion.preparedStatement.setString(4, product.getEstado());
				result = conexion.preparedStatement.executeUpdate();	
			} catch (Exception e) {
				System.out.println("Error al actualizar... "+e);
			}
			return result;
		}
		
		public void delete(int id) {
			String connsultaSqlString = "DELETE FROM producto WHERE IdProducto = "+id;
			try {
				conexion.connect();
				conexion.preparedStatement = conexion.getConnection().prepareStatement(connsultaSqlString);
				conexion.preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println("Error al borrar... "+e);
			}
		}
}
