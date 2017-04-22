import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class Main 
{
	public static void main(String[] args) {
		try (Connection conn = connection.getConnection()) {            
			System.out.println(String.format("Connected to database %s " + "successfully.", conn.getCatalog()));
		}catch (SQLException ex) {            
			System.out.println(ex.getMessage());        
			}
	}
	
}

