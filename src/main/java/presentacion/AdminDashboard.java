package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTable tbConvenios;
	private JTextField txtMonto;
	
	private JRadioButton rdbtnTarifaMensual;
	private JRadioButton rdbtnTarifaPorHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
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
	public AdminDashboard() {
		setTitle("Panel de Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 11, 544, 339);
		contentPane.add(tabbedPane);
		
		JPanel tabUsuarios = new JPanel();
		tabbedPane.addTab("Usuarios", null, tabUsuarios, null);
		tabUsuarios.setLayout(null);
		
		table = new JTable();
		table.setBounds(30, 89, 396, 178);
		tabUsuarios.add(table);
		
		JButton btnAgregarOperador = new JButton("Agregar Operador");
		btnAgregarOperador.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAgregarOperador.setBounds(30, 44, 121, 23);
		tabUsuarios.add(btnAgregarOperador);
		
		JButton btnAgregarAdmin = new JButton("Agregar Admin");
		btnAgregarAdmin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAgregarAdmin.setBounds(192, 44, 111, 23);
		tabUsuarios.add(btnAgregarAdmin);
		
		JButton btnModify = new JButton("Modificar");
		btnModify.setBounds(30, 278, 89, 23);
		tabUsuarios.add(btnModify);
		
		JButton btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(216, 278, 89, 23);
		tabUsuarios.add(btnDelete);
		
		JPanel tabTiposVehiculos = new JPanel();
		tabbedPane.addTab("Tipos de Vehiculos", null, tabTiposVehiculos, null);
		tabTiposVehiculos.setLayout(null);
		
		JButton btnAgregarVehiculo = new JButton("Agregar Vehiculo");
		btnAgregarVehiculo.setBounds(31, 23, 133, 23);
		tabTiposVehiculos.add(btnAgregarVehiculo);
		
		JComboBox cbTipoVehiculo = new JComboBox();
		cbTipoVehiculo.setBounds(31, 84, 133, 22);
		tabTiposVehiculos.add(cbTipoVehiculo);
		
		JButton btnEliminarVehiculo = new JButton("Eliminar Vehiculo");
		btnEliminarVehiculo.setBounds(31, 141, 133, 23);
		tabTiposVehiculos.add(btnEliminarVehiculo);
		
		JPanel tabTarifas = new JPanel();
		tabbedPane.addTab("Tarifas", null, tabTarifas, null);
		tabTarifas.setLayout(null);
		
		JLabel lblParqueoTarifa = new JLabel("Parqueo:");
		lblParqueoTarifa.setBounds(24, 11, 83, 14);
		tabTarifas.add(lblParqueoTarifa);
		
		JComboBox cbTarifaParqueo = new JComboBox();
		cbTarifaParqueo.setBounds(141, 7, 111, 22);
		tabTarifas.add(cbTarifaParqueo);
		
		JLabel lblTarifaVehiculo = new JLabel("Tipo de Vehiculo:");
		lblTarifaVehiculo.setBounds(24, 55, 89, 14);
		tabTarifas.add(lblTarifaVehiculo);
		
		JComboBox cbTarifaVehiculo = new JComboBox();
		cbTarifaVehiculo.setBounds(141, 51, 111, 22);
		tabTarifas.add(cbTarifaVehiculo);
		
		rdbtnTarifaMensual = new JRadioButton("Mensual");
		rdbtnTarifaMensual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTarifaPorHora.setSelected(!rdbtnTarifaMensual.isSelected());
			}
		});
		rdbtnTarifaMensual.setBounds(37, 103, 109, 23);
		tabTarifas.add(rdbtnTarifaMensual);
		
		rdbtnTarifaPorHora = new JRadioButton("Por hora");
		rdbtnTarifaPorHora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTarifaMensual.setSelected(!rdbtnTarifaPorHora.isSelected());
			}
		});
		rdbtnTarifaPorHora.setBounds(161, 103, 109, 23);
		tabTarifas.add(rdbtnTarifaPorHora);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(24, 167, 46, 14);
		tabTarifas.add(lblMonto);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(123, 164, 86, 20);
		tabTarifas.add(txtMonto);
		txtMonto.setColumns(10);
		
		JButton btnGuardarTarifa = new JButton("Guardar");
		btnGuardarTarifa.setBounds(24, 234, 89, 23);
		tabTarifas.add(btnGuardarTarifa);
		
		JPanel tabConvenios = new JPanel();
		tabbedPane.addTab("Convenios", null, tabConvenios, null);
		tabConvenios.setLayout(null);
		
		JButton btnAgregar = new JButton("Modificar");
		btnAgregar.setBounds(32, 259, 89, 23);
		tabConvenios.add(btnAgregar);
		
		JButton btnConvenio = new JButton("Crear nuevo convenio");
		btnConvenio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnConvenio.setBounds(24, 42, 156, 23);
		tabConvenios.add(btnConvenio);
		
		tbConvenios = new JTable();
		tbConvenios.setBounds(32, 107, 375, 133);
		tabConvenios.add(tbConvenios);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(318, 259, 89, 23);
		tabConvenios.add(btnEliminar);
		
		JPanel tabEmpresa = new JPanel();
		tabbedPane.addTab("Empresa", null, tabEmpresa, null);
		tabEmpresa.setLayout(null);
		
		JLabel lblParqueo = new JLabel("Parqueo:");
		lblParqueo.setBounds(10, 11, 77, 14);
		tabEmpresa.add(lblParqueo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(163, 7, 119, 22);
		tabEmpresa.add(comboBox);
		
		JLabel lblMinutosGracia = new JLabel("Minutos de gracia:");
		lblMinutosGracia.setBounds(10, 63, 119, 14);
		tabEmpresa.add(lblMinutosGracia);
		
		textField = new JTextField();
		textField.setBounds(163, 60, 117, 20);
		tabEmpresa.add(textField);
		textField.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 139, 89, 23);
		tabEmpresa.add(btnGuardar);
	}
}
