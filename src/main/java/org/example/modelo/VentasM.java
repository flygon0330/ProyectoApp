package org.example.modelo;

public class VentasM {
    private String fecha;
    private int idVendedor;
    private int idCliente;
    private String productoV;

    public VentasM() {
    }

    public VentasM(String fecha, int idVendedor, int idCliente, String productoV) {
        this.fecha = fecha;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
        this.productoV = productoV;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getProductoV() {
        return productoV;
    }

    public void setProductoV(String productoV) {
        this.productoV = productoV;
    }

    @Override
    public String toString() {
        return "Ventas " + " fecha " + fecha + " | "+ " idVendedor " + idVendedor +" | "+
                " idCliente " + idCliente + " | " + " productoV " + productoV ;
    }
}