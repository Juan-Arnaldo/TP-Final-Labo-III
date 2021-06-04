package com.company;

import com.company.Articulo.Articulo;
import com.company.Local.Local;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Operacion.Venta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Articulo> listaArticulo = new ArrayList<Articulo>();
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        List<Proveedor> listaProveedor = new ArrayList<Proveedor>();

        Local local = new Local(0,"Lo de juan","Colon",listaArticulo,listaCliente,listaProveedor);

        Venta a = new Venta();
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

    public static void loteDeClientes(ArrayList<Cliente> listaCliente){
        Cliente clien1 = new Cliente("Cristian","Puerto","2000","30000","cristian@gmail.com",0);
        listaCliente.add(clien1);
        Cliente clien2 = new Cliente("Martin","En la calle","2222","11232","martin@gmail.com",1);
        listaCliente.add(clien2);
        Cliente clien3 = new Cliente("Agus","Pasaje","333","22222","chango@gmail.com",2);
        listaCliente.add(clien3);
    }



}
