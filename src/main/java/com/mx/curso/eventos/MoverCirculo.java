package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoverCirculo extends JPanel implements MouseListener {

    int x = 100, y = 100;

    public MoverCirculo() {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 50, 50);
    }

    public void mouseClicked(MouseEvent e) {
        x = e.getX() - 25;
        y = e.getY() - 25;
        repaint();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Mover círculo con clic");
        MoverCirculo panel = new MoverCirculo();
        ventana.add(panel);
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
