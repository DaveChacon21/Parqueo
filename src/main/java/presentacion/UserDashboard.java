package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Font;

public class UserDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdCliente;
	private JTextField txtPlaca;
	private JTable table;
	private JTextField txtBlacklist;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDashboard frame = new UserDashboard();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserDashboard() {
		setTitle("Panel de Operador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 11, 414, 239);
		contentPane.add(tabbedPane);
		
		JPanel tabClientes = new JPanel();
		tabbedPane.addTab("Clientes", null, tabClientes, null);
		tabClientes.setLayout(null);
		
		JButton btnAgregarCliente = new JButton("Agregar cliente");
		btnAgregarCliente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarCliente.setBounds(20, 11, 122, 23);
		tabClientes.add(btnAgregarCliente);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.setBounds(20, 179, 89, 23);
		tabClientes.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setBounds(221, 179, 89, 23);
		tabClientes.add(btnNewButton_2);		
		
		table = new JTable();
		table.setBounds(20, 62, 294, 102);
		tabClientes.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(293, 62, 17, 48);
		tabClientes.add(scrollBar);
			
		JPanel tabRegistros = new JPanel();
		tabbedPane.addTab("Registros", null, tabRegistros, null);
		tabRegistros.setLayout(null);
		
		JLabel lblIdCliente = new JLabel("ID del cliente:");
		lblIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIdCliente.setBounds(10, 11, 86, 14);
		tabRegistros.add(lblIdCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(125, 8, 109, 20);
		tabRegistros.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		JLabel lblPlaca = new JLabel("No. de Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPlaca.setBounds(10, 42, 86, 14);
		tabRegistros.add(lblPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(125, 39, 109, 20);
		tabRegistros.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblTipoVehiculo = new JLabel("Tipo de Vehículo:");
		lblTipoVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTipoVehiculo.setBounds(10, 78, 86, 14);
		tabRegistros.add(lblTipoVehiculo);
		
		JComboBox cbTipoVehiculo = new JComboBox();
		cbTipoVehiculo.setBounds(125, 74, 109, 22);
		tabRegistros.add(cbTipoVehiculo);
		
		JLabel lblConvenio = new JLabel("Convenio:");
		lblConvenio.setBounds(10, 114, 71, 14);
		tabRegistros.add(lblConvenio);
		
		JComboBox cbConvenio = new JComboBox();
		cbConvenio.setBounds(125, 110, 109, 22);
		tabRegistros.add(cbConvenio);
		
		JButton btnIngresoParqueo = new JButton("Ingreso al Parqueo");
		btnIngresoParqueo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnIngresoParqueo.setBounds(10, 162, 123, 23);
		tabRegistros.add(btnIngresoParqueo);
		
		JButton btnSalida = new JButton("Salida");
		btnSalida.setBounds(167, 162, 109, 23);
		tabRegistros.add(btnSalida);
		
		JButton btnRegistro = new JButton("Ver Registro");
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegistro.setBounds(10, 196, 123, 23);
		tabRegistros.add(btnRegistro);
		
		JPanel tabListaNegra = new JPanel();
		tabbedPane.addTab("Lista Negra", null, tabListaNegra, null);
		tabListaNegra.setLayout(null);
		
		JLabel lblIdClienteBlacklist = new JLabel("ID del cliente:");
		lblIdClienteBlacklist.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIdClienteBlacklist.setBounds(65, 50, 86, 14);
		tabListaNegra.add(lblIdClienteBlacklist);
		
		txtBlacklist = new JTextField();
		txtBlacklist.setBounds(179, 47, 96, 20);
		tabListaNegra.add(txtBlacklist);
		txtBlacklist.setColumns(10);
		
		JLabel lblPlacaBlacklist = new JLabel("No. de Placa:");
		lblPlacaBlacklist.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPlacaBlacklist.setBounds(65, 86, 86, 14);
		tabListaNegra.add(lblPlacaBlacklist);
		
		textField = new JTextField();
		textField.setBounds(179, 78, 96, 20);
		tabListaNegra.add(textField);
		textField.setColumns(10);
		
		JButton btnBlacklist = new JButton("Blacklist");
		btnBlacklist.setBounds(176, 152, 99, 23);
		tabListaNegra.add(btnBlacklist);
		
		JPanel tabCierreDeCaja = new JPanel();
		tabbedPane.addTab("Cierre de Caja", null, tabCierreDeCaja, null);
		tabCierreDeCaja.setLayout(null);
		
		JLabel lblOperador = new JLabel("Operador:");
		lblOperador.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOperador.setBounds(28, 11, 81, 14);
		tabCierreDeCaja.add(lblOperador);
		
		JComboBox cbOperador = new JComboBox();
		cbOperador.setBounds(142, 7, 102, 22);
		tabCierreDeCaja.add(cbOperador);
		
		JLabel lblNewLabel = new JLabel("Total en caja:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(26, 48, 83, 14);
		tabCierreDeCaja.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 45, 104, 20);
		tabCierreDeCaja.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCerrarCaja = new JButton("Cerrar Caja");
		btnCerrarCaja.setBounds(190, 179, 97, 23);
		tabCierreDeCaja.add(btnCerrarCaja);
	}
}
