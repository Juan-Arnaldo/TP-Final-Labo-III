package com.company.Persona;

public class Cliente extends Persona{

    public Cliente(String nombre, String domicilio, String cuit, String telefono, String email, int codInterno) {
        super(nombre, domicilio, cuit, telefono, email, codInterno);
    }

    @Override
    public String toString() {
        return "\nCliente: "+
                "\nNombre: "+ getNombre()+
                "\nDomicilio: "+ getDomicilio()+
                "\nCuit: "+ getCuit()+
                "\nTelefono: "+ getTelefono()+
                "\nEmail: "+ getEmail();
    }
}
