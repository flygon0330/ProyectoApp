package org.example.Controlador;
import org.example.dao.DaoClientes;
import org.example.modelo.ClientesM;
import org.example.vista.ClientesV;
import org.example.vista.MenuPrincipal;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorClientes implements ActionListener{
    private final ClientesM modelo;
    private final ClientesV vista;
    public ControladorClientes(ClientesM modelo,ClientesV vista){
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnConsultaCli.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnRegresar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (vista.btnAgregar == evento.getSource()) {
            modelo.setIdCliente(Integer.parseInt(vista.tfidClientes.getText()));
            modelo.setNombre(vista.tfNombre.getText());
            modelo.setApellido(vista.tfApellido.getText());
            modelo.setDirrecion(vista.tfDirrecion.getText());
            modelo.setTelefono(Integer.parseInt(vista.tfTelefono.getText()));
            DaoClientes dao = new DaoClientes();
            if (dao.agregar(modelo)) {
                JOptionPane.showMessageDialog(null, "Se a registrado un nuevo Cliente :)",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Fallo el intento de guardar un Cliente nuevo",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            clear();
        }
        if (vista.btnRegresar == evento.getSource()) {
            return MenuPrincipal;
        }
    }

    public void clear(){
        this.vista.tfidClientes.setText("");
        this.vista.tfNombre.setText("");
        this.vista.tfApellido.setText("");
        this.vista.tfDireccion.setText("");
        this.vista.tfTelefono.setText("");
    }
}
