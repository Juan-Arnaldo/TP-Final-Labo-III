package com.company.Operacion;

import com.company.Persona.Persona;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Operacion {
    private Persona persona;
    private LocalDate fecha;
    private LocalTime hora;
    private int idOperacion;

    public Operacion(){

    }

    public Operacion(Persona persona){
        this.persona = persona;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
    }

    public Persona getPersona() {
        return persona;
    }

    @Override
    public String toString() {
        return "Operacion N°" + idOperacion +
                "\nPersona: " + persona +
                "\nFecha: " + fecha +
                "\nHora: " + hora ;
    }
}