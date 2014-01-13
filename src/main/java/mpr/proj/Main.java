package mpr.proj;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Connection con = null;
    	
    	try {
			Class.forName("org.hsqldb.jdbcDriver");
			con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			if(!con.isClosed())	{
				System.out.println("Nawiazano polaczenie z baza danych.");
			}
    	}
    	catch (Exception ex) {
    		System.out.println(ex.getMessage());
    		System.out.println("Wystapil wyjatek.");
    		
    	}
    	System.out.println("Witaj w bazie danych konii.");
    	System.out.println("Wpisz 1 aby dodać rekord.");
    	System.out.println("Wpisz 2 aby odczytac dane z tabeli.");
    	System.out.println("Wpisz 3 aby uaktualnic rekord.");
    	System.out.println("Wpisz 4 aby usunac program.");
      	System.out.println("Wpisz 5 aby Wyjsc.");
      
    		 int opcja = EasyIn.getInt();
    	        String opcjaString; 
    	        String opcja1String;
    	        String query;
    	        PreparedStatement statement;
    
    	  //     PreparedStatement statement;
    	        switch (opcja) {
    	            case 1:  opcjaString = "Create";{
    	              	System.out.println("Wpisz 1 aby dodać rekord do tabeli Horse.");
    	              	System.out.println("Wpisz 2 aby dodać rekord do tabeli Breeder.");
    	              	System.out.println("Wpisz 3 aby dodać rekord do tabeli Country.");
    	              	System.out.println("Wpisz 4 aby dodać rekord do tabeli Color.");
    	              	System.out.println("Wpisz 5 aby dodać rekord do tabeli Sex.");
    	              	 int opcja1 = EasyIn.getInt();
    	              	
    	              	 switch(opcja1) {
    	              	 case 1: opcja1String = "Horse";{
    	              		 System.out.println(opcja1String);
    	              		 	   
    	              	
							try {     
    	              		 query = "INSERT INTO HORSE (NAME, SEX, COLOR, DOB, YEARONLY, DAM, SIRE, BREEDER) VALUES (?,?,?,?,?,?,?,?)";
							statement = con.prepareStatement(query);
							
    		    			System.out.print("Podaj imie: ");
    		    			String godnosc = EasyIn.getString();
    		    			System.out.print("Podaj id gatunku: ");
    		    			int plec = EasyIn.getInt();
    		    			System.out.print("Podaj id koloru: ");
    		    			int kolor = EasyIn.getInt();
    		    			System.out.print("Podaj date urodzenia (YYYY-MM-DD): ");
    		    			String data = EasyIn.getString();
    		    			System.out.print("Podaj czy tylko rok: ");
    		    			int rok = EasyIn.getInt();
    		    			System.out.print("Podaj id matki: ");
    		    			int matka = EasyIn.getInt();
    		    			System.out.print("Podaj id ojca: ");
    		    			int ojciec = EasyIn.getInt();
    		    			System.out.print("Podaj id wlasciciela: ");
    		    			int wlasciciel = EasyIn.getInt();
    		    			statement.setString(1, godnosc);
    		    			statement.setInt(2, plec);
    		    			statement.setInt(3, kolor);
    		    			statement.setString(4, data);
    		    			statement.setInt(5, rok);
    		    			statement.setInt(6, matka);
    		    			statement.setInt(7, ojciec);
    		    			statement.setInt(8, wlasciciel);
    		    			if(statement.executeUpdate()>=1)	{
    		    				System.out.println("Dodano wpis "+godnosc+", "+plec+", "+kolor+", "+data+", "+rok+", "+matka+", "+ojciec+", "+wlasciciel+" do tabeli Breeder.");
    		    			} 
    		    			else	{
    		    				System.out.println("Nie dodano nowego wpisu");
    		    			}    	              		 

    	              		 
    	              		 } 		catch (SQLException e) {
     	                        e.printStackTrace();
		
							}break;

    	              	 }
    	              	case 2: opcja1String = "Breeder";{
    	              		try{
    	              		 query = "INSERT INTO Breeder (NAME, COUNTRY) VALUES (?,?)";
 							statement = con.prepareStatement(query);
 							System.out.print("Podaj imie hodowcy: ");
 							String name = EasyIn.getString();
    		    			System.out.print("Podaj id kraju: ");
    		    			int id = EasyIn.getInt();
    		    			statement.setString(1, name);
    		    			statement.setInt(2, id);
    		    			if(statement.executeUpdate()>=1)	{
    		    				System.out.println("Dodano hodowce "+name+", o kodzie kraju "+id+" .");
    		    			} 
    		    			else	{
    		    				System.out.println("Prosze podac dane do dodania.");
    		    			}
    		    		
    	              		} 		catch (SQLException e) {
    	                        e.printStackTrace();
    	              		}
    	              		
    	    
   	              		 break;
   	              	 }
    	              	case 3: opcja1String = "Country";{
    	              		try{
    	              	query = "INSERT INTO Country (NAME,CODE) VALUES (?,?)";
    	              	statement = con.prepareStatement(query);
    	              	System.out.println("Podaj nazwe panstwa: ");
    	              	String name = EasyIn.getString();
    	              	System.out.println("Podaj kod panstwa: ");
    	              	String code = EasyIn.getString();
    	              	statement.setString(1, name);
    	              	statement.setString(2, code);
    	              	if(statement.executeUpdate()>=1)	{
		    				System.out.println("Dodano panstwo "+name+",o kodzie  "+code+" .");
		    			} 
		    			else	{
		    				System.out.println("Prosze podac dane do dodania.");
    	              		}}
    	              		catch (SQLException e) {
    	                        e.printStackTrace();
    	                }
    	              		break;
    	              		
    	              		}	
   	              		
    	              	
    	              	case 4: opcja1String = "Color";{
    	              		try{
    	              	query = "INSERT INTO Color (LNAME,SNAME) VALUES (?,?)";
    	              	statement = con.prepareStatement(query);
    	              	System.out.println("Podaj dluga nazwe umaszczenia: ");
    	              	String lname = EasyIn.getString();
    	              	System.out.println("Podaj krotka nazwe umaszczenia: ");
    	              	String sname = EasyIn.getString();
    	              	statement.setString(1, lname);
    	              	statement.setString(2, sname);
    	              	if(statement.executeUpdate()>=1)	{
		    				System.out.println("Dodano umaszczenie o dlugiej nazwie "+lname+",i krotkiej nazwie "+sname+" .");
		    			} 
		    			else	{
		    				System.out.println("Prosze podac dane do dodania.");
    	              		}}
    	              		catch (SQLException e) {
    	                        e.printStackTrace();
    	                }
    	              		break;
    	              		
    	              		}
    	              	case 5: opcja1String = "Sex";{
    	              		try{
    	              	query = "INSERT INTO Sex (NAME) VALUES (?)";
    	              	statement = con.prepareStatement(query);
    	              	System.out.println("Podaj nazwe plci: ");
    	              	String name = EasyIn.getString();
    	          
    	              	statement.setString(1, name);
    	              	if(statement.executeUpdate()>=1)	{
		    				System.out.println("Dodano nowa plec o nazwie "+name+".");
		    			} 
		    			else	{
		    				System.out.println("Prosze podac dane do dodania.");
    	              		}}
    	              		catch (SQLException e) {
    	                        e.printStackTrace();
    	                }
    	              		break;
    	              		
    	              		}
    	              	 }
    	              	 
    	              	 
    	              	 
    	              	 
    	                     break;}
    	            case 2:  opcjaString = "Read";
    	                     break;
    	            case 3:  opcjaString = "Update";
    	                     break;
    	            case 4:  opcjaString = "Delete";
    	                     break;
    	            case 5:  opcjaString = "exit";{
    	            	System.exit(0);
    	            
    	            		break;}
    	            default: opcjaString = "Blad";
    	                     break;
    	        }

    	   System.out.println("Ahoj!");     
        
    }
    	
    	
    	
}
