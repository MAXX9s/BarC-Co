package GUI;

import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SoporteUsuarios extends JFrame {


    public SoporteUsuarios() {
        setTitle("Soporte Usuarios");
        setSize(651, 466);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null); 

        JLabel label = new JLabel("Soporte de Usuarios");
        label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(142, 45, 342, 40); 
        getContentPane().add(label);
        
        JButton btnNewButton = new JButton("Crear Usuario");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CrearUsuario frame = new CrearUsuario();
                frame.setVisible(true);
                dispose();
        	}
        });
        btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnNewButton.setBounds(237, 159, 161, 30);
        getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Seleccione una opcion:");
        lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(199, 96, 237, 18);
        getContentPane().add(lblNewLabel);
        
        JButton btnListaDeUsuarios = new JButton("Edicion Usuarios");
        btnListaDeUsuarios.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		EdicionUsuarios frame = new EdicionUsuarios();
                frame.setVisible(true);
                dispose();
        	}
        });
        btnListaDeUsuarios.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnListaDeUsuarios.setBounds(237, 212, 161, 30);
        getContentPane().add(btnListaDeUsuarios);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		PantallaAdmin frame = new PantallaAdmin();
                frame.setVisible(true);
                dispose();
        		
        	}
        });
        btnVolver.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        btnVolver.setBounds(237, 263, 161, 30);
        getContentPane().add(btnVolver);
}
}
