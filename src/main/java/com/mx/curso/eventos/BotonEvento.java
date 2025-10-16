package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.event.*;

public class BotonEvento {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Evento de Botón");
        JButton boton = new JButton("Presionar");

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¡Has presionado el botón!");
            }
        });

        ventana.add(boton);
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
