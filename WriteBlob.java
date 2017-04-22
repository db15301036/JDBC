import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class WriteBlob {
	public static void writeBlob(int candidateId, String filename) {
		String updateSQL = "UPDATE candidates "
				 + "SET resume = ? "
				 + "WHERE id=?";
		 try (Connection conn = connection.getConnection();                
				 PreparedStatement pstmt = conn.prepareStatement(updateSQL)) 
		 {
			// read the file            
			 File file = new File(filename);
			 FileInputStream input = new FileInputStream(file);
			 
			 // set parameters            
			 pstmt.setBinaryStream(1, input);            
			 pstmt.setInt(2, candidateId);
			 
			 // store the resume file in database            
			 System.out.println("Reading file " + file.getAbsolutePath());
			 
			 System.out.println("Store file in the database.");
			 pstmt.executeUpdate();
		 }catch(SQLException | FileNotFoundException e){
			 System.out.println(e.getMessage());
		 }
	}
	public static void main(String[]args){
		writeBlob(122,"johndoe_resume.pdf");
	}
}
