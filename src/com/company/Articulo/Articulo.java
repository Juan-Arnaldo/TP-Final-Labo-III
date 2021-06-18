package com.company.Articulo;

public class Articulo {
    private int idArticulo;
    private String nombre;
    private String departamento;
    private Marca marca;
    private int stock;
    private double costo;
    private double utilidad;
    private double precio;

    /**
     * Constructor de una instancia de la clase Articulo.java.
     * @param nombre
     * @param departamento
     * @param marca
     * @param costo
     * @param utilidad
     * @param stock
     */
    public Articulo(String nombre, String departamento, Marca marca, double costo, double utilidad, int stock) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.marca = marca;
        this.utilidad = utilidad;
        this.stock = stock;
        this.costo = costo;
        generarPrecio();
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
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
        generarPrecio();
    }

    public double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
        generarPrecio();
    }

    public double getPrecio() {
        return precio;
    }

    public void generarPrecio(){
        precio = costo + (costo * utilidad / 100);
    }

    @Override
    public String toString() {
        return
                "\n" + nombre +
                "\nId: " + idArticulo +
                "\nDepartamento: " + departamento +
                "\nMarca: " + marca +
                "\nStock: " + stock +
                "\nCosto: " + costo +
                "\nUtilidad: %" + utilidad +
                "\nPrecio Final: " + getPrecio() ;
    }

    public String toStringOpt(){
        return "ID: " + idArticulo + " Nombre: " + nombre + " Marca: " + getMarca().getNombre() +" Stock: " + stock;
    }
}
