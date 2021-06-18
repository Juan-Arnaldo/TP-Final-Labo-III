package com.company;


import com.company.Articulo.Articulo;
import com.company.Articulo.Departamento;
import com.company.Articulo.Marca;
import com.company.Json.LocalJson;
import com.company.Local.DescTarjeta;
import com.company.Local.Local;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Utilidad.Menu;
import com.company.Utilidad.Teclado;


public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        LocalJson json = new LocalJson();

        /*
         * Para incializar el programa sin datos
         * Inicializar el programa con este
         */
        //Local local = hardcodearLocalVacio();

        /*
         * Para incializar el programa con datos
         * Inicializar el programa con este
         */
        Local local = hardcodearLocalLleno();

        /*
         *En caso de querer comprarbar
         * inicializar el programa con este
         */
//        Local local = json.leerLocalArchivos();

        menu.menuInicio(local);


        /*
         *Recuerde que para guardar los datos,
         * tiene que salir de todos los menu
         */
        json.guardarLocalArchivo(local);

    }

    public static Local hardcodearLocalVacio() {
        Local local = new Local(0, "Hijo", "Donde Vaya el Padre");

        Cliente cliente = new Cliente("Consumidor", "", "", "", "", "Final");
        local.nuevoCliente(cliente);

        local.nuevaCaja();

        Proveedor prov = new Proveedor("Proveedor", "", "", "", "", "MDP", "Final");
        local.nuevoProveedor(prov);

        return local;
    }

    public static Local hardcodearLocalLleno() {
        Local local = new Local(0, "Hijo", "Donde Vaya el Padre");

        Cliente cliente = new Cliente("Consumidor", "", "", "", "", "Final");
        Cliente cliente2 = new Cliente("Juan", "Madrid 912", "123456", "2235498652", "juan@gmail.com", "Gonzales");
        Cliente cliente3 = new Cliente("Mirtha", "San Martin 45", "258147", "223145974", "mirta@gmail.com", "Martinez");
        Cliente cliente4 = new Cliente("Rafael", "Dorrego 1020", "369258", "45687912", "rafael@gmail.com", "Juarez");
        Cliente cliente5 = new Cliente("Adrian", "Solis 982", "741852", "123545687", "adrian@gmail.com", "Perez");
        Cliente cliente6 = new Cliente("Juliana", "Madrid 912", "456789", "123455778", "juliana@gmail.com", "Gonzales");
        local.nuevoCliente(cliente);
        local.nuevoCliente(cliente2);
        local.nuevoCliente(cliente3);
        local.nuevoCliente(cliente4);
        local.nuevoCliente(cliente5);
        local.nuevoCliente(cliente6);

        local.nuevaCaja();

        Proveedor prov = new Proveedor("Proveedor", "", "", "", "", "MDP", "Final");
        Proveedor prov2 = new Proveedor("Juan Ignacio", "San Martin 45", "235689", "321982", "juani@gmail.com", "vidal","Arnaldo");
        Proveedor prov3 = new Proveedor("Martin Arnaldo", "Solis 982", "457812", "3217845", "marti@gmail.com", "batan","Menem");
        local.nuevoProveedor(prov);
        local.nuevoProveedor(prov2);
        local.nuevoProveedor(prov3);

        Marca marca1 = new Marca("Generica");
        Marca marca2 = new Marca("Pepito");
        local.nuevaMarca(marca1);
        local.nuevaMarca(marca2);

        Departamento departamento = new Departamento("Tornillos");
        local.nuevoDepartamento(departamento);

        Articulo art1 = new Articulo("Tornillo A", departamento, marca1, 20, 50, 100);
        Articulo art2 = new Articulo("Tornillo B", departamento, marca1, 20, 50, 50);
        Articulo art3 = new Articulo("Tornillo C", departamento, marca2, 20, 10, 100);
        local.nuevoArticulo(art1);
        local.nuevoArticulo(art2);
        local.nuevoArticulo(art3);


        DescTarjeta d1 = new DescTarjeta(50, "Visa", "Visa 50%");
        DescTarjeta d2 = new DescTarjeta(50, "Maestro", "Maestro 50%");
        DescTarjeta d3 = new DescTarjeta(50, "Cabal", "Cabal 50%");
        local.nuevoDescuentoTarjeta(d1);
        local.nuevoDescuentoTarjeta(d2);
        local.nuevoDescuentoTarjeta(d3);

        return local;
    }
}
