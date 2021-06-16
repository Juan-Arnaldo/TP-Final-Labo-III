package com.company;

import com.company.Articulo.Articulo;
import com.company.Json.LocalJson;
import com.company.Local.Caja;
import com.company.Local.DescTarjeta;
import com.company.Local.Local;
import com.company.Persona.Cliente;
import com.company.Utilidad.Menu;

public class Main {

    public static void main(String[] args) {

        //TODO crear un nuevo método en la clase menú que maneje el menú pricipal (sacarlo del main)

        Menu menu = new Menu();

//        Local local = new Local(0, "Lo de juan", "Colon");
//
//
//        Caja caja = new Caja(0, 0, 0);
//
//        Cliente cliente = new Cliente("Consumidor", "", "", "", "", "Final");
//        Cliente cliente2 = new Cliente("Juan Ignacio", "asd", "222", "321", "juan@gmail.com", "Zapp");
//        Cliente cliente3 = new Cliente("Martin Arnaldo", "asd", "333", "321", "juan@gmail.com", "Juan");
//
//        Articulo art1 = new Articulo(1, "Tornillo", "asd", "dsa", 20, 50, 100, 10);
//        Articulo art2 = new Articulo(2, "Tornillo A", "asd", "dsa", 20, 50, 50, 10);
//        Articulo art3 = new Articulo(3, "Tornillo B", "asd", "dsa", 20, 10, 100, 10);
//
//        local.nuevoArticulo(art1);
//        local.nuevoArticulo(art2);
//        local.nuevoArticulo(art3);
//
//        local.nuevoCliente(cliente);
//        local.nuevoCliente(cliente2);
//        local.nuevoCliente(cliente3);
//
//        local.nuevaCaja();
//
//        DescTarjeta d1 = new DescTarjeta(50, "Visa", "Visa 50%");
//        DescTarjeta d2 = new DescTarjeta(50, "Maestro", "Maestro 50%");
//        DescTarjeta d3 = new DescTarjeta(50, "Cabal", "Cabal 50%");
//
//        local.nuevoDescuentoTarjeta(d1);
//        local.nuevoDescuentoTarjeta(d2);
//        local.nuevoDescuentoTarjeta(d3);

        LocalJson json = new LocalJson();

//        json.guardarLocalArchivo(local);

        Local local2 = new Local();
        local2 = json.leerLocalArchivos();

<<<<<<< HEAD
        menu.menuInicio(local);

//        System.out.println("Bienvenido!");
//        int op1=0;
//
//        do{
//            op1 = menu.cargarOpcionMenuInicio();
//
//            switch (op1) {
//                case 1:
//                    local.nuevoCliente(menu.cargarNuevoCliente(local));
//                    break;
//                case 2:
//                    local.mostrarListaClienteOptimizada();
//                    break;
//                case 3:
//                    local.nuevoDescuentoTarjeta(menu.cargarNuevoDescuentoTarjeta(local));
//                    local.mostrarDescuentos();
//                    break;
//                case 4:
//                    caja.cargaVenta(menu.cargarNuevaVenta(local, local.getListaCajas().getElemento(0)));
//                    break;
//                case 5:
//                    local.mostrarVentas();
//                    break;
//                case 6:
//
//                    break;
//                case 7:
//
//                    break;
//                case 8:
//
//                    break;
//                case 9:
//                    System.out.println("Saliendo..");
//                    break;
//                default:
//                    System.out.println("Opcion erronea.\nVuelva a intentarlo.");
//                    break;
//            }
//        }while (op1 != 9);
=======
        System.out.println("Bienvenido!");
        int op1=0;

        do{
            op1 = menu.cargarOpMain();

            switch (op1) {
                case 1:
                    local2.nuevoCliente(menu.cargarNuevoCliente(local2));
                    break;
                case 2:
                    local2.mostrarListaClienteOptimizada();
                    break;
                case 3:
                    local2.nuevoDescuentoTarjeta(menu.cargarNuevoDescuentoTarjeta(local2));
                    local2.mostrarDescuentos();
                    break;
                case 4:
                    local2.getListaCajas().getElemento(0).cargaVenta(menu.cargarNuevaVenta(local2, local2.getListaCajas().getElemento(0)), local2);
                    break;
                case 5:
                    local2.mostrarVentas();
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
>>>>>>> develop



    }


}
