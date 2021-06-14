package com.company.Utilidad;

import com.company.Persona.Cliente;

import java.io.*;

public class Directorio {
    File file = new File("tpfinal.txt");


    public void crearCliente(Cliente cliente) {
        if (file.exists()) {
            try {
                ///Escritura
                FileWriter fw = new FileWriter("tpfinal.txt");
                ///Escritura en Json
//                    File file = new File("json_tpfinal.json");
//                    ObjectMapper mapper
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}





