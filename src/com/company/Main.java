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

    }
}
