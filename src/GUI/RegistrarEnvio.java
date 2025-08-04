package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Envio;
import BLL.encEnvios;
import BLL.usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private JTextField textodestino;
	private JTextField textoorigen;
	private JTextField textoid;
	private JLabel lblNewLabel_5  = new JLabel("");
	private JLabel lblNewLabel_8  = new JLabel("");
	

	public static void main(String[] args) {

					RegistrarEnvio frame = new RegistrarEnvio();
					frame.setVisible(true);			
	}

	public boolean solonumeros(String texto){
		for(int i = 0; i < texto.length(); i++) {
			if (!Character.isDigit(texto.charAt(i))) {
				
			  	contentPane.revalidate();
                contentPane.repaint();
                return false;
			}
		}
		return true;
	}
	public boolean sololetras(String texto){
		for(int i = 0; i < texto.length(); i++) {
			if (!Character.isLetter(texto.charAt(i))) {
				
			  	contentPane.revalidate();
                contentPane.repaint();
                return false;
			}
		}
		return true;
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
		
		textodestino = new JTextField();
		textodestino.setBounds(314, 231, 202, 30);
		contentPane.add(textodestino);
		textodestino.setColumns(10);
		
		textoorigen = new JTextField();
		textoorigen.setBounds(89, 231, 205, 30);
		contentPane.add(textoorigen);
		textoorigen.setColumns(10);
		
		
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pendiente de Envío", "En proceso", "Entregado"}));
		comboBox.setBounds(314, 297, 202, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Estado:");
		lblNewLabel_6.setForeground(new Color(0, 64, 128));
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_6.setBounds(314, 282, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textoid = new JTextField();
		textoid.setBounds(89, 302, 205, 25);
		contentPane.add(textoid);
		textoid.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Su ID:");
		lblNewLabel_7.setForeground(new Color(0, 64, 128));
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_7.setBounds(89, 282, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(new Color(255, 128, 0));
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(148, 391, 315, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(new Color(0, 128, 0));
		lblNewLabel_8.setBackground(new Color(128, 128, 128));
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_8.setBounds(200, 98, 242, 14);
		contentPane.add(lblNewLabel_8);

		JLabel validacionorigen = new JLabel("");
		validacionorigen.setForeground(new Color(255, 128, 0));
		validacionorigen.setFont(new Font("Arial", Font.BOLD, 12));
		validacionorigen.setBounds(99, 261, 195, 14);
		contentPane.add(validacionorigen);
		
		JLabel validaciondestino = new JLabel("");
		validaciondestino.setForeground(new Color(255, 128, 0));
		validaciondestino.setFont(new Font("Arial", Font.BOLD, 12));
		validaciondestino.setBounds(321, 261, 195, 14);
		contentPane.add(validaciondestino);
		
		JLabel validacionid = new JLabel("");
		validacionid.setForeground(new Color(255, 128, 0));
		validacionid.setFont(new Font("Arial", Font.BOLD, 12));
		validacionid.setBounds(89, 325, 195, 14);
		contentPane.add(validacionid);
		
		
		
		JButton btnNewButton = new JButton("Registrar ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean hayerrores = false;
				if (textoorigen.getText().isEmpty()) {
					validacionorigen.setText("Debe ingresar el origen");
					hayerrores = true;
					
				}else if (!sololetras(textoorigen.getText())) {
					validacionorigen.setText("Solo se permiten letras");
					hayerrores = true;
				}else {
					validacionorigen.setText("");
				}
				
				if (textodestino.getText().isEmpty()) {
					validaciondestino.setText("Debe ingresar el destino");
					hayerrores = true;
					
				}else if (!sololetras(textodestino.getText())) {
					validaciondestino.setText("Solo se permiten letras");
					hayerrores = true;
				}else {
					validaciondestino.setText("");
				}
				
				if (textoid.getText().isEmpty()) {
					validacionid.setText("Debes ingresar tu ID");
					hayerrores = true;
					
				}else if (!solonumeros(textoid.getText())) {
					validacionid.setText("Solo se permiten numeros");
					hayerrores = true;
				}else {
					validacionid.setText("");
				}
				

				if (textField.getText().isEmpty() || textoorigen.getText().isEmpty() || textodestino.getText().isEmpty() ) {
					lblNewLabel_5.setText("Debe llenar los campos para poder registrar un envío!!");
					hayerrores = true;
				}else {
					lblNewLabel_5.setText("");
				}
					if(hayerrores) {
		               	contentPane.revalidate();
		                contentPane.repaint();
		                return;
					}
					
					lblNewLabel_8.setText("Envío registrado correctamente!!");
					contentPane.revalidate();
	                contentPane.repaint();	
					
				encEnvios encargadoenvios = new encEnvios();
				Envio envio = new Envio();

				String descripcion = textField.getText();
        		String origen = textoorigen.getText();
        		String destino = textodestino.getText();
        		String estado = (String) comboBox.getSelectedItem();
        		int fk = Integer.parseInt(textoid.getText());
        		int id=0;
        		Envio envionuevo = new Envio(id,descripcion,estado,origen,destino,fk );
        	
					encargadoenvios.agregarEnvio(envionuevo);
				
					
		
	                   
				}

			}

			
		);
		
		
		
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
