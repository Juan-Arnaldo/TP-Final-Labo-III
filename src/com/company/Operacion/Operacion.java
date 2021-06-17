package com.company.Operacion;

import com.company.Persona.Persona;

import java.time.LocalDate;
import java.time.LocalTime;

public class Operacion {
    private Persona persona;
    private int idOperacion;

    public Operacion(){

    }

    public Operacion(Persona persona){
        this.persona = persona;
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

    @Override
    public String toString() {
        return "Operacion N°" + idOperacion +
                "\nPersona: " + persona.getNombre() + " CUIT: " + persona.getCuit() ;
    }
}
