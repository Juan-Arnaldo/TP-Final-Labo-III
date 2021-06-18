package com.company.Operacion;

import com.company.Articulo.Articulo;

public class Linea {
    private Articulo articulo;
    private int cantidad;
    private double totalLinea;

    public Linea (Articulo articulo, int cantidad, double totalLinea){
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.totalLinea = totalLinea * cantidad;
    }

    public Linea(Articulo articulo, int cantidad){
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.totalLinea = generarTotal();
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotalLinea() {
        return totalLinea;
    }

    @Override
    public String toString() {
        return + cantidad + "\t\t\t\t" + articulo.getNombre() + "\t\t\t " + totalLinea;
    }

    /**
     * Funcion para sacar el precio final del articulo
     * @return double
     */
    private double generarTotal() {
        return (articulo.getCosto() + (articulo.getCosto() * articulo.getUtilidad() / 100)) * cantidad;
    }
}
