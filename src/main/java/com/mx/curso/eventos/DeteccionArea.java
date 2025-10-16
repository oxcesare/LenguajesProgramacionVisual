package com.mx.curso.eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeteccionArea extends JPanel implements MouseListener {

    int x = 100, y = 100, ancho = 100, alto = 100;
    boolean dentro = false;

    public DeteccionArea() {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dentro) g.setColor(Color.RED);
        else g.setColor(Color.GRAY);
        g.fillRect(x, y, ancho, alto);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getX() >= x && e.getX() <= x + ancho && e.getY() >= y && e.getY() <= y + alto) {
            dentro = !dentro;
            JOptionPane.showMessageDialog(null, "¡Clic dentro del área!");
        }
        repaint();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Detección de área");
        DeteccionArea panel = new DeteccionArea();
        ventana.add(panel);
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
