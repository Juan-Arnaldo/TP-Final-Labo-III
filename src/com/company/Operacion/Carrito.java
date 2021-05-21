package com.company.Operacion;

import com.company.Articulo.Articulo;

import java.util.ArrayList;

public class Carrito {
    private int idCarrito;
    private ArrayList<Articulo> listaCarrito;
    private double precioFinal;

    public Carrito(){

    }

    public Carrito(ArrayList<Articulo> listaCarrito){
        this.listaCarrito = listaCarrito;
    }



}
