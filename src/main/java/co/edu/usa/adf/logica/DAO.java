package co.edu.usa.adf.logica;

import java.util.ArrayList;
import java.util.List;
import org.sql2o.Connection;
import co.edu.usa.adf.datos.Funcion;
import co.edu.usa.adf.datos.Pelicula;
import co.edu.usa.adf.datos.Sala;
import co.edu.usa.adf.datos.SalaSilla;
import co.edu.usa.adf.datos.Silla;
import co.edu.usa.adf.datos.Ticket;
import org.sql2o.Sql2o;

public class DAO {

	public static List<Pelicula> getPeliculas(){
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from pelicula";
		List<Pelicula> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
			        .executeAndFetch(Pelicula.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return tasks;	
	}
	
	public static boolean insertPeli(Pelicula p){
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String insert="insert into pelicula(nombre, descripcion, duracion, genero) values(:nombre,:descripcion,:duracion,:genero)";
		
		System.out.println("------------>");
		try (Connection con=sql2.beginTransaction()){
			con.createQuery(insert).addParameter("nombre", p.getNombre())
								   .addParameter("descripcion", p.getDescripcion())
								   .addParameter("duracion", p.getDuracion())
								   .addParameter("genero", p.getGenero())
								   .executeUpdate();
			con.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static List<Silla> getSillas(){
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from silla";
		List<Silla> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
			        .executeAndFetch(Silla.class);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;	
	}
	
	public static boolean insertSilla(Silla s){
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String insert="insert into Silla(idSilla, fila, columna) values(:idSilla, :fila,:columna)";
		try (Connection con=sql2.beginTransaction()){
			con.createQuery(insert).addParameter("idSilla", s.getIdSilla())
			                       .addParameter("fila", s.getFila())
			                       .addParameter("columna", s.getColumna())								 
								   .executeUpdate();
			con.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;	
	}	
	
	public static List<Sala> getSalas(){
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from sala";
		List<Sala> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
			        .executeAndFetch(Sala.class);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;	
	}
	
	public static boolean insertSala(Sala s){
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String insert="insert into Sala(idSala, nombre, capacidad, filas) values(:idSala, :nombre,:capacidad,:filas)";
		try (Connection con=sql2.beginTransaction()){
			con.createQuery(insert).addParameter("idSala", s.getIdSala())
								   .addParameter("nombre", s.getNombre())
								   .addParameter("capacidad", s.getCapacidad())
								   .addParameter("filas", s.getFilas())
								   .executeUpdate();
			con.commit();
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static List<Funcion> getFunciones(){
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from funcion";
		List<Funcion> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
			        .executeAndFetch(Funcion.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;	
	}
	
	public static boolean insertFuncion(Funcion s){
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String insert="insert into Funcion(idFuncion, idPelicula, idSala, horaInicio) values(:idFuncion,:Pelicula_idPelicula,:Sala_idSala,:HoraInicio)";
		try (Connection con=sql2.beginTransaction()){
			con.createQuery(insert).addParameter("idFuncion", s.getIdFuncion())
			                       .addParameter("Pelicula_idPelicula", s.getIdPelicula())
								   .addParameter("Sala_idSala", s.getIdSala())
								   .addParameter("HoraInicio", s.getHoraInicio())
								   .executeUpdate();
			con.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static List<Ticket> getTickets(){
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from ticket";
		List<Ticket> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
			        .executeAndFetch(Ticket.class);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return tasks;	
	}
	
	public static boolean insertSala_silla(SalaSilla ss){
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String insert="insert into sala_silla(idSala, idSilla) values(:idSala,:idSilla)";
		try (Connection con=sql2.beginTransaction()){
			con.createQuery(insert).addParameter("idSala", ss.getIdSala())
								   .addParameter("idSilla", ss.getIdSilla())
								   .executeUpdate();
			con.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;	
	}

	public static List<SalaSilla> getSalaSillas() {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from sala_silla";
		List<SalaSilla> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
			        .executeAndFetch(SalaSilla.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}

	public static void insertTicket(Ticket ticket) {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String insert="insert into ticket(idSala_Silla, idFuncion, horaVenta, Vendido) values(:idSalaSilla,:idFuncion,:horaVenta,:vendido)";
		try (Connection con=sql2.beginTransaction()){
			con.createQuery(insert).addParameter("idSalaSilla", ticket.getIdSala_Silla())
								   .addParameter("idFuncion", ticket.getIdFuncion())
								   .addParameter("horaVenta", ticket.getHoraVenta())
								   .addParameter("vendido", ticket.isVendido())
								   .executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Sala getSalaByFuncion(int idFuncion) {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from Funcion where idFuncion = :idFuncion";
		List<Funcion> tasks1=null;
		try (Connection con=sql2.open()){
			tasks1 = con.createQuery(sql)
					.addParameter("idFuncion", idFuncion)
			        .executeAndFetch(Funcion.class);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sql2o sql2o =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql1="select * from Sala where idSala = :idSala";
		List<Sala> tasks=null;
		try (Connection con=sql2o.open()){
			tasks = con.createQuery(sql1)
					.addParameter("idSala", tasks1.get(0).getIdSala())
			        .executeAndFetch(Sala.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks.get(0);
	}

	public static Pelicula getPeliculaById(int idPelicula) {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from Pelicula where idPelicula = :idPelicula";
		List<Pelicula> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
					.addParameter("idPelicula", idPelicula)
			        .executeAndFetch(Pelicula.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks.get(0);
	}

	public static SalaSilla getSalaSillaById(int idSala_Silla) {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from Sala_Silla where idSala_Silla = :idSalaSilla";
		List<SalaSilla> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
					.addParameter("idSalaSilla", idSala_Silla)
			        .executeAndFetch(SalaSilla.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks.get(0);
	}
	
	public static Pelicula getPelicula(Funcion func) {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from pelicula where idPelicula = :idPelicula";
		List<Pelicula> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
					.addParameter("idPelicula", func.getIdPelicula())
			        .executeAndFetch(Pelicula.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks.get(0);
	}

	public static Sala getSala(Funcion func) {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from Sala where idSala = :idSala";
		List<Sala> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
					.addParameter("idSala", func.getIdSala())
			        .executeAndFetch(Sala.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks.get(0);
	}

	public static Silla getSilla(int idSilla) {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from Silla where idSilla = :idSilla";
		List<Silla> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
					.addParameter("idSala", idSilla)
			        .executeAndFetch(Silla.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks.get(0);
	}

	public static Funcion getFuncionById(int idFuncion) {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from Funcion where idFuncion = :idFuncion";
		List<Funcion> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
					.addParameter("idFuncion", idFuncion)
			        .executeAndFetch(Funcion.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks.get(0);
	}
	
	public static void UpdateTicket(Ticket ticket) {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String insert="update ticket set Vendido = :vendido, horaVenta = :horaVenta where idTicket= :idTicket";
		
		try (Connection con=sql2.open()){
			con.createQuery(insert).addParameter("vendido", ticket.isVendido())
								   .addParameter("horaVenta", ticket.getHoraVenta())
								   .addParameter("idTicket", ticket.getIdTicket())
								   .executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static ArrayList<SalaSilla> getSillasDisponibles(int idFuncion){
		Funcion funcion = getFuncionById(idFuncion);
		
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from Sala_Silla where idSala =:idSala";
		List<SalaSilla> sillasTotales=null;
		try (Connection con=sql2.open()){
			sillasTotales = con.createQuery(sql)
					.addParameter("idSala", funcion.getIdSala())
			        .executeAndFetch(SalaSilla.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql1="select * from Ticket where idFuncion =:idFuncion and Vendido = :vendido";
		List<Ticket> tickets = null;
		try (Connection con=sql2.open()){
			tickets = con.createQuery(sql1)
					.addParameter("idFuncion", funcion.getIdFuncion())
					.addParameter("vendido", true)
			        .executeAndFetch(Ticket.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		ArrayList<SalaSilla> sillasDisponibles = new ArrayList<SalaSilla>();
		for (int i = 0; i < sillasTotales.size(); i++) {
			SalaSilla silla = sillasTotales.get(i);
			boolean validacion = true;
			for (int j = 0; j < tickets.size(); j++) {
				Ticket vendido = tickets.get(j);
				if(silla.getIdSala_Silla() == vendido.getIdSala_Silla()){
					validacion = false;
				}
			}
			if(validacion){
				sillasDisponibles.add(silla);
			}
		}
		return sillasDisponibles;
	}
	
	public static int getIdSillaByName(String name) {
		String fila = (name.charAt(0)+"").toUpperCase();
		String column = name.substring(1).trim(); 
		int columna = Integer.parseInt(column);
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		String sql="select * from Silla where fila = :fila and columna = :columna";
		List<Silla> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
					.addParameter("fila", fila)
					.addParameter("columna", columna)
			        .executeAndFetch(Silla.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks.get(0).getIdSilla();
	}

	public static List<Silla> getSillasSala(int idSala) {
		Sql2o sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		
		String sql="select t2.* from sala_silla t1 inner join silla t2 on t1.idSilla = t2.idSilla where idSala = :idSala";
		List<Silla> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
					.addParameter("idSala", idSala)
			        .executeAndFetch(Silla.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}
}
