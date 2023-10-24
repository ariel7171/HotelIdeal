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
        return connection;
    }
}
