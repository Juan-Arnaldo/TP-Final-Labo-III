package com.company.Operacion;

import com.company.Articulo.Articulo;

import java.util.ArrayList;


public class Venta {
    private int idVenta = 0;
    private int idCaja;
    private String metodoPago;

    public Venta(){

    }

    public Venta(int idCaja, String metodoPago){
        idVenta ++;
        this.idCaja = idCaja;
        this.metodoPago = metodoPago;
    }

    private double generarPrecioFinal(Articulo articulo, int cantidad){ ;
        return articulo.getCosto() + ((articulo.getCosto() * articulo.getUtilidad()) / 100);
    }

    public void agregarArticulo(ArrayList<Linea> listaLineas,String metodoPago){
        Articulo aAgregar = buscarArticulo();
        int cant = cargarCantidadArticulo(aAgregar);
        if(cant != 0){
            Linea nueva = new Linea(aAgregar, cant);
            listaLineas.add(nueva);
        }
    }
}
