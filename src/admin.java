import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class admin extends usuario{
	private String mail;

	public admin(String nombre, String contraseña, LocalDate fechanacimiento, int telefono, String direccion,
			String puesto, String mail) {
		super(nombre, contraseña, fechanacimiento, telefono, direccion, puesto);
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
	
	public void Funcionesadmin() {
		String[] menu={
			"Soporte de Usuarios","Lista de Barcos","Lista de Envios","Cerrar sesion"
		};
		String[] usuarios= {
				"Lista","Modificar","Eliminar","Crear Usuario","Volver"
		};
	int selec=0;
	int selec1=0;
	do {
		selec=JOptionPane.showOptionDialog(null, "Bienvenido administrador"+ getNombre() , "", 0, selec, null, menu, menu[0]);
		
		switch (selec) {
		case 0:
			do {
				selec1=JOptionPane.showOptionDialog(null, "Que funcion desea realizar?:", "", 0, selec1, null, usuarios, usuarios[0]);
				switch (selec1) {
				case 0:
					JOptionPane.showInternalMessageDialog(null, getUsuarios());
					break;

				case 1:
					JOptionPane.showMessageDialog(null, "Seleccione el usuario que quiere modificar: \n .....");
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "Que usuario desea Eliminar?: \n .....");
				
					break;

				case 3:
					JOptionPane.showMessageDialog(null, "Creando Usuario...");
					
					break;
				case 4:
					break;
				}
			} while (selec1!=4);
			break;
			
		case 1:
			JOptionPane.showMessageDialog(null,"Lista de Barcos: \n .....");
			
			break;
		case 2:
			
			JOptionPane.showMessageDialog(null, "Lista de Envios: \n .....");
			break;
		case 3:
			
			JOptionPane.showMessageDialog(null,"Hasta luego que termine bien su dia!!");
			
			break;
		}
		
		
	} while (selec!=3);
	}}
	
	
	
 