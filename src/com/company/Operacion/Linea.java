package com.company.Operacion;

import com.company.Articulo.Articulo;

public class Linea {
    private Articulo articulo;
    private int cantidad;
    private double totalArticulo;

    public Linea (){

    }

    public Linea(Articulo articulo, int cantidad){
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.totalArticulo = generarPrecioFinal(articulo, cantidad);
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotalArticulo() {
        return totalArticulo;
    }

    private double generarPrecioFinal(Articulo articulo, int cantidad){ ;
        return articulo.getCosto() + ((articulo.getCosto() * articulo.getUtilidad()) / 100);
    }
}
