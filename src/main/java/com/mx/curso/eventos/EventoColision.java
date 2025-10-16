package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventoColision extends JPanel implements KeyListener, MouseListener {

    int xJugador = 50, yJugador = 150;
    int xEnemigo = 200, yEnemigo = 150;
    int tamaño = 40;
    String mensaje = "";

    public EventoColision() {
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(xJugador, yJugador, tamaño, tamaño);

        g.setColor(Color.RED);
        g.fillOval(xEnemigo, yEnemigo, tamaño, tamaño);

        g.setColor(Color.BLACK);
        g.drawString(mensaje, 100, 50);
    }

    // KeyListener
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            xJugador += 10;
            verificarColision();
            repaint();
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    // MouseListener
    public void mousePressed(MouseEvent e) {
        xJugador = e.getX();
        yJugador = e.getY();
        verificarColision();
        repaint();
    }

    private void verificarColision() {
        if (Math.abs(xJugador - xEnemigo) < tamaño && Math.abs(yJugador - yEnemigo) < tamaño) {
            mensaje = "¡Tocaste al enemigo!";
        } else {
            mensaje = "";
        }
    }

    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Evento + Colisión");
        EventoColision panel = new EventoColision();
        ventana.add(panel);
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}

