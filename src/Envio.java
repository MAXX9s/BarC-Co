
public class Envio {
	
	private String descripcion;
	private String estado;
	private int numero_envio;
	private String origen;
	private String destino;
	
	public Envio(String descripcion, String estado, int numero_envio, String origen, String destino) {
		super();
		this.descripcion = descripcion;
		this.estado = estado;
		this.numero_envio = numero_envio;
		this.origen = origen;
		this.destino = destino;
	}
	
	public Envio () {}

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
	
	
	
	
	
	
	
	
	
	

}
