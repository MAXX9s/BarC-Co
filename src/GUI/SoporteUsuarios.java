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
        setSize(688, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null); // o un layout como BorderLayout, etc.

        JLabel label = new JLabel("Soporte de Usuarios");
        label.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(161, 46, 342, 40); // solo si usás layout null
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
        btnNewButton.setBounds(248, 157, 161, 30);
        getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Seleccione una opcion:");
        lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(212, 97, 237, 18);
        getContentPane().add(lblNewLabel);
}
}
