package com.company.Json;

import com.company.Local.Local;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;

public class LocalJson {
    private final static String localJson = "ArchivoLocal";

    public void guardarLocalArchivo(Local local){
        File file = new File(localJson);
        try{
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            gson.toJson(local, Local.class, buffer);
            buffer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerLocalArchivos(){
        File file = new File(localJson);
        Local local = null;
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();

            local = gson.fromJson(buffer, new TypeToken<Local>(){}.getType());
            buffer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}