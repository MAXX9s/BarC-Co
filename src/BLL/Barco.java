package BLL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;

public class Barco {
	private LinkedList<Barco> Barco = new LinkedList<Barco>();
	private String nombre;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Time horaEntrada;
	private Time horaSalida;
	private int capacidadCarga;
	private double tarifa;
	private int FK_ecb;
	private int id;
	private double impuesto;
	


	public Barco(String nombre, Date fechaEntrada, Date fechaSalida, Time horaEntrada, Time horaSalida,
			int capacidadCarga, double tarifa,int FK_ecb) {
		super();
		this.nombre = nombre;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.capacidadCarga = capacidadCarga;
		this.tarifa = tarifa;
		this.FK_ecb = FK_ecb;
	
	}
	public LinkedList<Barco> getBarco() {
		return Barco;
	}
	public void setBarco(LinkedList<Barco> barco) {
		Barco = barco;
	}
	
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Time getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Time horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public Time getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
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
	
	public int getFK_ecb() {
		return FK_ecb;
	}
	public void setFK_ecb(int fK_ecb) {
		FK_ecb = fK_ecb;
	}
	public double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
}
