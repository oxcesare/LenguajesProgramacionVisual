package com.mx.curso.conversion;

import java.util.Scanner;

public class EjercicioConversion01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int score = 0;
        System.out.println("¿Cuál es la capital de Francia?");
        String respuesta = input.nextLine();

        if (respuesta.equals("París")) {
            score = score + 1;
            System.out.println("¡Correcto!");
        } else {
            System.out.println("Incorrecto");
        }

        System.out.println("Tu puntuación es: " + score);
    }
}
