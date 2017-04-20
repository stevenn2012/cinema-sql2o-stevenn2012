package co.edu.usa.adf.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import co.edu.usa.adf.datos.SalaSilla;
import co.edu.usa.adf.datos.Ticket;

public class AdminTickets {

	public Ticket venderTicket(int idFuncion, int idSilla){
		try {
			List<Ticket> tickets = DAO.getTickets();
			Ticket ticket = null;
			for (int i = 0; i < tickets.size(); i++) {
				Ticket tick = tickets.get(i);
				if(tick.getIdFuncion() == idFuncion && tick.getIdSala_Silla()==idSilla){
					ticket = tick;
				}
			}
			ticket.setVendido(true);
			ticket.setHoraVenta(new Date());
			DAO.UpdateTicket(ticket);
			return ticket;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void crearTickets(int idFuncion, int idSala){
		List<SalaSilla> totalSillas = DAO.getSalaSillas();
		List<SalaSilla> sillas = new ArrayList<SalaSilla>();
		for (int i = 0; i < totalSillas.size(); i++) {
			if(totalSillas.get(i).getIdSala() == idSala){
				sillas.add(totalSillas.get(i));
			}
		}
		for (int i = 0; i < sillas.size(); i++) {
			DAO.insertTicket(new Ticket(idFuncion,false, sillas.get(i).getIdSala_Silla()));
		}
	}

	public List<Ticket> getTickets() {
		return DAO.getTickets();
	}
}
