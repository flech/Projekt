package mpr.proj;
import java.sql.*;
import java.util.*;

import mpr.proj.pedigree.*;


public abstract class Kolekcje {
	static	Connection con;
	static String query;
	public static void getConnection(Connection connect){
		con = connect;
	}
	public static  void wyswietlKraje() {
	
		try {
		//	con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
				List<Country> lista = new ArrayList<Country>();
		query = "SELECT * FROM COUNTRY";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				lista.add(new Country (rs.getLong(1), rs.getString(2), rs.getString(3)));
			}
			for (Country a: lista){
		System.out.println(a);	}
		} catch (SQLException e) {
			e.printStackTrace();
		};		
	}
	
	public static void wyswietlKolory() {

		try {
			//con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			
				List<Color> lista = new ArrayList<Color>();
		query = "SELECT * FROM COLOR";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				lista.add(new Color (rs.getLong(1), rs.getString(2), rs.getString(3)));
			}
			for (Color a: lista){
		System.out.println(a);	}
		} catch (SQLException e) {
			e.printStackTrace();
		};		
		
	}
	
	public static void wyswietlKonie() {

		try {
			//con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			
				List<Horse> lista = new ArrayList<Horse>();
		query = "SELECT * FROM HORSE";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				lista.add(new Horse(rs.getLong(1), rs.getString(2),DBMetody.IDsex(rs.getInt(3)),new DateOfBirth(rs.getDate("DOB"), rs.getBoolean("YEARONLY")),DBMetody.idKolor(rs.getLong(6)), DBMetody.idKon(rs.getInt(7)), DBMetody.idKon(rs.getInt(8)), DBMetody.idHodowca(rs.getLong(9))));
			}
			for (Horse a: lista){
		System.out.println(a);	}
		} catch (SQLException e) {
			e.printStackTrace();
		};		
		
	}

	public static void wyswietlHodowcow()
	{
		try {
			List<Breeder> lista = new ArrayList<Breeder>();
		//	con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			query = "Select * from BREEDER";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()){
				lista.add(new Breeder(rs.getLong(1), rs.getString(2), DBMetody.idKraj(rs.getInt(3))));
				
				for (Breeder a : lista){
					System.out.println(a);
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void wyswietlPlec()
	{
	
		try {
			
			Map<Long, String> lista = new HashMap<Long, String>();
			//con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			query = "SELECT * FROM SEX";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()){
				lista.put (rs.getLong(1), rs.getString(2));
				System.out.println("ID: " + rs.getLong(1) + " Plec: " + rs.getString(2));
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void znajdzPotomstwo(){
		
		try {
			//con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			List<String> lista = new ArrayList<String>();
					System.out.println("Podaj ID Konia, ktorego potomstwo chcesz znalesc:");
			int id = EasyIn.getInt();
	query = "SELECT * FROM HORSE WHERE HORSE.SIRE=" + id + "OR HORSE.DAM=" + id;
	Statement statement = con.createStatement();
	ResultSet rs = statement.executeQuery(query);
		
	while(rs.next()){
		lista.add(rs.getString(2));
	}
	
	for (String a: lista){
		System.out.println(a);
	}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

		
	
		public static void rodowodo(Horse horse,int glebokosc){
			if(glebokosc > 0){
				if(horse.getSire() != null){
					int iterator = glebokosc;
						System.out.println("Ojciec konia "+horse.getName() + " ---> " + horse.getSire().getName());
						rodowodo(horse.getSire(), iterator -=1);
				}else System.out.println ("Brak ojca w bazie danych.");
				
				if(horse.getDam() != null){
						System.out.println("Matka konia "+horse.getName() + " ---> " + horse.getDam().getName());
						rodowodo(horse.getDam(), glebokosc -=1);
				}else System.out.println ("Brak ojca w bazie danych.");
			}
			
			
			
		}
	
	
	
	
}


			

		

	
	

	
	

