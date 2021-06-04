package com.company;

import java.util.Scanner;

public class Teclado {
    private Scanner sc;

    public Teclado() {
        sc = new Scanner(System.in);
    }

    /**
     * Método para cargar por teclado el nombre de un artículo.
     * @return nombre - nombre del artículo cargado.
     */
    public String cargarNombreArticulo() {
        String nombre;
        System.out.println("Ingrese el nombre del artículo: ");
        nombre = sc.nextLine();
        return nombre;
    }
}
