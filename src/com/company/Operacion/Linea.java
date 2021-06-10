package com.company.Operacion;

import com.company.Articulo.Articulo;

public class Linea {
    private Articulo articulo;
    private int cantidad;
    private double totalLinea;

    public Linea (){

    }

    public Linea(Articulo articulo, int cantidad, double totalLinea){
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.totalLinea = totalLinea;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotalArticulo() {
        return totalLinea;
    }

}
