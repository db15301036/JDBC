import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
public class Procedures {
	public static void getSkills(int candidateId) throws SQLException {
		 String query = "{ call get_candidate_skill(?) }";
		 ResultSet rs;
		 try (Connection conn = connection.getConnection();
				 CallableStatement stmt = conn.prepareCall(query)) { 
			     stmt.setInt(1, candidateId);
			     rs = stmt.executeQuery();
			     while (rs.next()) {
			    	 System.out.println(String.format("%s - %s",
			    			 rs.getString("first_name") + " "                      
			    	         + rs.getString("last_name"),
			    			 rs.getString("skill")));
			     }
		 }catch (SQLException ex){
	            System.out.println(ex.getMessage());
		 }
	}
	public static void main(String[]args) throws SQLException{
		getSkills(122);
	}
}
