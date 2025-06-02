package BLL;
import java.util.LinkedList;

public class Envio {
	
	private String descripcion;
	private String estado;
	private int numero_envio;
	private String origen;
	private String destino;
	private LinkedList<Envio>listaenvios;
	private int FK_encv;
	private int id;
	
	public Envio(int id,String descripcion, String estado, String origen, String destino,int FK_encv) {
		super();
	this.id=id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.numero_envio = numero_envio;
		this.origen = origen;
		this.destino = destino;
		this.FK_encv=FK_encv;
		this.listaenvios = listaenvios;
	}
	
	public Envio () {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero_envio() {
		return numero_envio;
	}

	public void setNumero_envio(int numero_envio) {
		this.numero_envio = numero_envio;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
		
	}
	
	
	
	

	public int getFK_encv() {
		return FK_encv;
	}

	public void setFK_encv(int fK_encv) {
		FK_encv = fK_encv;
	}

	public LinkedList<Envio> getListaenvios() {
		return listaenvios;
	}

	public void setListaenvios(LinkedList<Envio> listaenvios) {
		this.listaenvios = listaenvios;
	}

	@Override
	public String toString() {
		return " \n Envio [Descripcion:" + descripcion + ", Estado actual:" + estado + ", Número de envío:" + numero_envio
				+ ", Origen:" + origen + ", Destino:" + destino +  "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
