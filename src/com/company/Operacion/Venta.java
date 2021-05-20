package com.company.Operacion;

import java.util.ArrayList;

public class Venta extends Operacion implements ActualizacionRegistro{

    private ArrayList<Carrito> listaCarrito;

    public Venta(){

    }

    public Venta(ArrayList<Carrito> listaCarrito){
        this.listaCarrito = listaCarrito;
    }

    public ArrayList<Carrito> getListaCarrito() {
        return listaCarrito;
    }

    @Override
    public boolean actualizarCaja() {
        return false;
    }

    @Override
    public boolean actualizarStock() {
        return false;
    }
}
