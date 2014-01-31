import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import mpr.proj.*;
import mpr.proj.pedigree.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JunitTest {
	private Connection con;
	
	@Before
	public void connectDB(){
		try {

			con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println("Wystapil wyjatek.");
		}
	}
	
	
@Test
	public void testPobieranieKraj() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
		DBMetody.getConnection(con);
		Country test = DBMetody.idKraj(5);
		Country tester = new Country(10, "ANDORRA", "AN");
		assertEquals(tester.getName(), test.getName());
	}


@Test
public void testPobieranieKon_Rodzice() throws SQLException {
	Connection con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
	DBMetody.getConnection(con);
	Horse test = DBMetody.idKon(38);
	Horse tester = new Horse(38, "Maestro", null, null, null, null, null, null);
	assertEquals(tester.getName(), test.getName());
	
	assertEquals(test.getSire().getSex(), Sex.STALLION);
	assertEquals(test.getDam().getSex(), Sex.MARE);
	
}
@Test
public void testPobieranieHodowca() throws SQLException {
	Connection con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
	DBMetody.getConnection(con);
	Breeder test = DBMetody.idHodowca(2);
	Breeder tester = new Breeder(2, "Damian",null);
	assertEquals(tester.getName(), test.getName());
}

@Test
public void testPobieranieKolor() throws SQLException {
	Connection con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
	DBMetody.getConnection(con);
	Color test = DBMetody.idKolor(4);
	Color tester = new Color(4, "chestnut", "chest.");
	assertEquals(tester.getLname(), test.getLname());
	assertEquals(tester.getSname(), test.getSname());
}





}
