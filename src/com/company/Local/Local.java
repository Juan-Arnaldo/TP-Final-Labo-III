package com.company.Local;

import com.company.Articulo.Marca;
import com.company.Contenedor.ContenedorArrayList;
import com.company.Operacion.Compra;
import com.company.Operacion.Operacion;
import com.company.Operacion.Venta;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import com.company.Articulo.Articulo;
import com.company.Utilidad.Menu;
import com.company.Utilidad.Teclado;
import com.company.Utilidad.Validacion;


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
    private ContenedorArrayList<Marca> listaMarca;


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
        this.listaMarca = new ContenedorArrayList<Marca>();
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

    public ContenedorArrayList<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(ContenedorArrayList<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }

    /**
     * Método para cargar un nuevo cliente al registro.
     * @param nuevoCliente a cargar.
     */
    public void nuevoCliente(Cliente nuevoCliente){
        nuevoCliente.setCodInterno(listaClientes.getContadorId());
        listaClientes.agregar(nuevoCliente);
    }

    /**
     * Metodo para cargar un nuevo proveedor al registro.
     * @param nuevoProveedor a cargar
     */
    public void nuevoProveedor(Proveedor nuevoProveedor){
        nuevoProveedor.setCodInterno(listaProveedores.getContadorId());
        listaProveedores.agregar(nuevoProveedor);
    }

    /**
     * Método para cargar una nueva caja al registro.
     */
    public void nuevaCaja() {
        Caja nuevaCaja = new Caja(listaCajas.getContadorId(), this.idLocal, 0);
        listaCajas.agregar(nuevaCaja);

    }

    /**
     * Método para cargar un nuevo artículo al registro.
     * @param nuevoArticulo a cargar
     */
    public void nuevoArticulo(Articulo nuevoArticulo) {
        nuevoArticulo.setIdArticulo(listaArticulos.getContadorId());
        listaArticulos.agregar(nuevoArticulo);
    }

    /**
     * Método para cargar una nueva compra.
     */
    public void nuevaCompra(Compra nuevaCompra) {
        nuevaCompra.setIdOperacion(listaOperacion.getContadorId());
        listaOperacion.agregar(nuevaCompra);
    }

    /**
     * Método para crear nuevo descuento
     * @param nuevoDescTarjeta
     */
    public void nuevoDescuentoTarjeta(DescTarjeta nuevoDescTarjeta){
        if (nuevoDescTarjeta.getNombreTarjeta() != null) {
            nuevoDescTarjeta.setIdDescuento(listaDescuento.getContadorId());
            listaDescuento.agregar(nuevoDescTarjeta);
        }
    }

    /**
     * Método para ingresar una nueva Marca
     * @param marcaNueva
     */
    public void nuevaMarca(Marca marcaNueva){
        if (marcaNueva != null){
            listaMarca.agregar(marcaNueva);
        }
    }

    /**
     * Método para mostrar la lista de Marcas
     */
    public void mostrarMarcas(){
        for (Marca marca : listaMarca.getLista()){
            System.out.println(marca.toString());
        }
    }

    /**
     * Método para mostrar todos los Articulo
     */
    public void mostrarArticulos(){
        for (Articulo art : listaArticulos.getLista()){
            System.out.println(art.toString());
        }
    }

    /**
     * Método para mostrar un Articulo
     */
    public void mostrarUnArticulo(){
        Teclado t = new Teclado();
        Articulo art = buscarArticuloID();

        if (art != null){
            System.out.println(art.toString());
        }else{
            t.articuloNoEncontrado();
        }
    }

    /**
     * Método para eliminar un articulo
     */
    public void eliminarUnArticulo(){
        Teclado t = new Teclado();
        Articulo art = buscarArticuloID();

        if(art != null) {
            listaArticulos.eliminar(art.getIdArticulo());
        }else{
            t.articuloNoEncontrado();
        }
    }

    /**
     * Método para modificar un articulo
     */
    public void modificarUnArticulo(){
        Teclado t = new Teclado();
        Menu menu = new Menu();
        Articulo aModificar = buscarArticuloID();

        if(aModificar != null){
            menu.modificarArticuloSalida(aModificar, this);
        }else{
            t.articuloNoEncontrado();
        }
    }

    /**
     * Método para mostrar la lista de articulo de fomar optimizada
     */
    public boolean mostrarListaArticuloOptimizada() {
        boolean flag = false;
        Teclado t = new Teclado();
        Validacion val = new Validacion();
        String nombre = t.cargarNombreArticulo();

        for (Articulo aux : listaArticulos.getLista()){
            if (val.compararCaracter(nombre, aux.getNombre())){
                System.out.println(aux.toStringOpt());
                flag = true;
            }
        }
        for (Articulo aux : listaArticulos.getLista()){
            if (val.compararCaracter(nombre, aux.getMarca().getNombre())){
                System.out.println(aux.toStringOpt());
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Método para mostrar lista de clientes
     */
    public void mostrarClientes(){
        for (Cliente cliente : listaClientes.getLista()){
                cliente.toString();
        }
    }

    /**
     * Método para mostrar un cliente
     */
    public void mostrarUnCliente(){
        Teclado t = new Teclado();
        Cliente aMostrar = buscarCliente();

        if (aMostrar != null){
            System.out.println(aMostrar.toString());
        }else{
            t.clienteNoEncontrado();
        }
    }

    /**
     * Método para eliminar un cliente
     */
    public void eliminarUnCliente(){
        Teclado t = new Teclado();
        Cliente aBorrar = buscarCliente();

        if (aBorrar != null){
            int i = 0;
            for(Cliente aux : listaClientes.getLista()){
                if(aux.equals(aBorrar)){
                    listaClientes.eliminar(i);
                    break;
                }
                i++;
            }
        }else{
            t.clienteNoEncontrado();
        }
    }

    /**
     * Método para modificar un cliente
     */
    public void modificarUnCliente(){
        Teclado t = new Teclado();
        Menu menu = new Menu();
        Cliente aModificar = buscarCliente();

        if(aModificar != null){
            menu.modificarClienteSalida(aModificar);
        }else {
            t.clienteNoEncontrado();
        }
    }

    /**
     * Metodo para mostrar una lista de clientes optimizada
     */
    public boolean mostrarListaClienteOptimizada() {
        boolean flag = false;
        Teclado t = new Teclado();
        String nombre = t.cargarNombreCliente();
        Validacion val = new Validacion();

        for (Cliente aux : listaClientes.getLista()){
            if (val.compararCaracter(nombre, aux.getNombre())){
                System.out.println("\n" + aux.toStringOpt());
                flag = true;
            }
        }

        for (Cliente aux : listaClientes.getLista()){
            if (val.compararCaracter(nombre, aux.getApellido())){
                System.out.println("\n" + aux.toStringOpt());
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Metodo para mostrar una lista de clientes optimizada
     */
    public void mostrarListaProveedorOptimizada() {

        Teclado t = new Teclado();
        String nombre = t.cargarNombreCliente();
        Validacion val = new Validacion();

        for (Proveedor aux : listaProveedores.getLista()){
            if (val.compararCaracter(nombre, aux.getNombre())){
                System.out.println(aux.toStringOpt());
            }
        }
        for (Proveedor aux : listaProveedores.getLista()){
            if (val.compararCaracter(nombre, aux.getApellido())){
                System.out.println(aux.toStringOpt());
            }
        }
    }

    /**
     * Método para mostrar un cliente
     */
    public void mostrarUnProveedor(){
        Teclado t = new Teclado();
        Proveedor aMostrar = buscarProveedor();

        if (aMostrar != null){
            System.out.println(aMostrar.toString());
        }else{
            t.provNoEncontrado();
        }
    }

    /**
     * Método para eliminar un cliente
     */
    public void eliminarUnProv(){
        Teclado t = new Teclado();
        Proveedor aBorrar = buscarProveedor();

        if (aBorrar != null){
            int i = 0;
            for(Proveedor aux : listaProveedores.getLista()){
                if(aux.equals(aBorrar)){
                    listaProveedores.eliminar(i);
                }
                i++;
            }
        }else{
            t.provNoEncontrado();
        }
    }

    /**
     * Método para modificar un cliente
     */
    public void modificarUnProv(){
        Teclado t = new Teclado();
        Menu menu = new Menu();
        Proveedor aModificar = buscarProveedor();

        if(aModificar != null){
            menu.modificarProvSalida(aModificar);
        }else {
            t.clienteNoEncontrado();
        }
    }

    /**
     * Se le muestra una lista de clientes y se ingresa el CUIT del cliente para retornar
     * @return El cliente seleccionado
     */
    public Cliente buscarCliente() {
        Teclado t = new Teclado();
        Cliente cliente = null;
        if(mostrarListaClienteOptimizada()){
            String CUIT = t.cargarCuitCliente(listaClientes);
            for (Cliente aux : listaClientes.getLista()){
                if(aux.getCuit().equals(CUIT)){
                    cliente = aux;
                }
            }
        }

        return cliente;
    }

    /**
     * Método para buscar una nueva marca
     * @return La marca buscada
     * @return Null, si no se encuentra
     */
    public Marca buscarMarca(){
        Teclado t = new Teclado();
        Marca aBuscar = null;
        String nombre = t.cargarNombreMarcaBuscar();
        for (Marca marca : listaMarca.getLista()){
            if (marca.getNombre().equals(nombre)){
                aBuscar = marca;
            }
        }

        return aBuscar;
    }

    /**
     * Se le muestra una lista de clientes y se ingresa el CUIT del cliente para retornar
     * @return El cliente seleccionado
     */
    public Proveedor buscarProveedor() {
        Teclado t = new Teclado();
        Proveedor proveedor = null;
        mostrarListaProveedorOptimizada();
        String CUIT = t.cargarCuitProv(listaProveedores);
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
     * @return Articulo buscado.
     */
    public Articulo buscarArticuloID () {
        Articulo articulo = null;

        if(mostrarListaArticuloOptimizada()){
            Teclado t2 = new Teclado();
            int id = t2.cargarIDArticulo();
            for (Articulo aBuscar : listaArticulos.getLista()) {
                if (aBuscar.getIdArticulo() == id) {
                    articulo = aBuscar;
                }
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

    public void mostrarVentas(Caja caja){
        for (Operacion aMostrar : listaOperacion.getLista()){
            if (aMostrar instanceof Venta){
                if(((Venta) aMostrar).getIdCaja() == caja.getIdCaja())
                    ((Venta) aMostrar).mostrarVenta(listaDescuento);
            }
        }
    }

    public void mostrarCompras(){
        for (Operacion aMostrar : listaOperacion.getLista()){
            if (aMostrar instanceof Compra){
                ((Venta) aMostrar).mostrarVenta(listaDescuento);
            }
        }
    }

    public void mostrarDescuentos(){
        for (Descuento desc : listaDescuento.getLista()){
            if (desc instanceof DescTarjeta){
                System.out.println(desc.toString());
            }
        }
    }

    /**
     * Funcion para actualizar stock
     * @param art,stockpedido articulo a modificar y stock a restar
     */
    public void nuevoStock(Articulo art, int stockPedido) {
        art.setStock(art.getStock() - stockPedido);
    }


    /**
     * Método para buscar una caja sabiendo su id. Retorna la última de la lista en caso de recibir un id erroneo.
     * @param idCaja
     * @return Caja seleccionada.
     */
    public Caja buscarCaja(int idCaja) {
        if(listaCajas.getLista().get(idCaja) != null)
            return listaCajas.getElemento(idCaja);
        else
            return listaCajas.getElemento(listaCajas.getLista().size()-1);

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

