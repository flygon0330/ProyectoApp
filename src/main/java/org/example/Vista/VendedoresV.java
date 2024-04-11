package org.example.vista;

import javax.swing.*;

public class VendedoresV extends JFrame{
    private JPanel Inicio;
    private JTextField tfConsulta;
    private JButton btnConsultaVende;
    private JTable tblVendedores;
    private JButton btnEliminar;
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnRegresar;
    private JPanel Titulo;
    private JPanel Cuerpo;
    private JTextField tfidVendedor;
    private JTextField tfnombre;
    private JTextField tfhIngreso;
    private JTextField tfhSalida;
    private JTextField tfsalario;

    public VendedoresV(){
        setTitle("Menu de Empleados");
        Inicio.add(Titulo);
        Inicio.add(Cuerpo);
        setContentPane(Inicio);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1450,1500);
        setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
