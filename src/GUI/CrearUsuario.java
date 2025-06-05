package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import BLL.admin;
import BLL.usuario;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
public class CrearUsuario extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

    public CrearUsuario() {
        setTitle("Crear Nuevo Usuario");
        setSize(645, 484);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null); // o un layout como BorderLayout, etc.

        JLabel label = new JLabel("Hora de Crear un Usuario Nuevo");
        label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(118, 29, 392, 36); // solo si usás layout null
        getContentPane().add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        textField.setBounds(200, 105, 228, 25);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(244, 77, 143, 26);
        getContentPane().add(lblNewLabel);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        textField_1.setColumns(10);
        textField_1.setBounds(200, 155, 228, 25);
        getContentPane().add(textField_1);
        
        JLabel lblContrasea = new JLabel("Contraseña");
        lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
        lblContrasea.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
        lblContrasea.setBounds(244, 130, 143, 26);
        getContentPane().add(lblContrasea);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        textField_2.setColumns(10);
        textField_2.setBounds(199, 208, 229, 25);
        getContentPane().add(textField_2);
        
        JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento (YYYY-MM-DD)");
        lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
        lblFechaDeNacimiento.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
        lblFechaDeNacimiento.setBounds(200, 181, 228, 26);
        getContentPane().add(lblFechaDeNacimiento);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        textField_3.setColumns(10);
        textField_3.setBounds(200, 255, 228, 25);
        getContentPane().add(textField_3);
        
        JLabel lblDireccion = new JLabel("Direccion");
        lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
        lblDireccion.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
        lblDireccion.setBounds(244, 232, 143, 26);
        getContentPane().add(lblDireccion);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        textField_4.setColumns(10);
        textField_4.setBounds(200, 304, 228, 25);
        getContentPane().add(textField_4);
        
        JLabel lblTelefono = new JLabel("Telefono");
        lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
        lblTelefono.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
        lblTelefono.setBounds(244, 279, 143, 26);
        getContentPane().add(lblTelefono);
        
        JLabel lblPuesto = new JLabel("Puesto");
        lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
        lblPuesto.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
        lblPuesto.setBounds(244, 328, 143, 26);
        getContentPane().add(lblPuesto);
        
        textField_5 = new JTextField();
        textField_5.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        textField_5.setColumns(10);
        textField_5.setBounds(200, 354, 228, 25);
        getContentPane().add(textField_5);
        
        JButton btnNewButton = new JButton("Crear Usuario");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		admin administrador = new admin(); // o un singleton si lo preferís

        		String nombre = textField.getText();
        		String contraseña = textField_1.getText();
        		LocalDate fechaNacimiento = LocalDate.parse(textField_2.getText()); // o usar DateTimeFormatter
        		String direccion = textField_3.getText();
        		int telefono = Integer.parseInt(textField_4.getText());
        		String puesto = textField_5.getText(); // si tenés uno más
        		int id=0;
        		usuario nuevo = new usuario(id,nombre, contraseña, fechaNacimiento,telefono,direccion, puesto);
        		administrador.agregarUsuario(nuevo);
        		if (btnNewButton.equals(true)) {
					
				}
               
                dispose(); 
        		
        	}
        });
        btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnNewButton.setBounds(244, 390, 137, 23);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Cancelar");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SoporteUsuarios frame = new SoporteUsuarios();
                frame.setVisible(true);
                dispose();
        		
        	}
        });
        btnNewButton_1.setBounds(517, 409, 102, 25);
        getContentPane().add(btnNewButton_1);
        
        
        
        
        
        
        
        
        
        
        
    }

    public static void main(String[] args) {
        PantallaAdmin ventana = new PantallaAdmin();
        ventana.setVisible(true);
    }
}
