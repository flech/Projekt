package mpr.proj;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	
    	Dbmetody db = new Dbmetody();
    	db.connectDB();
    	db.menu();
    	db.disconnectDB();

    	   System.out.println("Ahoj!");     
        
    }
    	  	
}
