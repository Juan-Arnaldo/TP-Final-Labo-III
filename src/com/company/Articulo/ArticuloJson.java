package com.company.Articulo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloJson {
    private final static String archivoArticulos = "Articulos.json";
    /**
     * Guarda los articulos en el archivo "archivosArticulos"
     * @param listaArticulo
     */
    public void guardarArticulosArchivo(ArrayList<Articulo> listaArticulo){
        File file = new File(archivoArticulos);
        try{
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            gson.toJson(listaArticulo, ArrayList.class, buffer);
            buffer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee el archivo "archivosArticulos"
     * @return la lista obtenida del archivo
     */
    public ArrayList<Articulo> leerArticulosArchivo(){
        ArrayList<Articulo> listaArticulo = new ArrayList<>();
        File file = new File(archivoArticulos);
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();

            listaArticulo = gson.fromJson(buffer, new TypeToken<List<Articulo>>(){}.getType());
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaArticulo;
    }

}
