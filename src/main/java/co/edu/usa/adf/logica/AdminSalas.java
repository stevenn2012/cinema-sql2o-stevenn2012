package co.edu.usa.adf.logica;

import java.util.List;

import co.edu.usa.adf.datos.Sala;

public class AdminSalas {

	public Sala insertarSala(int capacidad, String nombre, int filas){
		try {
			Sala sala = new Sala(nombre, capacidad, filas);
			sala.setIdSala(DAO.getSalas().size()+1);
			DAO.insertSala(sala);
			return sala;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Sala> getSalas(){
		return DAO.getSalas();
	}

	public Sala getSala(int idFuncion) {
		return DAO.getSalaByFuncion(idFuncion);
	}
}
