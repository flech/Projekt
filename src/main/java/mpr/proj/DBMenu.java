package mpr.proj;
import java.sql.*;
import java.util.*;

public class DBMenu {
	private static Connection con;

   
  
public static void connectDB(){
	
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
}


public static void disconnectDB(){
	
	try {
		if(!con.isClosed()){
			con.close();
			System.out.println("\nPolaczenie z baza danych zostalo pomyslnie zamniete");
		}
		else {System.out.println("\nPolaczenie z baza danych zostalo pomyslnie zamniete");
		}
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Wystapil blad przy zamykaniu polaczneia z baza danych.");
	}
}


	public static void menu(){
		
		try {
			if(!con.isClosed()){
			
			
			System.out.println("Witaj w bazie danych konii.");
			System.out.println("Wpisz 1 aby dodać rekord.");
			System.out.println("Wpisz 2 aby odczytac dane z tabeli.");
			System.out.println("Wpisz 3 aby uaktualnic rekord.");
			System.out.println("Wpisz 4 aby usunac rekord.");
			System.out.println("Wpisz 5 aby znalesc potomstwo konia");
			System.out.println("Wpisz 6 aby Wyjsc.");
     
				 int opcja = EasyIn.getInt();
			       String opcjaString; 
			        String opcja1String;
			
			        
			        switch (opcja) {
			            case 1:  opcjaString = "Create";{
			              	System.out.println("Wpisz 1 aby dodać rekord do tabeli Horse.");
			              	System.out.println("Wpisz 2 aby dodać rekord do tabeli Breeder.");
			              	System.out.println("Wpisz 3 aby dodać rekord do tabeli Country.");
			              	System.out.println("Wpisz 4 aby dodać rekord do tabeli Color.");
			              	//System.out.println("Wpisz 5 aby dodać rekord do tabeli Sex.");
			              	 int opcja1 = EasyIn.getInt();
			              	
			              	 switch(opcja1) {
			              	 case 1: opcja1String = "Horse";{
			              		 DBMetody.dodajKonia();
			              		break;

			              	 }
			              	case 2: opcja1String = "Breeder";{
			              		DBMetody.dodajHodowce();
			    
			          		 break;
			          	 }
			              	case 3: opcja1String = "Country";{
			              			DBMetody.dodajKraj();
			              		break;
			             	}	
			          		
			              	
			              	case 4: opcja1String = "Color";{
			              		DBMetody.dodajKolor();
			              		break;
			              		
			              		}
			              	
			              	
			              	case 5: opcja1String = "Sex";{
			              		DBMetody.dodajPlec();
			              		break;
			              		
			              		}
			              	 }
			         
			                     break;}
			            case 2:  opcjaString = "Read";
		            	System.out.println("Wpisz 1 aby zobaczyc tabele Horse.");
		              	System.out.println("Wpisz 2 aby zobaczyc tabele Breeder.");
		              	System.out.println("Wpisz 3 aby zobaczyc tabele Country.");
		              	System.out.println("Wpisz 4 aby zobaczyc tabele Color.");
		              	System.out.println("Wpisz 5 aby zobaczyc tabele Sex.");
		              	int opcjaPodglad = EasyIn.getInt();
		             	 switch(opcjaPodglad) {
    	              	 case 1: opcja1String = "Horse";{	
    	              		 Kolekcje.wyswietlKonie();
    	              		 break;
    	              	 }
    	              	   
    	              	 
    	              	case 2: opcja1String = "Breeder";{
    	              	Kolekcje.wyswietlHodowcow();
   	              		 break;}
   	              	 
    	              	case 3: opcja1String = "Country";{
    	              		Kolekcje.wyswietlKraje();
    	             
   	              		 break;
   	              	 }
    	              	case 4: opcja1String = "Color";{
    	              		Kolekcje.wyswietlKolory();
   	              		 break;
   	              	 }
    	              	case 5: opcja1String = "Sex";{
    	              		Kolekcje.wyswietlPlec();
   	              		 break;
   	              	 }
    	              	 }
			            
			            
			            
			                     break;
			            case 3:  opcjaString = "Update";{
			            	System.out.println("Wpisz 1 aby uaktualnic rekord w tabeli Horse.");
			              	System.out.println("Wpisz 2 aby uaktualnic rekord w tabeli Breeder.");
			              	System.out.println("Wpisz 3 aby uaktualnic rekord w tabeli Country.");
			              	System.out.println("Wpisz 4 aby uaktualnic rekord w tabeli Color.");
			              	//System.out.println("Wpisz 5 aby uaktualnic rekord w tabeli Sex.");
			              	int opcja2 = EasyIn.getInt();
			              	switch(opcja2) {
			              	 case 1: opcja1String = "Horse";{
			              		 DBMetody.editKonia();
			              		break;
			              	 }
			              	case 2: opcja1String = "Breeder";{
			              	 	DBMetody.editHodowce();
			              		 break;
			              		
			          		
			          	 }
			              	case 3: opcja1String = "Country";{
			              		DBMetody.editKraj();
			          		 break;
			          	 }
			              	case 4: opcja1String = "Color";{
			              		DBMetody.editKolor();
			              		 break;
			          	 }
			              	case 5: opcja1String = "Sex";{
			              	DBMetody.editPlec();
			              		 break;
			          	 }
			              	 }
			                     break;}
			            case 4:  opcjaString = "Delete";{
			            	System.out.println("Wpisz 1 aby usunac rekord w tabeli Horse.");
			              	System.out.println("Wpisz 2 aby usunac rekord w tabeli Breeder.");
			              	System.out.println("Wpisz 3 aby usunac rekord w tabeli Country.");
			              	System.out.println("Wpisz 4 aby usunac rekord w tabeli Color.");
			              //	System.out.println("Wpisz 5 aby usunac rekord w tabeli Sex.");
			              	int opcja3 = EasyIn.getInt();
			              	switch(opcja3) {
			          	 case 1: opcja1String = "Horse";{
			          		 DBMetody.usunKonia();
			          		 break;
			          	 }
			          	case 2: opcja1String = "Breeder";{
			          		DBMetody.usunHodowce();
			          break;
			          	 }
			          	case 3: opcja1String = "Country";{
			          		DBMetody.usunKraj();
			          		 break;
			          	 }
			          	case 4: opcja1String = "Color";{
			         	DBMetody.usunKolor();
			          		 break;
			          	 }
			          	case 5: opcja1String = "Sex";{
			         	DBMetody.usunPlec();
			          		 break;
			          	 }
			          	 }
			            
			                     break;}
			            
			            
			            
			            case 5: opcjaString = "potomstwo";{
			            	Kolekcje.znajdzPotomstwo();
			            	break;
			            }
			            
			            
			            case 6:  opcjaString = "exit";{
			            	
				            	try {
				            		if(!con.isClosed()){
				            			con.close();
				            			System.out.println("Polaczenie z baza danych zostalo pomyslnie zamniete");
				            		}
				            		else {System.out.println("Polaczenie z baza danych zostalo pomyslnie zamniete");
				            		}
				            	} catch (SQLException e) {
				            		e.printStackTrace();
				            		System.out.println("Wystapil blad przy zamykaniu polaczneia z baza danych.");
				            	}
				            	System.out.println("Shutdown");
				            	System.exit(0);
			            
			            		break;}
			            default: opcjaString = "Blad";
			                     break;
			        }
			
			
}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nastapil blad przy polaczeniu z baza danych");
		}
	}
	
	
	

	
	
	
}
	

