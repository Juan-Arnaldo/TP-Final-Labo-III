package com.company.Local;

import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Articulo.Articulo;

import java.util.ArrayList;

public class Local {
    private int idLocal;
    private String nombre;
    private String direccion;
    private ArrayList<Articulo> listaArticulos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Proveedor> listaProveedores;
    private ArrayList<Caja> listaCajas;

    public Local(int idLocal, String nombre, String direccion, ArrayList<Articulo> listaArticulos, ArrayList<Cliente> listaClientes, ArrayList<Proveedor> listaProveedores, ArrayList<Caja> listaCajas) {
        this.idLocal = idLocal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaArticulos = listaArticulos;
        this.listaClientes = listaClientes;
        this.listaProveedores = listaProveedores;
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


    /*public void cargarCliente(ArrayList<Cliente> listaClientes, int idCliente){
        Cliente cliente;
        cliente = corroborarCliente(listaClientes, idCliente);
        if (cliente == null) {
            cliente = Main.crearCliente();
            cliente.setCodInterno((dimArrayCliente(listaClientes))+1);
            listaClientes.add(cliente);
        } else {
            System.out.println("El cliente ya existe!!");
        }
    }*/

    public Integer dimArrayCliente(ArrayList<Cliente> listaClientes){
        int dimension=0;
        for(Cliente cliente:listaClientes){
            dimension++;
        }
        return dimension;
    }

    public Cliente corroborarCliente(ArrayList<Cliente> listaClientes, int idCliente) {
        Cliente resultado = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCodInterno() == idCliente) {
                resultado = cliente;
                break;
            }
        }
        return resultado;
    }

    /*public void cargarProveedor(ArrayList<Proveedor> listaProveedores, int idProv){
        Proveedor proveedor;
        proveedor = corroborarProv(listaProveedores, idProv);
        if (proveedor == null) {
            proveedor = cargarProv();
            proveedor.setCodInterno((dimArrayProv(listaProveedores))+1);
            listaProveedores.add(proveedor);
        } else {
            System.out.println("El proveedor ya existe!!");
        }
    }*/

    public Integer dimArrayProv(ArrayList<Proveedor> listaProveedores){
        int dimension=0;
        for(Proveedor proveedor:listaProveedores){
            dimension++;
        }
        return dimension;
    }

    public Proveedor corroborarProv(ArrayList<Proveedor> listaProveedores, int idProv) {
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

    /**
     * Metodo para buscar un Articulo en especial por nombre
     * @param nombre
     * @return Objeto a Buscar
     */
    public Articulo buscarArticuloNombre(String nombre){
        Articulo aux = null;
        for (Articulo aBuscar : listaArticulos){
            if(aBuscar.getNombre().equals(nombre)){
                aux = aBuscar;
            }
        }
        return aux;
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
