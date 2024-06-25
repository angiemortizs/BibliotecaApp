package view;

import java.awt.EventQueue;

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

public class PrestamoView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigoEliminarPrestamo;
	private JTextField textCodigoActualizarPrestamo;
	private JTable table;
	public JButton btnMostrarPrestamos;
	public JButton btnCrearNuevoPrestamo;
	public JButton btnEliminarPrestamo;
	public JButton btnActualizarPrestamo;


	/**
	 * Create the frame.
	 */
	public PrestamoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarPrestamos = new JLabel("Modificar prestamos");
		lblModificarPrestamos.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificarPrestamos.setForeground(Color.RED);
		lblModificarPrestamos.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblModificarPrestamos.setBounds(197, 0, 170, 29);
		contentPane.add(lblModificarPrestamos);
		
		btnMostrarPrestamos = new JButton("Mostrar prestamos de los libros");
		btnMostrarPrestamos.setBounds(140, 25, 271, 23);
		contentPane.add(btnMostrarPrestamos);
		
		btnCrearNuevoPrestamo = new JButton("Ingresar nuevo prestamo");
		btnCrearNuevoPrestamo.setBounds(159, 189, 229, 50);
		contentPane.add(btnCrearNuevoPrestamo);
		
		JLabel lblEliminarLibro = new JLabel("Ingresar el codigo del prestamo que deseas eliminar:");
		lblEliminarLibro.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEliminarLibro.setBounds(10, 250, 398, 14);
		contentPane.add(lblEliminarLibro);
		
		textCodigoEliminarPrestamo = new JTextField();
		textCodigoEliminarPrestamo.setColumns(10);
		textCodigoEliminarPrestamo.setBounds(13, 274, 398, 23);
		contentPane.add(textCodigoEliminarPrestamo);
		
		btnEliminarPrestamo = new JButton("Eliminar registro");
		btnEliminarPrestamo.setBounds(418, 274, 151, 23);
		contentPane.add(btnEliminarPrestamo);
		
		JLabel lblCodigoActualizarPrestamo = new JLabel("Ingresar el codigo del prestamo que deseas actualizar:");
		lblCodigoActualizarPrestamo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCodigoActualizarPrestamo.setBounds(10, 308, 398, 14);
		contentPane.add(lblCodigoActualizarPrestamo);
		
		textCodigoActualizarPrestamo = new JTextField();
		textCodigoActualizarPrestamo.setColumns(10);
		textCodigoActualizarPrestamo.setBounds(13, 333, 398, 23);
		contentPane.add(textCodigoActualizarPrestamo);
		
		btnActualizarPrestamo = new JButton("Actualizar registro");
		btnActualizarPrestamo.setBounds(418, 333, 151, 23);
		contentPane.add(btnActualizarPrestamo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 559, 121);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Libro ID", "Usuario ID", "Fecha prestamo", "Fecha devolución"
			}
		));
		scrollPane.setViewportView(table);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
