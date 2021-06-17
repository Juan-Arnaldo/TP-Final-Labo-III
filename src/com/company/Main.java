package com.company;


import com.company.Articulo.Articulo;
import com.company.Json.LocalJson;
import com.company.Local.DescTarjeta;
import com.company.Local.Local;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Utilidad.Menu;
import com.company.Utilidad.Teclado;


public class Main {

    public static void main(String[] args) {

        Local local = new Local(10, "Messi", "Messi");
        local = hardcodearLocal(); // Esto descomentado hardcodea el local independientemente del archivo. Comentar la lectura para usarlo.

        Menu menu = new Menu();
      //  LocalJson json = new LocalJson();



//        local = json.leerLocalArchivos();

        menu.menuInicio(local);

      //  json.guardarLocalArchivo(local);

    }

    public static Local hardcodearLocal() {
        Local local = new Local(0, "Lo de juan", "Colon");

        Cliente cliente = new Cliente("Consumidor", "", "", "", "", "Final");
        Cliente cliente2 = new Cliente("Juan Ignacio", "asd", "222", "321", "juan@gmail.com", "Zapp");
        Cliente cliente3 = new Cliente("Martin Arnaldo", "asd", "333", "321", "juan@gmail.com", "Juan");

        Proveedor prov = new Proveedor("Consumidor", "", "", "", "", "mdp", "peton");
        Proveedor prov1 = new Proveedor("Juan Ignacio", "asd", "222", "321", "juan@gmail.com", "vidal","arnaldo");
        Proveedor prov2 = new Proveedor("Martin Arnaldo", "asd", "333", "321", "juan@gmail.com", "batan","menem");

        Articulo art1 = new Articulo("Tornillo", "asd", "dsa", 20, 50, 100);
        Articulo art2 = new Articulo("Tornillo A", "asd", "dsa", 20, 50, 50);
        Articulo art3 = new Articulo("Tornillo B", "asd", "dsa", 20, 10, 100);

        local.nuevoArticulo(art1);
        local.nuevoArticulo(art2);
        local.nuevoArticulo(art3);

        local.nuevoCliente(cliente);
        local.nuevoCliente(cliente2);
        local.nuevoCliente(cliente3);

        local.nuevoProveedor(prov);
        local.nuevoProveedor(prov1);
        local.nuevoProveedor(prov2);

        local.nuevaCaja();

        DescTarjeta d1 = new DescTarjeta(50, "Visa", "Visa 50%");
        DescTarjeta d2 = new DescTarjeta(50, "Maestro", "Maestro 50%");
        DescTarjeta d3 = new DescTarjeta(50, "Cabal", "Cabal 50%");

        local.nuevoDescuentoTarjeta(d1);
        local.nuevoDescuentoTarjeta(d2);
        local.nuevoDescuentoTarjeta(d3);

        return local;
    }
}
