package com.company.Persona;

public class Persona {
    private String nombre;
    private String domicilio;
    private String cuit;
    private String telefono;
    private String email;
    private int codInterno;

    public Persona(String nombre, String domicilio, String cuit, String telefono, String email, int codInterno) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cuit = cuit;
        this.telefono = telefono;
        this.email = email;
        this.codInterno = codInterno;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getCuit() {
        return cuit;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getCodInterno() {
        return codInterno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCodInterno(int codInterno) {
        this.codInterno = codInterno;
    }
}
