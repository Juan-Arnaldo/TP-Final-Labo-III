package com.company.Local;

import com.company.Main;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Articulo.Articulo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.Main.*;

public class Local {
    private int idLocal;
    private String nombre;
    private String direccion;
    private ArrayList<Articulo> listaArticulos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Proveedor> listaProveedores;
    private ArrayList<Caja> listaCajas;


    public Local(int idLocal, String nombre, String direccion, List<Articulo> listaArticulos, List<Cliente> listaClientes, List<Proveedor> listaProveedores) {

        this.idLocal = idLocal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaArticulos = new ArrayList<Articulo>();
        this.listaClientes = new ArrayList<Cliente>();
        this.listaProveedores = new ArrayList<Proveedor>();
        this.listaCajas = listaCajas;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }


    public void cargarCliente(int idCliente){
        Cliente cliente = null;
        cliente = corroborarCliente(listaClientes, idCliente);
        if (cliente == null) {
            cliente = crearCliente();
            cliente.setCodInterno((dimArrayCliente(listaClientes))+1);
            listaClientes.add(cliente);
        } else {
            System.out.println("El cliente ya existe!!");
        }
    }

    public Integer dimArrayCliente(ArrayList<Cliente> listaClientes){
        int dimension=0;
        for(Cliente cliente: this.listaClientes){
            dimension++;
        }
        return dimension;
    }

    public Cliente corroborarCliente(ArrayList<Cliente> listaClientes, int idCliente) {
        Cliente resultado = null;
        for (Cliente cliente : this.listaClientes) {
            if (cliente.getCodInterno() == idCliente) {
                resultado = cliente;
                break;
            }
        }
        return resultado;
    }

    public void cargarProveedor(int idProv){
        Proveedor proveedor = null;
        proveedor = corroborarProv(idProv);
        if (proveedor == null) {
            proveedor = crearProv();
            proveedor.setCodInterno((dimArrayProv())+1);
            listaProveedores.add(proveedor);
        } else {
            System.out.println("El proveedor ya existe!!");
        }
    }

    public Integer dimArrayProv(){
        int dimension=0;
        for(Proveedor proveedor:listaProveedores){
            dimension++;
        }
        return dimension;
    }

    public Proveedor corroborarProv(int idProv) {
        Proveedor resultado = null;
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getCodInterno() == idProv) {
                resultado = proveedor;
                break;
            }
        }
        return resultado;
    }

    public void crearCaja(Caja caja) {
        this.listaCajas.add(caja);
    }


    @Override
    public String toString() {
        return "Local{" +
                "\nidLocal=" + idLocal +
                ", \nnombre='" + nombre + '\'' +
                ", \ndireccion='" + direccion + '\'' +
                ", \nlistaArticulos=" + listaArticulos +
                ", \nlistaClientes=" + listaClientes +
                ", \nlistaProveedores=" + listaProveedores +
                '}';
    }

}
