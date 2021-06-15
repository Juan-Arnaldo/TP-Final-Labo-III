package com.company.Local;

public abstract class Descuento {
    private int idDescuento;
    private String nombreDesc;
    private int porcentaje;

    public Descuento(int porcentaje, String nombreDesc) {
        this.porcentaje = porcentaje;
        this.nombreDesc = nombreDesc;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombreDesc;
    }

    public void setNombre(String nombre) {
        this.nombreDesc = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreDesc +
                "\nPorcentaje: " + porcentaje;
    }
}
