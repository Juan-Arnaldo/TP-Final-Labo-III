package com.company.Operacion;

import com.company.Articulo.Articulo;
import com.company.Contenedor.ContenedorArrayList;
import com.company.Local.DescTarjeta;
import com.company.Local.Descuento;
import com.company.Persona.Persona;
import com.company.Utilidad.Validacion;

import java.util.ArrayList;

public class Compra extends Operacion {

    public Compra(Persona persona) {
        super(persona);
    }

    public double getCosto() {
        double costo = 0;

        for (Linea linea : getListaLinea().getLista()){
            costo =+ linea.getTotalLinea();
        }

        return costo;
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


    public void mostrarCompra(){
        System.out.println("\nID compra: " + getIdOperacion() + "\nProveedor: " + getPersona().getNombre() + " " +getPersona().getApellido() + ", CUIT " + getPersona().getCuit());
        mostrarLineas();
        System.out.println("\nTotal: \t\t " + getCosto());
        System.out.println("\n---------------------------------------\n");
    }
}