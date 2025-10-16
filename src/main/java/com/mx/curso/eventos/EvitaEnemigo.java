package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class EvitaEnemigo extends JPanel implements KeyListener {
    int xJugador = 50, yJugador = 150;
    int xEnemigo = 200, yEnemigo = 150;
    int tamaño = 40;
    int velocidadEnemigo = 5;
    int puntos = 0;
    boolean juegoTerminado = false;

    public EvitaEnemigo() {
        setFocusable(true);
        addKeyListener(this);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (!juegoTerminado) puntos++;
                repaint();
            }
        }, 0, 1000);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(xJugador, yJugador, tamaño, tamaño);

        g.setColor(Color.RED);
        g.fillOval(xEnemigo, yEnemigo, tamaño, tamaño);

        g.setColor(Color.BLACK);
        g.drawString("Puntos: " + puntos, 10, 20);

        if (juegoTerminado) {
            g.drawString("¡Perdiste! Puntos: " + puntos, 120, 50);
        }
    }

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (!juegoTerminado) {
            if (tecla == KeyEvent.VK_RIGHT) xJugador += 10;
            if (tecla == KeyEvent.VK_LEFT) xJugador -= 10;
            if (tecla == KeyEvent.VK_UP) yJugador -= 10;
            if (tecla == KeyEvent.VK_DOWN) yJugador += 10;
        }

        // Movimiento automático del enemigo
        xEnemigo += velocidadEnemigo;
        if (xEnemigo < 0 || xEnemigo > getWidth() - tamaño) velocidadEnemigo *= -1;

        // Detección de colisión
        if (Math.abs(xJugador - xEnemigo) < tamaño && Math.abs(yJugador - yEnemigo) < tamaño) {
            juegoTerminado = true;
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Evita al Enemigo");
        EvitaEnemigo panel = new EvitaEnemigo();
        ventana.add(panel);
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
