package org.example.dao;
import org.example.conexion.ConexionSql;
import org.example.modelo.InventarioM;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoInventario implements DaoGeneral<Integer, InventarioM> {
    private ConexionSql conexionSql;

    public DaoInventario(){
        conexionSql = new ConexionSql();
    }
    @Override
    public boolean agregar(InventarioM elemento){
        if (conexionSql.abrir()){
            String sql = "INSERT TO productos(idProducto,producto,stock,precio,idProveedor)VALUES (?,?,?,?,?)";
            Connection enlace = conexionSql.obtener();
            try{
                PreparedStatement pstm =enlace.prepareStatement(sql);
                pstm.setInt(1,elemento.getIdProducto());
                pstm.setString(2,elemento.getProducto());
                pstm.setInt(3, elemento.getStock());
                pstm.setDouble(4, elemento.getPrecio());
                pstm.setInt(5,elemento.getIdProveedor());
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
    public List<InventarioM> consultar(){
        List<InventarioM> lista = new ArrayList<>();
        if (conexionSql.abrir()){
            String sql = "SELECT * FROM inventario";
            Connection enlace = conexionSql.obtener();
            try {
                Statement stmt = enlace.createStatement();
                ResultSet resultados =  stmt.executeQuery(sql);
                while (resultados.next()){
                    InventarioM inventarioM = new InventarioM();
                    inventarioM.setIdProducto(resultados.getInt("idProducto"));
                    inventarioM.setProducto(resultados.getString("producto"));
                    inventarioM.setStock(resultados.getInt("stock"));
                    inventarioM.setPrecio(resultados.getDouble("precio"));
                    inventarioM.setIdProveedor(resultados.getInt("idProveedor"));
                    lista.add(inventarioM);
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
    public boolean actualizar(Integer idInventario, InventarioM nuevo){
        if (conexionSql.abrir()){
            String sql = "UPDATE  inventario SET producto = ? WHERE idProducto =?";
            Connection enlace = conexionSql.obtener();
            try {
                PreparedStatement stmt = enlace.prepareStatement(sql);
                stmt.setString(1, nuevo.getProducto());
                stmt.setInt(2,idInventario);
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
    public boolean eliminar(Integer idProducto){
        if (conexionSql.abrir()){
            String sql = "DELETE FROM inventario WHERE idProducto =?";
            Connection enlace = conexionSql.obtener();
            try {
                PreparedStatement stmt =enlace.prepareStatement(sql);
                stmt.setInt(1, idProducto);
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
