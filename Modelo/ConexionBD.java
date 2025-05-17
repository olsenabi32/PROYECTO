package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection conectar() {
        try {
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "010393");
            return connection;        
        
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}

