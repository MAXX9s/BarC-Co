package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import BLL.Barco;
import BLL.encBarcos;
import BLL.usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;

public class RegistrarBarco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JDateChooser dateChooser2;
	private  SpinnerNumberModel hourModel;	

	public static void main(String[] args) {

		RegistrarBarco frame = new RegistrarBarco();
		frame.setVisible(true);
	}

	public RegistrarBarco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro de Barcos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 38));
		lblNewLabel.setBounds(114, 21, 356, 60);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("A continuación registre todos los detalles del barco");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(133, 92, 300, 25);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(89, 148, 205, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(314, 148, 205, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(new Color(0, 64, 128));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2.setBounds(89, 123, 185, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fecha de Entrada");
		lblNewLabel_3.setForeground(new Color(0, 64, 128));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_3.setBounds(89, 214, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		
	

		JLabel lblNewLabel_4 = new JLabel("Capacidad de carga:");
		lblNewLabel_4.setForeground(new Color(0, 64, 128));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_4.setBounds(314, 128, 156, 14);
		contentPane.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setBounds(314, 236, 205, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Tarifa:");
		lblNewLabel_7.setForeground(new Color(0, 64, 128));
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_7.setBounds(314, 214, 46, 14);
		contentPane.add(lblNewLabel_7);

		JButton btnNewButton = new JButton("Registrar ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				encBarcos encargadobarcos = new encBarcos();
				Barco barco = new Barco();
					
				String Nombre = textField.getText();
				
				
				

				Barco barconuevo = new Barco(id, nombre, fechaEntrada,);
				encargadobarcos.agregarBarco(barconuevo);

				dispose();

			}

		});

		// Crear el segundo JDateChooser
		

		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setDateFormatString("dd/MM/yyyy");
		dateChooser2.setEnabled(true);
		dateChooser2.setBounds(89, 236, 205, 25);
		contentPane.add(dateChooser2);
	      
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(351, 352, 119, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdministrarEnvios frame1 = new AdministrarEnvios();
				frame1.setVisible(true);
				
				 
			}
			
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(114, 352, 119, 31);
		contentPane.add(btnNewButton_1);
		
		

	}
}
