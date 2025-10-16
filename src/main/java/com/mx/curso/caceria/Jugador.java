package com.mx.curso.caceria;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;

/**
 * Clase Jugador: Define los atributos y métodos del personaje principal.
 */
public class Jugador extends JLabel {
    // Atributos privados (Encapsulación)
    private int puntos;
    private int vidas;

    public Jugador(int x, int y) {
        this.puntos = 0;
        this.vidas = 3;

        // Configuración visual (Hereda de JLabel)
        setText("🏃");
        setFont(getFont().deriveFont(30f));
        setBounds(x, y, 40, 40); // Posición inicial y tamaño
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        setHorizontalAlignment(CENTER);
    }

    // Métodos públicos para modificar los atributos

    public void sumarPunto() {
        this.puntos++;
    }

    public void perderVida() {
        if (this.vidas > 0) {
            this.vidas--;
        }
    }

    // Getters para acceder a los atributos

    public int getPuntos() {
        return puntos;
    }

    public int getVidas() {
        return vidas;
    }

    // Método para obtener el área de colisión
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}