package org.example.modelo;

public class ClientesM {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String dirrecion;
    private int telefono;

    public ClientesM() {
    }

    public ClientesM(int idCliente, String nombre, String apellido, String dirrecion, int telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dirrecion = dirrecion;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Clientes " + " idCliente " + idCliente + " | " +
   " nombre " + nombre + " | " + " apellido " + apellido + " | " + " dirrecion " + dirrecion + " | " + " telefono " + telefono ;
    }
}
