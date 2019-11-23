/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silviohermida.app;

import com.silviohermida.jdbc.Database;
import com.silviohermida.pojos.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Registrar extends javax.swing.JFrame {

    /**
     * Creates new form Registrar
     */
    public Registrar() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Conectado como: "+Database.getUsuarioActual().getNombre());
        
    }
    
    public void registrar(){
        String nombre = this.campoNombre.getText();
        String apellidos = this.campoApellidos.getText();
        String password = this.campoContraseña.getText();
        String fechaNacimiento = this.campoFecha.getText();
        
        Usuario usuario = new Usuario(0, nombre, apellidos, password, fechaNacimiento, null);
        
        try{
            Database.insertarUsuario(usuario);
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error al Insertar un Usuario", "Error ", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        etiquetaApellidos = new javax.swing.JLabel();
        campoApellidos = new javax.swing.JTextField();
        etiquetaContraseña = new javax.swing.JLabel();
        campoContraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        campoFecha = new javax.swing.JTextField();
        etiquetaVacia = new javax.swing.JLabel();
        botonRegistar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(5, 2));

        etiquetaNombre.setText("Nombre");
        getContentPane().add(etiquetaNombre);
        getContentPane().add(campoNombre);

        etiquetaApellidos.setText("Apellidos");
        getContentPane().add(etiquetaApellidos);
        getContentPane().add(campoApellidos);

        etiquetaContraseña.setText("Contraseña");
        getContentPane().add(etiquetaContraseña);
        getContentPane().add(campoContraseña);

        jLabel4.setText("Fecha de Nacimiento");
        getContentPane().add(jLabel4);
        getContentPane().add(campoFecha);
        getContentPane().add(etiquetaVacia);

        botonRegistar.setText("Registar");
        getContentPane().add(botonRegistar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistar;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JPasswordField campoContraseña;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel etiquetaApellidos;
    private javax.swing.JLabel etiquetaContraseña;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaVacia;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}