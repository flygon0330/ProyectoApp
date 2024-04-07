package vista;
import conexion.Conexion;
import modelo.Modelo;
import controlador.Controlador;
import vista.Vista;
import java.sql.Connection;
/**
 *
 * @author Angelo
 */
public class Principal {
    public static void main(String[] args) {
    Conexion conexion = new Conexion();
    Modelo modelo = new Modelo();
    Vista vista = new Vista();
    Controlador control = new Controlador(modelo,vista);
    }  
}