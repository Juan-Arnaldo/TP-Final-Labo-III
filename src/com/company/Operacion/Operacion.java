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

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
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
                "\nPersona: " + persona.getNombre() + " CUIT: " + persona.getCuit() +
                "\nFecha: " + fecha +
                "\nHora: " + hora ;
    }
}
