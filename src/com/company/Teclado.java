package com.company;

import java.util.Scanner;

public class Teclado {
    private Scanner sc = new Scanner(System.in);

    public Teclado() {
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
    public int cargarCantidadArticlo(){
        System.out.println("Ingrese la cantidad del articulo: ");
        return sc.nextInt();
    }
}
