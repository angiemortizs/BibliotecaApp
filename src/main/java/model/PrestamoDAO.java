package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class PrestamoDAO {
	
	
    private Connection conexion;

    public PrestamoDAO(Connection conexion) {
        this.conexion = conexion;
    }

//Crear
    
    public void CreatePrestamo (Connection connection, DefaultTableModel modelo){
    	try {
    String sql = "INSERT INTO categorias (libro_id, usuario_id, fecha_prestamo, fecha devolucion) VALUES (?)";
    PreparedStatement sentencia = connection.prepareStatement (sql);
    ResultSet resultado = sentencia.executeQuery ();

    while (resultado.next()) {
    	int libro_id = resultado.getInt ("libro_id");
    	int usuario_id = resultado.getInt ("usuario_id");
    	String fecha_prestamo = resultado.getString ("fecha_prestamo");
    	String fecha_devolucion = resultado.getString ("fecha_devolucion");
    	modelo.addRow (new Object [] {libro_id, usuario_id, fecha_prestamo, fecha_prestamo});
    }
    	
    	sentencia.close();
    	resultado.close();
    	
    } catch (SQLException e) {
    	e.printStackTrace(); 
    }}
    	
    
    
//leer     
    
    public void CrearPrestamo (Connection connection, DefaultTableModel modelo) {
    	try {
    		String sql = "SELECT * FROM prestamo";
    		PreparedStatement sentencia = connection.prepareStatement(sql);
    		ResultSet resultado = sentencia.executeQuery();
    		
    		modelo.setRowCount(0);
    		
    		while (resultado.next()) {
    			int libro_id = resultado.getInt("libro_id");
    			int usuario_id = resultado.getInt("usuario_id");
    			String fecha_prestamo = resultado.getString("fecha_prestamo");
    			String fecha_devolucion = resultado.getString("fecha_devolucion");
    			modelo.addRow(new Object [] {});
    		}
    		sentencia.close();
    		resultado.close();
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    //actualizar
    	public void actualizarPrestamo (Connection connection, DefaultTableModel modelo) {
    		try {
    			String sql = "UPDATE prestamo SET libro_id = ?, usuario_id =?, fecha_prestamo = ?, fecha_devolucion = ? WHERE id = ?";
    			PreparedStatement sentencia = connection.prepareStatement(sql);
    			ResultSet resultado = sentencia.executeQuery();
    			
    			while (resultado.next()) {
    				int libro_id = resultado.getInt("libro_id");
    				int usuario_id = resultado.getInt("usuario_id");
    				String fecha_prestamo = resultado.getString("fecha_prestamo");
    				String fecha_devolucion = resultado.getString("fecha_devolucion");
    				modelo.addRow(new Object [] {libro_id , usuario_id, fecha_prestamo, fecha_devolucion});
    			}
    			sentencia.close();
        		resultado.close();	
        		
            } catch (SQLException e) {
            	e.printStackTrace();
            }}
    		
    
    //eliminar 
    		public void eliminarPrestamo(Connection connection, DefaultTableModel modelo) {
    	    	try {
    	    		String sql = "DELETE FROM prestamo WHERE id = ?";
    	    		PreparedStatement sentencia = connection.prepareStatement(sql);
    	    		ResultSet resultado = sentencia.executeQuery();
    	    		
    	    		while (resultado.next()) {
    	    			int libro_id = resultado.getInt("libro_id");
    	    			int usuario_id = resultado.getInt("usuario_id");
    	    			String fecha_prestamo = resultado.getString("fecha_prestamo");
    	    			String fecha_devolucion = resultado.getString("fecha_devolucion");
    	    			modelo.addRow(new Object [] {libro_id , usuario_id , fecha_prestamo, fecha_devolucion});
    	    		}
    	    		sentencia.close();
    	    		resultado.close();	
    	    		
    	    	} catch (SQLException e) {
    	    		e.printStackTrace();
    	    	}
    	    }
   }
    
    
    
    
 
 
		