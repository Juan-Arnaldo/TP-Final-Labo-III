package com.company;

import java.util.Scanner;

public class Teclado {
    private Scanner sc;

    public Teclado() {
        sc = new Scanner(System.in);
    }

//---------- Métodos de Carga Generales ----------

    /**
     * Método para consultar al usuario si desea continuar con lo que está realizando.
     * @return true - En caso de que desee continuar.
     * @return false - En caso de que no desee continuar.     *
     */
    public boolean deseaContinuar(){
        System.out.println("Ingrese 1 si desea continuar \n");
        int aux = sc.nextInt();
        if(aux == 1){
            return true;
        }
        return false;
    }

//---------- Métodos de Carga para Artículos ----------

    /**
     * Método para cargar por teclado el nombre de un artículo.
     * @return nombre - nombre del artículo cargado.
     */
    public String cargarNombreArticulo() {
        System.out.println("Ingrese el nombre del artículo: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar el nombre de un artículo en caso de que el nombre ingresado anteriormente no sea posible.
     * @param nombre - Nombre cargado anteriormente.
     * @return Nombre presuntamente corregido.
     */
    public String cargarNuevamenteNombreArticulo(String nombre) {
        System.out.println(nombre + " es el nombre de un artículo que ya existe en el registro.");
        System.out.println("Ingrese nuevamente el nombre del  artículo: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el departamento de un artículo.
     * @return departamento del artículo cargado.
     */
    public String cargarDepartamentoArticulo() {
        System.out.println("Ingrese el departamento del artículo: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado la marca de un artículo.
     * @return marca del artículo cargado.
     */
    public String cargarMarcaArticulo() {
        System.out.println("Ingrese la marca del artículo: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado la utilidad de un articulo.
     * @return utilidad del articulo.
     */
    public double cargarUtilidadArticulo() {
        System.out.println("Ingrese la utilidad del articulo: ");
        return sc.nextDouble();
    }

    /**
     * Método para volver a cargar la utilidad de un articulo en caso de que el valor ingresado anteriormente no sea posible.
     * @param utilidad - Utilidad cargada anteriormente.
     * @return Utilidad presuntamente corregida.
     */
    public double cargarNuevamenteUtilidadArticulo(double utilidad) {
        System.out.println(utilidad + " no es una utilidad válida. Se desea ganar dinero con las ventas.");
        System.out.println("Ingrese nuevamente la utilidad del articulo: ");
        return sc.nextDouble();
    }

    public boolean continuarCargandoArticulos(){
        System.out.println("¿Desea continuar cargando artículos?");
        System.out.println("Presione 1 si es así. En caso contrario presione cualquier otro número.");
        int aux = sc.nextInt();
        if(aux == 1){
            return true;
        }
        return false;
    }

    /**
     * Método para cargar por teclado la cantidad deseada.
     * @return cantidad deseada
     */
    public int cargarCantidadArticulo(){
        System.out.println("Ingrese la cantidad del articulo: ");
        return sc.nextInt();
    }

    /**
     * Método para volver a cargar por teclado la cantidad deseada luego de la validación fallida.
     * @return cantidad deseada
     */
    public int cargarNuevamenteCantidadArticulo(){
        System.out.println("No se puede vender la cantidad ingresada.");
        System.out.println("Ingrese nuevamente la cantidad del articulo: ");
        return sc.nextInt();
    }

    /**
     * Método para volver a cargar la cantidad de artículos en caso de que el valor ingresado anteriormente no sea posible.
     * @param cantidad - Cantidad cargada anteriormente.
     * @return Cantidad presuntamente corregida.
     */
    public int cantidadCeroONegativa(int cantidad) {
        System.out.println(cantidad + " no es una cantidad de artículos válida.");
        System.out.println("Ingrese nuevamente la cantidad del articulo: ");
        return sc.nextInt();
    }

    /**
     * Método para cargar el costo de la linea comprada.
     * @return costo de la linea.
     */
    public double cargarCostoLinea() {
        System.out.println("Ingrese el costo de la linea: ");
        return sc.nextDouble();
    }

    /**
     * Método para volver a cargar el costo de una linea en caso de que el valor ingresado anteriormente no sea posible.
     * @param costo - Cantidad cargada anteriormente.
     * @return Cantidad presuntamente corregida.
     */
    public double costoCeroONegativo(double costo) {
        System.out.println(costo + " no es un costo de línea válida.");
        System.out.println("Ingrese nuevamente el costo de la linea: ");
        return sc.nextDouble();
    }

    /**
     * Método para cargar por teclado el metodo de pago
     * @return
     */
    public int cargarMetodoPago(){
        System.out.println("1.Efectivo");
        System.out.println("\n2.Tarjeta");
        System.out.println("\n3.Cheque");
        System.out.println("\nIngrese el metodo con el que va a pagar: ");
        return sc.nextInt();
    }

    /**
     * Método para elegir cómo seguir en caso de que el nombre ingresado no corresponda a un artículo existente en los registros de local.
     * @param nombre - Nombre ingresado.
     * @return Opción elegida en forma de int. 1 - Intentar nuevamente. 2 - Agregar " + " al registro.");.
     */
    public int nombreArticuloCompradoNoExiste(String nombre) {
        System.out.println(nombre + " no corresponde a un artículo registrado.");
        System.out.println("1 - Intentar nuevamente.");
        System.out.println("2 - Agregar " + nombre + " al registro.");
        System.out.println("Seleccione acción a realizar.");
        return sc.nextInt();
    }

////---------- Métodos de Carga para Personas/Proveedores ----------

    /**
     * Método para cargar por teclado el nombre de una Persona.
     * @return nombre - nombre de la persana cargado.
     */
    public String cargarNombrePersona() {
        System.out.println("Ingrese el nombre de la persona: ");
        return sc.nextLine();
    }

}
