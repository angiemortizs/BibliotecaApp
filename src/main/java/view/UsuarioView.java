package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Usuario;

import java.util.List;

public class UsuarioView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigoEliminarUsuario;
	private JTextField textCodigoActualizarUsuario;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textTelefono;
	private JTable table;
	public JButton btnMostrarUsuarios;
	public JButton btnCrearNuevoUsuario;
	public JButton btnEliminarUsuario;
	public JButton btnActualizarUsuario;
	
	/**
	 * Create the frame.
	 */
	public UsuarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarUsuario = new JLabel("Modificar usuarios");
		lblModificarUsuario.setBounds(211, 0, 161, 21);
		lblModificarUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificarUsuario.setForeground(Color.RED);
		lblModificarUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		contentPane.add(lblModificarUsuario);
		
		btnMostrarUsuarios = new JButton("Mostrar usuarios existentes");
		btnMostrarUsuarios.setBounds(153, 32, 271, 23);
		contentPane.add(btnMostrarUsuarios);
		
		btnCrearNuevoUsuario = new JButton("Crear nuevo usuario");
		btnCrearNuevoUsuario.setBounds(174, 190, 229, 50);
		contentPane.add(btnCrearNuevoUsuario);
		
		JLabel lblEliminarUsuario = new JLabel("Ingresar el codigo del usuario que deseas eliminar:");
		lblEliminarUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEliminarUsuario.setBounds(10, 251, 398, 14);
		contentPane.add(lblEliminarUsuario);
		
		textCodigoEliminarUsuario = new JTextField();
		textCodigoEliminarUsuario.setColumns(10);
		textCodigoEliminarUsuario.setBounds(10, 274, 398, 23);
		contentPane.add(textCodigoEliminarUsuario);
		
		btnEliminarUsuario = new JButton("Eliminar usuario");
		btnEliminarUsuario.setBounds(418, 274, 151, 23);
		contentPane.add(btnEliminarUsuario);
		
		JLabel lblCodigoActualizarUsuario = new JLabel("Ingresar el codigo del usuario que deseas actualizar:");
		lblCodigoActualizarUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCodigoActualizarUsuario.setBounds(10, 316, 398, 14);
		contentPane.add(lblCodigoActualizarUsuario);
		
		textCodigoActualizarUsuario = new JTextField();
		textCodigoActualizarUsuario.setColumns(10);
		textCodigoActualizarUsuario.setBounds(10, 341, 398, 23);
		contentPane.add(textCodigoActualizarUsuario);
		
		btnActualizarUsuario = new JButton("Actualizar usuario");
		btnActualizarUsuario.setBounds(418, 341, 151, 23);
		contentPane.add(btnActualizarUsuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 507, 112);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNombre.setBounds(10, 374, 58, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(78, 374, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEmail.setBounds(174, 374, 58, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(222, 374, 86, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblTelefono.setBounds(318, 374, 58, 14);
		contentPane.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(376, 374, 86, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// Métodos para obtener los valores de los campos de texto
	public String getNombre() {
		return textNombre.getText();
	}

	public String getEmail() {
		return textEmail.getText();
	}

	public String getTelefono() {
		return textTelefono.getText();
	}

	public String getCodigoEliminarUsuario() {
		return textCodigoEliminarUsuario.getText();
	}

	public String getCodigoActualizarUsuario() {
		return textCodigoActualizarUsuario.getText();
	}
	
	// Método para actualizar la tabla de usuarios
	public void actualizarTablaUsuarios(List<Usuario> usuarios) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Limpiar la tabla
		
		for (Usuario usuario : usuarios) {
			model.addRow(new Object[] { usuario.getNombre(), usuario.getEmail(), usuario.getTelefono() });
		}
	}
}

