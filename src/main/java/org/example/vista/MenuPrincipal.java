package org.example.vista;

import javax.swing.*;

public class MenuPrincipal extends JFrame{
    private JPanel Inicio;
    private JPanel Titulo;
    private JButton btnInventario;
    private JButton btnVendedores;
    private JButton btnVentas;
    private JButton btnClientes;
    private JButton btnProveedores;
    private JLabel lblTitulo;
    private JPanel Cuerpo;

    public MenuPrincipal(){
        setTitle("Menu de Inicio");
        Inicio.add(Titulo);
        Inicio.add(Cuerpo);
        setContentPane(Inicio);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1450,1500);
        setVisible(true);
    }

}
