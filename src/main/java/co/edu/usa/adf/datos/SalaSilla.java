package co.edu.usa.adf.datos;

import java.io.Serializable;

public class SalaSilla implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idSala_Silla;
	private int idSala;
	private int idSilla;
	
	public SalaSilla() {}

	public SalaSilla(int idSala, int idSilla) {
		super();
		this.idSala = idSala;
		this.idSilla = idSilla;
	}

	public int getIdSala_Silla() {
		return idSala_Silla;
	}

	public void setIdSala_Silla(int idSala_Silla) {
		this.idSala_Silla = idSala_Silla;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public int getIdSilla() {
		return idSilla;
	}

	public void setIdSilla(int idSilla) {
		this.idSilla = idSilla;
	}

	@Override
	public String toString() {
		return "SalaSilla [idSala_Silla=" + idSala_Silla + ", idSala=" + idSala + ", idSilla=" + idSilla + "]";
	}
}