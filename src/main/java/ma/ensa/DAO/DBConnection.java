package ma.ensa.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String HOST = "localhost";
    private static final int PORT = 8888;
    private static final String DB_NAME = "db_controle2020";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static  Connection connection ;

    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME),USERNAME,PASSWORD);
//            System.out.println("Connexion reussite !");
        } catch (SQLException e) {
//            System.out.println("Connexion a été echouée !");
            e.printStackTrace();
        }
        return connection;

    }

    public static void close(){
        try{
            connection.close();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

}
