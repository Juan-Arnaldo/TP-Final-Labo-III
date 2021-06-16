package com.company.Utilidad;

import com.company.Articulo.Articulo;
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

    public Descuento validacionDescuento(String metodoPago, ContenedorArrayList<Descuento> listaDesc){
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

}
