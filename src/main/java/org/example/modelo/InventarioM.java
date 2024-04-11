package org.example.modelo;

public class InventarioM {
    private int idProducto;
    private String producto;
    private int stock;
    private double precio;
    private int idProveedor;

    public InventarioM() {
    }

    public InventarioM(int idProducto, String producto, int stock, double precio, int idProveedor) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.stock = stock;
        this.precio = precio;
        this.idProveedor = idProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getIdProveedor() {return idProveedor;}
    public void setIdProveedor(int idProveedor){this.idProveedor = idProveedor;}

    @Override
    public String toString() {
    return "Inventario" + "idProducto" + idProducto +" | "+ "producto" + producto +" | "+ ", stock " + stock +" | "
            +" precio" + precio + " | " + "idProveedor" + idProveedor;
    }
}
