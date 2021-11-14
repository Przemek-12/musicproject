package musicproject3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class musicproject3 {

    public static void main(String[] args) throws Exception {
        getConnection();
    }

    public static Connection getConnection() throws Exception {
	
	
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						String url= "jdbc:mysql://127.0.0.1:3306/music?useTimezone=true&serverTimezone=UTC";
						String username = "root";
						String password = "muzyka";
						Connection conn = DriverManager.getConnection(url, username, password);
						System.out.println("connected");
						return conn;
						
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
	
	return null;
	
}

}
