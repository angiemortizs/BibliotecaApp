package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class CategoriaDAO {

    private Connection conexion;
    
    public CategoriaDAO() {
    	
    }
    //Metodos CRUD
    
    //crear
    public void CreateCategoria (Connection connection, DefaultTableModel modelo){
    	try {
    		//dice la consulta que hara
    		String sql = "INSERT INTO categorias (nombre) VALUES (?)";
    		//Prepara la consulta para ser realizada si la coneccion esta abierta
    		PreparedStatement sentencia = connection.prepareStatement(sql);
    		//Guarda el resultado de la consulta en la base de datos
    		ResultSet resultado = sentencia.executeQuery();
    		
    		while (resultado.next()) {
    			//toma el id guardado en resultado
    			int id = resultado.getInt("id");
    			//toma el nombre guardado en resultado
    			String nombre = resultado.getString("nombre");
    			//agrega una nueva fila con el contenido de resultado
    			modelo.addRow(new Object [] {id , nombre});
    			} 
    			//cierra la conexion
    			sentencia.close();
    			resultado.close();
    		
    			//excepcion en caso de no realizar la conexion correctamente
    		} catch (SQLException e) {
    			e.printStackTrace();
    	}
    }
    
    //leer
    public void LeerProductos(Connection connection, DefaultTableModel modelo) {
    	try {
    		String sql = "SELECT * FROM categorias";
    		PreparedStatement sentencia = connection.prepareStatement(sql);
    		ResultSet resultado = sentencia.executeQuery();
    		
    		modelo.setRowCount(0);
    		
    		while (resultado.next()) {
    			int id = resultado.getInt("id");
    			String nombre = resultado.getString("nombre");
    			modelo.addRow(new Object [] {id , nombre});
    		}
    		sentencia.close();
    		resultado.close();
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
        
    //actualizar
    public boolean actualizarCategoria(Connection id2, String nuevoNombre) {
    	try {
    		String sql = "UPDATE categorias SET nombre = ? WHERE id = ?";
    		PreparedStatement sentencia = id2.prepareStatement(sql);
    		ResultSet resultado = sentencia.executeQuery();
    		
    		while (resultado.next()) {
    			int id = resultado.getInt("id");
    			String nombre = resultado.getString("nombre");
    			//nuevoNombre.addRow(new Object [] {id , nombre});
    	} 
    		sentencia.close();
    		resultado.close();	
    		
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    	return true; //TODO: Revisar que se retorna
    }

    //eliminar
    public void eliminarCategoria(Connection connection, DefaultTableModel modelo) {
    	try {
    		String sql = "DELETE FROM categorias WHERE id = ?";
    		PreparedStatement sentencia = connection.prepareStatement(sql);
    		ResultSet resultado = sentencia.executeQuery();
    		
    		while (resultado.next()) {
    			int id = resultado.getInt("id");
    			String nombre = resultado.getString("nombre");
    			modelo.addRow(new Object [] {id , nombre});
    		}
    		sentencia.close();
    		resultado.close();	
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

	public List<String> mostrarCategorias() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eliminarCategoria(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
 }
    		
    			
        
