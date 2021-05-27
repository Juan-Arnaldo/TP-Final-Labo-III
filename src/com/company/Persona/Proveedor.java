package com.company.Persona;

public class Proveedor extends Persona{
    private String localidad;

    public Proveedor(String nombre, String domicilio, String cuit, String telefono, String email, int codInterno, String localidad) {
        super(nombre, domicilio, cuit, telefono, email, codInterno);
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "\nCliente: "+
                "\nNombre: "+ getNombre()+
                "\nDomicilio: "+ getDomicilio()+
                "\nCuit: "+ getCuit()+
                "\nTelefono: "+ getTelefono()+
                "\nEmail: "+ getEmail()+
                "\nLocalidad: "+ localidad;
    }
}