package mpr.proj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mpr.proj.pedigree.*;



public class DBMetody {
	private static Connection con;
	private static String query;
    private static PreparedStatement statement;
	public static void dodajPlec(){
		try{
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
	}
	public static void editPlec(){
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
		
	}
	public static void usunPlec(){
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
	}
	public static void dodajKonia() {
		 System.out.println("Czy wprowadzany kon posiada rodzicow w bazie danych(dla 'tak' wprowadz 1, dla 'nie' 0) ?");
  		 int odp = EasyIn.getInt();
  		if (odp == 1){
  			try {     
  				con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
		}
	}
	public static void dodajHodowce() {
		try{
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
     		
		
	}
	public static void dodajKraj(){
		try{
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
          		
		
		
		
		
	}
	public static void dodajKolor(){
		try{
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
		
	}
	public static void editKonia(){
		 System.out.println("Czy edytowany kon posiada rodzicow w bazie danych(dla 'tak' wprowadz 1, dla 'nie' 0) ?");
  		 int odp = EasyIn.getInt();
  		if (odp == 1){
  			try {     
  				con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
		}
	}
	public static void editHodowce() {

		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
		
		
	}
	public static void editKraj(){

 		try {
 			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
	}
	public static void editKolor(){
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
	}
	public static void usunKonia(){
	   	try {
	   		con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
	}
	public static void usunHodowce(){

		
     	try {
     		con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
      	
	}
	public static void usunKraj(){
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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
	}
	public static void usunKolor(){
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
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

	}
	public static Color idKolor(long id)
	{
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			
		query = "SELECT * FROM COLOR where ID =" +id ;
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				return (new Color(rs.getLong(1), rs.getString(2), rs.getString(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		};		
		
		return null;
	}
	
	public static Breeder idHodowca(long id)
	{
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			query = "SELECT * FROM Breeder WHERE ID =" + id;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next())
			{
				return new Breeder(rs.getLong(1), rs.getString(2), idKraj(rs.getLong(3)));
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public static Country idKraj(long id)
	{
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			query = "SELECT * FROM COUNTRY WHERE ID=" +id;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()){
				return new Country(rs.getLong(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Horse idKon(long id)
	{
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			query = "SELECT * FROM HORSE WHERE ID =" + id;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next())
			{
				return new Horse(rs.getLong(1), rs.getString(2),IDsex(rs.getInt(3)),new DateOfBirth(rs.getDate("DOB"), rs.getBoolean("YEARONLY")),DBMetody.idKolor(rs.getLong(6)), DBMetody.idKon(rs.getLong(7)),idKon(rs.getLong(8)) , DBMetody.idHodowca(rs.getLong(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
    public static Sex IDsex(long id){
    	try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb","sa","");
			query = "SELECT * FROM SEX WHERE ID=" +id;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next())
			{
				return Sex.valueOf(rs.getString("NAME").toUpperCase());
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
		return null;
    	}

    }
	
	
	

