package co.edu.usa.adf.logica;

import java.util.ArrayList;
import java.util.List;
import co.edu.usa.adf.datos.SalaSilla;
import co.edu.usa.adf.datos.Silla;

public class AdminSillas {

	public void crearSillas(int capacidad, int filas, int idSala){
		List<Silla> sillas = DAO.getSillas();
		
		int capacidadFila = capacidad/filas;
    	int columna = 0, fila = 65;
    	
    	for (int i = 0; i < capacidad; i++) {	
			Silla silla = new Silla();
			boolean val = true;
			for (int j = 0; j < sillas.size(); j++) {
				if(sillas.get(j).getColumna() == (columna+1) && sillas.get(j).getFila().equalsIgnoreCase((char)fila+"")){
					val = false;
					silla = sillas.get(j);
				}
			}
			if(val)	silla = insertarSilla((char)fila+"", columna+1);	
			insertarSalaSilla(idSala, silla.getIdSilla());
			columna++;
    		if(((i+1) %capacidadFila) == 0){
				columna=0; fila++;
				if(fila>90)	fila = 65;
			}
		}
	}
	
	public void insertarSalaSilla(int idSala, int idSilla){
		SalaSilla salaSilla = new SalaSilla(idSala, idSilla);
		DAO.insertSala_silla(salaSilla);
	}

	public Silla insertarSilla(String fila, int columna){
		System.out.println("\t Se creo la silla: "+fila+columna);
		Silla silla = new Silla(fila, columna);
		silla.setIdSilla(DAO.getSillas().size()+1);
		DAO.insertSilla(silla);
		return silla;
	}
	
	public ArrayList<SalaSilla> getSillasDisponibles(int idFuncion){
		return DAO.getSillasDisponibles(idFuncion);
	}

	public int getSillaByName(String name) {
		return DAO.getIdSillaByName(name);
	}
	
	public List<Silla> getSillasSala(int idSala) {
		return DAO.getSillasSala(idSala);
	}

	public Silla getSilla(int idSilla) {
		return DAO.getSilla(idSilla);
	}

	public SalaSilla getSalaSilla(int idSala_Silla) {
		return DAO.getSalaSillaById(idSala_Silla);
	}
}
