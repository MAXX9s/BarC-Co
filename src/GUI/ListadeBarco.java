package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import BLL.usuario;
import BLL.Barco;
import BLL.Envio;
import BLL.encBarcos;
import BLL.encEnvios;
import DLL.ControllerUsuario;

public class ListadeBarco extends JFrame {

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
					ListadeBarco frame = new ListadeBarco();
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
	public ListadeBarco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
        model = new DefaultTableModel(new String[] {
				"ID_Barco", "Nombre", "Capacidad", "Fecha entrada", "Hora Entrada", "Fecha Salida", "Hora Salida", "Tarifa","Impuesto"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 133, 644, 233);
        contentPane.add(scrollPane);
       
        
     
		
		
		
		
		JLabel lblNewLabel = new JLabel("Lista de Barcos");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 42));
		lblNewLabel.setBounds(168, 64, 358, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaencBarcos frame = new PantallaencBarcos();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(261, 376, 132, 36);
		contentPane.add(btnNewButton);
	    
        cargarTabla();

    };
		
	 

		  private void cargarTabla() {
			
					model.setRowCount(0);
					  
		 			  LinkedList<Barco> listaBarcos = encBarcos.verBarcos();
					
					
					for (Barco u : listaBarcos) {
			        	/*int id, String nombre, String contraseña, LocalDate fechanacimiento, int telefono, String direccion,
					String puesto*/
			        	/*int id, String nombre, double capacidad, Date fechaEntrada, Time horaEntrada, 
			              Date fechaSalida, Time horaSalida, double tarifa, double impuesto, int fkEncargado*/
			            model.addRow(
			            		new Object[]{
			            				u.getId(),
			            				u.getNombre(),
			            				u.getCapacidad(),
			            				u.getFechaEntrada(),
			            				u.getHoraEntrada(),
			            				u.getFechaSalida(),
			            				u.getHoraSalida(),
			            				u.getTarifa(), 
			            				u.getImpuesto()
			            				}
			            		);
			        } 
			        }
		  		
			    

		  }
		  
		  
		

