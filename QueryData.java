import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryData {
	public static void main(String argc[]) throws SQLException{
	Connection conn = connection.getConnection();
	Statement stmt  = conn.createStatement();
	String sql = "SELECT first_name, last_name, email " +
            "FROM candidates";
	ResultSet rs = stmt.executeQuery(sql);
	
	while (rs.next()) {
		   System.out.println(rs.getString("first_name") + "\t" + 
		                      rs.getString("last_name")  + "\t" +
		                      rs.getString("email"));
		   }
	try{
		   rs.close();
		   stmt.close();
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		}
}}
