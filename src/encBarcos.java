import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class encBarcos extends usuario {
	private LinkedList<Barco> barcos = new LinkedList<Barco>();
	public encBarcos(String nombre, String contraseña, LocalDate fechanacimiento, int telefono, String direccion) {
		super(nombre, contraseña, fechanacimiento, telefono, direccion, direccion);
	}
	public void registrarBarco(){
		String nombre = validarCaracteres("Ingrese el nombre del barco");
		String fechaEntrada = JOptionPane.showInputDialog("Ingrese La fecha de entrada del barco");
		String horaEntrada = JOptionPane.showInputDialog("Ingrese la hora de entrada del barco");
		int capacidadcarga = validarNumeros("Ingrese la capacidad de carga");
		Barco nuevoBarco = new Barco(nombre,fechaEntrada,horaEntrada,capacidadcarga);
		barcos.add(nuevoBarco);
		JOptionPane.showMessageDialog(null, "Nombre"+nombre+"\n"+"Hora de Entrada"+horaEntrada+"\n"+"Capacidad de carga:"+capacidadcarga);
	}
	public void registrarsalidaBarco(){
		String nombre = validarCaracteres("Ingrese el nombre del barco que va a salir:");
		 Barco barcoEncontrado = null;
		    for (Barco b : barcos) {
		        if (b.getNombre().equalsIgnoreCase(nombre)) {
		            barcoEncontrado = b;
		            break;
		        }
		        
		    }
		    if (barcoEncontrado == null) {
		        JOptionPane.showMessageDialog(null, "No se encontró un barco con ese nombre.");
		        return;
		    }

			String fechaSalida = JOptionPane.showInputDialog("Ingrese La fecha de Salida del barco");
		    String horaSalida = JOptionPane.showInputDialog("Ingrese la hora de salida del barco");
		    barcoEncontrado.setHoraSalida(horaSalida);
	}
	public void calcularTarifaImpuesto(){
	
	}
	public void verBarcos() {
		if (barcos.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay barcos registrados.");
	        return;
	    }

	    for (Barco b : barcos) {
	        String datos = "Nombre: " + b.getNombre() + "\n"
	                     + "Hora de entrada: " + b.getHoraEntrada() + "\n"
	                     + "Hora de salida: " + (b.getHoraSalida() != null ? b.getHoraSalida() : "No registrada") + "\n"
	                     + "Capacidad de carga: " + b.getCapacidadCarga() + "\n";

	        JOptionPane.showMessageDialog(null, datos);
	    }
	}
	public String validarCaracteres(String mensaje) {
		String palabra = "";
		while (palabra.contains("1") || palabra.equals(" ") || palabra.contains("2") || palabra.contains("3")
				|| palabra.contains("4") || palabra.contains("5") || palabra.contains("6") || palabra.contains("7")
				|| palabra.contains("8") || palabra.contains("9") || palabra.contains("0") || palabra.isEmpty()) {
			palabra = JOptionPane.showInputDialog(mensaje);
		}
		return palabra;
	}
	public int validarNumeros(String mensaje) {
		boolean flag;
		String num = "";
		do {
			flag = true;
			num = JOptionPane.showInputDialog(mensaje);
			while (num.isEmpty()) {
				num = JOptionPane.showInputDialog(mensaje);
			}
			for (int i = 0; i < num.length(); i++) {
				if (!Character.isDigit(num.charAt(i))) {
					flag = false;
					break;
				}
			}
		} while (!flag);

		return Integer.parseInt(num);
	}
}
