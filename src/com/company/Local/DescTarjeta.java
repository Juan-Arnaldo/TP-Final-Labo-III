package com.company.Local;

public class DescTarjeta extends Descuento {
    private String nombreTarjeta;

    public DescTarjeta(int porcentaje, String nombreTarjeta, String nombreDesc) {
        super(porcentaje, nombreDesc);
        this.nombreTarjeta = nombreTarjeta;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }


    @Override
    public String toString() {
        return "Nombre del Desc: " + getNombre() +
                "\nNombre de la Tarjeta: " + nombreTarjeta +
                "\nPorcentaje: " + getPorcentaje() + " %" ;
    }
}
