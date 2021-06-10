package com.company;

import com.company.Articulo.Articulo;
import com.company.Local.Local;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Operacion.Venta;

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

        System.out.println("Bienvenido!");
        int op1=0;

        do{
            op1 = teclado.cargarOpMain();

            switch (op1) {
                case 1:

                    break;
                case 2:

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
                default:
                    System.out.println("Opcion erronea.\nVuelva a intentarlo.");
                    break;
            }
        }while (op1 != 9);



    }




    /*public static void loteDeClientes(ArrayList<Cliente> listaCliente){
        Cliente clien1 = new Cliente("Cristian","Puerto","2000","30000","cristian@gmail.com",0);
        listaCliente.add(clien1);
        Cliente clien2 = new Cliente("Martin","En la calle","2222","11232","martin@gmail.com",1);
        listaCliente.add(clien2);
        Cliente clien3 = new Cliente("Agus","Pasaje","333","22222","chango@gmail.com",2);
        listaCliente.add(clien3);
    }*/
}
