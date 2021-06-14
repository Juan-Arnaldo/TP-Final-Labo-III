package com.company;

import com.company.Articulo.Articulo;
import com.company.Local.Caja;
import com.company.Local.DescTarjeta;
import com.company.Local.Local;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Utilidad.Teclado;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Teclado teclado = new Teclado();

        List<Articulo> listaArticulo = new ArrayList<Articulo>();
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        List<Proveedor> listaProveedor = new ArrayList<Proveedor>();

        File f = new File("tpfinal.txt");

        int nCaja=teclado.numeroCaja();

        Local local = new Local(nCaja, "Lo de juan", "Colon");


        Caja caja = new Caja(1, 0, local);

        Cliente cliente = new Cliente("Juan Martin", "asd", "111", "321", "juan@gmail.com", "Arnaldo");
        Cliente cliente2 = new Cliente("Juan Ignacio", "asd", "222", "321", "juan@gmail.com", "Zapp");
        Cliente cliente3 = new Cliente("Martin Arnaldo", "asd", "333", "321", "juan@gmail.com", "Juan");

        Articulo art1 = new Articulo(1, "Tornillo", "asd", "dsa", 20, 50, 100, 10);
        Articulo art2 = new Articulo(2, "Tornillo A", "asd", "dsa", 20, 50, 50, 10);
        Articulo art3 = new Articulo(3, "Tornillo B", "asd", "dsa", 20, 10, 100, 10);

        local.getListaArticulos().agregar(art1);
        local.getListaArticulos().agregar(art2);
        local.getListaArticulos().agregar(art3);

        local.getListaClientes().agregar(cliente);
        local.getListaClientes().agregar(cliente2);
        local.getListaClientes().agregar(cliente3);

        DescTarjeta d1 = new DescTarjeta(50, "Visa", "d1");
        DescTarjeta d2 = new DescTarjeta(50, "Maestro", "d2");
        DescTarjeta d3 = new DescTarjeta(50, "Cabal", "d3");

        local.getListaDescuento().agregar(d1);
        local.getListaDescuento().agregar(d2);
        local.getListaDescuento().agregar(d3);

        System.out.println("Bienvenido caja "+nCaja+"!");
        int op1=0;

        do{
            op1 = teclado.cargarOpMain();

            switch (op1) {
                case 1:
                    local.crearCliente();
                    break;
                case 2:
                    local.mostrarListaClienteOptimizada();
                    break;
                case 3:
                    local.agregarDescuentoTarjeta();
                    local.mostrarDescuentos();
                    break;
                case 4:
                    caja.cargaVenta();
                    break;
                case 5:
                    local.mostrarVentas();
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("Opcion erronea.\nVuelva a intentarlo.");
                    break;
            }
        }while (op1 != 9);



    }


}
