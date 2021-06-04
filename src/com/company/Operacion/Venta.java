package com.company.Operacion;

import com.company.Articulo.Articulo;

import java.util.ArrayList;

public class Venta {
    private int idVenta = 0;
    private int idCaja;
    private String metodoPago;
    private ArrayList<Linea> listaLinea;

    public Venta(){

    }

    public Venta(int idCaja, String metodoPago){
        idVenta ++;
        this.idCaja = idCaja;
        this.metodoPago = metodoPago;
        this.listaLinea = new ArrayList<Linea>();
    }

    private double generarPrecioFinal(Articulo articulo, int cantidad){ ;
        return articulo.getCosto() + ((articulo.getCosto() * articulo.getUtilidad()) / 100);
    }

    public void agregarArticulo(Articulo aAgregar, int cant){
            Linea nueva = new Linea(aAgregar, cant, generarPrecioFinal(aAgregar, cant));
            listaLinea.add(nueva);
        }


}
