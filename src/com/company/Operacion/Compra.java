package com.company.Operacion;

import com.company.Articulo.Articulo;
import com.company.Contenedor.ContenedorArrayList;
import com.company.Persona.Persona;

import java.util.ArrayList;

public class Compra extends Operacion {

    private int costo;

    public Compra(Persona persona) {
        super(persona);
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
        Linea nueva = new Linea(aAgregar, cant, total);
        super.getListaLinea().agregar(nueva);
    }
}
