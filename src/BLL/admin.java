package BLL;

import java.awt.JobAttributes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.Conexion;
import DLL.ControllerUsuario;
import repository.UsuarioRepository;

public class admin extends usuario {
	private String mail;
	private static Connection con = Conexion.getInstance().getConnection();

	public admin(int id, String nombre, String contraseña, LocalDate fechanacimiento,  String direccion,int telefono,
			String puesto) {
		super(id, nombre, contraseña, fechanacimiento, telefono, direccion, puesto);
		this.mail = mail;
	}
	public admin() {};
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void agregarUsuario(usuario usuario) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO usuario (Nombre, Contraseña, `Fecha de nacimiento`, Direccion, Telefono, Puesto) "
							+ "VALUES (?, ?, ?, ?, ?, ?)");

			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getContraseña());
			statement.setDate(3, java.sql.Date.valueOf(usuario.getFechanacimiento()));
			statement.setInt(5, usuario.getTelefono());
			statement.setString(4, usuario.getDireccion());
			statement.setString(6, usuario.getPuesto());

			int filas = statement.executeUpdate();
			if (filas > 0) {
				System.out.println("Usuario agregado correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
	
		}
	}
	



	public void Funcionesadmin() {
		String[] menu = { "Soporte de Usuarios", "Lista de Barcos", "Lista de Envios", "Cerrar sesion" };
		String[] usuarios = { "Lista", "Modificar", "Eliminar", "Crear Usuario", "Volver" };
		int selec = 0;
		int selec1 = 0;
		do {
			selec = JOptionPane.showOptionDialog(null, "Bienvenido administrador" + getNombre(), "", 0, selec, null,
					menu, menu[0]);

			switch (selec) {
			case 0:
				do {
					selec1 = JOptionPane.showOptionDialog(null, "Que funcion desea realizar?:", "", 0, selec1, null,
							usuarios, usuarios[0]);
					switch (selec1) {
					case 0:
						JOptionPane.showMessageDialog(null, "Lista de Usuarios:"+ "\n" + ControllerUsuario.mostrarUsuarios2() );
						
						break;

					case 1:
						JOptionPane.showMessageDialog(null, "Seleccione el usuario que quiere modificar: \n .....");
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Que usuario desea Eliminar?: \n .....");

						break;

					case 3:
						String nombre = JOptionPane.showInputDialog("Ingresa el Nombre");
						String contra = JOptionPane.showInputDialog("Ingresa la Contraseña");
						String fecha = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (YYYY-MM-DD)");
						int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de telefono"));
						String direc = JOptionPane.showInputDialog("Ingrese la dirección");
						String puesto = JOptionPane.showInputDialog("Ingrese el puesto");

						LocalDate fechaNac = LocalDate.parse(fecha);

						agregarUsuario(new usuario(numero, nombre, contra, fechaNac, numero, direc, puesto));
						break;
					case 4:
						break;
					}
				} while (selec1 != 4);
				break;

			case 1:
			

				break;
			case 2:

				JOptionPane.showMessageDialog(null, "Lista de Envios: \n .....");
				break;
			case 3:

				JOptionPane.showMessageDialog(null, "Hasta luego que termine bien su dia!!");

				break;

			}

		} while (selec != 3);
	}
}
