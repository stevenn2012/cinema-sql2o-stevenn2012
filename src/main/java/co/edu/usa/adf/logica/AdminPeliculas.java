package co.edu.usa.adf.logica;

import java.util.List;

import co.edu.usa.adf.datos.Pelicula;

public class AdminPeliculas {

	public Pelicula insertarPelicula(String descripcion, int duracion, String genero, String nombre){
		try {
			Pelicula pelicula = new Pelicula(nombre, descripcion, duracion, genero);
			DAO.insertPeli(pelicula);
			return pelicula;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Pelicula> getPeliculas(){
		return DAO.getPeliculas();
	}

	public Pelicula getPelicula(int idPelicula) {
		return DAO.getPeliculaById(idPelicula);
	}
}
