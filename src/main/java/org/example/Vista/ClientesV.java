package org.example.vista;

import javax.swing.*;

public class ClientesV extends JFrame{
    private JPanel Inicio;
    private JTextField tfidCliente;
    private JButton btnConsultaCli;
    private JTable tblClientes;
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnRegresar;
    private JPanel Titulo;
    private JPanel Cuerpo;
    private JTextField tfDireccion;
    private JTextField tfTelefono;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblDireccion;
    private JLabel lblTelefono;
    private JTextField tfConsulta;

    public ClientesV(){
        setTitle("Menu de Clientes");
        Inicio.add(Titulo);
        Inicio.add(Cuerpo);
        setContentPane(Inicio);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1450,1500);
        setVisible(true);
    }
}
