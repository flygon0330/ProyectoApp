package org.example.dao;
import org.example.conexion.ConexionSql;
import org.example.modelo.ClientesM;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoClientes implements DaoGeneral<Integer, ClientesM> {
    private ConexionSql conexionSql;

public DaoClientes(){
    conexionSql = new ConexionSql();
}
@Override
public boolean agregar(ClientesM elemento){
    if (conexionSql.abrir()){
        String sql = "INSERT TO clientes(idCliente,nombre,apellido,direccion,telefono)VALUES (?,?,?,?,?)";
        Connection enlace = conexionSql.obtener();
        try{
            PreparedStatement pstm =enlace.prepareStatement(sql);
            pstm.setInt(1,elemento.getIdCliente());
            pstm.setString(2,elemento.getNombre());
            pstm.setString(3, elemento.getApellido());
            pstm.setString(4, elemento.getDirrecion());
            pstm.setInt(5,elemento.getTelefono());
            pstm.execute();
            return true;
        } catch (SQLException e){
            return false;
        } finally {
            conexionSql.cerrar();
        }
    }
    return false;
}
@Override
public List<ClientesM> consultar(){
    List<ClientesM> lista = new ArrayList<>();
    if (conexionSql.abrir()){
        String sql = "SELECT * FROM clientes";
        Connection enlace = conexionSql.obtener();
        try {
            Statement stmt = enlace.createStatement();
            ResultSet resultados =  stmt.executeQuery(sql);
            while (resultados.next()){
                ClientesM cliente = new ClientesM();
                cliente.setIdCliente(resultados.getInt("idCliente"));
                cliente.setNombre(resultados.getString("nombre"));
                cliente.setApellido(resultados.getString("apellido"));
                cliente.setDirrecion(resultados.getString("direccion"));
                cliente.setTelefono(resultados.getInt("telefono"));
                lista.add(cliente);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            conexionSql.cerrar();
        }
    }
    return lista.stream().toList();
}

@Override
    public boolean actualizar(Integer idCliente, ClientesM nuevo){
    if (conexionSql.abrir()){
        String sql = "UPDATE  clientes SET nombre = ? WHERE idCliente =?";
        Connection enlace = conexionSql.obtener();
        try {
            PreparedStatement stmt = enlace.prepareStatement(sql);
            stmt.setString(1, nuevo.getNombre());
            stmt.setInt(2,idCliente);
            stmt.executeUpdate();
return  true;
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }finally {
            conexionSql.cerrar();

        }
    }
    return false;
}

@Override
public boolean eliminar(Integer idCliente){
    if (conexionSql.abrir()){
        String sql = "DELETE FROM clientes WHERE idClientes =?";
        Connection enlace = conexionSql.obtener();
        try {
            PreparedStatement stmt =enlace.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            conexionSql.cerrar();
        }
    }
    return false;
}

}
