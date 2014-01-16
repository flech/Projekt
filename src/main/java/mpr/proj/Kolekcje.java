package mpr.proj;
import java.sql.*;
import java.util.*;

import mpr.proj.pedigree.*;


public abstract class Kolekcje {
	static	Connection con;
	static String query;
	public static  void wyswietlKraje() {
	
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			
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
	public static void znajdzPotomstwo(){
		
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
	
}
