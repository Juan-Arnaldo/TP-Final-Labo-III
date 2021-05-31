package com.company.Operacion;

import java.util.ArrayList;

public class Venta extends Operacion{

    private ArrayList<Carrito> listaCarrito;

    public Venta(){

    }

    public Venta(ArrayList<Carrito> listaCarrito){
        this.listaCarrito = listaCarrito;
    }

    public ArrayList<Carrito> getListaCarrito() {
        return listaCarrito;
    }







    public boolean actualizarCaja() {
        return false;
    }

    public boolean actualizarStock() {
        return false;
    }
}
