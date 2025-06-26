package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Barco;
import BLL.encBarcos;

public class VisualizacionBarcos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	   private DefaultTableModel model;
	    private JTable table; 
	    private JLabel lblNewLabel;
	    private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizacionBarcos frame = new VisualizacionBarcos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VisualizacionBarcos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
        model = new DefaultTableModel(new String[] {
				"ID_Barco", "Nombre", "Capacidad", "Fecha entrada", "Hora Entrada", "Fecha Salida", "Hora Salida", "Tarifa"}, 0);
        contentPane.setLayout(null);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 113, 699, 232);
        contentPane.add(scrollPane);
       
        
     
		
		
		
		
		JLabel lblNewLabel = new JLabel("Lista de Barcos");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 25));
		lblNewLabel.setBounds(281, 32, 234, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAdmin frame = new PantallaAdmin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(327, 363, 135, 35);
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
			            				}
			            		);
			        } 
			        }
		
		
	}


