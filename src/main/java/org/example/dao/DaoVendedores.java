package org.example.dao;
import org.example.conexion.ConexionSql;
import org.example.modelo.VendedoresM;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoVendedores implements DaoGeneral<Integer, VendedoresM> {
    private ConexionSql conexionSql;

    public DaoVendedores(){
        conexionSql = new ConexionSql();
    }
    @Override
    public boolean agregar(VendedoresM elemento){
        if (conexionSql.abrir()){
            String sql = "INSERT TO vendedores(idVendedor,hIngreso,hSalida,salario,nombre)VALUES (?,?,?,?,?)";
            Connection enlace = conexionSql.obtener();
            try{
                PreparedStatement pstm =enlace.prepareStatement(sql);
                pstm.setInt(1,elemento.getIdVendedor());
                pstm.setDouble(3,elemento.gethIngreso());
                pstm.setDouble(4, elemento.gethSalida());
                pstm.setDouble(5,elemento.getSalario());
                pstm.setString(2, elemento.getNombre());
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
    public List<VendedoresM> consultar(){
        List<VendedoresM> lista = new ArrayList<>();
        if (conexionSql.abrir()){
            String sql = "SELECT * FROM vendedores";
            Connection enlace = conexionSql.obtener();
            try {
                Statement stmt = enlace.createStatement();
                ResultSet resultados =  stmt.executeQuery(sql);
                while (resultados.next()){
                    VendedoresM vendedoresM = new VendedoresM();
                    vendedoresM.setIdVendedor(resultados.getInt("idVendedor"));
                    vendedoresM.sethIngreso(resultados.getDouble("hIngreso"));
                    vendedoresM.sethSalida(resultados.getDouble("hSalida"));
                    vendedoresM.setSalario(resultados.getDouble("salario"));
                    vendedoresM.setNombre(resultados.getString("nombre"));
                    lista.add(vendedoresM);
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
    public boolean actualizar(Integer idVendedor, VendedoresM nuevo){
        if (conexionSql.abrir()){
            String sql = "UPDATE  vendedores SET nombre =? WHERE idVendedor =?";
            Connection enlace = conexionSql.obtener();
            try {
                PreparedStatement stmt = enlace.prepareStatement(sql);
                stmt.setString(1, nuevo.getNombre());
                stmt.setInt(2,idVendedor);
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
    public boolean eliminar(Integer idVendedor){
        if (conexionSql.abrir()){
            String sql = "DELETE FROM vendedores WHERE idVendedor =?";
            Connection enlace = conexionSql.obtener();
            try {
                PreparedStatement stmt =enlace.prepareStatement(sql);
                stmt.setInt(1, idVendedor);
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
