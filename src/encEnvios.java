import java.time.LocalDate;

import javax.swing.JOptionPane;

public class encEnvios extends usuario {


	public encEnvios(String nombre, String contraseña, LocalDate fechanacimiento, int telefono, String direccion,
			String puesto) {
		super(nombre, contraseña, fechanacimiento, telefono, direccion, puesto);
		// TODO Auto-generated constructor stub
	}

	public encEnvios() {}
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
		selec=JOptionPane.showOptionDialog(null, "Bienvenido administrador"+ getNombre() , "", 0, selec, null, menu, menu[0]);
		
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
	
	

	public void administrarEnvios () {
		
		Envio envio = new Envio();
		
		String [] elección = new String [] {
			"Resgistrar envío","Actualizar estado de envío","Salir"	
		};
		int elegido = 0;
		boolean flag = false;
		do {
			elegido = JOptionPane.showOptionDialog(null, "Menu Administrador", getNombre(), 0, 0, null, elección, elección[0]);
			switch (elegido) {
			case 0:
				
				JOptionPane.showMessageDialog(null, "A continuación registre todos los detalles del envío a realizar");
				
				envio.setDescripcion(JOptionPane.showInputDialog("Escriba una breve descripción indicando el contenido del container:"));
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
	
	public void verEnvios() {
		
		
		
	}
	
	
	
	
	
	
}
