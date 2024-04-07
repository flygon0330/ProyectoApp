package controlador;

import Conexion.Conexion;
import dao.DAO;
import modelo.Modelo;
import vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
    protected final Modelo modelo;
    protected final Vista vista;
    protected final Conexion conexion;
    protected final DAO dao;
    
    public Controlador(Modelo modelo, Vista vista, DAO dao) {
        this.modelo = modelo;
        this.vista = vista;
        this.dao = dao;
        conexion = new Conexion();
         
        vista.btnregistro.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent eventoRegistro){
        registrar();    
        }
        });
        
        vista.menuItemsalir.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent eventoSalida){
        cerrar();    
        }
        });
    }  

   
    private void registrar() {
        String nombre = vista.campoNombre.getText();
        String apellido = vista.campoApellido.getText();
        String sexo = (String) vista.combosexo.getSelectedItem();
        int edad = (int) vista.spinEdad.getValue();
        String correo = (String) vista.campoCorreo.getText();
        String telefono = vista.campoTelefono.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || sexo.isEmpty() || correo.isEmpty() || telefono.isEmpty() || !vista.checkTC.isSelected()){
        JOptionPane.showMessageDialog(vista, "Por favor, llene todos los campos.", "Advertencia de Registro", JOptionPane.WARNING_MESSAGE);
        return;
        }

        Modelo cliente = new Modelo(nombre, apellido, sexo, edad, correo, telefono);
        boolean exito = dao.agregar(cliente);

        if (exito) {
        JOptionPane.showMessageDialog(vista, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
        JOptionPane.showMessageDialog(vista, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cerrar() {
    JOptionPane.showMessageDialog(vista, "Hasta luego!", "Saliendo...", JOptionPane.PLAIN_MESSAGE);
    vista.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    System.out.println("Registro");   
    }
    }