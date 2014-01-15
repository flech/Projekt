package mpr.proj;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	
    
    	DBMetodyMenu.connectDB();
    	DBMetodyMenu.menu();
    	DBMetodyMenu.disconnectDB();

    	   System.out.println("Ahoj!");     
        
    }
    	  	
}
