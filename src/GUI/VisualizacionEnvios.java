package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Envio;
import BLL.encEnvios;

public class VisualizacionEnvios extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultTableModel model;
    private JTable table; 
    private JLabel lblNewLabel;
    private JButton btnNewButton;

 

    public VisualizacionEnvios() {
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
        scrollPane.setBounds(10, 71, 622, 200);
        contentPane.add(scrollPane);
        
        lblNewLabel = new JLabel("Lista de Envios");
        lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        lblNewLabel.setBounds(240, 22, 177, 38);
        contentPane.add(lblNewLabel);
        
        btnNewButton = new JButton("Volver");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		PantallaAdmin frame = new PantallaAdmin();
                frame.setVisible(true);
                dispose();
        	}
        });
        btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
        btnNewButton.setBounds(107, 336, 154, 46);
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
        comboEstado.addItem("Pendiente de Envío");
        comboEstado.addItem("En proceso");
        comboEstado.addItem("Entregado");
        

        contentPane.add(comboPais);
        contentPane.add(comboEstado);
        
        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBounds(339, 412, 174, 25);
        btnFiltrar.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String paisSeleccionado = comboPais.getSelectedItem().toString();
                String estadoSeleccionado = comboEstado.getSelectedItem().toString();
                cargarTablaFiltroEnvio(paisSeleccionado, estadoSeleccionado);
            }
        });
        contentPane.add(btnFiltrar);
        
        JLabel lblNewLabel_1 = new JLabel("Por país de origen:");
        lblNewLabel_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(338, 293, 134, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Por estado:");
        lblNewLabel_1_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 11));
        lblNewLabel_1_1.setBounds(338, 353, 79, 14);
        contentPane.add(lblNewLabel_1_1);
        
        
        
    }

    private void cargarTabla() {
        model.setRowCount(0); 
        Envio envio = new Envio();
        LinkedList<Envio> listaenvios = encEnvios.verEnvios();
        for (Envio u : listaenvios) {
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