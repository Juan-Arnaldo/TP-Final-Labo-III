package com.company.Local;

import com.company.Contenedor.ContenedorArrayList;
import com.company.Operacion.Compra;
import com.company.Operacion.MetodoPago;
import com.company.Operacion.Operacion;
import com.company.Operacion.Venta;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Articulo.Articulo;
import com.company.Utilidad.Menu;

public class Local {
    private int idLocal;
    private String nombre;
    private String direccion;
    private ContenedorArrayList<Articulo> listaArticulos;
    private ContenedorArrayList<Cliente> listaClientes;
    private ContenedorArrayList<Proveedor> listaProveedores;
    private ContenedorArrayList<Caja> listaCajas;
    private ContenedorArrayList<Operacion> listaOperacion;
    private ContenedorArrayList<DescTarjeta> listaDescuento;


    public Local(){

    }

    public Local(int idLocal, String nombre, String direccion) {

        this.idLocal = idLocal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaArticulos = new ContenedorArrayList<Articulo>();
        this.listaClientes = new ContenedorArrayList<Cliente>();
        this.listaProveedores = new ContenedorArrayList<Proveedor>();
        this.listaCajas = new ContenedorArrayList<Caja>();
        this.listaOperacion = new ContenedorArrayList<Operacion>();
        this.listaDescuento = new ContenedorArrayList<DescTarjeta>();
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

    public ContenedorArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ContenedorArrayList<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public ContenedorArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ContenedorArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ContenedorArrayList<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(ContenedorArrayList<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public ContenedorArrayList<Operacion> getListaOperacion() {
        return listaOperacion;
    }

    public void setListaOperacion(ContenedorArrayList<Operacion> listaOperacion) {
        this.listaOperacion = listaOperacion;
    }

    public ContenedorArrayList<DescTarjeta> getListaDescuento() {
        return listaDescuento;
    }

    public void setListaDescuento(ContenedorArrayList<DescTarjeta> listaDescuento) {
        this.listaDescuento = listaDescuento;
    }

    public ContenedorArrayList<Caja> getListaCajas() {
        return listaCajas;
    }

    public void setListaCajas(ContenedorArrayList<Caja> listaCajas) {
        this.listaCajas = listaCajas;
    }

    /**
     * Método para cargar un nuevo cliente al registro.
     * @param nuevoCliente a cargar.
     */
    public void nuevoCliente(Cliente nuevoCliente){
        nuevoCliente.setCodInterno(listaClientes.getContadorId());
        listaClientes.aumentarContadorId();
        listaClientes.agregar(nuevoCliente);
    }

    /**
     * Metodo para cargar un nuevo proveedor al registro.
     * @param nuevoProveedor a cargar
     */
    public void nuevoProveedor(Proveedor nuevoProveedor){
        nuevoProveedor.setCodInterno(listaProveedores.getContadorId());
        listaProveedores.aumentarContadorId();
        listaProveedores.agregar(nuevoProveedor);
    }

    /**
     * Método para cargar una nueva caja al registro.
     */
    public void nuevaCaja() {
        Caja nuevaCaja = new Caja(listaCajas.getContadorId(), this.idLocal, 0);
        listaCajas.aumentarContadorId();
        listaCajas.agregar(nuevaCaja);
    }

    /**
     * Método para cargar un nuevo artículo al registro.
     * @param nuevoArticulo a cargar
     */
    public void nuevoArticulo(Articulo nuevoArticulo) {
        nuevoArticulo.setIdArticulo(listaArticulos.getContadorId());
        listaArticulos.aumentarContadorId();
        listaArticulos.agregar(nuevoArticulo);
    }

    /**
     * Método para cargar una nueva compra.
     */
    public void nuevaCompra(Compra nuevaCompra) {
        nuevaCompra.setIdOperacion(listaOperacion.getContadorId());
        listaOperacion.aumentarContadorId();
        listaOperacion.agregar(nuevaCompra);
    }

    public void nuevoDescuentoTarjeta(DescTarjeta nuevoDescTarjeta){
        if (nuevoDescTarjeta.getNombreTarjeta() != null) {
            nuevoDescTarjeta.setIdDescuento(listaDescuento.getContadorId());
            listaDescuento.aumentarContadorId();
            listaDescuento.agregar(nuevoDescTarjeta);
        }
    }


    public void mostrarArticulos(){
        for (Articulo art : listaArticulos.getLista()){
            System.out.println(art.toString());
        }
    }

    /**
     * Metodo para mostrar una lista de clientes optimizada
     */
    public void mostrarListaClienteOptimizada() {
        Menu teclado = new Menu();
        String nombre = teclado.cargarNombre();
        for (Cliente aux : listaClientes.getLista()){
            if (compararCaracter(nombre, aux.getNombre())){
                System.out.println(aux.toStringOpt());
            }
        }
        for (Cliente aux : listaClientes.getLista()){
            if (compararCaracter(nombre, aux.getApellido())){
                System.out.println(aux.toStringOpt());
            }
        }
    }

    /**
     * Metodo para mostrar una lista de clientes optimizada
     */
    public void mostrarListaProveedorOptimizada() {
        Menu teclado = new Menu();
        String nombre = teclado.cargarNombre();
        for (Proveedor aux : listaProveedores.getLista()){
            if (compararCaracter(nombre, aux.getNombre())){
                System.out.println(aux.toStringOpt());
            }
        }
        for (Proveedor aux : listaProveedores.getLista()){
            if (compararCaracter(nombre, aux.getApellido())){
                System.out.println(aux.toStringOpt());
            }
        }
    }

    private boolean compararCaracter(String nombreABuscar, String nombre){
        int cantC = nombreABuscar.length();
        char C;
        boolean flag = true;
        int i = 0;
        while (flag && i < cantC ){

            C = nombreABuscar.charAt(i);

            if (C== (nombre.toLowerCase().charAt(i))||C== (nombre.toUpperCase().charAt(i))){
                flag = true;
            }else {
                flag = false;
            }
            i++;
        }
        return flag;
    }

    /**
     * Se le muestra una lista de clientes y se ingresa el CUIT del cliente para retornar
     * @return El cliente seleccionado
     */
    public Cliente buscarCliente() {
        Menu teclado = new Menu();
        Cliente cliente = null;
        mostrarListaClienteOptimizada();
        String CUIT = teclado.cargarCuit();
        for (Cliente aux : listaClientes.getLista()){
            if(aux.getCuit().equals(CUIT)){
                cliente = aux;
            }
        }

        return cliente;
    }

    /**
     * Se le muestra una lista de clientes y se ingresa el CUIT del cliente para retornar
     * @return El cliente seleccionado
     */
    public Proveedor buscarProveedor() {
        Menu teclado = new Menu();
        Proveedor proveedor = null;
        mostrarListaClienteOptimizada();
        String CUIT = teclado.cargarCuit();
        for (Proveedor aux : listaProveedores.getLista()){
            if(aux.getCuit().equals(CUIT)){
                proveedor = aux;
            }
        }

        return proveedor;
    }

    /**
     * Metodo para buscar un proveedor de la lista de proveedores conociendo su Id.
     * @param cuitProv Id del proveedor a buscar.
     * @return proveedor buscado.
     */
    public Proveedor buscarProveedorCuit(String cuitProv) {
        Proveedor resultado = null;
        for (Proveedor proveedor : listaProveedores.getLista()) {
            if (proveedor.getCuit() == cuitProv) {
                resultado = proveedor;
                break;
            }
        }
        return resultado;
    }

    /**
     * Metodo para buscar un artículo de la lista de artículos conociendo su nombre.
     * @param nombre nombre del artículo a buscar.
     * @return Articulo buscado.
     */
    public Articulo buscarArticuloNombre (String nombre) {
        Articulo articulo = null;
        for (Articulo aBuscar : listaArticulos.getLista()) {
            if (aBuscar.getNombre().equalsIgnoreCase(nombre)) {
                articulo = aBuscar;
            }
        }
        return articulo;
    }

    /**
     * Método para verificar si determinado nombre ya figura en los registros vinculado a un artículo.
     * @param nombre - nombre a verificar.
     * @return true si el nombre se encuntra; false si el nombre no se encuentra.
     */
    public boolean nombreArticuloRepetido(String nombre) {
        for (Articulo aBuscar : listaArticulos.getLista()) {
            if (aBuscar.getNombre().equalsIgnoreCase(nombre))
                return true;
        }
        return false;
    }

    public void mostrarVentas(){
        for (Operacion aMostrar : listaOperacion.getLista()){
            if (aMostrar instanceof Venta){
                ((Venta) aMostrar).mostrarVenta(listaDescuento);
            }
        }
    }


    public String cargarMetodoDePago() {
        int aux;
        MetodoPago metodoPago = null;
        Menu teclado = new Menu();
        do {
            aux = teclado.cargarMetodoPago();
            switch (aux) {
                case 1:
                    metodoPago = MetodoPago.Efectivo;
                    break;
                case 2:
                    metodoPago = MetodoPago.Tarjeta;
                    return seleccionTarjeta();
                case 3:
                    metodoPago = MetodoPago.Cheque;
                    break;
                default:
                    System.out.println("La opcion que ingresaste no es valida");
                    break;
            }
        } while (aux != 1 && aux != 2 && aux != 3 && aux != 0);

        return metodoPago.name();
    }

    /**
     * Funcion para la seleccion de la tarjeta
     * @return el nombre de la tarjeta seleccionada
     */

    public String seleccionTarjeta() {
        int aux;
        String tarjeta = null;
        Menu teclado = new Menu();
        do {
            aux = teclado.cargarTarjeta();
            switch (aux) {
                case 1:
                    tarjeta = "Visa";
                    break;
                case 2:
                    tarjeta = "Mastercad";
                    break;
                case 3:
                    tarjeta = "Cabal";
                    break;
                case 4:
                    tarjeta = "American Express";
                    break;
                case 5:
                    tarjeta = "Maestro";
                    break;
                case 6:
                    tarjeta = "Naranja";
                    break;
                default:
                    System.out.println("La opcion ingresada es incorrecta, ingrese 0 de si desea salir");
                    break;
            }

        } while (aux != 1 && aux != 2 && aux != 3 && aux != 4 && aux != 5 && aux != 6 && aux != 0);

        return tarjeta;
    }

    public void mostrarDescuentos(){
        for (Descuento desc : listaDescuento.getLista()){
            if (desc instanceof DescTarjeta){
                System.out.println(desc.toString());
            }
        }
    }

    public void modificarArticulo(Articulo articulo) {
        Menu teclado = new Menu();
        int aux;
        do{
            aux = teclado.modificiarArticulo();
            switch (aux){
                case 1:
                    articulo.setNombre(teclado.cargarNombreArticulo());
                    break;
                case 2:
                    articulo.setDepartamento(teclado.cargarDepartamentoArticulo());
                    break;
                case 3:
                    articulo.setMarca(teclado.cargarMarcaArticulo());
                    break;
                case 4:
                    articulo.setCosto(teclado.cargarCostoArticulo());
                    break;
                case 5:
                    articulo.setUtilidad(teclado.cargarUtilidadArticulo());
                    break;
                case 6:
                    articulo.setStock(teclado.cargarCantidadArticulo());
                    break;
                default:
                    System.out.println("La opcion ingresada no es correcta!\n");
                    break;
            }
        }while(aux != 1 && aux != 2 && aux != 3 && aux != 4 && aux != 5 && aux != 6 && aux != 0);
    }

    public String toString() {
        return "Local{" +
                "\nidLocal=" + idLocal +
                ", \nnombre='" + nombre + '\'' +
                ", \ndireccion='" + direccion + '\'' +
                ", \nlistaArticulos=" + listaArticulos +
                ", \nlistaClientes=" + listaClientes +
                ", \nlistaProveedores=" + listaProveedores;
    }

}

