package com.company.Persona;

public class Proveedor extends Persona{
    private String localidad;

    public Proveedor(String nombre, String domicilio, String cuit, String telefono, String email, String localidad, String apellido) {
        super(nombre, domicilio, cuit, telefono, email, apellido);
        this.localidad = localidad;
    }

    public void setLocalidad(String localidad) {
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

    public String toStringOpt(){
        return "Proveedor: " + getApellido()+ ", " + getNombre() + ". CUIT: " + getCuit();
    }
}
