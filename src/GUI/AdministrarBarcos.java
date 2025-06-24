package GUI;

import java.awt.EventQueue;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministrarBarcos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {

					AdministrarBarcos frame = new AdministrarBarcos();
					frame.setVisible(true);
	}


	public AdministrarBarcos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administración de Barcos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		lblNewLabel.setBounds(94, 49, 446, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione la opción deseada:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(206, 125, 199, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Registrar Barco");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				RegistrarBarco frame = new RegistrarBarco();
				frame.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(140, 163, 138, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrar Salida");
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				RegistrarsalidaBarco frame = new RegistrarsalidaBarco();
				frame.setVisible(true);

			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(347, 163, 138, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaencBarcos frame1 = new PantallaencBarcos();
				frame1.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBounds(206, 324, 199, 39);
		contentPane.add(btnNewButton_2);
		
		
		
	}
}
