package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class EventoColisionPuntos extends JPanel implements KeyListener {
    int xJugador = 50, yJugador = 150;
    int xObjetivo = 200, yObjetivo = 150;
    int tamaño = 40;
    int puntos = 0;
    Random rand = new Random();

    public EventoColisionPuntos() {
        setFocusable(true);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(xJugador, yJugador, tamaño, tamaño);

        g.setColor(Color.GREEN);
        g.fillOval(xObjetivo, yObjetivo, tamaño, tamaño);

        g.setColor(Color.BLACK);
        g.drawString("Puntos: " + puntos, 10, 20);
    }

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_RIGHT) xJugador += 10;
        if (tecla == KeyEvent.VK_LEFT) xJugador -= 10;
        if (tecla == KeyEvent.VK_UP) yJugador -= 10;
        if (tecla == KeyEvent.VK_DOWN) yJugador += 10;

        // Detección de colisión con el objetivo
        if (Math.abs(xJugador - xObjetivo) < tamaño && Math.abs(yJugador - yObjetivo) < tamaño) {
            puntos++;
            xObjetivo = rand.nextInt(getWidth() - tamaño);
            yObjetivo = rand.nextInt(getHeight() - tamaño);
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Colisión + Puntos");
        EventoColisionPuntos panel = new EventoColisionPuntos();
        ventana.add(panel);
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}

