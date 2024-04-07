package vista;
import controlador.Controlador;
import dao.DAO;
import modelo.Modelo;
/**
 *
 * @author Angelo
 * Clase Principal donde se ejecuta la GUI por capas Modelo-Vista-Controlador
 */
public class Principal {
    public static void main(String[] args) {     
    Modelo modelo = new Modelo();
    Vista vista = new Vista();
    DAO dao = new DAO();
    Controlador controlador = new Controlador(modelo, vista, dao);
    }
    
}