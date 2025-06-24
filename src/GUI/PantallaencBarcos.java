package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantallaencBarcos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public PantallaencBarcos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO ENCARGADO DE BARCOS");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel.setBounds(51, 22, 540, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione la opción deseada:");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(307, 104, 228, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Administrar Barcos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		AdministrarBarcos frame = new AdministrarBarcos();
                frame.setVisible(true);
                dispose();
			}
			
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setBounds(332, 143, 154, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver Barcos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ListadeBarco frame = new ListadeBarco();
				frame.setVisible(true);
			
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton_1.setBounds(340, 205, 139, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cerrar Sesion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaPrincipal frame = new PantallaPrincipal();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton_2.setBounds(341, 263, 138, 37);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(PantallaencBarcos.class.getResource("/img/enviar.png")));
		lblNewLabel_2.setBounds(61, 91, 208, 265);
		contentPane.add(lblNewLabel_2);}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaencBarcos frame = new PantallaencBarcos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	

}
