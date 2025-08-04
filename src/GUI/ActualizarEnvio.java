package GUI;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Envio;
import BLL.encEnvios;
import BLL.usuario;
import DLL.ControllerUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ActualizarEnvio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTable table;
	private DefaultTableModel model;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblErrorSeleccion = new JLabel("");

	public static void main(String[] args) {
					ActualizarEnvio frame = new ActualizarEnvio();
					frame.setVisible(true);
	}


	public ActualizarEnvio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
        model = new DefaultTableModel(new String[] {
				"ID_Envio", "Descripcion", "Estado", "Origen", "Destino", "FK_encv"}, 0);
        contentPane.setLayout(null);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 117, 584, 213);
        contentPane.add(scrollPane);
        
        lblNewLabel = new JLabel("Actualización de Envío");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
        lblNewLabel.setBounds(124, 26, 384, 43);
        contentPane.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("Seleccione el envío al que le desea cambiar el estado:");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_1.setBounds(134, 80, 363, 14);
        contentPane.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("Actualizar");
        btnNewButton.addActionListener(e -> {
            int filaSeleccionada = table.getSelectedRow();
            if (filaSeleccionada != -1) {
            	lblErrorSeleccion.setText("");

                	 int ID_Envio = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString()); 
                     String EstadoActual = model.getValueAt(filaSeleccionada, 2).toString(); 

                     UpdateEstado frame = new UpdateEstado(ID_Envio, this);
                     frame.setVisible(true);
                     this.setVisible(false); 

            } else {
            	lblErrorSeleccion.setText("¡Debes seleccionar un envío para actualizar!");
            	 contentPane.revalidate();
                 contentPane.repaint();
            }
        });

        btnNewButton.setBounds(349, 391, 148, 29);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Volver");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		AdministrarEnvios frame = new AdministrarEnvios();
				frame.setVisible(true);
        		
        	}
        });
        btnNewButton_1.setBounds(134, 391, 148, 29);
        contentPane.add(btnNewButton_1);
        
        lblErrorSeleccion = new JLabel("");
        lblErrorSeleccion.setForeground(new Color(255, 0, 0));
        lblErrorSeleccion.setBounds(191, 92, 315, 14);
        contentPane.add(lblErrorSeleccion);
        
        cargarTabla();
        ;}
        
		 public void cargarTabla() {
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
		            				u.getFK_ecnv(),
		            				}
		            		);
		        }
		    
		
	}
}
