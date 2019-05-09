package UTN.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionFactory {
    private static ConnectionFactory instance;
    private Connection conn;

    private ConnectionFactory(){}

    public static ConnectionFactory getInstance(){
        instance = Optional.ofNullable(instance).orElse(new ConnectionFactory());
        return instance;
    }

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("url","user","pass");
        }catch (SQLException ex){
            System.out.println("Problem connecting to Database");
        }catch (ClassNotFoundException ex){
            System.out.println("MySql Driver not installed");
        }

        return conn;
    }
}
