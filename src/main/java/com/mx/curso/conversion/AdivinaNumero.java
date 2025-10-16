package com.mx.curso.conversion;

import java.util.Scanner;

public class AdivinaNumero {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int secreto = 7;
        int intento = 0;

        System.out.println("Adivina el número (entre 1 y 10):");

        while (intento != secreto) {
            intento = input.nextInt();

            if (intento == secreto) {
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Intenta de nuevo...");
            }
        }

        System.out.println("Fin del juego");
    }
}

