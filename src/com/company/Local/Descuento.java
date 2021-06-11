package com.company.Local;

public abstract class Descuento {
    private String nombre;
    private int porcentaje;

    public Descuento(int porcentaje) {
        this.porcentaje = porcentaje;
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
