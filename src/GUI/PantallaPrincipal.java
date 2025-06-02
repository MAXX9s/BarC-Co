package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.usuario;
import BLL.usuario;
import DLL.ControllerUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpEmail;
	private JPasswordField inpContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
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
	public PantallaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel LblTitulo = new JLabel("Empresa Barc-Co");
		LblTitulo.setForeground(Color.GRAY);
		LblTitulo.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
		LblTitulo.setBounds(140, 36, 367, 137);
		contentPane.add(LblTitulo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/img/puerto2.png")));
		lblNewLabel.setBounds(302, 211, 256, 232);
		contentPane.add(lblNewLabel);

		inpEmail = new JTextField();
		inpEmail.setBounds(40, 262, 200, 32);
		contentPane.add(inpEmail);
		inpEmail.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(40, 211, 200, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setBounds(40, 331, 200, 14);
		contentPane.add(lblNewLabel_1_1);

		inpContrasenia = new JPasswordField();
		inpContrasenia.setBounds(40, 382, 200, 32);
		contentPane.add(inpContrasenia);

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(40, 355, 265, 32);
		contentPane.add(lblError);
		JButton btnLogin = new JButton("Inciar sesión");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				usuario logueado = ControllerUsuario.login(inpEmail.getText(), inpContrasenia.getText());
				if (logueado == null) {
					lblError.setText("No se encontró");
				} else {
					if (!logueado.equals(btnLogin)) {
						//JOptionPane.showMessageDialog(null,"No existe");
					}else {
					Tabla tabla = new Tabla();
					tabla.setVisible(true);
					dispose();
					}
					}
			}
		});
		btnLogin.setBounds(40, 451, 121, 23);
		contentPane.add(btnLogin);

	}
}
