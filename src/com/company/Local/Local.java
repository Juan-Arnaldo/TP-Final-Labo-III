package com.company.Local;

import com.company.Operacion.Compra;
import com.company.Operacion.MetodoPago;
import com.company.Operacion.Operacion;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Articulo.Articulo;
import com.company.Teclado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Local {
    private int idLocal;
    private String nombre;
    private String direccion;
    private ArrayList<Articulo> listaArticulos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Proveedor> listaProveedores;
    private ArrayList<Caja> listaCajas;
    private ArrayList<Operacion> listaOperacion;
    private ArrayList<Descuento> listaDescuento;


    public Local(int idLocal, String nombre, String direccion) {

        this.idLocal = idLocal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaArticulos = new ArrayList<Articulo>();
        this.listaClientes = new ArrayList<Cliente>();
        this.listaProveedores = new ArrayList<Proveedor>();
        this.listaCajas = new ArrayList<Caja>();
        this.listaOperacion = new ArrayList<Operacion>();
        this.listaDescuento = new ArrayList<Descuento>();
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

    public ArrayList<Operacion> getListaOperacion() {
        return listaOperacion;
    }

    public void setListaOperacion(ArrayList<Operacion> listaOperacion) {
        this.listaOperacion = listaOperacion;
    }

    public ArrayList<Descuento> getListaDescuento() {
        return listaDescuento;
    }

    public void setListaDescuento(ArrayList<Descuento> listaDescuento) {
        this.listaDescuento = listaDescuento;
    }

    /**
     * Metodo para la creacion de cliente, carga de sus datos y lo agrega a la lista
     * @return El cliente cargado
     */
    public void crearCliente(){
        Teclado teclado = new Teclado();

        String nombre = teclado.cargarNombre();
        String direc = teclado.cargarDireccion();
        String cuit = teclado.cargarCuit();
        String tel = teclado.cargarTelefono();
        String correo = teclado.cargarEmail();

        Cliente cliente = new Cliente(nombre, direc, cuit, tel, correo);
        listaClientes.add(cliente);
    }

    /**
     * Metodo para la creacion de proveedor y carga de sus datos
     * @return El proveedor cargado
     */

    public Proveedor crearProv(){
        Teclado teclado = new Teclado();

        String nombre = teclado.cargarNombre();
        String direc = teclado.cargarDireccion();
        String cuit = teclado.cargarCuit();
        String tel = teclado.cargarTelefono();
        String correo = teclado.cargarEmail();
        String localidad = teclado.cargarLocalidad();

        Proveedor prov = new Proveedor(nombre, direc, cuit, tel, correo, localidad);
        listaProveedores.add(prov);

        return prov;
    }

    /**
     * Metodo para buscar un cliente de la lista de clientes conociendo su Id.
     * @return cliente buscado.
     * @param cuitCliente Id del cliente a buscar.
     */
    public Cliente corroborarCliente(String cuitCliente){
        Cliente resultado = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCuit() == cuitCliente) {
                resultado = cliente;
                break;
            }
        }
        return resultado;
    }

    /**
     * Metodo para mostrar una lista de clientes optimizada
     */

    public void mostrarListaClienteOptimizada(){
        Teclado teclado = new Teclado();
        String nombre = teclado.cargarNombre();
        for (Cliente aux : listaClientes){
            if (aux.getNombre() == nombre){
                aux.toStringOpt();
            }
        }
    }

    /**
     * Se le muestra una lista de clientes y se ingresa el CUIT del cliente para retornar
     * @return El cliente seleccionado
     */
    public Cliente buscarCliente(){
        Teclado teclado = new Teclado();
        Cliente cliente = null;
        mostrarListaClienteOptimizada();
        String CUIT = teclado.cargarCuit();
        for (Cliente aux : listaClientes){
            if(aux.getCuit() == CUIT){
                cliente = aux;
            }
        }

        return cliente;
    }

    /**
     * Metodo para buscar un proveedor de la lista de proveedores conociendo su Id.
     * @return proveedor buscado.
     * @param cuitProv Id del proveedor a buscar.
     */
    public Proveedor corroborarProv(String cuitProv){
        Proveedor resultado = null;
        for (Proveedor proveedor : this.listaProveedores) {
            if (proveedor.getCuit() == cuitProv) {
                resultado = proveedor;
                break;
            }
        }
        return resultado;
    }

    public void crearCaja (Caja caja){
        this.listaCajas.add(caja);
    }

    /**
     * Metodo para buscar un artículo de la lista de artículos conociendo su nombre.
     * @return Articulo buscado.
     * @param nombre nombre del artículo a buscar.
     */
    public Articulo buscarArticuloNombre (String nombre){
        Articulo articulo = null;
        for (Articulo aBuscar : listaArticulos) {
            if (aBuscar.getNombre().equals(nombre)) {
                articulo = aBuscar;
            }
        }
        return articulo;
    }

    /**
     * Método para cargar una nueva compra.
     */
    public void cargarCompra() {
        Teclado teclado = new Teclado();

        Compra nuevaCompra = new Compra();

        String nombreArticuloComprado = null;
        Articulo articuloComprado = null;
        int cantidadComprada = 0;
        double costoLinea = 0;

        do {
            nombreArticuloComprado = teclado.cargarNombreArticulo();                             //
            articuloComprado = buscarArticuloNombre(nombreArticuloComprado);
            while(articuloComprado == null) {                                                    // En caso de que el nombre ingresado no corresponda con un artículo registrado
                switch (teclado.nombreArticuloCompradoNoExiste(nombreArticuloComprado)) {        // Le pregunto al usuario qué desea hacer
                    case 1 :
                        nombreArticuloComprado = teclado.cargarNombreArticulo();                 // Corrige el nombre cargado
                        break;
                    case 2 :
                        cargarArticulo();                                                        // El nombre es correcto y decide cargarlo en el registro de artículos
                        break;
                    default:
                        System.out.println("La opcion ingresada no es valida.");                 // Toca tecla que no va
                        break;
                }
            }

            cantidadComprada = teclado.cargarCantidadArticulo();                                 // Carga de la Cantidad de Artículos en la Línea
            while(cantidadComprada < 1){
                cantidadComprada = teclado.cantidadCeroONegativa(cantidadComprada);
            }

            costoLinea = teclado.cargarCostoLinea();                                             // Carga del Costo de la Línea
            while(costoLinea <= 0){
                costoLinea = teclado.costoCeroONegativo(costoLinea);
            }

            nuevaCompra.agregarLinea(articuloComprado, cantidadComprada, costoLinea);
            nuevaCompra.setFecha(LocalDate.now());
            nuevaCompra.setHora(LocalTime.now());

            //TODO - Vincular la compra con un Proveedor.

        } while(teclado.deseaContinuar());

        getListaOperacion().add(nuevaCompra);
    }

    /**
     * Método cargar un nuevo artículo.
      */
    public void cargarArticulo() {
        Teclado teclado = new Teclado();

        String nombre;
        String departamento;
        String marca;
        double utilidad;
        do {
            //TODO - Autoincrementar los idArticulo teniendo en cuenta la lista de local y la lista parcial de este método.
            nombre = teclado.cargarNombreArticulo();
            while (nombreArticuloRepetido(nombre)) {
                nombre = teclado.cargarNuevamenteNombreArticulo(nombre);
            }
            departamento = teclado.cargarDepartamentoArticulo();
            //TODO - Buscar la forma de validar existencia de departamentos. ¿Enum?
            marca = teclado.cargarMarcaArticulo();
            //TODO - Buscar la forma de validar existencia de marca. ¿Enum?
            utilidad = teclado.cargarUtilidadArticulo();
            while (utilidad < 0) {             // ¿Puede haber artículos que se vendan al costo? (Utilidad = 0)
                utilidad = teclado.cargarNuevamenteUtilidadArticulo(utilidad);
            }

            Articulo nuevo = new Articulo(nombre, departamento, marca, utilidad);
            listaArticulos.add(nuevo);
        } while (teclado.continuarCargandoArticulos());
    }

    public boolean nombreArticuloRepetido(String nombre) {

        for (Articulo aBuscar : listaArticulos) {
            if (aBuscar.getNombre().equals(nombre))
                return true;
        }
        return false;
    }

    public String emailValido(){
        Teclado teclado = new Teclado();
        boolean op = false;
        String email;
        do{
            Pattern pattern = Pattern
                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

            email= teclado.cargarEmail();

            Matcher mather = pattern.matcher(email);

            if (mather.find()) {
                System.out.println("El email ingresado es válido.");
                op=true;
            } else {
                System.out.println("El email ingresado es inválido.");
                op=false;
            }
        }while(!op);

        return email;
    }

//    public void agregarDescuento(){
//        Teclado teclado = new Teclado();
//        String nombre = null;
//        String nombreTarjera = null;
//        int porcentaje = 0;
//
//
//
//    }

    public String toString(){
        return "Local{" +
                "\nidLocal=" + idLocal +
                ", \nnombre='" + nombre + '\'' +
                ", \ndireccion='" + direccion + '\'' +
                ", \nlistaArticulos=" + listaArticulos +
                ", \nlistaClientes=" + listaClientes +
                ", \nlistaProveedores=" + listaProveedores;
    }

}

