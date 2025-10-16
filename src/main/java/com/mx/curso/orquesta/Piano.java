package com.mx.curso.orquesta;

public class Piano implements Instrumento {
    @Override
    public void tocar() {
        System.out.println("Tocando un Piano");
    }
}