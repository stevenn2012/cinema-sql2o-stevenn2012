package co.edu.usa.adf.datos;

import java.io.Serializable;

public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idPelicula;
	private String nombre;
	private String descripcion;
	private int duracion;
	private String genero;

	public Pelicula() {}

	public Pelicula(String nombre, String descripcion, int duracion, String genero) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.genero = genero;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", duracion=" + duracion + ", genero=" + genero + "]";
	}
}