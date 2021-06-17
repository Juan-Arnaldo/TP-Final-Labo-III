package com.company;


import com.company.Json.LocalJson;
import com.company.Local.Local;
import com.company.Utilidad.Menu;
import com.company.Utilidad.Teclado;


public class Main {

    public static void main(String[] args) {

        //TODO crear un nuevo método en la clase menú que maneje el menú pricipal (sacarlo del main)

        Teclado teclado = new Teclado();
        Menu menu = new Menu();
        LocalJson json = new LocalJson();

        Local local2 = json.leerLocalArchivos();;

        Local local = json.leerLocalArchivos();

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

        System.out.println("Bienvenido!");
        int op1=0;

        do{
            op1 = teclado.cargarOpMain();

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
                    local2.getListaCajas().getElemento(0).nuevaVenta(menu.cargarNuevaVenta(local2, local2.getListaCajas().getElemento(0)), local2);
                    break;
                case 5:
                    local2.mostrarVentas();
                    break;
                case 6:
                    local2.nuevoArticulo(menu.cargarNuevoArticulo(local2));
                    break;
                case 7:

                    break;
                case 8:
                    json.guardarLocalArchivo(local2);
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
