package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import recourses.Conexion;

public class ClienteDao {
	Conexion conexion = new Conexion();
	ResultSet resultSet;
	
	public Cliente search(String dni) {
		Cliente cliente = new Cliente();
		String colsutaSqlString = "SELECT * FROM cliente WHERE Dni = "+dni;
		try {
			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(colsutaSqlString);
			resultSet = conexion.preparedStatement.executeQuery();
			while (resultSet.next()) {
				cliente.setIdCliente(resultSet.getInt(1));
				cliente.setDni(resultSet.getString(2));
				cliente.setNombre(resultSet.getString(3));
				cliente.setDireccion(resultSet.getString(4));
				cliente.setEstado(resultSet.getString(5));
			}
		} catch (Exception e) {
			System.out.println("Error al buscar... "+e);
		}
		return cliente;
	}
	//CRUD
	public List list() {
		List<Cliente>list = new ArrayList<>();
		String consultaSqlString = "SELECT * FROM cliente";
		try {
			conexion.connect();
			conexion.preparedStatement=conexion.getConnection().prepareStatement(consultaSqlString);
			resultSet = conexion.preparedStatement.executeQuery();
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(resultSet.getInt(1));
				cliente.setDni(resultSet.getString(2));
				cliente.setNombre(resultSet.getString(3));
				cliente.setDireccion(resultSet.getString(4));
				cliente.setEstado(resultSet.getString(5));
				list.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("Error al listar... "+e);
		}
		return list;
	}
	public void add(Cliente cliente) {
		String colsutaSqlString = "INSERT INTO cliente (Dni,Nombres,Direccion,Estado) VALUES (?, ?, ?, ?)";
		try {
			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(colsutaSqlString);
			conexion.preparedStatement.setString(1, cliente.getDni());
			conexion.preparedStatement.setString(2, cliente.getNombre());
			conexion.preparedStatement.setString(3, cliente.getDireccion());
			conexion.preparedStatement.setString(4, cliente.getEstado());
			conexion.preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al añadir... "+e);
		}
	}
	
	public void delete(int id) {
		String colsultaSqString = "DELETE FROM cliente WHERE IdCliente = "+id;
		try {
			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(colsultaSqString);
			conexion.preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al eliminar... "+e);
		}
	}
	public Cliente edit(int id) {
		Cliente cliente = new Cliente();
		String connsultaSqlString = "SELECT * FROM cliente WHERE IdCliente ="+id;
		try {
			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(connsultaSqlString);
			resultSet = conexion.preparedStatement.executeQuery();
			while (resultSet.next()) {
				cliente.setDni(resultSet.getString(2));
				cliente.setNombre(resultSet.getString(3));
				cliente.setDireccion(resultSet.getString(4));
				cliente.setEstado(resultSet.getString(5));
			}
		} catch (Exception e) {
			System.out.println("Error al editar... "+e);
		}
		return cliente;
	}
	public void update (Cliente cliente) {
  		String consultaSqlString = "UPDATE cliente SET Dni=?, Nombres=?, Direccion=?, Estado=? WHERE IdCliente='"+cliente.getIdCliente()+"'";
  		try {
  		    conexion.connect();
  		    conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
  		    conexion.preparedStatement.setString(1, cliente.getDni());
  		    conexion.preparedStatement.setString(2, cliente.getNombre());
  		    conexion.preparedStatement.setString(3, cliente.getDireccion());
  		    conexion.preparedStatement.setString(4, cliente.getEstado());
  		    conexion.preparedStatement.executeUpdate();
  		} catch (Exception e) {
  		    System.out.println("Error al actualizar...." + e);
  		}
  	}
}
