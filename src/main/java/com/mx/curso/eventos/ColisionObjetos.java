package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColisionObjetos extends JPanel implements KeyListener {

    int xJugador = 50, yJugador = 150;
    int xEnemigo = 200, yEnemigo = 150;
    int tamaño = 40;
    boolean colision = false;

    public ColisionObjetos() {
        setFocusable(true);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(xJugador, yJugador, tamaño, tamaño);

        g.setColor(Color.RED);
        g.fillOval(xEnemigo, yEnemigo, tamaño, tamaño);

        if (colision) {
            g.setColor(Color.BLACK);
            g.drawString("¡Colisión detectada!", 120, 50);
        }
    }

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_RIGHT) xJugador += 10;
        if (tecla == KeyEvent.VK_LEFT) xJugador -= 10;

        // Detección de colisión
        colision = Math.abs(xJugador - xEnemigo) < tamaño && Math.abs(yJugador - yEnemigo) < tamaño;
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Colisión entre objetos");
        ColisionObjetos panel = new ColisionObjetos();
        ventana.add(panel);
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}

