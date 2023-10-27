package hotelideal.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static String server = "localhost";
    private static String database = "hotel_ideal";
    private static String userName = "root";
    private static String password = "";
    private static String driverClassName = "org.mariadb.jdbc.Driver";
    private static String url = "jdbc:mariadb://" + server + "/" + database;
//    private static String port = "3306";
//    private static String timeZone = "America/Argentina/Cordoba";
//    private static String password = "@270Jorge571";
//    private static String driverClassName = "com.mysql.cj.jdbc.Driver";   
//    private static String url = "jdbc:mysql://" + server + ":" + port + "/" + database + "?serverTimezone=" + timeZone;

    private static Connection connection;

    private Conexion() {
    }

    public static Connection getConnection() throws SQLException {

        if (connection == null) {
            try {
                
                Class.forName(driverClassName);
                connection = DriverManager.getConnection(url, userName, password);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la BD "+ex.getMessage());
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers "+ex.getMessage());
            }
        }else{
       }

//        if (connection == null || connection.isClosed()) {
//            // Utilizamos el nuevo nombre de clase del controlador
//            
//            try {
//                Class.forName(driverClassName);
//            } catch (ClassNotFoundException e) {
//                throw new SQLException("MySQL JDBC Driver not found");
//            }
//            
//            connection = DriverManager.getConnection(url, userName, password);
//        }

        return connection;
    }
        
}
