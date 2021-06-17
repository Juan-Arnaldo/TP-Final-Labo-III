package com.company.Articulo;

public class Marca {
    private String nombre;
    private int cont = 0;

    public Marca(String nombre){
        this.nombre = nombre;
        this.cont++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCont() {
        return cont;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre ;
    }
}
