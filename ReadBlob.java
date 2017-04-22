import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ReadBlob {
	public static void readBlob(int candidateId, String filename) throws SQLException, IOException {
		 // update sql        
		String selectSQL = "SELECT resume FROM candidates WHERE id=?";
		ResultSet rs = null;
		try (Connection conn = connection.getConnection();                
				PreparedStatement pstmt = conn.prepareStatement(selectSQL);) 
		{
			 // set parameter;            
			pstmt.setInt(1, candidateId);            
			rs = pstmt.executeQuery();
			
			 // write binary stream into file            
			File file = new File(filename);            
			FileOutputStream output = new FileOutputStream(file);
			System.out.println("Writing to file " + file.getAbsolutePath());
			while (rs.next()) {                InputStream input = rs.getBinaryStream("resume");                byte[] buffer = new byte[1024];                while (input.read(buffer) > 0) {                    
				output.write(buffer);                
				}            
			}
		}catch(SQLException | IOException e) {
			System.out.println(e.getMessage());
		}finally{
			try {                
				if (rs != null) 
				{                   
					rs.close();                
					}
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		
	}
	public static void main(String[] args) throws SQLException, IOException 
	{       
		readBlob(122, "johndoe_resume_from_db.pdf");    
	
	}
}

