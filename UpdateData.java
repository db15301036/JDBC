import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UpdateData {

	public static void main (String arg[]) throws SQLException{
		Connection conn = connection.getConnection();
		String sqlUpdate = "UPDATE candidates "
				+ "SET last_name = ? "
				+ "WHERE id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
		String lastName = "William";
		int id = 2;
		pstmt.setString(1, lastName);
		pstmt.setInt(2, id);
		int rowAffected = pstmt.executeUpdate();
		System.out.println(String.format("Row affected %d", rowAffected));
		
		lastName = "Grohe";            
		id = 101;            
		pstmt.setString(1, lastName);            
		pstmt.setInt(2, id);             
		rowAffected = pstmt.executeUpdate();           
		System.out.println(String.format("Row affected %d", rowAffected));
	}
}
