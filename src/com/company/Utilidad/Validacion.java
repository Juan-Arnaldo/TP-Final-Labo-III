package com.company.Utilidad;

import com.company.Articulo.Articulo;
import com.company.Articulo.Marca;
import com.company.Contenedor.ContenedorArrayList;
import com.company.Local.DescTarjeta;
import com.company.Local.Descuento;
import com.company.Persona.Cliente;
import com.company.Persona.Persona;
import com.company.Persona.Proveedor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {

    public boolean validarCuitProveedor(String cuit, ArrayList<Proveedor> listaProv){
        for (Persona persona : listaProv){
            if(persona.getCuit().equals(cuit)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarCuitCliente(String cuit, ArrayList<Cliente> listaCliente){
        for (Persona persona : listaCliente){
            if(persona.getCuit().equals(cuit)) {
                return true;
            }
        }
        return false;
    }

    public boolean validacionEmailValido(String email){

        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find())
            return true;
        else
            return false;
    }

    public Descuento validacionDescuento(String metodoPago, ContenedorArrayList<DescTarjeta> listaDesc){
        Descuento aux = null;
        for (Descuento desc : listaDesc.getLista()) {
            if (desc instanceof DescTarjeta) {
                if (((DescTarjeta) desc).getNombreTarjeta().equals(metodoPago)) {
                    aux = desc;
                }
            }
        }
        return aux;
    }


    public boolean mayorQueCero(double num){
        boolean flag = false;

        if (num > 0){
            flag = true;
        }

        return flag;
    }

    public boolean compararCaracter(String nombreABuscar, String nombre){
        int cantC = nombreABuscar.length();
        char C;
        boolean flag = true;
        int i = 0;
        while (flag && i < cantC ){

            C = nombreABuscar.charAt(i);

            if (C == (nombre.toLowerCase().charAt(i)) || C == (nombre.toUpperCase().charAt(i))){
                flag = true;
            }else {
                flag = false;
            }
            i++;
        }
        return flag;
    }

    public boolean contieneSoloLetras(String cadena) {
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            // Si no está entre a y z, ni entre A y Z
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        return true;
    }


    public boolean validacionMarcaNueva(ContenedorArrayList<Marca> listaMarca, String nombre){
        boolean flag = false;
        for (Marca aux : listaMarca.getLista()){
            if(aux.getNombre().equalsIgnoreCase(nombre)){
                flag = true;
            }
        }
        return flag;
    }



}
