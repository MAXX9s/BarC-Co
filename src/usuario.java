import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class usuario {
	private String nombre;
	private String contraseña;
	private LocalDate fechanacimiento;
	private int telefono;
	private String direccion;
	private String puesto;
	LinkedList<usuario> usuarios = new LinkedList<usuario>();
	
	public usuario(String nombre, String contraseña, LocalDate fechanacimiento, int telefono, String direccion, String puesto
			) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.fechanacimiento = fechanacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.puesto=puesto;
		
	}
	public usuario() {}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public LocalDate getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(LocalDate fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

	
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public LinkedList<usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(LinkedList<usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public String toString() {
		return "usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", fechanacimiento=" + fechanacimiento
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
	
	
	
	
	public void Login(String nom,String con,usuario usuarioEncontrado ) {
		usuario UsuarioEncontrado;
		admin Nico=new admin("Nico","111",LocalDate.of(2005, 9, 25),2222,"french 2930","Administrador","nico@davinci.edu.ar");
		encBarcos Maxi=new encBarcos("Maxi","123",LocalDate.of(2000, 4, 14),3333,"french 2930","Encargado de Barcos");
		encEnvios Lucas=new encEnvios("Lucas","222",LocalDate.of(1999, 11, 10),4444,"french 2930","Encargado de Envios");
		usuarios.add(new admin("Nico","111",LocalDate.of(2005, 9, 25),2222,"french 2930","Administrador","nico@davinci.edu.ar"));
		usuarios.add( new usuario("Maxi","123",LocalDate.of(2000, 4, 14),3333,"french 2930","Encargado de Barcos"));
		usuarios.add( new usuario("Lucas","222",LocalDate.of(1999, 11, 10),4444,"french 2930","Encargado de Envios"));

		do {
	        nom = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");

	        if (nom == null || nom.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre.");
	            
	        }

	        for (usuario u : usuarios) {
	            if (u.getNombre().equals(nom)) {
	                usuarioEncontrado = u;
	                break;
	            }
	        }

	        if (usuarioEncontrado == null) {
	            JOptionPane.showMessageDialog(null, "El nombre " + nom + " no pertenece a ningún usuario registrado.");
	        }

	    } while (usuarioEncontrado == null);


	    do {
	        con = JOptionPane.showInputDialog("Usuario " + nom + ", ingrese su contraseña:");

	        if (con == null || con.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña.");
	        } else if (!con.equals(usuarioEncontrado.getContraseña())) {
	            JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
	        }

	    } while (!con.equals(usuarioEncontrado.getContraseña()));

	   
	    JOptionPane.showMessageDialog(null, "Bienvenido " + usuarioEncontrado.getNombre() + " - " + usuarioEncontrado.getPuesto());
	    if (usuarioEncontrado.getPuesto().equals("Administrador")) {
	    	UsuarioEncontrado=usuarioEncontrado;
	    	Nico.Funcionesadmin();
	    	
			
		}
	    if (usuarioEncontrado.getPuesto().equals("Encargado de Barcos")) {
	    	UsuarioEncontrado=usuarioEncontrado;
	     String[] menu= {
	    		 "Registrar Barcos", "Tomar salida", "Ver Barcos","Calcular Tarifa","Salir"
	     };
	     int selec=0;
			selec=JOptionPane.showOptionDialog(null, "Bienvenido administrador"+ getNombre() , "", 0, selec, null, menu, menu[0]);
do {
	switch (selec) {
	case 0:
		Maxi.registrarBarco();
		break;

	case 1:
		Maxi.registrarsalidaBarco();
		break;
	case 2:
		Maxi.verBarcos();
		break;

	case 3:
		Maxi.calcularTarifaImpuesto();
		
		break;
		
	}
	
	
	
} while (selec!=4);
			
		}
	    if (usuarioEncontrado.getPuesto().equals("Encargado de Envios")) {
	    	UsuarioEncontrado=usuarioEncontrado;
	    	Lucas.FuncionesEnvios();
	    	
			
		}
	
	}}