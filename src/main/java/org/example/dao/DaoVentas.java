package org.example.dao;
import org.example.conexion.ConexionSql;
import org.example.modelo.VentasM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoVentas implements DaoGeneral<Integer, VentasM> {
    private ConexionSql conexionSql;

    public DaoVentas(){
        conexionSql = new ConexionSql();
    }
    @Override
    public boolean agregar(VentasM elemento){
        if (conexionSql.abrir()){
            String sql = "INSERT TO ventas(fecha,idVendedor,idCliente,productoV)VALUES (?,?,?,?)";
            Connection enlace = conexionSql.obtener();
            try{
                PreparedStatement pstm =enlace.prepareStatement(sql);
                pstm.setString(1,elemento.getFecha());
                pstm.setInt(2,elemento.getIdVendedor());
                pstm.setInt(3,elemento.getIdCliente());
                pstm.setString(4,elemento.getProductoV());
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
    public List<VentasM> consultar(){
        List<VentasM> lista = new ArrayList<>();
        if (conexionSql.abrir()){
            String sql = "SELECT * FROM ventas";
            Connection enlace = conexionSql.obtener();
            try {
                Statement stmt = enlace.createStatement();
                ResultSet resultados =  stmt.executeQuery(sql);
                while (resultados.next()){
                    VentasM ventas = new VentasM();
                    ventas.setFecha(resultados.getString("fecha"));
                    ventas.setIdVendedor(resultados.getInt("idVendedor"));
                    ventas.setIdCliente(resultados.getInt("idCliente"));
                    ventas.setProductoV(resultados.getString("productoV"));
                    lista.add(ventas);
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
    public boolean actualizar(Integer idVendedor, VentasM nuevo){
        if (conexionSql.abrir()){
            String sql = "UPDATE  ventas SET fecha = ? WHERE idVendedor =?";
            Connection enlace = conexionSql.obtener();
            try {
                PreparedStatement stmt = enlace.prepareStatement(sql);
                stmt.setString(1, nuevo.getFecha());
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
            String sql = "DELETE FROM ventas WHERE idVendedor =?";
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

