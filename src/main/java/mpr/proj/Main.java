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
    	System.out.println("Wpisz 4 aby usunac rekord.");
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
    	              		 System.out.println("Czy wprowadzany kon posiada rodzicow w bazie danych(dla 'tak' wprowadz 1, dla 'nie' 0) ?");
    	              		 int odp = EasyIn.getInt();
    	              		if (odp == 1){
    	              			try {     
    	    	              		 query = "INSERT INTO HORSE (NAME, SEX, COLOR, DOB, YEARONLY,DAM,SIRE,BREEDER) VALUES (?,?,?,?,?,?,?,?)";
    								statement = con.prepareStatement(query);
    								
    	    		    			System.out.print("Podaj imie konia do dodania: ");
    	    		    			String name = EasyIn.getString();
    	    		    			System.out.print("Podaj id plci konia do dodania(mare=0,stallion=1,gelding=2): ");
    	    		    			int idsex = EasyIn.getInt();
    	    		    			System.out.print("Podaj id koloru konia do dodania: ");
    	    		    			int idcolor = EasyIn.getInt();
    	    		    			System.out.print("Podaj date urodzenia konia do dodania w formacie RRRR-MM-DD: ");
    	    		    			String date = EasyIn.getString();
    	    		    			System.out.print("Podaj czy tylko rok (tak=1, nie=0): ");
    	    		    			int year  = EasyIn.getInt();
    	    		    			System.out.print("Podaj id hodowcy konia do dodania: ");
    	    		    			int breeder = EasyIn.getInt();
    	    		    			System.out.print("Podaj id matki konia do dodania: ");
    	    		    			int iddam = EasyIn.getInt();
    	    		    			System.out.print("Podaj id ojca konia do dodania: ");
    	    		    			int idsire = EasyIn.getInt();
    	    		    			
    	    		    			statement.setString(1, name);
    	    		    			statement.setInt(2, idsex);
    	    		    			statement.setInt(3, idcolor);
    	    		    			statement.setString(4, date);
    	    		    			statement.setInt(5, year);
    	    		    			statement.setInt(6, iddam );
    	    		    			statement.setInt(7,idsire);
    	    		    			statement.setInt(8, breeder);
    	    		    			
    	    		    			if(statement.executeUpdate()>=1)	{
    	    		    				System.out.println("Dodano konia o danych: Imie: "+name+", Id plci: "+idsex+", Id koloru: "+idcolor+", Data urodzenia "+date+",Czy tylko rok?: "+year+", Id matki: "+iddam+", Id Ojca:"+idsire+",Id hodowcy "+breeder+".");
    	    		    			} 
    	    		    			else	{
    	    		    				System.out.println("Prosze podac poprawne dane!");
    	    		    			}    	              		 

    	    	              		 
    	    	              		 } 		catch (SQLException e) {
    	     	                        e.printStackTrace();
    	    	              		 }
    	              		}
    	              		else if (odp ==0) {
    	              	
							try {     
    	              		 query = "INSERT INTO HORSE (NAME, SEX, COLOR, DOB, YEARONLY,BREEDER) VALUES (?,?,?,?,?,?)";
							statement = con.prepareStatement(query);
							
    		    			System.out.print("Podaj imie konia do dodania: ");
    		    			String name = EasyIn.getString();
    		    			System.out.print("Podaj id plci konia do dodania(mare=0,stallion=1,gelding=2): ");
    		    			int idsex = EasyIn.getInt();
    		    			System.out.print("Podaj id koloru konia do dodania: ");
    		    			int idcolor = EasyIn.getInt();
    		    			System.out.print("Podaj date urodzenia konia do dodania w formacie RRRR-MM-DD: ");
    		    			String date = EasyIn.getString();
    		    			System.out.print("Podaj czy tylko rok(tak=1, nie=0) : ");
    		    			int year  = EasyIn.getInt();
    		    			System.out.print("Podaj id hodowcy konia do dodania: ");
    		    			int breeder = EasyIn.getInt();
    		    			statement.setString(1, name);
    		    			statement.setInt(2, idsex);
    		    			statement.setInt(3, idcolor);
    		    			statement.setString(4, date);
    		    			statement.setInt(5, year);
    		    			statement.setInt(6, breeder);
    		    			if(statement.executeUpdate()>=1)	{
    		    				System.out.println("Dodano konia o danych: Imie: "+name+",Id plci: "+idsex+",Id koloru: "+idcolor+",Data urodzenia: "+date+",Czy tylko rok? "+year+", Id hodowcy: "+breeder+".");
    		    			} 
    		    			else	{
    		    				System.out.println("Prosze podac poprawne dane!");
    		    			}    	              		 

    	              		 
    	              		 } 		catch (SQLException e) {
     	                        e.printStackTrace();
    	              		 }
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
    	            case 3:  opcjaString = "Update";{
    	            	System.out.println("Wpisz 1 aby uaktualnic rekord w tabeli Horse.");
    	              	System.out.println("Wpisz 2 aby uaktualnic rekord w tabeli Breeder.");
    	              	System.out.println("Wpisz 3 aby uaktualnic rekord w tabeli Country.");
    	              	System.out.println("Wpisz 4 aby uaktualnic rekord w tabeli Color.");
    	              	System.out.println("Wpisz 5 aby uaktualnic rekord w tabeli Sex.");
    	              	int opcja2 = EasyIn.getInt();
    	              	switch(opcja2) {
    	              	 case 1: opcja1String = "Horse";{
    	              		 System.out.println("Czy edytowany kon posiada rodzicow w bazie danych(dla 'tak' wprowadz 1, dla 'nie' 0) ?");
    	              		 int odp = EasyIn.getInt();
    	              		if (odp == 1){
    	              			try {     
    	    	              		 query = "UPDATE HORSE SET NAME=(?), SEX=(?), COLOR=(?), DOB=(?), YEARONLY=(?), DAM=(?), SIRE=(?), BREEDER=(?) WHERE ID=(?)";
    								statement = con.prepareStatement(query);
    								System.out.println("Podaj id konia do edycji: ");
    								int id = EasyIn.getInt();
    							
    	    		    			System.out.print("Podaj nowe imie konia: ");
    	    		    			String name = EasyIn.getString();
    	    		    			System.out.print("Podaj nowe id plci konia(mare=0,stallion=1,gelding=2): ");
    	    		    			int idsex = EasyIn.getInt();
    	    		    			System.out.print("Podaj nowe id koloru konia: ");
    	    		    			int idcolor = EasyIn.getInt();
    	    		    			System.out.print("Podaj nowa date urodzenia konia  w formacie RRRR-MM-DD: ");
    	    		    			String date = EasyIn.getString();
    	    		    			System.out.print("Podaj nowe czy tylko rok (tak=1, nie=0): ");
    	    		    			int year  = EasyIn.getInt();
    	    		    			System.out.print("Podaj nowe id hodowcy konia: ");
    	    		    			int breeder = EasyIn.getInt();
    	    		    			System.out.print("Podaj nowe id matki konia: ");
    	    		    			int iddam = EasyIn.getInt();
    	    		    			System.out.print("Podaj nowe id ojca konia: ");
    	    		    			int idsire = EasyIn.getInt();
    	    		    			
    	    		    			statement.setString(1, name);
    	    		    			statement.setInt(2, idsex);
    	    		    			statement.setInt(3, idcolor);
    	    		    			statement.setString(4, date);
    	    		    			statement.setInt(5, year);
    	    		    			statement.setInt(6, iddam );
    	    		    			statement.setInt(7,idsire);
    	    		    			statement.setInt(8, breeder);
    	    		    			statement.setInt(9,id);
    	    		    			if(statement.executeUpdate()>=1)	{
    	    		    				System.out.println("Edytowano konia o id: "+id+" Nowe dane to: Imie: "+name+", Id plci: "+idsex+", Id koloru: "+idcolor+", Data urodzenia "+date+",Czy tylko rok?: "+year+", Id matki: "+iddam+", Id Ojca:"+idsire+",Id hodowcy "+breeder+".");
    	    		    			} 
    	    		    			else	{
    	    		    				System.out.println("Prosze podac poprawne dane!");
    	    		    			}    	              		 

    	    	              		 
    	    	              		 } 		catch (SQLException e) {
    	     	                        e.printStackTrace();
    	    	              		 }
    	              		}
    	              		else if (odp ==0) {
    	              	
							try {     
								query = "UPDATE HORSE SET NAME=(?), SEX=(?), COLOR=(?), DOB=(?), YEARONLY=(?), BREEDER=(?) WHERE ID=(?)";
								statement = con.prepareStatement(query);
								System.out.println("Podaj id konia do edycji: ");
								int id = EasyIn.getInt();
	    		    			System.out.print("Podaj nowe imie konia: ");
	    		    			String name = EasyIn.getString();
	    		    			System.out.print("Podaj nowe id plci konia(mare=0,stallion=1,gelding=2): ");
	    		    			int idsex = EasyIn.getInt();
	    		    			System.out.print("Podaj nowe id koloru konia: ");
	    		    			int idcolor = EasyIn.getInt();
	    		    			System.out.print("Podaj nowa date urodzenia konia  w formacie RRRR-MM-DD: ");
	    		    			String date = EasyIn.getString();
	    		    			System.out.print("Podaj nowe czy tylko rok (tak=1, nie=0): ");
	    		    			int year  = EasyIn.getInt();
	    		    			System.out.print("Podaj nowe id hodowcy konia: ");
	    		    			int breeder = EasyIn.getInt();

	    		    			
	    		    			statement.setString(1, name);
	    		    			statement.setInt(2, idsex);
	    		    			statement.setInt(3, idcolor);
	    		    			statement.setString(4, date);
	    		    			statement.setInt(5, year);
	    		    			statement.setInt(6, breeder);
	    		    			statement.setInt(7,id);
	    		    			if(statement.executeUpdate()>=1)	{
	    		    				System.out.println("Edytowano konia o id: "+id+" Nowe dane to: Imie: "+name+", Id plci: "+idsex+", Id koloru: "+idcolor+", Data urodzenia "+date+",Czy tylko rok?: "+year+",Id hodowcy "+breeder+".");
	    		    			} 
    		    			else	{
    		    				System.out.println("Prosze podac poprawne dane!");
    		    			}    	              		 

    	              		 
    	              		 } 		catch (SQLException e) {
     	                        e.printStackTrace();
    	              		 }
							}break;
    	              	 }
    	              	case 2: opcja1String = "Breeder";{
    	              	 	try {
        	              		query ="UPDATE Breeder SET NAME=(?), COUNTRY=(?) WHERE ID=(?)";
								statement = con.prepareStatement(query);
								System.out.println("Podaj ID hodowcy do edycji: ");
								int id = EasyIn.getInt();
								System.out.println("Podaj nowa nazwe hodowcy: ");
								String name = EasyIn.getString();
								System.out.println("Podaj nowe ID panstwa hodowcy: ");
								int countryid = EasyIn.getInt();
								
								statement.setString(1,name);
								statement.setInt(2,countryid);
								statement.setInt(3, id);
								if(statement.executeUpdate()>=1)	{
				    				System.out.println("Edytowano hodowce o id "+id+" na imie: "+name+", id panstwa: "+countryid+" .");
				    			} 
				    			else	{
				    				System.out.println("Prosze podac dane do edycji");
				    			}
								
							} catch (SQLException e) {
							
								e.printStackTrace();
							}
    	              		 break;
    	              		
   	              		
   	              	 }
    	              	case 3: opcja1String = "Country";{
    	              		try {
    	              		query ="UPDATE Country SET NAME=(?), CODE=(?) WHERE ID=(?)";
							statement = con.prepareStatement(query);
							System.out.println("Podaj ID panstwa do edycji: ");
							int id = EasyIn.getInt();
							System.out.println("Podaj nowa nazwe panstwa: ");
							String name = EasyIn.getString();
							System.out.println("Podaj nowe kod kraju: ");
							String countryid = EasyIn.getString();
							
							statement.setString(1,name);
							statement.setString(2,countryid);
							statement.setInt(3, id);
							if(statement.executeUpdate()>=1)	{
			    				System.out.println("Edytowano panstwo o id "+id+" na nazwe: "+name+", kod panstwa: "+countryid+" .");
			    			} 
			    			else	{
			    				System.out.println("Prosze podac dane do edycji");
			    			}
							
						} catch (SQLException e) {
						
							e.printStackTrace();
						}
	              		 break;
   	              	 }
    	              	case 4: opcja1String = "Color";{
    	              		try {
        	              		query ="UPDATE Color SET LNAME=(?), SNAME=(?) WHERE ID=(?)";
    							statement = con.prepareStatement(query);
    							System.out.println("Podaj ID koloru do edycji: ");
    							int id = EasyIn.getInt();
    							System.out.println("Podaj nowa dluga nazwe koloru: ");
    							String name = EasyIn.getString();
    							System.out.println("Podaj nowa krotka nazwe koloru: ");
    							String sname = EasyIn.getString();
    							
    							statement.setString(1,name);
    							statement.setString(2,sname);
    							statement.setInt(3, id);
    							if(statement.executeUpdate()>=1)	{
    			    				System.out.println("Edytowano kolor o id "+id+" na dluga nazwe: "+name+", krotka nazwe: "+sname+" .");
    			    			} 
    			    			else	{
    			    				System.out.println("Prosze podac dane do edycji");
    			    			}
    							
    						} catch (SQLException e) {
    						
    							e.printStackTrace();
    						}
    	              		 break;
   	              	 }
    	              	case 5: opcja1String = "Sex";{
    	              		try {
        	              		query ="UPDATE Sex SET NAME=(?) WHERE ID=(?)";
    							statement = con.prepareStatement(query);
    							System.out.println("Podaj ID plci do edycji: ");
    							int id = EasyIn.getInt();
    							System.out.println("Podaj nowa nazwe plci: ");
    							String name = EasyIn.getString();
    							
    							statement.setString(1,name);
    							statement.setInt(2, id);
    							if(statement.executeUpdate()>=1)	{
    			    				System.out.println("Edytowano plec o id "+id+" na nazwe: "+name+".");
    			    			} 
    			    			else	{
    			    				System.out.println("Prosze podac dane do edycji");
    			    			}
    							
    						} catch (SQLException e) {
    						
    							e.printStackTrace();
    						}
    	              		 break;
   	              	 }
    	              	 }
    	                     break;}
    	            case 4:  opcjaString = "Delete";{
    	            	System.out.println("Wpisz 1 aby usunac rekord w tabeli Horse.");
    	              	System.out.println("Wpisz 2 aby usunac rekord w tabeli Breeder.");
    	              	System.out.println("Wpisz 3 aby usunac rekord w tabeli Country.");
    	              	System.out.println("Wpisz 4 aby usunac rekord w tabeli Color.");
    	              	System.out.println("Wpisz 5 aby usunac rekord w tabeli Sex.");
    	              	int opcja3 = EasyIn.getInt();
    	              	switch(opcja3) {
   	              	 case 1: opcja1String = "Horse";{
   	              	try {
   	             		query = "DELETE FROM HORSE WHERE ID=(?)";
						statement = con.prepareStatement(query);
						System.out.println("Podaj ID konia do usuniecia");
						int id = EasyIn.getInt();
						statement.setInt(1,id);
						if(statement.executeUpdate()>=1)	{
		    				System.out.println("Usunieto konia o id "+id+"");
		    			} 
		    			else	{
		    				System.out.println("Prosze podac dane do usuniecia");
		    			}
					} catch (SQLException e) {

						e.printStackTrace();
					}
   	              		 break;
   	              	 }
   	              	case 2: opcja1String = "Breeder";{
   	              		
   	             	try {
   	             		query = "DELETE FROM BREEDER WHERE ID=(?)";
						statement = con.prepareStatement(query);
						System.out.println("Podaj ID hodowcy do usuniecia");
						int id = EasyIn.getInt();
						statement.setInt(1,id);
						if(statement.executeUpdate()>=1)	{
		    				System.out.println("Usunieto hodowce o id "+id+"");
		    			} 
		    			else	{
		    				System.out.println("Prosze podac dane do usuniecia");
		    			}
					} catch (SQLException e) {

						e.printStackTrace();
					}
  	              		 break;
  	              	 }
   	              	case 3: opcja1String = "Country";{
   	             	try {
   	             		query = "DELETE FROM Country WHERE ID=(?)";
						statement = con.prepareStatement(query);
						System.out.println("Podaj ID kraju do usuniecia");
						int id = EasyIn.getInt();
						statement.setInt(1,id);
						if(statement.executeUpdate()>=1)	{
		    				System.out.println("Usunieto kraj o id "+id+"");
		    			} 
		    			else	{
		    				System.out.println("Prosze podac dane do usuniecia");
		    			}
					} catch (SQLException e) {

						e.printStackTrace();
					}
  	              		 break;
  	              	 }
   	              	case 4: opcja1String = "Color";{
   	             	try {
   	             		query = "DELETE FROM COLOR WHERE ID=(?)";
						statement = con.prepareStatement(query);
						System.out.println("Podaj ID coloru do usuniecia");
						int id = EasyIn.getInt();
						statement.setInt(1,id);
						if(statement.executeUpdate()>=1)	{
		    				System.out.println("Usunieto kolor o id "+id+"");
		    			} 
		    			else	{
		    				System.out.println("Prosze podac dane do usuniecia");
		    			}
					} catch (SQLException e) {

						e.printStackTrace();
					}
  	              		 break;
  	              	 }
   	              	case 5: opcja1String = "Sex";{
   	             	try {
   	             		query = "DELETE FROM SEX WHERE ID=(?)";
						statement = con.prepareStatement(query);
						System.out.println("Podaj ID plci do usuniecia");
						int id = EasyIn.getInt();
						statement.setInt(1,id);
						if(statement.executeUpdate()>=1)	{
		    				System.out.println("Usunieto plec o id "+id+"");
		    			} 
		    			else	{
		    				System.out.println("Prosze podac dane do usuniecia");
		    			}
					} catch (SQLException e) {

						e.printStackTrace();
					}
  	              		 break;
  	              	 }
   	              	 }
    	            
    	                     break;}
    	            case 5:  opcjaString = "exit";{
    	            	System.out.println("Shutdown");
    	            	System.exit(0);
    	            	
    	            
    	            		break;}
    	            default: opcjaString = "Blad";
    	                     break;
    	        }

    	   System.out.println("Ahoj!");     
        
    }
    	  	
}
