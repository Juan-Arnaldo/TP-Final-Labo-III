package com.company;

import com.company.Articulo.Articulo;
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

        Local local = new Local(0, "Lo de juan", "Colon");

        Cliente cliente = new Cliente("Juan Martin", "asd", "123", "321", "juan@gmail.com", "Arnaldo");
        Cliente cliente2 = new Cliente("Juan Ignacio", "asd", "123", "321", "juan@gmail.com", "Zapp");
        Cliente cliente3 = new Cliente("Martin Arnaldo", "asd", "123", "321", "juan@gmail.com", "Juan");

        local.getListaClientes().agregar(cliente);
        local.getListaClientes().agregar(cliente2);
        local.getListaClientes().agregar(cliente3);

        System.out.println("Bienvenido!");
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
                    break;
                case 4:

                    break;
                case 5:

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
