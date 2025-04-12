package presentacion;

import java.awt.BorderLayout;

import logica.LogicaLogin;

import java.awt.EventQueue;

import entidades.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Bienvenido al sistema de Parqueo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(45, 27, 67, 19);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(45, 56, 214, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(45, 101, 67, 14);
		contentPane.add(lblPassword);

		pfPassword = new JPasswordField();
		pfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pfPassword.setBounds(45, 130, 214, 20);
		contentPane.add(pfPassword);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogicaLogin ll = new LogicaLogin();

				Usuario user = ll.validarUsuario(txtUsuario.getText(), pfPassword.getText());

				if (user.getMensajeError() == null) {

					JOptionPane.showMessageDialog(contentPane, user.getNombre() + " bienvenido", "Ingreso al sistema",
							JOptionPane.INFORMATION_MESSAGE);

					if (user.getRol().equals("Administrador")) {
						AdminDashboard ad = new AdminDashboard();
						ad.setVisible(true);
					} else {
						UserDashboard ud = new UserDashboard();
						ud.setVisible(true);
					}

					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(contentPane, user.getMensajeError(), "Error de inicio",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnIngresar.setBounds(45, 189, 89, 23);
		contentPane.add(btnIngresar);
	}
}
