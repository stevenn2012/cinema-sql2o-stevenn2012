package co.edu.usa.adf.logica;

import java.util.Date;
import java.util.List;
import co.edu.usa.adf.datos.Funcion;

public class AdminFunciones {

	public Funcion insertarFuncion(Date horaInicio, int idPelicula, int idSala){
		try {
			Funcion funcion = new Funcion(idPelicula, idSala, horaInicio);
			funcion.setIdFuncion(DAO.getFunciones().size()+1);
			DAO.insertFuncion(funcion);
			return funcion;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Funcion> getFunciones(){
		return DAO.getFunciones();
	}

	public Funcion getFuncion(int idFuncion) {
		return DAO.getFuncionById(idFuncion);
	}
}
