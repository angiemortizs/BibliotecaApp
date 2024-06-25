package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class LibroDAO {
	
    private Connection conexion;

    public LibroDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void crearLibro(String titulo, String autor, String editorial, int anioPublicacion, String isbn) {
        try {
            String sql = "INSERT INTO libros (titulo, autor, editorial, anio_publicacion, isbn) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, titulo);
            sentencia.setString(2, autor);
            sentencia.setString(3, editorial);
            sentencia.setInt(4, anioPublicacion);
            sentencia.setString(5, isbn);

            int filasInsertadas = sentencia.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Libro creado exitosamente.");
            } else {
                System.out.println("No se pudo crear el libro.");
            }

            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	public void eliminarLibro(String isbn) {
		// TODO Auto-generated method stub
		 PreparedStatement sentencia = null;
	        try {
	            String sql = "DELETE FROM libros WHERE isbn = ?";
	            sentencia = conexion.prepareStatement(sql);
	            sentencia.setString(1, isbn);

	            int filasEliminadas = sentencia.executeUpdate();
	            if (filasEliminadas > 0) {
	                System.out.println("Libro con ISBN " + isbn + " eliminado correctamente.");
	            } else {
	                System.out.println("No se encontró un libro con ISBN " + isbn + " para eliminar.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Cerrar la sentencia en un bloque finally para asegurar que siempre se cierre
	            if (sentencia != null) {
	                try {
	                    sentencia.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

	public List<Libro> obtenerLibros() {
		List<Libro> libros = new ArrayList<>();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            String sql = "SELECT * FROM libros";
            sentencia = conexion.prepareStatement(sql);
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String titulo = resultado.getString("titulo");
                String autor = resultado.getString("autor");
                String editorial = resultado.getString("editorial");
                int anioPublicacion = resultado.getInt("anio_publicacion");
                String isbn = resultado.getString("isbn");

                Libro libro = new Libro(titulo, autor, editorial, anioPublicacion, isbn);
                
                libros.add(libro); // [Libro, Libro2]
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultado != null) {
                try {
                    resultado.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return libros;
	}
    
   
} 