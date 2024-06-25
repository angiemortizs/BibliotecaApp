package run;

import java.sql.Connection;

import connector.DatabaseConnection;
import controller.LibroController;
import model.LibroDAO;
import view.LibroView;

public class BibliotecaApp {

	 public static void main(String[] args) {
	        Connection conexion = null;
	        try {
	            // Obtener la conexión
	            conexion = DatabaseConnection.getConnection();

	            // Crear instancias del modelo, vista y controlador
	            LibroDAO modeloLibro = new LibroDAO(conexion);
	            LibroView vistaLibro = new LibroView();
	            LibroController controladorLibro = new LibroController(vistaLibro, modeloLibro);

	            // Mostrar la vista de libros
	            vistaLibro.setVisible(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
