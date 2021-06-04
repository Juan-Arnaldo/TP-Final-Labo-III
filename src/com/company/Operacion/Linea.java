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
