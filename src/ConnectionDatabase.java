
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class ConnectionDatabase {

	Connection getConnection() {
        try {
            Properties props = getConfig();

            String DATABASE = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            System.out.println(DATABASE);
            System.out.println(user);
            System.out.println(password);

            Connection connection = DriverManager.getConnection(DATABASE, user, password);
            
            String query = "CREATE DATABASE IF NOT EXISTS curso_java";
            
            Statement stmt = connection.createStatement();
            
            
            stmt.execute(query);
            
            
            
            return connection;
        } catch (SQLException | IOException e) {
            // Lidar com os erros e retornar null em caso de erro
            if (e instanceof SQLException) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + ((SQLException) e).getSQLState());
                System.out.println("VendorError: " + ((SQLException) e).getErrorCode());
            }
            if (e instanceof IOException) {
                System.out.println("IOException: " + e.getMessage());
            }
            return null;
        }
    }
	
	private static Properties getConfig() throws IOException {
		Properties prop = new Properties();

		try {
	        

	        prop.load(ConnectionDatabase.class.getResourceAsStream("config.properties"));  
		    return prop;
				
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
		

	}
	
}
	
