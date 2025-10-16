package com.mx.curso.conceptos;

public class Docente extends Administrativo {
    @Override
    public void gestionar() {
        System.out.println("Gestionando tareas administrativas del docente.");
    }
}
