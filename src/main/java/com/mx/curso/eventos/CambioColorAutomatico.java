package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CambioColorAutomatico extends JPanel {

    Timer temporizador;
    Color colorActual = Color.RED;

    public CambioColorAutomatico() {
        temporizador = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colorActual = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
                repaint();
            }
        });
        temporizador.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colorActual);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Cambio de color automático");
        CambioColorAutomatico panel = new CambioColorAutomatico();
        ventana.add(panel);
        ventana.setSize(300, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
