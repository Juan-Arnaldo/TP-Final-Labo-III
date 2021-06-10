package com.company;

import com.company.Persona.Cliente;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Directorio {
    File file = new File("tpfinal.txt");


    public void crearCliente(Cliente cliente){
        try{
            if (file.exists()) {
                try{
                    ///Escritura
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(cliente);
                    objectOutputStream.close();

                    ///Escritura en Json
                    File file = new File("json_tpfinal.json");
                    ObjectMapper mapper
                }

            }
            else{
            }
        }
    }




}
