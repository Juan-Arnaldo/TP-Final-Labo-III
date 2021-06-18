package com.company.Operacion;

import com.company.Contenedor.ContenedorArrayList;
import com.company.Persona.Persona;

import java.time.LocalDate;
import java.time.LocalTime;

public class Operacion {
    private Persona persona;
    private int idOperacion;
    private ContenedorArrayList<Linea> listaLinea;

    public Operacion(){

    }

    public Operacion(Persona persona){
        this.persona = persona;
        this.listaLinea = new ContenedorArrayList<>();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public ContenedorArrayList<Linea> getListaLinea() {
        return listaLinea;
    }

    public void setListaLinea(ContenedorArrayList<Linea> listaLinea) {
        this.listaLinea = listaLinea;
    }

    @Override
    public String toString() {
        return "Operacion N°" + idOperacion +
                "\nPersona: " + persona.getNombre() + " CUIT: " + persona.getCuit() ;
    }


    public void mostrarLineas() {
        System.out.println("Cantidad \t Nombre Articulo \t Precio");
        for (Linea linea : getListaLinea().getLista()){
            System.out.println(linea.toString());
        }
    }
}
