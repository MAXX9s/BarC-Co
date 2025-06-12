package BLL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.Conexion;

public class encEnvios extends usuario {
    private LinkedList<Envio> listaEnvios = new LinkedList<>();
    private static Connection con = Conexion.getInstance().getConnection();


    public encEnvios(int id, String nombre, String contraseña, LocalDate fechaNacimiento, String direccion, int telefono, String puesto) {
        super(id, nombre, contraseña, fechaNacimiento, telefono, direccion, puesto);
    }

	
	public encEnvios() {}
	
	public LinkedList<Envio> getListaEnvios() {
		return listaEnvios;
	}

	public void setListaEnvios(LinkedList<Envio> listaEnvios) {
		this.listaEnvios = listaEnvios;
	}

	public void FuncionesEnvios() {
		String[] menu={
			"Administrar Envios","Ver Envios","Cerrar sesion"
		};
		String[] usuarios= {
				"Lista","Modificar","Eliminar","Volver"
		};
	int selec=0;
	int selec1=0;
	do {
		selec=JOptionPane.showOptionDialog(null, "Bienvenido Encargado Envíos  "+ getNombre() , "", 0, selec, null, menu, menu[0]);
		
		switch (selec) {
				case 0:
					administrarEnvios();
					break;
				case 1:
					verEnvios();
					break;
				case 2:
					break;
		
		
		
		}
	}while (selec!=2);
	
	}
	public void agregarEnvio(Envio envio) {
	    try {
	        PreparedStatement statement = con.prepareStatement(
	            "INSERT INTO envio (Descripcion, Estado, Origen, Destino,FK_ecnv) " +
	            "VALUES (?, ?, ?, ?,?)"
	        );

	        statement.setString(1, envio.getDescripcion());
	        statement.setString(2, envio.getEstado());
	        statement.setString(3, envio.getOrigen());
	        statement.setString(4, envio.getDestino());
	        statement.setInt(5, envio.getFK_encv());

	       ;

	        int filas = statement.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Enivo Agregado correctamente.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	

	public void administrarEnvios () {
		
		Envio envio = new Envio();
		
		String [] elección = new String [] {
			"Resgistrar envío","Actualizar estado de envío","Salir"	
		};
		int elegido = 0;
		boolean flag = false;
		do {
			elegido = JOptionPane.showOptionDialog(null, "Menú Encargado de Envíos  ", getNombre(), 0, 0, null, elección, elección[0]);
			switch (elegido) {
			case 0:
				
				JOptionPane.showMessageDialog(null, "A continuación registre todos los detalles del envío a realizar");
				
				String descripcion=JOptionPane.showInputDialog("Escriba una breve descripción indicando el contenido del container:");
				String origen =JOptionPane.showInputDialog("Escriba el origen del envío:");
				String destino=JOptionPane.showInputDialog("Escriba el destino del envío");
				int fk=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de ID"));

				String [] estados = new String [] {
						"Pendiente de Envio","En proceso","Entregado"	
					};
				String estadoactual;
				estadoactual=((String) JOptionPane.showInputDialog(null, "Eliga el estado actual en el que se encuentra el envío registrado:", "Estado actual del envío", 0, null, estados, estados[0]));
				flag = true;
				
				
				/*try {
				    PreparedStatement statement = con.prepareStatement(
				        "SELECT `FK_Encargado de Envios` FROM `envio`"
				    );
				    
				    ResultSet rs = statement.executeQuery();
				    while (rs.next()) {
				        int fk = rs.getInt(1); 
				     
				    }
				    
				} catch (Exception e) {
				    e.printStackTrace();
				}
*/
				
				  JOptionPane.showMessageDialog(null, "EL ENVÍO FUE REGISTRADO CORRECTAMENTE: \n"
						+ "Descripción" + descripcion 
						 + " \n Origen:" + origen + "\n Destino:" + destino + "\n Estado actual:" + estadoactual);
				  
				  agregarEnvio(new Envio(id,descripcion,estadoactual, origen, destino, fk));

				  
				  
				  break;
				 
				
			case 1:
				if (flag) {
					int numeroeleccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del envío al que le desea cambiar el estado:"));
					
					if (numeroeleccion==envio.getId()) {
						String [] estados1 = new String [] {
								"Pendiente de Envio","En proceso","Entregado"	
							};
						String estadoactual1 = "";
						
						if (envio.getEstado().equals("Pendiente de Envio")) {
							estadoactual = (String) JOptionPane.showInputDialog(null, "Eliga el estado al que desea actualizar el envío", "Actualización de estado de envío", 0, null, estados1, estados1[0]);
							envio.setEstado(estadoactual1);
							JOptionPane.showMessageDialog(null, "El estado del envío correspondiente ya fue actualizado");
						}
						else if (envio.getEstado().equals("En proceso")) {
							estadoactual = (String) JOptionPane.showInputDialog(null, "Eliga el estado al que desea actualizar el envío", "Actualización de estado de envío", 0, null, estados1, estados1[0]);
							envio.setEstado(estadoactual1);
							JOptionPane.showMessageDialog(null, "El estado del envío correspondiente ya fue actualizado");
						}
												
						
					} else {
						JOptionPane.showMessageDialog(null, "El número de envío que usted escribió no existe");
					}
				} else {
					JOptionPane.showMessageDialog(null, "No hay envíos registrados");
				}
				
				break;
						
			default:
				break;
			}	
		} while (elegido!=2);
	}
	
	public static LinkedList<Envio> verEnvios() {
		
	        LinkedList<Envio> Envios = new LinkedList<>();
	        try {
	            PreparedStatement stmt = con.prepareStatement("SELECT * FROM envio");
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                int id = rs.getInt("ID_Envio");
	                String descripcion = rs.getString("Descripcion");
	                String estado = rs.getString("Estado");
	                String origen = rs.getString("Origen");
	                String destino = rs.getString("Destino");
	                int FK_ecnv = rs.getInt("FK_ecnv");


	               
		            Envios.add((Envio)new Envio(id,descripcion,estado,origen,destino,FK_ecnv));
                    	                    
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return Envios; 
	    }
	
	public void actualizarEstadoEnvio(Envio u,int ID_Envio, String nuevoEstado) {
		  try {
		        PreparedStatement statement = con.prepareStatement(
		            "UPDATE envio SET Estado = ? WHERE ID_Envio = ?"
		        );

		        statement.setString(1, nuevoEstado); 
		        statement.setInt(2, ID_Envio);        

		        int filasActualizadas = statement.executeUpdate();

		        if (filasActualizadas > 0) {
		            System.out.println("Estado del envío actualizado correctamente.");
		        } else {
		            System.out.println("No se encontró el envío con ese ID.");
		        }

		       

		       
		        if (filasActualizadas > 0) {
		            System.out.println("Envío actualizado correctamente.");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}


	

	
	
	
	
}
	    
	
	


