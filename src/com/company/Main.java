package com.company;

import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

    }

    public static Cliente crearCliente() {
        Scanner sc = new Scanner(System.in);
        String nombre, direccion;
        String telefono;
        String cuit;
        String email;
        int codInterno = 0;


        System.out.println("Ingrese el nombre del cliente: ");
        nombre = sc.nextLine();

        System.out.println("Ingrese la direccion del cliente: ");
        direccion = sc.nextLine();

        System.out.println("Ingrese el telefono del cliente: ");
        telefono = sc.next();

        System.out.println("Ingrese el cuit del cliente: ");
        cuit = sc.next();

        System.out.println("Ingrese el email del cliente: ");
        email = sc.next();


        Cliente cliente = new Cliente(nombre,direccion,cuit,telefono,email,codInterno);
        return cliente;
    }

    public static Proveedor crearProv() {
        Scanner sc = new Scanner(System.in);
        String nombre, direccion;
        String telefono;
        String cuit;
        String email;
        int codInterno = 0;
        String localidad;


        System.out.println("Ingrese el nombre del cliente: ");
        nombre = sc.nextLine();

        System.out.println("Ingrese la direccion del cliente: ");
        direccion = sc.nextLine();

        System.out.println("Ingrese el telefono del cliente: ");
        telefono = sc.next();

        System.out.println("Ingrese el cuit del cliente: ");
        cuit = sc.next();

        System.out.println("Ingrese el email del cliente: ");
        email = sc.next();

        System.out.println("Ingrese la localidad del cliente: ");
        localidad = sc.nextLine();


        Proveedor proveedor = new Proveedor(nombre,direccion,cuit,telefono,email,codInterno,localidad);
        return proveedor;
    }
}
