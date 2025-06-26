package GUI;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BLL.admin;
import BLL.usuario;
import DLL.ControllerUsuario;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.LinkedList;

public class EdicionUsuarios extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private usuario usuarioSeleccionado;
    private JTextField inpFiltro;
    private JTextField filtro;

  

    public EdicionUsuarios() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 823, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        

        model = new DefaultTableModel(new String[]{
        "ID_Usuario", "Nombre", "Contraseña", "Fecha de nacimiento","Direccion","Telefono","Puesto"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 69, 787, 200);
        contentPane.add(scrollPane);
        
        JLabel lblErrorEditar = new JLabel("No seleccionó ningún usuario");
        lblErrorEditar.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
        lblErrorEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblErrorEditar.setForeground(Color.RED);
        lblErrorEditar.setBounds(280, 38, 225, 20); 
        lblErrorEditar.setVisible(false); 
        contentPane.add(lblErrorEditar);
        
        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
        btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow(); 

                lblErrorEditar.setVisible(false);
                
                if (filaSeleccionada != -1 && usuarioSeleccionado != null) {
                    new ActualizarUsuarios(usuarioSeleccionado, EdicionUsuarios.this).setVisible(true);
                } else {
                    lblErrorEditar.setText("No seleccionó ningún usuario");
                    lblErrorEditar.setVisible(true);
                }
            }
        });
        btnEditar.setBounds(10, 280, 150, 40);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));

btnEliminar.addActionListener(e -> {
    int filaSeleccionada = table.getSelectedRow();
    
            
                int idUsuario = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());
                usuario u = new usuario();
                u.setId(idUsuario);
                ControllerUsuario.EliminarUsuario(u);
                model.removeRow(filaSeleccionada);
                
        
    });
        btnEliminar.setBounds(647, 280, 150, 40);
        contentPane.add(btnEliminar);

    
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();
                if (row != -1) {
                	
                	
                    usuarioSeleccionado = new usuario(
                        (int) model.getValueAt(row, 0),
                        (String) model.getValueAt(row, 1),
                        (String) model.getValueAt(row, 2),
                        (LocalDate) model.getValueAt(row, 3),
                        (String) model.getValueAt(row, 4),
                        (int) model.getValueAt(row, 5),                  
                        (String) model.getValueAt(row, 6)
    
                    );
                    
                   
                }
            }
        });
        
        filtro = new JTextField();
        filtro.setBounds(306, 300, 174, 20);
        contentPane.add(filtro);
        filtro.setColumns(10);
        
        JButton btnNewButton = new JButton("Filtrar");
        btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		cargarTablaFiltro(filtro.getText());
        	}
        });
        btnNewButton.setBounds(338, 331, 118, 40);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Edicion de Usuarios");
        lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        lblNewLabel.setBounds(280, 11, 225, 20);
        contentPane.add(lblNewLabel);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SoporteUsuarios frame = new SoporteUsuarios();
                frame.setVisible(true);
                dispose();
        		
        	}
        });
        btnVolver.setBounds(647, 367, 150, 40);
        contentPane.add(btnVolver);
        
        JLabel lblNewLabel_1 = new JLabel("Buscador:");
        lblNewLabel_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(355, 280, 85, 14);
        contentPane.add(lblNewLabel_1);
  
        cargarTabla();

    }

    public void cargarTabla() {
        model.setRowCount(0);
        LinkedList<usuario> usuarios = ControllerUsuario.mostrarUsuarios2();
        for (usuario u : usuarios) {
       
            model.addRow(
            		new Object[]{
            				u.getId(),
            				u.getNombre(),
            				u.getContraseña(),
            				u.getFechanacimiento(),
            				u.getDireccion(),
            				u.getTelefono(),
            				u.getPuesto()}
            		);
        }
    }
    
    
    
    
    private void cargarTablaFiltro(String filtro) {
        model.setRowCount(0);
        LinkedList<usuario> usuarios = ControllerUsuario.mostrarUsuarios2();
        for (usuario u : usuarios) {
        	if (u.getNombre().equalsIgnoreCase(filtro)) {
				
			
            model.addRow(
            		new Object[]{
            				u.getId(),
            				u.getNombre(),
            				u.getContraseña(),
            				u.getFechanacimiento(),
            				u.getDireccion(),
            				u.getTelefono(),
            				u.getPuesto()}
            		);
        }}
    }

	
}
