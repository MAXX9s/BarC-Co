	package DLL;
	import BLL.usuario;
import GUI.AdministrarEnvios;

import GUI.PantallaAdmin;
import GUI.PantallaencBarcos;
import GUI.PantallaencEnvios;
import GUI.EdicionUsuarios;
import BLL.admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import BLL.encEnvios;
import BLL.encBarcos;
import BLL.usuario;
import repository.UsuarioRepository;

public class ControllerUsuario<T extends usuario> implements UsuarioRepository {

    private static Connection con = Conexion.getInstance().getConnection();

    
    public static usuario login(String nombre, String contraseña) {
  
		usuario usuario = new usuario();
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE nombre = ? AND contraseña = ?"
            );
            stmt.setString(1, nombre);
            stmt.setString(2, contraseña);
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
    
                int id = rs.getInt("ID_Usuario");
                String Nombre = rs.getString("Nombre");
                String Contraseña = rs.getString("Contraseña");
                LocalDate Fecha = LocalDate.now();
                String Direccion = rs.getString("Direccion");
                int Telefono = rs.getInt("Telefono");
                String Puesto = rs.getString("Puesto");
              

                


                switch (Puesto.trim().toLowerCase()) {
                case "encargado de barcos":
                    usuario =  new encBarcos(id, Nombre, Contraseña, Fecha, Direccion, Telefono, Puesto);
                    PantallaencBarcos frame1 = new PantallaencBarcos();
                    frame1.setVisible(true);
                    break;

                case "encargado de envios":
                    usuario =  new encEnvios(id, Nombre, Contraseña, Fecha, Direccion, Telefono, Puesto);
            		PantallaencEnvios frame2 = new PantallaencEnvios();
                    frame2.setVisible(true);
                    break;
                case "administrador":
                    usuario =  new admin(id, Nombre, Contraseña, Fecha, Direccion,Telefono, Puesto);
                	PantallaAdmin frame = new PantallaAdmin();
                    frame.setVisible(true);
                    
                    break;

                    
                default:
                    System.out.println("Tipo de puesto desconocido: '" + Puesto + "'");
                    break;
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void agregarUsuario(usuario usuario) {
    	try {
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO usuario (Nombre, Contraseña, `Fecha de nacimiento`, Direccion, Telefono, Puesto) "
							+ "VALUES (?, ?, ?, ?, ?, ?)");

			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getContraseña());
			statement.setDate(3, java.sql.Date.valueOf(usuario.getFechanacimiento()));
			statement.setString(4, usuario.getDireccion());
			statement.setInt(5, usuario.getTelefono());
			statement.setString(6, usuario.getPuesto());

			int filas = statement.executeUpdate();
			if (filas > 0) {
				System.out.println("Usuario agregado correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
	
		}
    }

	public static LinkedList<usuario> mostrarUsuarios2() {
        LinkedList<usuario> usuarios = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_Usuario");
                String Nombre = rs.getString("Nombre");
                String Contraseña = rs.getString("Contraseña");
                LocalDate Fecha = rs.getDate("Fecha de nacimiento").toLocalDate();                
                String Direccion = rs.getString("Direccion");
                int Telefono = rs.getInt("Telefono");
                String Puesto = rs.getString("Puesto");


	            switch (Puesto.toLowerCase()) {
                case "encargado de barcos":
                	usuarios.add((usuario) new encBarcos(id, Nombre, Contraseña, Fecha, Direccion,Telefono,Puesto));
                    break;
                case "encargado de envios":
                 	usuarios.add((usuario) new encEnvios(id, Nombre, Contraseña, Fecha, Direccion,Telefono,Puesto));
                    break;
                case "administrador":
                 	usuarios.add((usuario) new admin(id, Nombre, Contraseña, Fecha,Direccion,Telefono,Puesto));
                    break;
                default:
                    System.out.println("Tipo desconocido: " + Puesto);
                    break;}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
	public static usuario EliminarUsuario(usuario usuario) {
        try {
            PreparedStatement statement = con.prepareStatement(
            		"DELETE FROM usuario WHERE ID_Usuario=?"

            );
            statement.setInt(1, usuario.getId());            

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario Eliminado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return usuario;
    }

	public static boolean ActualizarUsuario(usuario u) {
	    try  {
            PreparedStatement ps = con.prepareStatement(

            		"UPDATE usuario SET " +
                            "`Nombre` = ?, " +
                            "`Contraseña` = ?, " +
                            "`Direccion` = ?, " +
                            "`Telefono` = ?, " +
                            "`Puesto` = ? " +
                            "WHERE `ID_Usuario` = ?");
	       
	        ps.setString(1, u.getNombre());
	        ps.setString(2, u.getContraseña());
	        ps.setString(3, u.getDireccion());
	        ps.setInt(4, u.getTelefono());
	        ps.setString(5, u.getPuesto());
	        ps.setInt(6, u.getId());

	        int filas = ps.executeUpdate();
	        System.out.println("Filas afectadas: " + filas);
	        return filas > 0;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return false;
	    }
	}

	
	
	
	@Override
	public List<usuario> mostrarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
