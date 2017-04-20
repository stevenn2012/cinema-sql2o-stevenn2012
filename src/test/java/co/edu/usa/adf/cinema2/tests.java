package co.edu.usa.adf.cinema2;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import co.edu.usa.adf.datos.*;
import co.edu.usa.adf.logica.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class tests {
	
	public Sql2o sql2; 
	public Funcion f;
	public Silla s;
	public Ticket tk;
	public Sala sa;
	public SalaSilla ss;
	
	@Before
	public void init(){
		sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		
		f=new Funcion();
		f.setHoraInicio(new Date());
		f.setIdPelicula(1);
		f.setIdSala(1);
		
		s=new Silla();
		s.setColumna(3);
		s.setFila("k");
		
		tk=new Ticket();
		tk.setIdSala_Silla(1);
		tk.setIdFuncion(1);
		tk.setHoraVenta(new Date());
		tk.setVendido(false);
		
		sa=new Sala();
		sa.setCapacidad(90);
		sa.setFilas(14);
		sa.setNombre("salaTest");
		
		ss=new SalaSilla();
	}

	@Test
	public void testSelectConnection() {
		String sql="select * from pelicula";
		List<Pelicula> tasks=null;
		try (Connection con=sql2.open()){
			tasks = con.createQuery(sql)
			        .executeAndFetch(Pelicula.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertFalse(tasks.isEmpty());
	}
	
	@Test
	public void insertDeletePelisDao(){
		List<Pelicula>initPelis=DAO.getPeliculas();
		assertNotNull(initPelis.isEmpty());
		int lastId=initPelis.get(initPelis.size()-1).getIdPelicula();
		int initialPelis=DAO.getPeliculas().size();
		for (int i = 0; i < 40; i++) {
			Pelicula p=new Pelicula();
			p.setNombre(getSaltString());
			p.setDescripcion(getSaltString());
			p.setGenero("etx");
			p.setDuracion(90);
			DAO.insertPeli(p);
		}
		List<Pelicula>lastPelis=DAO.getPeliculas();
		assertNotNull(lastPelis);
		assertTrue(lastPelis.size()>initialPelis);
		String query="delete from pelicula where idPelicula > :id";
		try(Connection con=sql2.beginTransaction()){
			con.createQuery(query).addParameter("id", initPelis.get(initPelis.size()-1).getIdPelicula())
			.executeUpdate();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		assertEquals(initialPelis, DAO.getPeliculas().size());
		
	}
	
	@Test
	public void testDaoTicket(){
		DAO.insertTicket(tk);
		List<Ticket>tiq=DAO.getTickets();
		assertNotNull(tiq);
		assertEquals(tk.getIdFuncion(),tiq.get(tiq.size()-1).getIdFuncion());
		assertEquals(tk.getIdSala_Silla(),tiq.get(tiq.size()-1).getIdSala_Silla());
		String query ="delete from ticket where idTicket = :id";
		try(Connection con=sql2.beginTransaction()){
			con.createQuery(query).addParameter("id",tiq.get(tiq.size()-1).getIdTicket())
			.executeUpdate();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testsillaDao(){

		DAO.insertSilla(s);
		List<Silla>sillas=DAO.getSillas();
		assertFalse(sillas.isEmpty());
		assertTrue(s.getColumna()==sillas.get(sillas.size()-1).getColumna());
		assertTrue(s.getFila().equals(sillas.get(sillas.size()-1).getFila()));
		String query="delete from silla where idSilla = :id";
		try(Connection con=sql2.beginTransaction()){
			con.createQuery(query).addParameter("id", sillas.get(sillas.size()-1).getIdSilla())
			   .executeUpdate();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void funcionDao(){
		DAO.insertFuncion(f);
		List<Funcion>funciones=DAO.getFunciones();
		assertFalse(funciones.isEmpty());
		assertTrue(f.getIdSala()==funciones.get(funciones.size()-1).getIdSala());
		assertTrue(f.getIdPelicula()==funciones.get(funciones.size()-1).getIdPelicula());
		String query="delete from funcion where idFuncion = :id";
		try(Connection con=sql2.beginTransaction()){
			con.createQuery(query).addParameter("id", funciones.get(funciones.size()-1).getIdFuncion())
			   .executeUpdate();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void SalaDao(){
		DAO.insertSala(sa);
		List<Sala>salas=DAO.getSalas();
		assertFalse(salas.isEmpty());
		assertTrue(sa.getNombre().equals(salas.get(salas.size()-1).getNombre()));
		String query="delete from sala where nombre = :nombreSala";
		try(Connection con=sql2.beginTransaction()){
			con.createQuery(query).addParameter("nombreSala", sa.getNombre())
			   .executeUpdate();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}

