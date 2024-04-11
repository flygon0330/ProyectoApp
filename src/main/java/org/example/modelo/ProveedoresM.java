package org.example.modelo;

public class ProveedoresM {
    private int idProveedor;
    private String productoV;
    private double precioP;

    public ProveedoresM() {
    }

    public ProveedoresM(int idProveedor, String productoV, double precioP) {
        this.idProveedor = idProveedor;
        this.productoV = productoV;
        this.precioP = precioP;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProductoV() {
        return productoV;
    }

    public void setProductoV(String productoV) {
        this.productoV = productoV;
    }

    public double getPrecioP() {
        return precioP;
    }

    public void setPrecioP(double precioP) {
        this.precioP = precioP;
    }

    @Override
    public String toString() {
        return "Proveedores" +
                "idProveedor " + idProveedor + " | "+  " productoV " + productoV + " | " +
                "precioP " + precioP;
    }
}
