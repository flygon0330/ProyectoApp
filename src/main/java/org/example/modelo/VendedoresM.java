package org.example.modelo;

public class VendedoresM {
    private int idVendedor;
    private String nombre;
    private double hIngreso;
    private double hSalida;
    private double salario;

    public VendedoresM() {
    }

    public VendedoresM(int idVendedor, String nombre, double hIngreso, double hSalida, double salario) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.hIngreso = hIngreso;
        this.hSalida = hSalida;
        this.salario = salario;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double gethIngreso() {
        return hIngreso;
    }

    public void sethIngreso(double hIngreso) {
        this.hIngreso = hIngreso;
    }

    public double gethSalida() {
        return hSalida;
    }

    public void sethSalida(double hSalida) {
        this.hSalida = hSalida;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Vendedores " + "idVendedor=" + idVendedor + " | " +
                " hIngreso " + hIngreso + " | " + "hSalida " + hSalida + "|"+ " salario " + salario;
    }
}
