package co.edu.usa.adf.cinema2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;
import org.sql2o.Sql2o;
import co.edu.usa.adf.datos.Funcion;
import co.edu.usa.adf.datos.Pelicula;
import co.edu.usa.adf.datos.Sala;
import co.edu.usa.adf.datos.SalaSilla;
import co.edu.usa.adf.datos.Silla;
import co.edu.usa.adf.datos.Ticket;
import co.edu.usa.adf.logica.AdminFunciones;
import co.edu.usa.adf.logica.AdminPeliculas;
import co.edu.usa.adf.logica.AdminSalas;
import co.edu.usa.adf.logica.AdminSillas;
import co.edu.usa.adf.logica.AdminTickets;
import co.edu.usa.adf.logica.DAO;

public class TestMock {
	
	public Sql2o sql2; 
	public Funcion f;
	public Silla s;
	public Ticket tk;
	public Sala sa;
	public SalaSilla ss;
	public Pelicula p;
	
	@Before
	public void init(){
		sql2 =new Sql2o("jdbc:mysql://localhost:3306/cinema2","root","rivera");
		
		p=new Pelicula();
		p.setDescripcion("etc");
		p.setDuracion(90);
		p.setGenero("asd");
		p.setIdPelicula(0);
		p.setNombre("bla");
		
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
	public void TestAdminFunciones(){
		AdminFunciones adminfuncionesMock=mock(AdminFunciones.class);
		List<Funcion>ff=new ArrayList<>();
		ff.add(f);
		when(adminfuncionesMock.getFunciones()).thenReturn(ff);
		assertNotNull(adminfuncionesMock.getFunciones());
		when(adminfuncionesMock.getFuncion(0)).thenReturn(f);
		assertEquals(f,adminfuncionesMock.getFuncion(0));
	}
	
	@Test
	public void testAdminPeliculas(){
		AdminPeliculas adminpeliMock=mock(AdminPeliculas.class);
		List<Pelicula>pp=new ArrayList<>();
		pp.add(p);
		when(adminpeliMock.getPeliculas()).thenReturn(pp);
		assertNotNull(adminpeliMock.getPeliculas());
		when(adminpeliMock.getPelicula(0)).thenReturn(p);
		assertEquals(p, adminpeliMock.getPelicula(0));
		when(adminpeliMock.insertarPelicula("", 0, "", "")).thenReturn(null);
		assertNotEquals(p, adminpeliMock.insertarPelicula("a",0, "", ""));
		pp=DAO.getPeliculas();
		when(adminpeliMock.getPeliculas()).thenReturn(pp);
		assertEquals(pp, adminpeliMock.getPeliculas());
	}
	
	@Test
	public void testAdminSalas(){
		AdminSalas adminsalaMock=mock(AdminSalas.class);
		List<Sala>sl=new ArrayList<>();
		sl.clear();
		when(adminsalaMock.getSalas()).thenReturn(sl);
		assertTrue(adminsalaMock.getSalas().isEmpty());
		sl.add(sa);
		assertNotNull(adminsalaMock.getSalas());
		when(adminsalaMock.getSala(0)).thenReturn(sa);
		assertEquals(sa, adminsalaMock.getSala(0));
		when(adminsalaMock.insertarSala(0, "", 0)).thenReturn(null);
		assertNotEquals(sa, adminsalaMock.insertarSala(0, "", 0));	
	}
	
	@Test
	public void testAdminSillas(){
		AdminSillas adminsillasMock=mock(AdminSillas.class);
		List<Silla>sillas=new ArrayList<>();
		when(adminsillasMock.getSillasSala(0)).thenReturn(sillas);
		assertTrue(adminsillasMock.getSillasSala(0).isEmpty());
		when(adminsillasMock.getSillasDisponibles(0)).thenReturn(new ArrayList<SalaSilla>());
		assertTrue(adminsillasMock.getSillasDisponibles(0).isEmpty());
	}

	@Test
	public void testAdminTickets(){
		AdminTickets adminticketsMock=mock(AdminTickets.class);
		List<Ticket>tks=new ArrayList<>();
		when(adminticketsMock.getTickets()).thenReturn(tks);
		assertTrue(adminticketsMock.getTickets().isEmpty());
		tks.add(tk);
		assertFalse(adminticketsMock.getTickets().isEmpty());
		when(adminticketsMock.venderTicket(0, 0)).thenReturn(null);
		assertNotEquals(tk, adminticketsMock.venderTicket(0, 0));		
	}
}
