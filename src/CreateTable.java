import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
 public static void main(String[] args) throws SQLException {
	
	 String query = "CREATE TABLE IF NOT EXISTS pessoas ("
	 		+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
	 		+ "nome VARCHAR(80) NOT NULL"
	 		+ ")";
	 
	 ConnectionDatabase connectionDatabase = new ConnectionDatabase();
	 
	 Connection connection = connectionDatabase.getConnection();
	
	 
	 Statement stmt = connection.createStatement();
	 
	 
	 stmt.execute(query);
	 
	 
	 
	 
}
}
