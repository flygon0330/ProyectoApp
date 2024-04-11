package org.example.vista;

import javax.swing.*;

public class ProveedoresV extends JFrame {
    private JPanel Inicio;
    private JPanel Cuerpo;
    private JTextField tfConsulta;
    private JButton btnConsulta;
    private JTable tblProveedores;
    private JButton btnAgregar;
    private JButton btnBorrar;
    private JButton btnActualizar;
    private JButton btnRegresar;
    private JPanel Titulo;
    private JTextField tfidProveedor;
    private JTextField tfproductoV;
    private JTextField tfprecioP;

    public ProveedoresV(){
        setTitle("Menu de Proveedores");
        Inicio.add(Titulo);
        Inicio.add(Cuerpo);
        setContentPane(Inicio);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1450,1500);
        setVisible(true);
    }
}
