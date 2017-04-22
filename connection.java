import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection 
{
	public static Connection getConnection() {
     Connection conn=null;
 try{
       String url = "jdbc:mysql://172.31.34.145:3306/db15301036";
	   String user = "15301036";
	   String password  = "15301036";
	   conn = DriverManager.getConnection(url, user, password);
    }	
       catch(SQLException e) 
       {   
       System.out.println(e.getMessage());
       }  
        
	    return conn;
    }
}
