package com.company.Local;

import java.time.LocalDate;

public class DescTarjeta extends Descuento {
    private String nombreTarjeta;
    private LocalDate diaDeLaSemana; /// investigar e implementar classe Date

    public DescTarjeta(int porcentaje, String nombreTarjeta, String nombreDesc) {
        super(porcentaje, nombreDesc);
        this.nombreTarjeta = nombreTarjeta;
        this.diaDeLaSemana = LocalDate.now();
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public LocalDate getDiaDeLaSemana() {
        return diaDeLaSemana;
    }

    @Override
    public String toString() {
        return "Nombre del Desc: " + getNombre() +
                "\nNombre de la Tarjeta: " + nombreTarjeta +
                "\nPorcentaje: " + getPorcentaje() + " %" +
                "\nDia De La Semana: " + diaDeLaSemana;
    }
}
