package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import recourses.Conexion;

public class EmpleadoDao {
    Conexion conexion = new Conexion();
    ResultSet resultSet;
    int result;
    
    public Empleado Validar (String user, String dni) {
		Empleado empleado = new Empleado();
		String consultaSqlString = "select * from empleado where User=? and Dni=?";
		try {
			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
			conexion.preparedStatement.setString(1, user);
			conexion.preparedStatement.setString(2, dni);
			resultSet = conexion.preparedStatement.executeQuery();
			while (resultSet.next()) {
				empleado.setUser(resultSet.getString("User"));
				empleado.setDni(resultSet.getString("Dni"));
				empleado.setEstado(resultSet.getString("Estado"));
				empleado.setIdEmpleado(resultSet.getInt("IdEmpleado"));
				empleado.setNombre(resultSet.getString("Nombres"));
				empleado.setTelefono(resultSet.getString("Telefono"));
			}
		} catch (Exception e) {
			System.out.print("Erorr... "+e);
		}
		return empleado;
	}
    //CRUD
  	public List list() {
  		String consultaSqlString="select * from empleado";
  		List<Empleado>list=new ArrayList<>();
  		try {
			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
			resultSet=conexion.preparedStatement.executeQuery();
			while (resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setIdEmpleado(resultSet.getInt(1));
				empleado.setDni(resultSet.getString(2));
				empleado.setNombre(resultSet.getString(3));
				empleado.setTelefono(resultSet.getString(4));
				empleado.setEstado(resultSet.getString(5));
				empleado.setUser(resultSet.getString(6));
				list.add(empleado);
			}
		} catch (Exception e) {
					System.out.print("Error..."+e);
		}
  		return list;
  		
  	}
  	public int add(Empleado e) {
  		String consultaSqlString = "INSERT INTO empleado (Dni, Nombres, Telefono, Estado, User) VALUES (?, ?, ?, ?, ?)";
  		try {
  			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
			conexion.preparedStatement.setString(1, e.getDni());
			conexion.preparedStatement.setString(2, e.getNombre());
			conexion.preparedStatement.setString(3, e.getTelefono());
			conexion.preparedStatement.setString(4, e.getEstado());
			conexion.preparedStatement.setString(5, e.getUser());
			conexion.preparedStatement.executeUpdate();
		} catch (Exception e2) {
			System.out.println("Error al agregar...."+e2);
		}
  		return result;
  	}
  	
  	public Empleado edit(int id) {
		Empleado empleado = new Empleado();
		String consultaSqlString = "SELECT * FROM empleado WHERE IdEmpleado = "+id;
		try {
			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
			resultSet = conexion.preparedStatement.executeQuery();
			while (resultSet.next()) {
				empleado.setDni(resultSet.getString(2));
				empleado.setNombre(resultSet.getString(3));
				empleado.setTelefono(resultSet.getString(4));
				empleado.setEstado(resultSet.getString(5));
				empleado.setUser(resultSet.getString(6));
			}
		} catch (Exception e) {
			System.out.print("Error ...."+e);
		}
		return empleado;
	}
  	public int update(Empleado e) {
  		String consultaSqlString = "UPDATE empleado SET Dni=?, Nombres=?, Telefono=?, Estado=?, User=? WHERE IdEmpleado='"+e.getIdEmpleado()+"'";
  		try {
  		    conexion.connect();
  		    conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
  		    conexion.preparedStatement.setString(1, e.getDni());
  		    conexion.preparedStatement.setString(2, e.getNombre());
  		    conexion.preparedStatement.setString(3, e.getTelefono());
  		    conexion.preparedStatement.setString(4, e.getEstado());
  		    conexion.preparedStatement.setString(5, e.getUser());
  		    result = conexion.preparedStatement.executeUpdate();
  		} catch (Exception e2) {
  		    System.out.println("Error al actualizar...." + e2);
  		}
  	    return result;
  	}
  	
  	public void delete(int id) {
  		String consultaSqlString = "delete from empleado where IdEmpleado="+id;
  		try {
  			conexion.connect();
			conexion.preparedStatement = conexion.getConnection().prepareStatement(consultaSqlString);
			conexion.preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.print("Error..."+e);
		}
  	}
}