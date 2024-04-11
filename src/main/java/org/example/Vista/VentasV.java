package org.example.vista;

import javax.swing.*;

public class VentasV extends JFrame{
    private JPanel Inicio;
    private JTextField tfConsulta;
    private JButton btnConsultaVent;
    private JTable tblVentas;
    private JButton eliminarButton;
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton regresarButton;
    private JPanel Titulo;
    private JPanel Cuerpo;
    private JTextField tffecha;
    private JTextField tfidVendedor;
    private JTextField tfidCliente;
    private JTextField tfproductoV;

    public VentasV(){
setTitle("Menu de Ventas");
Inicio.add(Titulo);
Inicio.add(Cuerpo);
setContentPane(Inicio);
setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
setSize(1450,1500);
setVisible(true);
}
}
