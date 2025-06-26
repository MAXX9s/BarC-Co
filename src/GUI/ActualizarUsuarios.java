package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.admin;
import BLL.usuario;
import DLL.ControllerUsuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class ActualizarUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private static EdicionUsuarios parent;
	private static usuario usuarioOriginal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarUsuarios frame = new ActualizarUsuarios(usuarioOriginal, parent);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ActualizarUsuarios(usuario usuario, EdicionUsuarios parent) {
		   this.usuarioOriginal = usuario; 
		    this.parent = parent;
		setTitle("Actualizar Envio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Actulizar Envio");
		lblNewLabel.setBounds(223, 25, 228, 37);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(258, 89, 143, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		lblContrasea.setBounds(258, 138, 143, 26);
		contentPane.add(lblContrasea);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento (YYYY-MM-DD)");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeNacimiento.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		lblFechaDeNacimiento.setBounds(223, 200, 228, 26);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		lblDireccion.setBounds(258, 254, 143, 26);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		lblTelefono.setBounds(258, 299, 143, 26);
		contentPane.add(lblTelefono);
		
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		lblPuesto.setBounds(258, 351, 143, 26);
		contentPane.add(lblPuesto);
		
		textField = new JTextField();
		textField.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		textField.setColumns(10);
		textField.setBounds(223, 110, 228, 25);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		textField_1.setColumns(10);
		textField_1.setBounds(223, 164, 228, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		textField_2.setColumns(10);
		textField_2.setBounds(222, 229, 229, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		textField_3.setColumns(10);
		textField_3.setBounds(223, 276, 228, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		textField_4.setColumns(10);
		textField_4.setBounds(223, 325, 228, 25);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
		textField_5.setColumns(10);
		textField_5.setBounds(223, 375, 228, 25);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 guardarCambios();
			
			
			}
		});
		
		 
		btnNewButton.setBounds(284, 411, 117, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(543, 411, 103, 26);
		contentPane.add(btnNewButton_1);
	}
	private void guardarCambios() {
	    try {
	       
	    	String nombre = textField.getText();
    		String contraseña = textField_1.getText();
    		LocalDate fechaNacimiento = LocalDate.parse(textField_2.getText()); 
    		String direccion = textField_3.getText();
    		int telefono = Integer.parseInt(textField_4.getText());
    		String puesto = textField_5.getText(); 
    		  int id = usuarioOriginal.getId();

	        
	        usuario actualizado = new usuario(id, nombre, contraseña, fechaNacimiento, direccion, telefono, puesto);

	        ControllerUsuario<usuario> usuCtrl = new ControllerUsuario<>();
	        boolean exito = usuCtrl.ActualizarUsuario(actualizado);

	        if (exito) {
	            JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            parent.cargarTabla();
	            dispose();
	        } else {
	            JOptionPane.showMessageDialog(this, "No se pudo actualizar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "El teléfono debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
	        textField_4.requestFocus();
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}
	
}
