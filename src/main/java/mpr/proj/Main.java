package mpr.proj;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	
    
    	DBMenu.connectDB();
    	DBMenu.menu();
    	DBMenu.disconnectDB();

    	   System.out.println("Ahoj!");     
        
    }
    	  	
}
