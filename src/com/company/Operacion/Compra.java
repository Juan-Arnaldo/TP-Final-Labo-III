package com.company.Operacion;

import com.company.Articulo.Articulo;
import com.company.Contenedor.ContenedorArrayList;
import com.company.Local.DescTarjeta;
import com.company.Local.Descuento;
import com.company.Persona.Persona;
import com.company.Utilidad.Validacion;

import java.util.ArrayList;

public class Compra extends Operacion {

    private int costo;
    private ArrayList<Linea> listaLinea; // Está presente también en Venta, mover a Operación

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
        Linea nueva = new Linea(aAgregar, cant);
        listaLinea.add(nueva);
    }


    public void mostrarVenta(ContenedorArrayList<DescTarjeta> listaDesc){
        System.out.println("Proveedor: " + getPersona().getNombre() + " " +getPersona().getApellido() + ", CUIT " + getPersona().getCuit() +
                "\nID compra: " + getIdOperacion());

        mostrarLineas();
    }
}
