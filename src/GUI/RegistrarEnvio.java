package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Envio;
import BLL.encEnvios;
import BLL.usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;

public class RegistrarEnvio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	public static void main(String[] args) {

					RegistrarEnvio frame = new RegistrarEnvio();
					frame.setVisible(true);
	}

	public RegistrarEnvio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Envio");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 38));
		lblNewLabel.setBounds(133, 21, 330, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("A continuación registre todos los detalles del envío");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(154, 74, 288, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(89, 148, 427, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(314, 231, 202, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 231, 205, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("Escriba una breve descripción del envio :");
		lblNewLabel_2.setForeground(new Color(0, 64, 128));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2.setBounds(89, 123, 245, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Origen:");
		lblNewLabel_3.setForeground(new Color(0, 64, 128));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_3.setBounds(89, 214, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Destino:");
		lblNewLabel_4.setForeground(new Color(0, 64, 128));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_4.setBounds(314, 214, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sin entregar", "En proceso", "Entregado"}));
		comboBox.setBounds(314, 297, 202, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Estado:");
		lblNewLabel_6.setForeground(new Color(0, 64, 128));
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_6.setBounds(314, 282, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(89, 302, 205, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Su ID:");
		lblNewLabel_7.setForeground(new Color(0, 64, 128));
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_7.setBounds(89, 282, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Registrar ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				encEnvios encargadoenvios = new encEnvios();
				Envio envio = new Envio();

				String descripcion = textField.getText();
        		String origen = textField_2.getText();
        		String destino = textField_1.getText();
        		String estado = (String) comboBox.getSelectedItem();
        		int fk = Integer.parseInt(textField_4.getText());
        		int id=0;

        		Envio envionuevo = new Envio(id,descripcion,estado,origen,destino,fk);
				encargadoenvios.agregarEnvio(envionuevo);
        		
               
                dispose(); 

				
				
				
			}

			
		});
		
		
		
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(314, 351, 119, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose ();
				AdministrarEnvios frame1 = new AdministrarEnvios();
				frame1.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(89, 350, 119, 31);
		contentPane.add(btnNewButton_1);
		
		
		
		
	}
}
