package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaencEnvios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaencEnvios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Encargado de Envios");
		lblNewLabel.setForeground(new Color(64, 0, 0));
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 25));
		lblNewLabel.setBounds(64, 67, 487, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione la opción deseada:");
		lblNewLabel_1.setForeground(new Color(64, 0, 0));
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(186, 149, 228, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Administrar Envios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		AdministrarEnvios frame = new AdministrarEnvios();
                frame.setVisible(true);
                dispose();
			}
			
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setBounds(64, 227, 139, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver Envíos");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton_1.setBounds(241, 227, 139, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cerrar Sesion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaPrincipal frame = new PantallaPrincipal();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton_2.setBounds(413, 227, 138, 37);
		contentPane.add(btnNewButton_2);}
	
	public static void main(String[] args) {
		PantallaencEnvios frame = new PantallaencEnvios();
		frame.setVisible(true);
}
}


