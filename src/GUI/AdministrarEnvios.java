package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministrarEnvios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {

					AdministrarEnvios frame = new AdministrarEnvios();
					frame.setVisible(true);
	}


	public AdministrarEnvios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administración de Envíos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		lblNewLabel.setBounds(94, 49, 417, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione la opción deseada:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(206, 125, 199, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Registrar Envío");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				RegistrarEnvio frame = new RegistrarEnvio();
				frame.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(232, 164, 138, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Actualizar Envío");
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ActualizarEnvio frame = new ActualizarEnvio();
				frame.setVisible(true);

			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(232, 227, 138, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaencEnvios frame1 = new PantallaencEnvios();
				frame1.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBounds(232, 284, 138, 35);
		contentPane.add(btnNewButton_2);

		
	}

}
