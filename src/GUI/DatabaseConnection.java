package GUI;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "login";
        String databaseUser = "root";
        String databasePassword = "Eragorn100818";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
