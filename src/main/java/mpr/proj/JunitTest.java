package mpr.proj;
import mpr.proj.pedigree.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTest {
@Test
	public void testPobieranieKraj() {
		Country test = DBMetody.idKraj(5);
		Country tester = new Country(10, "ANDORRA", "AN");
		assertEquals(tester.getName(), test.getName());
	}

@Test
public void testPobieranieKon_Rodzice() {
	Horse test = DBMetody.idKon(38);
	Horse tester = new Horse(38, "Maestro", null, null, null, null, null, null);
	assertEquals(tester.getName(), test.getName());
	
	assertEquals(test.getSire().getSex(), Sex.STALLION);
	assertEquals(test.getDam().getSex(), Sex.MARE);
	
}
@Test
public void testPobieranieHodowca() {
	Breeder test = DBMetody.idHodowca(2);
	Breeder tester = new Breeder(2, "Damian",null);
	assertEquals(tester.getName(), test.getName());
}

@Test
public void testPobieranieKolor() {
	Color test = DBMetody.idKolor(4);
	Color tester = new Color(4, "chestnut", "chest.");
	assertEquals(tester.getLname(), test.getLname());
	assertEquals(tester.getSname(), test.getSname());
}





}
