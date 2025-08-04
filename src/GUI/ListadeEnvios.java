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
import javax.swing.JComboBox;

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
		setBounds(100, 100, 658, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
        model = new DefaultTableModel(new String[] {
				"ID_Envio", "Descripcion", "Estado", "Origen", "Destino", "FK_encv"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 78, 622, 200);
        contentPane.add(scrollPane);
       	
		JLabel lblNewLabel = new JLabel("Lista de Envios");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 42));
		lblNewLabel.setBounds(168, 23, 309, 59);
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
		btnNewButton.setBounds(131, 341, 132, 36);
		contentPane.add(btnNewButton);
	    
        cargarTabla();
        
        JComboBox<String> comboPais = new JComboBox<>();
        comboPais.setBounds(339, 318, 174, 20);
        comboPais.addItem("Todos"); 
        comboPais.addItem("Argentina");
        comboPais.addItem("Chile");
        comboPais.addItem("Uruguay");
        comboPais.addItem("Colombia");
        comboPais.addItem("Brasil");
        comboPais.addItem("Estados Unidos");
        comboPais.addItem("China");
        comboPais.addItem("España");
        comboPais.addItem("Canadá");
        comboPais.addItem("México");


        JComboBox<String> comboEstado = new JComboBox<>();
        comboEstado.setBounds(339, 370, 174, 20);
        comboEstado.addItem("Todos");
        comboEstado.addItem("Pendiente de Envio");
        comboEstado.addItem("En proceso");
        comboEstado.addItem("Entregado");
        

        contentPane.add(comboPais);
        contentPane.add(comboEstado);
        
        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBounds(339, 412, 174, 25);
        btnFiltrar.setFont(new Font("Arial", Font.BOLD, 13));
        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String paisSeleccionado = comboPais.getSelectedItem().toString();
                String estadoSeleccionado = comboEstado.getSelectedItem().toString();
                cargarTablaFiltroEnvio(paisSeleccionado, estadoSeleccionado);
            }
        });
        contentPane.add(btnFiltrar);
        
        JLabel lblNewLabel_1 = new JLabel("Por país de origen:");
        lblNewLabel_1.setForeground(new Color(0, 0, 128));
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 11));
        lblNewLabel_1.setBounds(339, 300, 134, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Por estado:");
        lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
        lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 11));
        lblNewLabel_1_1.setBounds(338, 353, 79, 14);
        contentPane.add(lblNewLabel_1_1);

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
		            				u.getFK_ecnv(),
		            				}
		            		);
		        }
		    }
		
		    private void cargarTablaFiltroEnvio(String pais, String estado) {
		        model.setRowCount(0);
		        LinkedList<Envio> envios = encEnvios.verEnvios();

		        for (Envio e : envios) {
		            boolean cumplePais = pais.equals("Todos") || e.getOrigen().equalsIgnoreCase(pais);
		            boolean cumpleEstado = estado.equals("Todos") || e.getEstado().equalsIgnoreCase(estado);
		            
		            if (cumplePais && cumpleEstado) {
		                model.addRow(new Object[]{
		                		e.getId(),
		                        e.getDescripcion(),
		                        e.getEstado(),
		                        e.getOrigen(),
		                        e.getDestino(),
		                        e.getFK_ecnv(),
		                });
		            }
		        }
		    }
}
