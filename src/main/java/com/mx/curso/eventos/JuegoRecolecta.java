package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class JuegoRecolecta extends JPanel implements KeyListener {
    int xJugador = 50, yJugador = 150;
    int xEnemigo = 200, yEnemigo = 150;
    int xObjeto = 300, yObjeto = 100;
    int tamaño = 40;
    int velocidadEnemigo = 5;
    int puntos = 0;
    boolean juegoTerminado = false;
    Random rand = new Random();

    public JuegoRecolecta() {
        setFocusable(true);
        addKeyListener(this);
        Timer timer = new Timer(100, e -> {
            if (!juegoTerminado) {
                // Movimiento automático enemigo
                xEnemigo += velocidadEnemigo;
                if (xEnemigo < 0 || xEnemigo > getWidth() - tamaño) velocidadEnemigo *= -1;
            }
            repaint();
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(xJugador, yJugador, tamaño, tamaño);

        g.setColor(Color.RED);
        g.fillOval(xEnemigo, yEnemigo, tamaño, tamaño);

        g.setColor(Color.GREEN);
        g.fillOval(xObjeto, yObjeto, tamaño, tamaño);

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

        // Colisión con enemigo
        if (Math.abs(xJugador - xEnemigo) < tamaño && Math.abs(yJugador - yEnemigo) < tamaño) {
            juegoTerminado = true;
        }

        // Colisión con objeto
        if (Math.abs(xJugador - xObjeto) < tamaño && Math.abs(yJugador - yObjeto) < tamaño) {
            puntos++;
            xObjeto = rand.nextInt(getWidth() - tamaño);
            yObjeto = rand.nextInt(getHeight() - tamaño);
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Recolecta los Objetos");
        JuegoRecolecta panel = new JuegoRecolecta();
        ventana.add(panel);
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
