package BLL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.Conexion;
import DLL.ControllerBarco;

public class encBarcos extends usuario {
	private LinkedList<Barco> barcos = new LinkedList<Barco>();
    private static Connection con = Conexion.getInstance().getConnection();

	public encBarcos(int id, String nombre, String contraseña, LocalDate fecha, String direccion, int telefono,
			String puesto) {
        super(id, nombre, contraseña, fecha, direccion, telefono, puesto);

	}


	public void FuncionesencBarcos() {
	    String[] menu = {
	        "Registrar Barco", "Registrar Salida Barco", "Mostrar Barcos","Calcular Tarifa e Impuesto","Cerrar sesión"
	    };

	    int selec = 0;
	    do {
	    	  selec = JOptionPane.showOptionDialog(null, "Bienvenido encargado de barcos " + getNombre(), "", 0, 0, null, menu, menu[0]);

	        switch (selec) {
	            case 0:
	            	agregarBarco(null);
	                break;
	            case 1:
	                registrarsalidaBarco();
	                break;
	            case 2:
	                verBarcos();
	                break;
	            case 3:
	            	calcularTarifaImpuesto();
	            	break;
	            case 4:
	                JOptionPane.showMessageDialog(null, "Hasta luego, que termine bien su día!!");
	                break;
	        
	        }
	    } while (selec != 4);
	}
	

		
	
	
	public LinkedList<Barco> getBarcos() {
		return barcos;
	}

	public void setBarcos(LinkedList<Barco> barcos) {
		this.barcos = barcos;
	}


	public void agregarBarco(Barco Barco) {
	    try {
	        PreparedStatement statement = con.prepareStatement(
	            "INSERT INTO envio (Nombre, Fecha_Entrada, Capacidad, Hora_Entrada) VALUES (?, ?, ?, ?)"
	        );
	        statement.setString(1, Barco.getNombre());
	        statement.setDate(2, Barco.getFechaEntrada());
	        statement.setDouble(3, Barco.getCapacidad());
	        statement.setTime(4, Barco.getHoraEntrada());

	        int filas = statement.executeUpdate();
	        if (filas > 0) {
	            System.out.println("Barco registrado parcialmente.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
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
		   // barcoEncontrado.setHoraSalida(horaSalida);
		    //barcoEncontrado.setFechaSalida(fechaSalida);
	}
	public void calcularTarifaImpuesto(){
		    String nombre = validarCaracteres("Ingrese el nombre del barco al que desea asignar tarifa e impuesto:");
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
		    
		    double tarifa = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa:"));  
		    double impuesto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el impuesto:"));;
		    
		    barcoEncontrado.setTarifa(tarifa);
		    barcoEncontrado.setImpuesto(impuesto);
		    
		    JOptionPane.showMessageDialog(null, "Tarifa e impuesto asignados exitosamente al barco " + nombre+"\n"+"Tarifa: "+tarifa+"\n"+"Impuesto: "+impuesto);
		}
		
	
	public static LinkedList<Barco> verBarcos() {
		LinkedList<Barco> listaBarcos = ControllerBarco.obtenerTodosLosBarcos();
		if (listaBarcos.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay barcos registrados.");
	      
	    }
		return listaBarcos;
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
	public static boolean registrarSalida(Barco barco) {
	    try {
	        PreparedStatement stmt = con.prepareStatement(
	            "UPDATE barco SET fecha_salida = ?, hora_salida = ? WHERE id = ?");
	        stmt.setDate(1, barco.getFechaSalida());
	        stmt.setTime(2, barco.getHoraSalida());
	        stmt.setInt(3, barco.getId());
	        
	        return stmt.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
