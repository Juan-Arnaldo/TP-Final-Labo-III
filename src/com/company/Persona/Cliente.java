package com.company.Persona;

public class Cliente extends Persona{

    public Cliente(String nombre, String domicilio, String cuit, String telefono, String email, String apellido) {
        super(nombre, domicilio, cuit, telefono, email, apellido);
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

    public String toStringOpt(){
        return "Cliente: " + getApellido()+ ", " + getNombre() + ". CUIT: " + getCuit();
    }
}
