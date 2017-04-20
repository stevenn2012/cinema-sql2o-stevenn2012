package co.edu.usa.adf.datos;

import java.io.Serializable;

public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idSala;
	private String nombre;
	private int capacidad;
	private int filas;
	
	public Sala() {}

	public Sala(String nombre, int capacidad, int filas) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.filas = filas;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", nombre=" + nombre + ", capacidad=" + capacidad + ", filas=" + filas + "]";
	}
}