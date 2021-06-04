package com.company.Operacion;

import com.company.Articulo.Articulo;

public class Linea {
    private Articulo articulo;
    private int cantidad;
    private double totalArticulo;

    public Linea (){

    }

    public Linea(Articulo articulo, int cantidad, double totalArticulo){
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.totalArticulo = totalArticulo;
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

}
