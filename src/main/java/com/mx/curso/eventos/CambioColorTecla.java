package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CambioColorTecla extends JFrame implements KeyListener {

    JPanel panel;

    public CambioColorTecla() {
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel);

        addKeyListener(this);
        setSize(300, 200);
        setTitle("Cambio de color con tecla");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            panel.setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new CambioColorTecla();
    }
}
