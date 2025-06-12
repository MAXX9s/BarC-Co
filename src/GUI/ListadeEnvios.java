package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import BLL.usuario;
import BLL.Envio;
import BLL.encEnvios;
import DLL.ControllerUsuario;

public class ListadeEnvios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadeEnvios frame = new ListadeEnvios();
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
	public ListadeEnvios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
        model = new DefaultTableModel(new String[] {
				"ID_Envio", "Descripcion", "Estado", "Origen", "Destino", "FK_encv"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 134, 500, 200);
        contentPane.add(scrollPane);
       
        
     
		
		
		
		
		JLabel lblNewLabel = new JLabel("Lista de Envios");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 42));
		lblNewLabel.setBounds(107, 64, 335, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaencEnvios frame = new PantallaencEnvios();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(192, 340, 132, 36);
		contentPane.add(btnNewButton);
	    
        cargarTabla();

    };
		
	 

		  private void cargarTabla() {
				model.setRowCount(0);
				Envio envio = new Envio();
		        LinkedList<Envio> listaenvios = encEnvios.verEnvios();
		        for (Envio u : listaenvios) {
		        	/*int id, String nombre, String contraseña, LocalDate fechanacimiento, int telefono, String direccion,
				String puesto*/
		            model.addRow(
		            		new Object[]{
		            				u.getId(),
		            				u.getDescripcion(),
		            				u.getEstado(),
		            				u.getOrigen(),
		            				u.getDestino(),
		            				u.getFK_encv(),
		            				}
		            		);
		        }
		    }
		
}
