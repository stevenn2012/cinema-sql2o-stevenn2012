package co.edu.usa.adf.datos;

import java.io.Serializable;
import java.util.Date;

public class Funcion implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idFuncion;
	private int idPelicula;
	private int idSala;
	private Date horaInicio;
	
	public Funcion() {}

	public Funcion(int idPelicula, int idSala, Date horaInicio) {
		super();
		this.idPelicula = idPelicula;
		this.idSala = idSala;
		this.horaInicio = horaInicio;
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Override
	public String toString() {
		return "Funcion [idFuncion=" + idFuncion + ", idPelicula=" + idPelicula + ", idSala=" + idSala + ", horaInicio="
				+ horaInicio + "]";
	}
}