package com.company;

import com.company.Articulo.Articulo;
import com.company.Local.Caja;
import com.company.Local.DescTarjeta;
import com.company.Local.Local;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Utilidad.Menu;
import org.xml.sax.ext.Attributes2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //TODO crear un nuevo método en la clase menú que maneje el menú pricipal (sacarlo del main)

        Menu menu = new Menu();

        File f = new File("tpfinal.txt");

        int nCaja=teclado.numeroCaja();

        Local local = new Local(nCaja, "Lo de juan", "Colon");


        Caja caja = new Caja(1, 0, local);

        Cliente cliente = new Cliente("Consumidor", "", "", "", "", "Final");
        Cliente cliente2 = new Cliente("Juan Ignacio", "asd", "222", "321", "juan@gmail.com", "Zapp");
        Cliente cliente3 = new Cliente("Martin Arnaldo", "asd", "333", "321", "juan@gmail.com", "Juan");

        Articulo art1 = new Articulo(1, "Tornillo", "asd", "dsa", 20, 50, 100, 10);
        Articulo art2 = new Articulo(2, "Tornillo A", "asd", "dsa", 20, 50, 50, 10);
        Articulo art3 = new Articulo(3, "Tornillo B", "asd", "dsa", 20, 10, 100, 10);

        local.nuevoArticulo(art1);
        local.nuevoArticulo(art2);
        local.nuevoArticulo(art3);

        local.nuevoCliente(cliente);
        local.nuevoCliente(cliente2);
        local.nuevoCliente(cliente3);

        local.nuevaCaja();

        DescTarjeta d1 = new DescTarjeta(50, "Visa", "Visa 50%");
        DescTarjeta d2 = new DescTarjeta(50, "Maestro", "Maestro 50%");
        DescTarjeta d3 = new DescTarjeta(50, "Cabal", "Cabal 50%");

        local.nuevoDescuentoTarjeta(d1);
        local.nuevoDescuentoTarjeta(d2);
        local.nuevoDescuentoTarjeta(d3);


//        System.out.println("Bienvenido caja "+nCaja+"!");

//        Directorio direcClientes = new Directorio();
//
//        direcClientes.guardarDescuentoArchivos(local.getListaDescuento().getLista());

        //local.getListaDescuento().setListaDeElementos(direcClientes.leerDescuentosArchivo());


//        direcClientes.guardarClientesArchivo(local.getListaClientes().getLista());
        Directorio directorio = new Directorio();
        local.getListaClientes().setListaDeElementos(directorio.leerArchivo(new File("Clientes.json")));

        System.out.println("Bienvenido!");
        int op1=0;

        do{
            op1 = menu.cargarOpMain();

            switch (op1) {
                case 1:
                    local.nuevoCliente(menu.cargarNuevoCliente(local));
                    break;
                case 2:
                    local.mostrarListaClienteOptimizada();
                    break;
                case 3:
                    local.nuevoDescuentoTarjeta(menu.cargarNuevoDescuentoTarjeta(local));
                    local.mostrarDescuentos();
                    break;
                case 4:
                    caja.cargaVenta(menu.cargarNuevaVenta(local, local.getListaCajas().getElemento(0)));
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
