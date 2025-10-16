package com.mx.curso.conceptos;

public class Main {
    public static void main(String[] args) {

        //Representacion de polimorfismo
        Administrativo admin = new Docente();
        admin.gestionar();

        admin = new RecursosHumanos();
        admin.gestionar();

    }
}
