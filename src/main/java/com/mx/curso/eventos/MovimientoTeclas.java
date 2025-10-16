package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovimientoTeclas extends JPanel implements KeyListener {

    int x = 150, y = 150;

    public MovimientoTeclas() {
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 40, 40);
    }

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_RIGHT) x += 10;
        if (tecla == KeyEvent.VK_LEFT) x -= 10;
        if (tecla == KeyEvent.VK_UP) y -= 10;
        if (tecla == KeyEvent.VK_DOWN) y += 10;
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Movimiento con teclas");
        MovimientoTeclas panel = new MovimientoTeclas();
        ventana.add(panel);
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}

