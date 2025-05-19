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
			String puesto) {
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
}
	
	
	
	