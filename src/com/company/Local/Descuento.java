package com.company.Local;

public abstract class Descuento {
    private String nombre;
    private int porcentaje;
    private String nombreTarjeta;

    public Descuento(int porcentaje, String nombre, String nombreTarjeta) {
        this.porcentaje = porcentaje;
        this.nombre = nombre;
        this.nombreTarjeta = nombreTarjeta;
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

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }
}
