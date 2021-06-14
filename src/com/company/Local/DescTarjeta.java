package com.company.Local;

public class DescTarjeta extends Descuento {
    private String nombreTarjeta;
    private String diaDeLaSemana; /// investigar e implementar classe Date

    public DescTarjeta(int porcentaje, String nombreTarjeta, String diaDeLaSemana, String nombreDesc) {
        super(porcentaje, nombreDesc);
        this.nombreTarjeta = nombreTarjeta;
        this.diaDeLaSemana = diaDeLaSemana;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public String getDiaDeLaSemana() {
        return diaDeLaSemana;
    }

    public void setDiaDeLaSemana(String diaDeLaSemana) {
        this.diaDeLaSemana = diaDeLaSemana;
    }

}
