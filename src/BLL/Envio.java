package BLL;
import java.util.LinkedList;

public class Envio {
	
	private String descripcion;
	private String estado;
	private String origen;
	private String destino;
	private LinkedList<Envio>listaenvios;
	private int FK_ecnv;
	private int id;
	
	public Envio(int id,String descripcion, String estado, String origen, String destino,int FK_ecnv) {
		super();
	this.id=id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.origen = origen;
		this.destino = destino;
		this.FK_ecnv=FK_ecnv;
		this.listaenvios = listaenvios;
	}
	
	public Envio () {
		
	}

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
	

	public int getFK_ecnv() {
		return FK_ecnv;
	}

	public void setFK_ecnv(int FK_ecnv) {
		FK_ecnv = FK_ecnv;
	}

	public LinkedList<Envio> getListaenvios() {
		return listaenvios;
	}

	public void setListaenvios(LinkedList<Envio> listaenvios) {
		this.listaenvios = listaenvios;
	}

	@Override
	public String toString() {
		return " \n Envio [Descripcion:" + descripcion + ", Estado actual:" + estado + ", Número de envío:" +  ", Origen:" + origen + ", Destino:" + destino +  "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
