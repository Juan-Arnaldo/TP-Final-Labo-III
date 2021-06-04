package com.company;

import java.util.Scanner;

public class Teclado {
    private Scanner sc = new Scanner(System.in);

    public Teclado() {
    }

    public String cargarNombreArticulo() {
        String nombre;
        System.out.println("Ingrese el nombre del artículo: ");
        nombre = sc.nextLine();
        return nombre;
    }
}
