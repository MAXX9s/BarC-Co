package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.admin;
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
import javax.swing.SwingConstants;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpEmail;
	private JPasswordField inpContrasenia;


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

	
	public PantallaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel LblTitulo = new JLabel("Bienvenido a Barc-Co");
		LblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		LblTitulo.setForeground(new Color(0, 64, 128));
		LblTitulo.setFont(new Font("Arial", Font.BOLD, 50));
		LblTitulo.setBounds(96, 27, 527, 118);
		contentPane.add(LblTitulo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/img/Logo.png")));
		lblNewLabel.setBounds(401, 155, 256, 258);
		contentPane.add(lblNewLabel);

		inpEmail = new JTextField();
		inpEmail.setBounds(63, 221, 243, 32);
		contentPane.add(inpEmail);
		inpEmail.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(63, 185, 200, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(63, 287, 200, 14);
		contentPane.add(lblNewLabel_1_1);

		inpContrasenia = new JPasswordField();
		inpContrasenia.setBounds(63, 323, 243, 32);
		contentPane.add(inpContrasenia);

		JLabel lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setBounds(10, 366, 362, 32);
		contentPane.add(lblError);
		JButton btnLogin = new JButton("Inciar sesión");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario usuario = new usuario();
				usuario logueado = ControllerUsuario.login(inpEmail.getText(), inpContrasenia.getText());
				if (inpEmail.getText().isEmpty() || inpContrasenia.getText().isEmpty()) {
					lblError.setText("Campos incompletos, por favor vuelva a intenar.");
				} else if (!inpEmail.getText().equals(usuario.getNombre()) || !inpContrasenia.getText().equals(usuario.getContraseña())) {
					lblError.setText("Usuario o contraseña incorrectos, intente otra vez");
					dispose();
					
				}else  {
					
					
					
					}
			}
		});

		btnLogin.setBounds(111, 407, 152, 32);
		contentPane.add(btnLogin);

	}
}
