package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Libro;
import model.LibroDAO;
import view.LibroView;

public class LibroController implements ActionListener {
    private LibroView vista;
    private LibroDAO modelo;

    public LibroController(LibroView vista, LibroDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnActualizarLibro.addActionListener(this);
        this.vista.btnCrearLibro.addActionListener(this);
        this.vista.btnEliminarLibro.addActionListener(this);
        this.vista.btnMostrarLibros.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnCrearLibro) {
            String titulo = vista.getTitulo();
            String autor = vista.getAutor();
            String editorial = vista.getEditorial();
            String anoPublicacion = vista.getAnoPublicacion();
            String isbn = vista.getISBN();

            System.out.println("Crear Libro:");
            System.out.println("Título: " + titulo);
            System.out.println("Autor: " + autor);
            System.out.println("Editorial: " + editorial);
            System.out.println("Año publicación: " + anoPublicacion);
            System.out.println("ISBN: " + isbn);

            modelo.crearLibro(titulo, autor, editorial, Integer.parseInt(anoPublicacion), isbn);
            
            List<Libro> libros = modelo.obtenerLibros();

            // Actualizar la vista con los libros obtenidos
            vista.actualizarTablaLibros(libros);


        if (e.getSource() == vista.btnMostrarLibros) {
        	// Obtener los libros del modelo
            List<Libro> libros1 = modelo.obtenerLibros();

            // Actualizar la vista con los libros obtenidos
            vista.actualizarTablaLibros(libros1);
        }

        if (e.getSource() == vista.btnEliminarLibro) {
            String codigo = vista.getCodigoEliminarLibro();
            System.out.println("Eliminar Libro con código: " + codigo);
            modelo.eliminarLibro(codigo);
            // Aquí puedes llamar al método del DAO para eliminar el libro
            // modelo.eliminarLibro(codigo);
        }

        if (e.getSource() == vista.btnActualizarLibro) {
            String codigo = vista.getCodigoActualizarLibro();
            System.out.println("Actualizar Libro con código: " + codigo);

            // Aquí puedes llamar al método del DAO para actualizar el libro
            // modelo.actualizarLibro(new Libro(codigo, ...));
        }
    }

    // Métodos para manejar eventos de los botones (crear, leer, actualizar, eliminar)
}
}