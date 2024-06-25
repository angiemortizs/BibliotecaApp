package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Usuario;
import model.UsuarioDAO;
import view.UsuarioView;

public class UsuarioController implements ActionListener {
    private UsuarioView vista;
    private UsuarioDAO modelo;

    public UsuarioController(UsuarioView vista, UsuarioDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnActualizarUsuario.addActionListener(this);
        this.vista.btnCrearNuevoUsuario.addActionListener(this);
        this.vista.btnEliminarUsuario.addActionListener(this);
        this.vista.btnMostrarUsuarios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnCrearNuevoUsuario) {
            String nombre = vista.getNombre();
            String email = vista.getEmail();
            String telefono = vista.getTelefono();
            modelo.crearUsuario(nombre, email, telefono);
            actualizarTablaUsuarios();
        } else if (e.getSource() == vista.btnMostrarUsuarios) {
            actualizarTablaUsuarios();
        } else if (e.getSource() == vista.btnEliminarUsuario) {
            int id = Integer.parseInt(vista.getCodigoEliminarUsuario());
            modelo.eliminarUsuario(id);
            actualizarTablaUsuarios();
        } else if (e.getSource() == vista.btnActualizarUsuario) {
            int id = Integer.parseInt(vista.getCodigoActualizarUsuario());
            String nombre = vista.getNombre();
            String email = vista.getEmail();
            String telefono = vista.getTelefono();
            modelo.actualizarUsuario(id, nombre, email, telefono);
            actualizarTablaUsuarios();
        }
    }

    private void actualizarTablaUsuarios() {
        List<Usuario> usuarios = modelo.leerUsuarios();
        vista.actualizarTablaUsuarios(usuarios);
    }
}

