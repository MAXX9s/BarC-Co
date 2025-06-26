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
        scrollPane.setBounds(10, 134, 622, 200);
        contentPane.add(scrollPane);
        
        lblNewLabel = new JLabel("Lista de Envios");
        lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        lblNewLabel.setBounds(241, 62, 177, 38);
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
        btnNewButton.setBounds(261, 369, 123, 23);
        contentPane.add(btnNewButton);
        
        // ... resto del código del constructor ...
        
        cargarTabla();
    }

    private void cargarTabla() {
        model.setRowCount(0); // Ahora model está correctamente inicializado
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
}