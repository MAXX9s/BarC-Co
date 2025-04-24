import java.time.LocalDate;

import javax.swing.JOptionPane;

public class encEnvios extends usuario {

	private String nombre;

	public encEnvios(String nombre, String contraseña, LocalDate fechanacimiento, int telefono, String direccion,
			String nombre2) {
		super(nombre, contraseña, fechanacimiento, telefono, direccion, nombre2);
		nombre = nombre2;
	}
	
	public encEnvios() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void administrarEnvios () {
		
		Envio envio = new Envio();
		
		String [] elección = new String [] {
			"Resgistrar envío","Actualizar estado de envío","Salir"	
		};
		int elegido = 0;
		boolean flag = false;
		do {
			elegido = JOptionPane.showOptionDialog(null, envio, nombre, elegido, elegido, null, elección, elección[0]);
			switch (elegido) {
			case 0:
				String[] estados = new String [] {
						"Pendiente de envío","En proceso","Entregado"
					};
				JOptionPane.showMessageDialog(null, "A continuación registre todos los detalles del envío a realizar");
				
				envio.setDescripcion(JOptionPane.showInputDialog("Escriba una breve descripción indicando el contenido del container:"));
				envio.setEstado((String) JOptionPane.showInputDialog(null, "Eliga el estado en el que se encuentra el envío:", null, getTelefono(), null, estados, estados[0]));
				envio.setNumero_envio(Integer.parseInt(JOptionPane.showInputDialog("Asigenele un numero a este envío o escriba el número del envío en el caso de que ya exista")));
				envio.setOrigen(JOptionPane.showInputDialog("Escriba el origen del envío:"));
				envio.setDestino(JOptionPane.showInputDialog("Escriba el destino del envío"));
				
				flag = true;

				
				JOptionPane.showMessageDialog(null, "EL ENVÍO FUE REGISTRADO CORRECTAMENTE: \n"
						+ "Descripción" + envio.getDescripcion() + " \n Estado:" + envio.getEstado() + " \n Número de envío:" + envio.getNumero_envio()
						 + " \n Origen:" + envio.getOrigen() + "\n Destino:" + envio.getDestino());
				
				break;
			case 1:
				if (flag) {
					int numeroeleccion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del envío al que le desea cambiar el estado:"));
					
					if (numeroeleccion==envio.getNumero_envio()) {
						
						switch (envio.getNumero_envio()) {
						case 0:
							
							break;
						case 1:
							
							break;
						case 2:
	
							break;

						default:
							break;
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
	
	
	
	
	
	
}
