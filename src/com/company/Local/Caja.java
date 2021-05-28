package com.company.Local;

public class Caja {
    private int idCaja;
    private double dinero;

    public Caja(int idCaja, double dinero) {
        this.idCaja = idCaja;
        this.dinero = dinero;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    boolean cargarVenta() {
        /*  */
        return true;
    }
}
