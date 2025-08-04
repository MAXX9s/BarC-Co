package GUI;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import BLL.Barco;
import DLL.ControllerBarco;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class RegistrarBarco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textocarga;
	private JTextField textotarifa;
	private JDateChooser dateChooser2;
	private JSpinner hourSpinner;
    private JSpinner minuteSpinner;  

	public static void main(String[] args) {

		RegistrarBarco frame = new RegistrarBarco();
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

		textocarga = new JTextField();
		textocarga.setBounds(314, 148, 205, 25);
		contentPane.add(textocarga);
		textocarga.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(new Color(0, 64, 128));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2.setBounds(89, 123, 185, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fecha y hora de entrada:");
		lblNewLabel_3.setForeground(new Color(0, 64, 128));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_3.setBounds(89, 214, 174, 12);
		contentPane.add(lblNewLabel_3);
        
        JLabel validaciontarifa = new JLabel("");
        validaciontarifa.setForeground(new Color(255, 128, 0));
        validaciontarifa.setFont(new Font("Arial", Font.BOLD, 12));
        validaciontarifa.setBounds(374, 263, 175, 19);
        contentPane.add(validaciontarifa);
        
        JLabel validacioncarga = new JLabel("");
        validacioncarga.setForeground(new Color(255, 128, 0));
        validacioncarga.setFont(new Font("Arial", Font.BOLD, 12));
        validacioncarga.setBounds(314, 177, 213, 14);
        contentPane.add(validacioncarga);
	
		
	

		JLabel lblNewLabel_4 = new JLabel("Capacidad de carga:");
		lblNewLabel_4.setForeground(new Color(0, 64, 128));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_4.setBounds(314, 128, 156, 14);
		contentPane.add(lblNewLabel_4);

		textotarifa = new JTextField();
		textotarifa.setBounds(374, 236, 145, 25);
		contentPane.add(textotarifa);
		textotarifa.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Tarifa:");
		lblNewLabel_7.setForeground(new Color(0, 64, 128));
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_7.setBounds(374, 213, 46, 14);
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
		lblNewLabel_8.setBounds(178, 313, 242, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Registrar ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean hayerrores = false;
				if (textocarga.getText().isEmpty()) {
					validacioncarga.setText("La carga no puede estar vacia");
					hayerrores = true;
					
				}else if (!solonumeros(textocarga.getText())) {
					validacioncarga.setText("Solo se permiten numeros");
					hayerrores = true;
				}else {
					validacioncarga.setText("");
				}
				if (textotarifa.getText().isEmpty()) {
					validaciontarifa.setText("La tarifa no puede estar vacia");
					hayerrores = true;
					
				}else if (!solonumeros(textotarifa.getText())) {
					validaciontarifa.setText("Solo se permiten numeros");
					hayerrores = true;
				}else {
					validaciontarifa.setText("");
				}
				
				if (textField.getText().isEmpty() || textocarga.getText().isEmpty() || textotarifa.getText().isEmpty() ) {
					lblNewLabel_5.setText("Debe llenar los campos para poder registrar un envío!!");
					hayerrores = true;
				}else{
					lblNewLabel_5.setText("");
				}
				if(hayerrores) {
	               	contentPane.revalidate();
	                contentPane.repaint();
	                return;
				}
				
					
				   String nombre = textField.getText();
                   Date fechaEntrada = dateChooser2.getDate();
                   int horas = (int) hourSpinner.getValue();
                   int minutos = (int) minuteSpinner.getValue();
                   int capacidad = Integer.parseInt(textocarga.getText());
                   double tarifa = Double.parseDouble(textotarifa.getText());

                   Barco nuevoBarco = new Barco();
                   nuevoBarco.setNombre(nombre);
                   nuevoBarco.setCapacidad(capacidad);
                   nuevoBarco.setFechaEntrada(fechaEntrada);
                   nuevoBarco.setHoraEntrada(new Time(horas, minutos, 0));  
                   nuevoBarco.setTarifa(tarifa);  
                   nuevoBarco.setFkEncargado(1);
                   
                   if (ControllerBarco.registrarBarco(nuevoBarco)) {
               		
   					lblNewLabel_8.setText("Barco registrado correctamente!!");
   					validaciontarifa.setText("");
   					lblNewLabel_5.setText("");
   					validacioncarga.setText("");
   					contentPane.revalidate();
   	                contentPane.repaint();	
                      
                   } else {
                                          }
			}
			}
		);

		// Crear el segundo JDateChooser
		

		dateChooser2 = new JDateChooser();
	    dateChooser2.setDateFormatString("dd/MM/yyyy");
	    dateChooser2.setBounds(89, 236, 135, 25);
	    contentPane.add(dateChooser2);
	      
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(351, 352, 119, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdministrarBarcos frame1 = new AdministrarBarcos();
				frame1.setVisible(true);
				 
				 
			}
			
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(114, 352, 119, 31);
		contentPane.add(btnNewButton_1);
		
		 SpinnerNumberModel hourModel = new SpinnerNumberModel(0, 0, 23, 1);
	        hourSpinner = new JSpinner(hourModel);
	        hourSpinner.setBackground(SystemColor.windowText);
	        JSpinner.NumberEditor hourEditor = new JSpinner.NumberEditor(hourSpinner, "00");
	        hourSpinner.setEditor(hourEditor);
	        hourSpinner.setBounds(234, 236, 60, 25);
	        contentPane.add(hourSpinner); 
	        
	        SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 59, 1);
	        minuteSpinner = new JSpinner(minuteModel);
	        minuteSpinner.setBackground(SystemColor.windowText);
	        JSpinner.NumberEditor minuteEditor = new JSpinner.NumberEditor(minuteSpinner, "00");
	        minuteSpinner.setEditor(minuteEditor);
	        minuteSpinner.setBounds(304, 236, 60, 25); 
	        contentPane.add(minuteSpinner); 
	        
	        JLabel lblNewLabel_3_1 = new JLabel("Hora");
	        lblNewLabel_3_1.setForeground(new Color(0, 64, 128));
	        lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 11));
	        lblNewLabel_3_1.setBounds(249, 214, 26, 12);
	        contentPane.add(lblNewLabel_3_1);
	        
	        JLabel lblNewLabel_3_1_1 = new JLabel("Minutos");
	        lblNewLabel_3_1_1.setForeground(new Color(0, 64, 128));
	        lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 11));
	        lblNewLabel_3_1_1.setBounds(304, 214, 60, 12);
	        contentPane.add(lblNewLabel_3_1_1);
	        


	}
}
