package co.edu.usa.adf.datos;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idTicket;
	private int idFuncion;
	private boolean vendido;
	private Date horaVenta;
	private int idSala_Silla;

	public Ticket() {
	}

	public Ticket(int idFuncion, boolean vendido, int idSala_Silla) {
		super();
		this.idFuncion = idFuncion;
		this.vendido = vendido;
		this.idSala_Silla = idSala_Silla;
	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public Date getHoraVenta() {
		return horaVenta;
	}

	public void setHoraVenta(Date horaVenta) {
		this.horaVenta = horaVenta;
	}

	public int getIdSala_Silla() {
		return idSala_Silla;
	}

	public void setIdSala_Silla(int idSala_Silla) {
		this.idSala_Silla = idSala_Silla;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", idFuncion=" + idFuncion + ", vendido=" + vendido + ", horaVenta="
				+ horaVenta + ", idSala_Silla=" + idSala_Silla + "]";
	}
}