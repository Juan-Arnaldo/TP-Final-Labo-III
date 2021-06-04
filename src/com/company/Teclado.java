package com.company;

import java.util.Scanner;

public class Teclado {
    private Scanner sc;

    public Teclado() {
        sc = new Scanner(System.in);
    }

    // Métodos de Carga para Artículos

    /**
     * Método para cargar por teclado el nombre de un artículo.
     * @return nombre - nombre del artículo cargado.
     */
    public String cargarNombreArticulo() {
        System.out.println("Ingrese el nombre del artículo: ");
        return sc.nextLine();
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




}
