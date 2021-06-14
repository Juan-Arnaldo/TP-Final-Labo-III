package com.company.Operacion;

import com.company.Articulo.Articulo;

import java.util.ArrayList;

public class Compra extends Operacion {

    private int costo;
    private ArrayList<Linea> listaLinea; // Está presente también en Venta, mover a Operación

    public Compra() {
        super();
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * Funcion para agregar el articulo en la lista de lineas
     * @param aAgregar
     * @param cant
     */
    public void agregarLinea(Articulo aAgregar, int cant, double total){
        Linea nueva = new Linea(aAgregar, cant);
        listaLinea.add(nueva);
    }
}
