package co.edu.usa.adf.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import co.edu.usa.adf.datos.Funcion;
import co.edu.usa.adf.datos.Pelicula;
import co.edu.usa.adf.datos.Sala;
import co.edu.usa.adf.datos.SalaSilla;
import co.edu.usa.adf.datos.Silla;
import co.edu.usa.adf.datos.Ticket;

public class cinema {

	private String nombre;
	private AdminPeliculas adminPeliculas;
	private AdminFunciones adminFunciones;
	private AdminSalas adminSalas;
	private AdminSillas adminSillas;
	private AdminTickets adminTickets;
	
	public cinema(String nombre) {
		this.nombre = nombre;
		this.adminPeliculas = new AdminPeliculas();
		this.adminFunciones = new AdminFunciones();
		this.adminSalas = new AdminSalas();
		this.adminSillas = new AdminSillas();
		this.adminTickets = new AdminTickets();
	}
	
	public void init(){
		try {
			int option=0;
			do {
				System.out.printf("Bienvenido a %s --------------->\n",nombre);
				System.out.println("Opciones: \n 1. Registrar Sala. \n 2. Registrar Pelicula. \n 3. Crear Funcion. \n 4. Vender Tickets");
				System.out.println("\tVer: \n\t 5. Ver salas \n\t 6. Ver Peliculas \n\t 7. Ver Funciones \n\t 8. Ver Tickets \n 9. Salir");
				option = Leer.integer();
				switch (option) {
					case 1:registrarSala();break;
					case 2:registrarPelicula();break;
					case 3:crearFuncion();break;
					case 4:venderTickets();break;
					case 5:verSalas();break;
					case 6:verPeliculas();break;
					case 7:verFunciones();break;
					case 8:verTickets();break;
					case 9:System.out.println("::::::::::::::::::::::::::::::::::::::::::::");break;
					default: System.err.println("Opcion no implementada\n"); break;
				}
			} while (option != 9);
		} catch (Exception e) {
			init();
		}
	}
	
