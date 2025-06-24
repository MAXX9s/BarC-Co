package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PantallaAdmin extends JFrame {

    public PantallaAdmin() {
        setTitle("Pantalla de Administrador");
        setSize(684, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null); // o un layout como BorderLayout, etc.

        JLabel label = new JLabel("Bienvenido Administrador");
        label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(184, 47, 308, 37); // solo si usás layout null
        getContentPane().add(label);
        
        JLabel lblNewLabel = new JLabel("Seleccione la opcion deseada:");
        lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setBounds(26, 109, 283, 37);
        getContentPane().add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Soporte de Usuarios");
        btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SoporteUsuarios frame = new SoporteUsuarios();
                frame.setVisible(true);
                dispose();
        	}
        });
        btnNewButton.setBounds(63, 166, 172, 37);
        getContentPane().add(btnNewButton);
        
        JButton btnListadoDeBarcos = new JButton("Listado de Barcos");
        btnListadoDeBarcos.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnListadoDeBarcos.setBounds(63, 226, 172, 37);
        getContentPane().add(btnListadoDeBarcos);
        
        JButton btnListadoDeEnvios = new JButton("Listado de Envios");
        btnListadoDeEnvios.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		
        		
        		
        	}
        });
        btnListadoDeEnvios.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnListadoDeEnvios.setBounds(63, 283, 172, 37);
        getContentPane().add(btnListadoDeEnvios);
        
        JButton btnSalir = new JButton("Cerrar Session");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PantallaPrincipal frame = new PantallaPrincipal();
                frame.setVisible(true);
                dispose();
        		
        		
        	}
        });
        btnSalir.setFont(new Font("Dialog", Font.PLAIN, 11));
        btnSalir.setBounds(63, 345, 172, 37);
        getContentPane().add(btnSalir);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(PantallaAdmin.class.getResource("/img/admin4.png")));
        lblNewLabel_1.setBounds(338, 109, 256, 306);
        getContentPane().add(lblNewLabel_1);
    }

    public static void main(String[] args) {
        PantallaAdmin ventana = new PantallaAdmin();
        ventana.setVisible(true);
    }
}
