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
    private java.sql.Date fechaEntrada;
    private java.sql.Date fechaSalida;
	private Time horaEntrada;
	private Time horaSalida;
	private double capacidad;
	private double tarifa;
	private int fkEncargado;
	private int id;
	private double impuesto;
	

	
	  public Barco() {
		super();
		
	}
	  public Barco(int id, String nombre, double capacidad, Date fechaEntrada, Time horaEntrada, 
              Date fechaSalida, Time horaSalida, double tarifa, double impuesto, int fkEncargado) {
      this.id = id;
      this.nombre = nombre;
      this.capacidad = capacidad;
      this.fechaEntrada = fechaEntrada;
      this.horaEntrada = horaEntrada;
      this.fechaSalida = fechaSalida;
      this.horaSalida = horaSalida;
      this.tarifa = tarifa;
      this.impuesto = impuesto;
      this.fkEncargado = fkEncargado;
	  }
	public LinkedList<Barco> getBarco() {
		return Barco;
	}
	
	
	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	public int getFkEncargado() {
		return fkEncargado;
	}
	public void setFkEncargado(int fkEncargado) {
		this.fkEncargado = fkEncargado;
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
	  public void setFechaSalida(java.util.Date fecha) {
	        this.fechaSalida = fecha != null ? new java.sql.Date(fecha.getTime()) : null;
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
	public void setFechaEntrada(java.util.Date fecha) {
		this.fechaEntrada = new java.sql.Date(fecha.getTime());
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String toString() {
        return this.nombre ; 
    }
	
}
