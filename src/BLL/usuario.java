package BLL;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class usuario {
	   protected int id;
	private String nombre;
	private String contraseña;
	private LocalDate fechanacimiento;
	private int telefono;
	private String direccion;
	private String puesto;
	LinkedList<usuario> usuarios = new LinkedList<usuario>();
	
	public usuario(int id, String nombre, String contraseña, LocalDate fechanacimiento, int telefono, String direccion,
			String puesto, LinkedList<usuario> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.fechanacimiento = fechanacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.puesto = puesto;
		this.usuarios = usuarios;
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
		admin Nico=new admin("Nico","111",LocalDate.of(2005, 9, 25),22, "french 2930","Administrador","nico@davinci.edu.ar");
		encBarcos Maxi=new encBarcos(id, "Maxi","123",LocalDate.of(2000, 4, 14),"french 2930",221, "Encargado de Barcos");
		encEnvios Lucas=new encEnvios(id,"Lucas","222",LocalDate.of(1999, 11, 10),"french 2930",222,"Encargado de Envios");
		usuarios.add(new admin("Nico","111",LocalDate.of(2005, 9, 25),2222,"french 2930","Administrador","nico@davinci.edu.ar"));
		usuarios.add(new usuario(id, "Maxi","123",LocalDate.of(2000, 4, 14),3333,"french 2930","Encargado de Barcos", usuarios));
		usuarios.add(new usuario(id,"Lucas","222",LocalDate.of(1999, 11, 10),4444,"french 2930","Encargado de Envios",usuarios ));

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
	    	Maxi.FuncionesencBarcos();

	
	
		}
	    if (usuarioEncontrado.getPuesto().equals("Encargado de Envios")) {
	    	UsuarioEncontrado=usuarioEncontrado;
	    	Lucas.FuncionesEnvios();
	    	
			
		}
	
	}}