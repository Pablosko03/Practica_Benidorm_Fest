package modelo;

public class Cantante {

	private String dni;
	private String nombre;
	private String imagen;
	private int votos;
	
	public Cantante() {
		super();
	}

	
	public Cantante(String dni, String nombre, String imagen, int votos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.imagen = imagen;
		this.votos = votos;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Cantante [dni=" + dni + ", nombre=" + nombre + ", imagen=" + imagen + ", votos=" + votos + "]";
	}
	
	
}
