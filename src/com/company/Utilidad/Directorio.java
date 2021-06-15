package com.company.Utilidad;


import com.company.Articulo.Articulo;
import com.company.Local.Descuento;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Directorio<T> {

    private ArrayList<T> listaElementos;

    public void guardarArchivo(File myFile, ArrayList<T> listaElementos) {

        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(myFile));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            gson.toJson(listaElementos, ArrayList.class, bufferedWriter);

            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public ArrayList<T> leerArchivo(File myFile) {
        ArrayList<T> lista = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile));
            Gson gson = new Gson();


            lista = gson.fromJson(bufferedReader, new TypeToken<List<Object>>(){}.getType());
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

//    private final static String archivoArticulos = "Articulos.json";
//    private final static String archivoClientes = "Clientes.json";
//    private final static String archivoProveedores = "Proveedores.json";
//    private final static String archivoDescuentos = "Descuentos.json";
//
//     //*******************************************************//
//    //***********************Articulos***********************//
//
//    /**
//     * Guarda los articulos en el archivo "archivosArticulos"
//     * @param listaArticulo
//     */
//    public void guardarArticulosArchivo(ArrayList<Articulo> listaArticulo){
//        File file = new File(archivoArticulos);
//        try{
//            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//            gson.toJson(listaArticulo, ArrayList.class, buffer);
//            buffer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Lee el archivo "archivosArticulos"
//     * @return la lista obtenida del archivo
//     */
//    public ArrayList<Articulo> leerArticulosArchivo(){
//        ArrayList<Articulo> listaArticulo = new ArrayList<>();
//        File file = new File(archivoArticulos);
//        try{
//            BufferedReader buffer = new BufferedReader(new FileReader(file));
//            Gson gson = new Gson();
//
//            listaArticulo = gson.fromJson(buffer, new TypeToken<List<Articulo>>(){}.getType());
//            buffer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return listaArticulo;
//    }
//
//     //********************************************************//
//    //************************Clientes************************//
//
//    /**
//     * Guarda los Clientes en el archivo "archivosClientes"
//     * @param listaClientes
//     */
//    public void guardarClientesArchivo(ArrayList<Cliente> listaClientes){
//        File file = new File(archivoClientes);
//        try{
//            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//            gson.toJson(listaClientes, ArrayList.class, buffer);
//            buffer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Lee el archivo"archivosClientes"
//     * @return la lista obtenida del archivo
//     */
//    public ArrayList<Cliente> leerClientesArchivo(){
//        File file = new File(archivoClientes);
//        ArrayList<Cliente> listaClientes = new ArrayList<>();
//
//        try{
//            BufferedReader buffer = new BufferedReader(new FileReader(file));
//            Gson gson = new Gson();
//
//            listaClientes = gson.fromJson(buffer, new TypeToken<List<Cliente>>(){}.getType());
//            buffer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return listaClientes;
//    }
//
//     //***********************************************************//
//    //************************Proveedores************************//
//
//    /**
//     * Guarda los proveedores en el archivo "archivoProveedores"
//     * @param listaProv
//     */
//    public void guardarProveedoresArchivo(ArrayList<Proveedor> listaProv){
//        File file = new File(archivoProveedores);
//        try{
//            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//            gson.toJson(listaProv, ArrayList.class, buffer);
//            buffer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Lee el archivo "archivosProveedores"
//     * @return la lista obtenida del archivo
//     */
//    public ArrayList<Proveedor> leerProveedoresArchivo(){
//        File file = new File(archivoProveedores);
//        ArrayList<Proveedor> listaProv = new ArrayList<>();
//
//        try{
//            BufferedReader buffer = new BufferedReader(new FileReader(file));
//            Gson gson = new Gson();
//
//            listaProv = gson.fromJson(buffer, new TypeToken<List<Proveedor>>(){}.getType());
//            buffer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return listaProv;
//    }
//
//    //***********************************************************//
//    //************************Descuento************************//
//
//    /**
//     * Guarda los descuentos en el archivo "archivoDescuentos"
//     * @param listaDesc
//     */
//    public void guardarDescuentoArchivos(ArrayList<Descuento> listaDesc){
//        File file = new File(archivoDescuentos);
//        try{
//            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//            gson.toJson(listaDesc, ArrayList.class, buffer);
//            buffer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Lee el archivo"archivosDescuentos"
//     * @return la lista obtenida del archivo
//     */
//    public ArrayList<Descuento> leerDescuentosArchivo(){
//        File file = new File(archivoDescuentos);
//        ArrayList<Descuento> lista = new ArrayList<>();
//        try{
//            BufferedReader buffer = new BufferedReader(new FileReader(file));
//            Gson gson = new Gson();
//
//            lista = gson.fromJson(buffer, new TypeToken<List<Descuento>>(){}.getType());
//            buffer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lista;
//    }
}





