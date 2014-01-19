package mpr.proj;



public class Main {
    public static void main(String[] args) {
    	
    
    	DBMenu.connectDB();
    	DBMenu.menu();
    	DBMenu.disconnectDB();

    	   System.out.println("Ahoj!");     
        
    }
    	  	
}
