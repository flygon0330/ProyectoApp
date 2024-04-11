package org.example.dao;
import org.example.conexion.ConexionSql;
import org.example.modelo.ProveedoresM;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoProveedores implements DaoGeneral<Integer, ProveedoresM> {
    private ConexionSql conexionSql;

    public DaoProveedores(){
        conexionSql = new ConexionSql();
    }
    @Override
    public boolean agregar(ProveedoresM elemento){
        if (conexionSql.abrir()){
            String sql = "INSERT TO proveedores(idProveedor,productoV,precioP)VALUES (?,?,?)";
            Connection enlace = conexionSql.obtener();
            try{
                PreparedStatement pstm =enlace.prepareStatement(sql);
                pstm.setInt(1,elemento.getIdProveedor());
                pstm.setString(2,elemento.getProductoV());
                pstm.setDouble(3, elemento.getPrecioP());
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
    public List<ProveedoresM> consultar(){
        List<ProveedoresM> lista = new ArrayList<>();
        if (conexionSql.abrir()){
            String sql = "SELECT * FROM proveedores";
            Connection enlace = conexionSql.obtener();
            try {
                Statement stmt = enlace.createStatement();
                ResultSet resultados =  stmt.executeQuery(sql);
                while (resultados.next()){
                    ProveedoresM proveedoresM = new ProveedoresM();
                    proveedoresM.setIdProveedor(resultados.getInt("idProveedor"));
                    proveedoresM.setProductoV(resultados.getString("productoV"));
                    proveedoresM.setPrecioP(resultados.getDouble("precioP"));
                    lista.add(proveedoresM);
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
    public boolean actualizar(Integer idProveedores, ProveedoresM nuevo){
        if (conexionSql.abrir()){
            String sql = "UPDATE  clientes SET productoV = ? WHERE idProveedor =?";
            Connection enlace = conexionSql.obtener();
            try {
                PreparedStatement stmt = enlace.prepareStatement(sql);
                stmt.setString(1, nuevo.getProductoV());
                stmt.setInt(2,idProveedores);
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
    public boolean eliminar(Integer idProveedor){
        if (conexionSql.abrir()){
            String sql = "DELETE FROM proveedores WHERE idProveedor =?";
            Connection enlace = conexionSql.obtener();
            try {
                PreparedStatement stmt =enlace.prepareStatement(sql);
                stmt.setInt(1, idProveedor);
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
