package com.company.Articulo;

public class Articulo {
    private int idArticulo;
    private String nombre;
    private String departamento;
    private String marca;
    private int stock;
    private double costo;
    private double utilidad;
    private double precio;

    /*** Constructor para la carga real del Artículo desde Local.*/
    //TODO - Al resolver el autoincremental de idArticulo, agregarlo acá.
    public Articulo(String nombre, String departamento, String marca, double costo, double utilidad, int stock) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.marca = marca;
        this.utilidad = utilidad;
        this.stock = stock;
        this.costo = costo;
        this.precio = costo + (costo * utilidad);
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return
                 "\n" + nombre +
                ":\nId " + idArticulo +
                "\nDepartamento " + departamento +
                "\nMarca " + marca +
                "\nStock " + stock +
                "\nCosto " + costo +
                "\nUtilidad " + utilidad ;
    }

    public String toStringOpt(){
        return "ID: " + idArticulo + " Nombre: " + nombre + " Stock: " + stock;
    }
}
