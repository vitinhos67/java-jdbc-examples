import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddPersonInDB {
 public static void main(String[] args) throws SQLException {
	
	 ConnectionDatabase connectionDatabase = new ConnectionDatabase();
	 Connection connection = connectionDatabase.getConnection();
	 
	 System.out.println("Informe o nome da pessoa:");
	 
	 Scanner entrada = new Scanner(System.in);
	 
	 String nome = entrada.nextLine();
	 
	 
	 
	 String query = "INSERT INTO pessoas (nome) VALUES (?)";
	 
	 PreparedStatement stmt =  connection.prepareStatement(query);
	 stmt.setString(1, nome);
	 
	 stmt.execute();
	 
	 
	 entrada.close();
	
	 
	 
}
}
