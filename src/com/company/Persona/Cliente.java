package com.company.Persona;

public class Cliente extends Persona{

    public Cliente(String nombre, String domicilio, String cuit, String telefono, String email) {
        super(nombre, domicilio, cuit, telefono, email);
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
