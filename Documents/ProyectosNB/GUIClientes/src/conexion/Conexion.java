package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public final class Conexion {
    private static final String bd = "prueba";
    private static final String user = "root";
    private static final String pswd = "admin";
    private static final String host = "localhost";
    private static final String puerto = "3306";
    private final String url;
    private Connection conexion;

    public Conexion() {
        url = "jdbc:mysql://" + host + ":" + puerto + "/" + bd;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pswd);
            JOptionPane.showMessageDialog(null, "Conexion establecida correctamente");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexion: " + e.getMessage());
        }
    }

    public Connection getConn() {return conexion;}
    public Connection obtener() {return conexion;}

    public boolean abrir() {
        try {Class.forName("com.mysql.cj.jdbc.Driver");
         conexion = DriverManager.getConnection(url, user, pswd);
        } catch (SQLException | ClassNotFoundException e){
        return true;
        }
        return false;
    }
    
        public boolean cerrar () {
            try {conexion.close(); return true;} catch (SQLException e) 
            { return false; }
        }

        public void closeConn () {
            try { conexion.close();
               JOptionPane.showMessageDialog(null, "Conexion cerrada correctamente");
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }