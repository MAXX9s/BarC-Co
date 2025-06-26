package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Envio;
import BLL.encEnvios;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateEstado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int idEnvio;
	private ActualizarEnvio frameAnterior;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 UpdateEstado frame = new UpdateEstado(1, null); 
		    frame.setVisible(true);	
	}

	/**
	 * Create the frame.
	 */
	public UpdateEstado(int idEnvio, ActualizarEnvio frameAnterior) {

		 this.idEnvio = idEnvio;
		   this.frameAnterior = frameAnterior;

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 603, 493);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    JLabel lblNewLabel = new JLabel("Cambio de estado de envío");
	    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
	    lblNewLabel.setBounds(34, 58, 529, 47);
	    contentPane.add(lblNewLabel);

	    JComboBox<String> comboBox = new JComboBox<>();
	    comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Sin entregar", "En proceso", "Entregado"}));
	    comboBox.setFont(new Font("Arial", Font.PLAIN, 25));
	    comboBox.setBounds(236, 182, 307, 47);
	    contentPane.add(comboBox);


	    comboBox.getSelectedItem();

	    JLabel lblNewLabel_1 = new JLabel("Eliga el estado al que desea cambiar el envío:");
	    lblNewLabel_1.setForeground(new Color(0, 64, 128));
	    lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
	    lblNewLabel_1.setBounds(226, 135, 322, 36);
	    contentPane.add(lblNewLabel_1);

	    JButton btnNewButton = new JButton("Confirmar");
	    btnNewButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String nuevoEstado = comboBox.getSelectedItem().toString();

	            Envio envio = new Envio();
	            envio.setId(idEnvio);
	            envio.setEstado(nuevoEstado);

	            encEnvios encargadoenvios = new encEnvios();
	            encargadoenvios.actualizarEstadoEnvio(envio, idEnvio, nuevoEstado);

	            
	            frameAnterior.setVisible(true);
	            frameAnterior.cargarTabla(); 
	            dispose();
	        }
	    });
	    btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
	    btnNewButton.setBounds(299, 269, 191, 36);
	    contentPane.add(btnNewButton);

	    JLabel lblNewLabel_2 = new JLabel("");
	    lblNewLabel_2.setIcon(new ImageIcon(UpdateEstado.class.getResource("/img/actualizar2.png")));
	    lblNewLabel_2.setBounds(57, 156, 134, 133);
	    contentPane.add(lblNewLabel_2);
	}


}
