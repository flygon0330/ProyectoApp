package org.example.vista;

import javax.swing.*;

public class InventarioV extends  JFrame{
    private JPanel Inicio;
    private JTextField tfConsulta;
    private JButton btnConsultaInv;
    private JTable table1;
    private JButton btnAgregarInv;
    private JButton btnActualizarInv;
    private JButton btnEliminarInv;
    private JButton btnRegresar;
    private JPanel Titulo;
    private JPanel Cuerpo;
    private JTextField tfidProducto;
    private JTextField tfproducto;
    private JTextField tfstock;
    private JTextField tfprecio;
    private JTextField tfproveedor;

    public InventarioV(){
        setTitle("Menu de Inventario");
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
