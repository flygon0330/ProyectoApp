package controlador;
import modelo.Modelo;
import vista.Vista;
import dao.DAO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Controlador implements ActionListener{
    private final Modelo modelo;
    private final Vista vista;
    private final DAO dao;
    public Controlador(Modelo modelo, Vista vista) {
    this.modelo= modelo;
    this.vista = vista;
    this.dao= new DAO();
    this.vista.btnregistrar.addActionListener(this);
    this.vista.itemsalir.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    salir();    
    }
    });
    this.vista.checkTC.addActionListener(this);
    }
    public void salir(){
    JOptionPane.showMessageDialog(vista, "Hasta luego!", "Saliendo...", JOptionPane.INFORMATION_MESSAGE);
    vista.dispose();    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.btnregistrar) {
        String nombre = vista.campoNombre.getText();
        String apellido = vista.campoApellido.getText();
        String sexo = vista.combosexo.getSelectedItem().toString();
        int edad = (int) vista.spinneredad.getValue();
        String correo = vista.campoCorreo.getText();
        String telefono = vista.campoTelefono.getText();

        // Verifica que todos los campos estén llenos
        if (nombre.isEmpty() || apellido.isEmpty() || sexo.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡Debe completar todos los campos!", "AVISO", JOptionPane.ERROR_MESSAGE);
            return; // Sale del método sin registrar
        }

        // Verifica si el checkbox está seleccionado
        if (!vista.checkTC.isSelected()) {
            JOptionPane.showMessageDialog(null, "¡Debe aceptar los términos y condiciones!", "Oh no!", JOptionPane.WARNING_MESSAGE);
            return; // Sale del método sin registrar
        }

        // Si llegamos aquí, todos los campos están llenos y el checkbox está seleccionado
        modelo.setNombre(nombre);
        modelo.setApellido(apellido);
        modelo.setSexo(sexo);
        modelo.setEdad(edad);
        modelo.setCorreo(correo);
        modelo.setTelefono(telefono);

        if (dao.agregar(modelo)) {
            JOptionPane.showMessageDialog(null, "¡Registro guardado exitosamente!", "EXITO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "¡Upps! Error al registrar cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}

}
