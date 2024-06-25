package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.CategoriaDAO;

import java.util.List;

import view.CategoriaView;

public class CategoriaController implements ActionListener {
    private CategoriaView categoriaView;
    private CategoriaDAO categoriaDAO;

    public CategoriaController(CategoriaView categoriaView, CategoriaDAO categoriaDAO) {
        this.categoriaView = categoriaView;
        this.categoriaDAO = categoriaDAO;
        this.categoriaView.btnCrearCategoria.addActionListener(this);
        this.categoriaView.btnEliminarCategoria.addActionListener(this);
        this.categoriaView.btnMostrarCategoria.addActionListener(this);
        this.categoriaView.btnActualizarCategoria.addActionListener(this);    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == categoriaView.btnCrearCategoria) {
            crearCategoria();
        } else if (e.getSource() == categoriaView.btnEliminarCategoria) {
            eliminarCategoria();
        } else if (e.getSource() == categoriaView.btnMostrarCategoria) {
            mostrarCategorias();
        } else if (e.getSource() == categoriaView.btnActualizarCategoria) {
            actualizarCategoria();
        }
    }

    private void crearCategoria() {
        String nombre = categoriaView.getNombreCategoria(); 
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(categoriaView, "El nombre de la categoría no puede estar vacío");
        } else {
            boolean success = categoriaDAO.eliminarCategoria(1); //TODO: falta revisar
            if (success) {
                JOptionPane.showMessageDialog(categoriaView, "Categoría creada con éxito");
                mostrarCategorias(); 
            } else {
                JOptionPane.showMessageDialog(categoriaView, "Error al crear la categoría");
            }
        }
    }

    private void eliminarCategoria() {
        int id = categoriaView.getIdCategoria(); 
        boolean success = categoriaDAO.eliminarCategoria(id);
        if (success) {
            JOptionPane.showMessageDialog(categoriaView, "Categoría eliminada con éxito");
            mostrarCategorias(); 
        } else {
            JOptionPane.showMessageDialog(categoriaView, "Error al eliminar la categoría");
        }
    }

    private void mostrarCategorias() {
        List<String> categorias = categoriaDAO.mostrarCategorias(); 
        categoriaView.mostrarCategorias(categorias); 
    }

    private void actualizarCategoria() {
        int id = categoriaView.getIdCategoria(); 
        String nuevoNombre = categoriaView.getNuevoNombreCategoria(); 
        if (nuevoNombre.isEmpty()) {
            JOptionPane.showMessageDialog(categoriaView, "El nombre de la categoría no puede estar vacío");
        } else {
            boolean success = categoriaDAO.actualizarCategoria(null, nuevoNombre);
            if (success) {
                JOptionPane.showMessageDialog(categoriaView, "Categoría actualizada con éxito");
                mostrarCategorias(); 
            } else {
                JOptionPane.showMessageDialog(categoriaView, "Error al actualizar la categoría");
            }
        }
    }
}
