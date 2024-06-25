package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Libro;

public class LibroView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigoEliminarLibro;
	private JTextField textCodigoActualizarLibro;
	private JTable table;
	private DefaultTableModel tableModel;
	public JButton btnMostrarLibros;
	public JButton btnCrearLibro;
	public JButton btnEliminarLibro;
	public JButton btnActualizarLibro;

	public JTextField textTitulo;
	public JTextField textAutor;
	public JTextField textEditorial;
	public JTextField textAnoPublicacion;
	public JTextField textISBN;

	/**
	 * Create the frame.
	 */
	public LibroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarLibros = new JLabel("Modificar Libros");
		lblModificarLibros.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificarLibros.setBounds(242, 0, 137, 29);
		lblModificarLibros.setForeground(Color.RED);
		lblModificarLibros.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		contentPane.add(lblModificarLibros);
		
		btnMostrarLibros = new JButton("Mostrar libros existentes");
		btnMostrarLibros.setBounds(169, 31, 271, 23);
		contentPane.add(btnMostrarLibros);
	
		btnCrearLibro = new JButton("Crear libro");
		btnCrearLibro.setBounds(122, 197, 341, 44);
		contentPane.add(btnCrearLibro);
		
		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblTitulo.setBounds(10, 250, 150, 14);
		contentPane.add(lblTitulo);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(160, 250, 150, 23);
		contentPane.add(textTitulo);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblAutor.setBounds(10, 280, 150, 14);
		contentPane.add(lblAutor);
		
		textAutor = new JTextField();
		textAutor.setColumns(10);
		textAutor.setBounds(160, 280, 150, 23);
		contentPane.add(textAutor);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEditorial.setBounds(10, 310, 150, 14);
		contentPane.add(lblEditorial);
		
		textEditorial = new JTextField();
		textEditorial.setColumns(10);
		textEditorial.setBounds(160, 310, 150, 23);
		contentPane.add(textEditorial);
		
		JLabel lblAnoPublicacion = new JLabel("Año publicación:");
		lblAnoPublicacion.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblAnoPublicacion.setBounds(10, 340, 150, 14);
		contentPane.add(lblAnoPublicacion);
		
		textAnoPublicacion = new JTextField();
		textAnoPublicacion.setColumns(10);
		textAnoPublicacion.setBounds(160, 340, 150, 23);
		contentPane.add(textAnoPublicacion);
		
		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblISBN.setBounds(10, 370, 150, 14);
		contentPane.add(lblISBN);
		
		textISBN = new JTextField();
		textISBN.setColumns(10);
		textISBN.setBounds(160, 370, 150, 23);
		contentPane.add(textISBN);

		JLabel lblEliminarLibro = new JLabel("Ingresar el codigo del libro que deseas eliminar:");
		lblEliminarLibro.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEliminarLibro.setBounds(10, 410, 398, 14);
		contentPane.add(lblEliminarLibro);
		
		textCodigoEliminarLibro = new JTextField();
		textCodigoEliminarLibro.setColumns(10);
		textCodigoEliminarLibro.setBounds(10, 430, 398, 23);
		contentPane.add(textCodigoEliminarLibro);
		
		btnEliminarLibro = new JButton("Eliminar libro");
		btnEliminarLibro.setBounds(418, 430, 151, 23);
		contentPane.add(btnEliminarLibro);
		
		JLabel lblCodigoActualizarLibro = new JLabel("Ingresar el codigo del libro que deseas actualizar:");
		lblCodigoActualizarLibro.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCodigoActualizarLibro.setBounds(10, 460, 398, 14);
		contentPane.add(lblCodigoActualizarLibro);
		
		textCodigoActualizarLibro = new JTextField();
		textCodigoActualizarLibro.setColumns(10);
		textCodigoActualizarLibro.setBounds(10, 480, 398, 23);
		contentPane.add(textCodigoActualizarLibro);
		
		btnActualizarLibro = new JButton("Actualizar libro");
		btnActualizarLibro.setBounds(418, 480, 151, 23);
		contentPane.add(btnActualizarLibro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 559, 121);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
        tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Título", "Autor", "Editorial", "Año Publicación", "ISBN" }
            );
        table.setModel(tableModel);
		scrollPane.setViewportView(table);
	}
	
	public void actualizarTablaLibros(List<Libro> libros) {
        // Limpiar tabla
        tableModel.setRowCount(0);

        // Llenar tabla con los libros recibidos
        for (Libro libro : libros) {
            Object[] fila = {
                libro.getTitulo(),
                libro.getAutor(),
                libro.getEditorial(),
                libro.getAnioPublicacion(),
                libro.getIsbn()
            };
            tableModel.addRow(fila);
        }
    }

	public String getTitulo() {
		return textTitulo.getText();
	}

	public String getAutor() {
		return textAutor.getText();
	}

	public String getEditorial() {
		return textEditorial.getText();
	}

	public String getAnoPublicacion() {
		return textAnoPublicacion.getText();
	}

	public String getISBN() {
		return textISBN.getText();
	}

	public String getCodigoEliminarLibro() {
		return textCodigoEliminarLibro.getText();
	}

	public String getCodigoActualizarLibro() {
		return textCodigoActualizarLibro.getText();
	}
}
