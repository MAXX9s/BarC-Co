import java.time.LocalDateTime;
import java.util.LinkedList;

public class Barco {
	private LinkedList<Barco> Barco = new LinkedList<Barco>();
	private String nombre;
	private String fechaEntrada;
	private String fechaSalida;
	private String horaEntrada;
	private String horaSalida;
	private int capacidadCarga;
	private double tarifa;
	private double impuesto;
	
	public Barco(String nombre, String fechaEntrada,String horaEntrada,int capacidadCarga) {
		this.nombre = nombre;
		this.fechaEntrada = fechaEntrada;
		this.horaEntrada = horaEntrada;
		this.capacidadCarga = capacidadCarga;
	}
	public Barco(LinkedList<Barco> barco, String nombre, String fechaEntrada, String fechaSalida, String horaEntrada,
			String horaSalida, int capacidadCarga, double tarifa, double impuesto) {
		Barco = barco;
		this.nombre = nombre;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.capacidadCarga = capacidadCarga;
		this.tarifa = tarifa;
		this.impuesto = impuesto;
	}
	

	public LinkedList<Barco> getBarco() {
		return Barco;
	}
	public void setBarco(LinkedList<Barco> barco) {
		Barco = barco;
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCapacidadCarga() {
		return capacidadCarga;
	}
	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	public double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
}