	private void verTickets() {
		System.out.println("Tickets::::::::::::::::::::::::::::::::::::::");
		List<Ticket> tickets = adminTickets.getTickets();
		for (int i = 0; i < tickets.size(); i++) {
			Ticket ticket = tickets.get(i);
			Funcion funcion = adminFunciones.getFuncion(ticket.getIdFuncion());
			Pelicula pelicula = adminPeliculas.getPelicula(funcion.getIdPelicula());
			SalaSilla salaSilla = adminSillas.getSalaSilla(ticket.getIdSala_Silla());
			Silla silla = adminSillas.getSilla(salaSilla.getIdSilla());
			Sala sala = adminSalas.getSala(funcion.getIdFuncion());
			System.out.println("\t Ticket id: "+ticket.getIdTicket()+" Pelicula: "+pelicula.getNombre()+" Hora Inicio: "+
			funcion.getHoraInicio().toString()+" Sala: "+sala.getNombre()+" Silla: "+silla.getFila()+silla.getColumna());
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
	}

	private void verFunciones() {
		try {
			System.out.println("Funciones::::::::::::::::::::::::::::::::::::");
			List<Funcion> funciones = adminFunciones.getFunciones();
			for (int i = 0; i < funciones.size(); i++) {
				Funcion funcion = funciones.get(i);
				Pelicula pelicula = adminPeliculas.getPelicula(funcion.getIdPelicula());
				Sala sala = adminSalas.getSala(funcion.getIdFuncion());
				System.out.println("\t Funcion id: "+funcion.getIdFuncion()+", Pelicula: "+pelicula.getNombre()+", Hora Inicio: "+funcion.getHoraInicio()+
						", Sala: "+sala.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
	}

	private void verPeliculas() {
		System.out.println("Peliculas::::::::::::::::::::::::::::::::::::");
		List<Pelicula> peliculas = adminPeliculas.getPeliculas();
		for (int i = 0; i < peliculas.size(); i++) {
			Pelicula pelicula = peliculas.get(i);
			System.out.println("\t Nombre: "+pelicula.getNombre()+" Genero: "+pelicula.getGenero()+" Descripcion: "+pelicula.getDescripcion()+" Durcion: "+pelicula.getDuracion());
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
	}

	private void verSalas() {
		System.out.println("Salas::::::::::::::::::::::::::::::::::::::::");
		List<Sala> salas = adminSalas.getSalas();
		for (int i = 0; i < salas.size(); i++) {
			Sala sala = salas.get(i);
			System.out.println("\t Nombre: "+sala.getNombre()+" Capacidad: "+sala.getCapacidad()+" Filas: "+sala.getFilas());
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
	}

	public void registrarSala(){
		titulo("Registrar Sala");
		System.out.println("Nota: Oprima enter para salir");
		try {
			System.out.println("Ingrese nombre: ");
			String nombre = Leer.string();
			if(!nombre.isEmpty()){
				System.out.println("Ingrese Capacidad: ");
				int capacidad = Leer.integer();
				System.out.println("Ingrese cantidad de filas: ");
				int filas = Leer.integer();
				
				Sala sala = adminSalas.insertarSala(capacidad, nombre, filas);
				System.out.println("Se registró: "+sala);
				System.out.println("Creando sillas...");
				adminSillas.crearSillas(capacidad, filas, sala.getIdSala());
				System.out.println("Se asignaron "+capacidad+" sillas a la sala");
			}
		} catch (Exception e) {}
	}
	
	private void registrarPelicula() {
		titulo("Registrar Pelicula");
		System.out.println("Nota: Oprima enter para salir");
		try {
			System.out.println("Ingrese nombre: ");
			String nombre = Leer.string();
			if(!nombre.isEmpty()){
				System.out.println("Ingrese Genero: ");
				String genero = Leer.string();
				if(!genero.isEmpty()){
					System.out.println("Ingrese Descripcion: ");
					String descripcion = Leer.string();
					if(!descripcion.isEmpty()){
						System.out.println("Ingrese duracion (minutos):");
						int duracion = Leer.integer();
						System.out.println("Se registró: "+adminPeliculas.insertarPelicula(descripcion, duracion, genero, nombre));
					}
				}
			}
		} catch (Exception e) {}
	}
	
	private void crearFuncion() {
		titulo("Crear Funcion");
		System.out.println("Nota: Oprima enter para salir");
		try {
			System.out.println("Seleccione la pelicula: ");
			List<Pelicula> peliculas = adminPeliculas.getPeliculas();
			for (int i = 0; i < peliculas.size(); i++) {
				Pelicula pelicula = peliculas.get(i);
				System.out.println("\t"+(i+1)+". nombre: "+pelicula.getNombre()+" genero: "+pelicula.getGenero()+" duracion: "+pelicula.getDuracion());
			}
			int idPelicula = peliculas.get(Leer.integer()-1).getIdPelicula();
			
			System.out.println("Seleccione la sala: ");
			List<Sala> salas = adminSalas.getSalas();
			for (int i = 0; i < salas.size(); i++) {
				Sala sala = salas.get(i);
				System.out.println("\t"+(i+1)+". Nombre: "+sala.getNombre()+" capacidad: "+sala.getCapacidad()+" Filas: "+sala.getFilas());
			}
			int idSala = salas.get(Leer.integer()-1).getIdSala();
			System.out.println("Ingrese fecha y hora de inicio (Formato: yyyy-MM-dd-hh-mm):");
			Date horaInicio = Leer.date();
			
			Funcion funcion = adminFunciones.insertarFuncion(horaInicio, idPelicula, idSala);
			System.out.println("Se registró: "+funcion);
			
			System.out.println("Creando tickets...");
			adminTickets.crearTickets(funcion.getIdFuncion(), idSala);
			System.out.println("Se crearon los tickets para esta funcion");
		} catch (Exception e) {}
	}
	
	private void venderTickets() {
		titulo("Vender ticket");
		System.out.println("Nota: Oprima enter para salir");
		try {
			System.out.println("Selecione el numero de la funcion: ");
			List<Funcion> funciones = adminFunciones.getFunciones();
			for (int i = 0; i < funciones.size(); i++) {
				Funcion func = funciones.get(i);
				Pelicula pelicula = DAO.getPelicula(func);
				Sala sala = DAO.getSala(func);
				System.out.println("\t"+(i+1)+". Pelicula: "+pelicula.getNombre()+" Dia y Hora: "+func.getHoraInicio()+" Sala: "+sala.getNombre());
			}
			Funcion funcion = funciones.get(Leer.integer()-1);
			int idFuncion = funcion.getIdFuncion();
			
			System.out.println("Ingrese nombre de la silla: ");
			ArrayList<SalaSilla> sillas = adminSillas.getSillasDisponibles(idFuncion);
			Sala sala = adminSalas.getSala(idFuncion);
			
			int capacidadFila = sala.getCapacidad()/sala.getFilas();
			
			List<Silla> sillasreales = adminSillas.getSillasSala(sala.getIdSala());
			
			Collections.sort(sillasreales, new Comparator<Silla>() {
		        @Override
		        public int compare(Silla silla2, Silla silla1){
		        	return (silla2.getFila()+(char)silla2.getColumna()).compareTo((silla1.getFila()+(char)silla1.getColumna()));
		        }
			});
			
			for (int i = 0; i < sillasreales.size(); i++) {
				Silla silla = sillasreales.get(i);
				
				String mostrar = "";
				for (int j = 0; j < sillas.size(); j++) {
					if(silla.getIdSilla() == sillas.get(j).getIdSilla()){
						mostrar = silla.getFila()+silla.getColumna();
					}
				}
				if(mostrar.equals("")){
					mostrar = "X";
				}
				System.out.print(mostrar);
				
				if(((i+1) %capacidadFila) == 0){
					System.out.println();
				}else{
					System.out.print(",\t");
				}
			}
			int idSilla = adminSillas.getSillaByName(Leer.string());
			SalaSilla ss = new SalaSilla();
			for (int i = 0; i < sillas.size(); i++) {
				if(idSilla == sillas.get(i).getIdSilla()){
					ss = sillas.get(i);
				}
			}
			System.out.println("Se vendió: "+adminTickets.venderTicket(idFuncion, ss.getIdSala_Silla()));
		} catch (Exception e) {}
	}
	
	private void titulo(String mensaje){
		System.out.println("\n"+mensaje+" ----------------->");
	}
}
