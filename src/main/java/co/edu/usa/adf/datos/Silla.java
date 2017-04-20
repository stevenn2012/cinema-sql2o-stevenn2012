package co.edu.usa.adf.datos;

import java.io.Serializable;

public class Silla implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idSilla;
	private String fila;
	private int columna;
	
	public Silla() {}

	public Silla(String fila, int columna) {
		super();
		this.fila = fila;
		this.columna = columna;
	}

	public int getIdSilla() {
		return idSilla;
	}

	public void setIdSilla(int idSilla) {
		this.idSilla = idSilla;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public Silla(int idSilla, String fila, int columna) {
		super();
		this.idSilla = idSilla;
		this.fila = fila;
		this.columna = columna;
	}

	@Override
	public String toString() {
		return "Silla [idSilla=" + idSilla + ", fila=" + fila + ", columna=" + columna + "]";
	}
}