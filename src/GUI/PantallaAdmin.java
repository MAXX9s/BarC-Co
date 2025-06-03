package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(194, 104, 283, 37);
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
        btnNewButton.setBounds(244, 163, 172, 37);
        getContentPane().add(btnNewButton);
        
        JButton btnListadoDeBarcos = new JButton("Listado de Barcos");
        btnListadoDeBarcos.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnListadoDeBarcos.setBounds(244, 222, 172, 37);
        getContentPane().add(btnListadoDeBarcos);
        
        JButton btnListadoDeEnvios = new JButton("Listado de Envios");
        btnListadoDeEnvios.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnListadoDeEnvios.setBounds(244, 284, 172, 37);
        getContentPane().add(btnListadoDeEnvios);
    }

    public static void main(String[] args) {
        PantallaAdmin ventana = new PantallaAdmin();
        ventana.setVisible(true);
    }
}
