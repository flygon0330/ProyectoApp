package dao;

import modelo.Modelo;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;


public class DAO implements DAOGeneral<Integer, Modelo> {
    private Conexion conexion;

    public DAO() {
     conexion = new Conexion();
    }

     @Override
    public boolean agregar(Modelo elemento) {
    String sentencia = "INSERT INTO clientes(nombre, apellido, sexo, edad, correo , telefono) VALUES (?, ?, ?, ?, ?,?)";
    Connection enlace = conexion.getConn();
    try {
    PreparedStatement pstm = enlace.prepareStatement(sentencia);
    pstm.setString(1, elemento.getNombre());
    pstm.setString(2, elemento.getApellido());
    pstm.setString(3, elemento.getSexo());
    pstm.setInt(4, elemento.getEdad());
    pstm.setString(5, elemento.getCorreo());
    pstm.setString(6, elemento.getTelefono());
    pstm.executeUpdate();
    return true;
    } catch(SQLException e) { 
    e.printStackTrace();
    return false;
    } 
    }

    @Override
    public List<Modelo> consultar(){
    List<Modelo> lista = new ArrayList<>();
    if(conexion.abrir()) {
    String sql = "SELECT * FROM clientes";
    Connection enlace = conexion.obtener();
    try{
    Statement stmt = enlace.createStatement();
    ResultSet resultados = stmt.executeQuery(sql);
    while(resultados.next()) { 
    Modelo modelo = new Modelo();
    modelo.setId(resultados.getInt("id"));
    modelo.setNombre(resultados.getString("nombre"));
    lista.add(modelo);
    }
    } catch (SQLException e){
    throw new RuntimeException(e);    
    } finally { 
    conexion.cerrar();
    }
    }return lista.stream().toList();
    }

    @Override
    public boolean actualizar(Integer id, Modelo nuevo) {
    if(conexion.abrir()){
    String sql ="UPDATE modelo SET nombre=? WHERE id=?";
    Connection enlace = conexion.obtener();
    try{
    PreparedStatement stmt = enlace.prepareStatement(sql);
    stmt.setString(1,nuevo.getNombre());
    stmt.setInt(2, id);
    stmt.executeUpdate();
    return true;
    }catch(SQLException e){
    throw new RuntimeException(e);    
    } finally {
    conexion.cerrar();
    }
    }
    return false;
    }
    @Override
    public boolean eliminar(Integer id) {
    if(conexion.abrir()){
    String sql = "DELETE FROM clientes WHERE id=?";
    Connection con = conexion.obtener();
    try{
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setInt(1, id);
    statement.executeUpdate();
    return true;
    }catch (SQLException e){
    throw new RuntimeException(e);    
    }finally {
    conexion.cerrar();
    }
    } 
    return false;
    }
}    