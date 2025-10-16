package com.mx.curso.eventos;

import javax.swing.*;

public class SaludoUsuario {

    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("¿Cuál es tu nombre?");
        JOptionPane.showMessageDialog(null, "Hola " + nombre);
        System.exit(0);

    }
}