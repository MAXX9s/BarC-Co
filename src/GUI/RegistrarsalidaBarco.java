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
import java.util.LinkedList;

import BLL.Barco;
import BLL.encBarcos;
import BLL.usuario;
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
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class RegistrarsalidaBarco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_4;
	private JDateChooser dateChooser2;
	private JSpinner hourSpinner;
    private JSpinner minuteSpinner;  
    private JComboBox<Barco> comboBarcos;
    private Barco barcoSeleccionado;

	public static void main(String[] args) {

		RegistrarsalidaBarco frame = new RegistrarsalidaBarco();
		frame.setVisible(true);
	}

	public RegistrarsalidaBarco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBarcos = new JComboBox<>();
        comboBarcos.setBounds(89, 147, 430, 25);
        contentPane.add(comboBarcos);	
        
        JLabel lblBarco = new JLabel("Seleccione Barco:");
        lblBarco.setForeground(new Color(0, 64, 128));
        lblBarco.setFont(new Font("Arial", Font.BOLD, 11));
        lblBarco.setBounds(89, 123, 185, 14);
        contentPane.add(lblBarco);
        
        cargarBarcos();
		
        comboBarcos.addActionListener(e -> {
            barcoSeleccionado = (Barco) comboBarcos.getSelectedItem();
            if (barcoSeleccionado != null) {
                // Mostrar datos del barco seleccionado
              
                textField_4.setText(String.valueOf(barcoSeleccionado.getImpuesto()));
            }
        });
        
    
                   
	
		JLabel lblNewLabel = new JLabel("Salida de Barcos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 38));
		lblNewLabel.setBounds(135, 22, 356, 60);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("A continuación, registre todos los detalles correspondientes a la salida del barco");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(83, 92, 508, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Fecha y hora de salida:");
		lblNewLabel_3.setForeground(new Color(0, 64, 128));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_3.setBounds(89, 214, 174, 12);
		contentPane.add(lblNewLabel_3);

		textField_4 = new JTextField();
		textField_4.setBounds(374, 236, 145, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Impuesto:");
		lblNewLabel_7.setForeground(new Color(0, 64, 128));
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_7.setBounds(377, 213, 60, 14);
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
				if (barcoSeleccionado == null || textField_4.getText().isEmpty() ) {
					lblNewLabel_5.setText("Debe llenar los campos para poder registrar un envío!!");
	               	contentPane.revalidate();
	                contentPane.repaint();
		        }else {
				 int horas = (int) hourSpinner.getValue();
		            int minutos = (int) minuteSpinner.getValue();
		            double impuesto = Double.parseDouble(textField_4.getText());
		            
		            barcoSeleccionado.setFechaSalida(new Date(dateChooser2.getDate().getTime()));
		            barcoSeleccionado.setHoraSalida(new Time(horas, minutos, 0));
		            barcoSeleccionado.setImpuesto(impuesto);
		        
		            if (ControllerBarco.registrarSalida(barcoSeleccionado)) {
		                JOptionPane.showMessageDialog(null, "Salida registrada exitosamente");
		                dispose();
		                new AdministrarBarcos().setVisible(true);
		            } else {
		                JOptionPane.showMessageDialog(null, "Error al registrar salida");
		            }

			}
			}
		});

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
	
	        
        private void cargarBarcos() {
            comboBarcos.removeAllItems();
            LinkedList<Barco> barcos = ControllerBarco.obtenerBarcosEnPuerto();
            for (Barco barco : barcos) {
                comboBarcos.addItem(barco);
            }
        
      

	}
}
