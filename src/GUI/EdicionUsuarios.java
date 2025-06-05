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
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSeleccionado = new JLabel("Seleccionado:");
        lblSeleccionado.setBounds(10, 44, 760, 20);
        contentPane.add(lblSeleccionado);

        model = new DefaultTableModel(new String[]{
        "ID_Usuario", "Nombre", "Contraseña", "Fecha de nacimiento","Direccion","Telefono","Puesto"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 69, 760, 200);
        contentPane.add(scrollPane);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(10, 280, 150, 40);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");

btnEliminar.addActionListener(e -> {
    int filaSeleccionada = table.getSelectedRow();
    if (filaSeleccionada != -1) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int idUsuario = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());

            // Crear objeto usuario con solo el ID
            usuario u = new usuario();
            u.setId(idUsuario);

            // Llamar al método para eliminar en la base de datos
            ControllerUsuario.EliminarUsuario(u);

            // Eliminar de la tabla (solo interfaz)
            model.removeRow(filaSeleccionada);

            // Actualizar etiqueta
            lblSeleccionado.setText("Seleccionado:");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Selecciona un usuario para eliminar.");
    }
});
        btnEliminar.setBounds(620, 280, 150, 40);
        contentPane.add(btnEliminar);

        // Acción al seleccionar fila
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();
                if (row != -1) {
                	
                	
                    usuarioSeleccionado = new usuario(
                        (int) model.getValueAt(row, 0),
                        (String) model.getValueAt(row, 1),
                        (String) model.getValueAt(row, 2),
                        (LocalDate) model.getValueAt(row, 3),
                        (int) model.getValueAt(row, 4),
                        (String) model.getValueAt(row, 5),
                        (String) model.getValueAt(row, 6)
    
                    );
                    lblSeleccionado.setText(usuarioSeleccionado.toString());
                   
                   
                }
            }
        });
        
        filtro = new JTextField();
        filtro.setBounds(293, 290, 174, 20);
        contentPane.add(filtro);
        filtro.setColumns(10);
        
        JButton btnNewButton = new JButton("Filtrar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		cargarTablaFiltro(filtro.getText());
        	}
        });
        btnNewButton.setBounds(322, 330, 118, 40);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Edicion de Usuarios");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(304, 11, 174, 22);
        contentPane.add(lblNewLabel);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SoporteUsuarios frame = new SoporteUsuarios();
        		
                frame.setVisible(true);
                dispose();
        		
        	}
        });
        btnVolver.setBounds(620, 366, 150, 40);
        contentPane.add(btnVolver);
        // Cargar datos
        cargarTabla();

    }

    private void cargarTabla() {
        model.setRowCount(0);
        LinkedList<usuario> usuarios = ControllerUsuario.mostrarUsuarios2();
        for (usuario u : usuarios) {
        	/*int id, String nombre, String contraseña, LocalDate fechanacimiento, int telefono, String direccion,
		String puesto*/
            model.addRow(
            		new Object[]{
            				u.getId(),
            				u.getNombre(),
            				u.getContraseña(),
            				u.getFechanacimiento(),
            				u.getTelefono(),
            				u.getDireccion(),
            				u.getPuesto()}
            		);
        }
    }
    
    
    
    
    private void cargarTablaFiltro(String filtro) {
        model.setRowCount(0);
        LinkedList<usuario> usuarios = ControllerUsuario.mostrarUsuarios2();
        for (usuario u : usuarios) {
        	if (u.getNombre().startsWith(filtro)) {
				
			
            model.addRow(
            		new Object[]{
            				u.getId(),
            				u.getNombre(),
            				u.getContraseña(),
            				u.getFechanacimiento(),
            				u.getTelefono(),
            				u.getDireccion(),
            				u.getPuesto()}
            		);
        }}
    }
}
