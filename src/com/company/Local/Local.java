package com.company.Local;

import com.company.Articulo.Departamento;
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
    private ContenedorArrayList<Departamento> listaDepartamento;


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
        this.listaDepartamento = new ContenedorArrayList<Departamento>();
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

    public ContenedorArrayList<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaDepartamento(ContenedorArrayList<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    /**
     * M??todo para cargar un nuevo cliente al registro.
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
     * M??todo para cargar una nueva caja al registro.
     */
    public void nuevaCaja() {
        Caja nuevaCaja = new Caja(listaCajas.getContadorId(), this.idLocal, 0);
        listaCajas.agregar(nuevaCaja);

    }

    /**
     * M??todo para cargar un nuevo art??culo al registro.
     * @param nuevoArticulo a cargar
     */
    public void nuevoArticulo(Articulo nuevoArticulo) {
        nuevoArticulo.setIdArticulo(listaArticulos.getContadorId());
        listaArticulos.agregar(nuevoArticulo);
    }

    /**
     * M??todo para cargar una nueva compra.
     */
    public void nuevaCompra(Compra nuevaCompra) {
        nuevaCompra.setIdOperacion(listaOperacion.getContadorId());
        listaOperacion.agregar(nuevaCompra);
    }

    /**
     * M??todo para crear nuevo descuento
     * @param nuevoDescTarjeta
     */
    public void nuevoDescuentoTarjeta(DescTarjeta nuevoDescTarjeta){
        if (nuevoDescTarjeta.getNombreTarjeta() != null) {
            nuevoDescTarjeta.setIdDescuento(listaDescuento.getContadorId());
            listaDescuento.agregar(nuevoDescTarjeta);
        }
    }

    /**
     * M??todo para ingresar una nueva Marca
     * @param marcaNueva
     */
    public void nuevaMarca(Marca marcaNueva){
        if (marcaNueva != null){
            listaMarca.agregar(marcaNueva);
        }
    }

    /**
     * M??todo para mostrar la lista de Marcas
     */
    public void mostrarMarcas(){
        for (Marca marca : listaMarca.getLista()){
            System.out.println(marca.toString());
        }
    }

    /**
     * M??todo para ingresar un nuevo departamento
     * @param deptoNuevo
     */
    public void nuevoDepartamento(Departamento deptoNuevo){
        if (deptoNuevo != null){
            listaDepartamento.agregar(deptoNuevo);
        }
    }

    /**
     * M??todo para mostrar la lista de departamentos
     */
    public void mostrarDeptos(){
        for (Departamento depto : listaDepartamento.getLista()){
            System.out.println(depto.toString());
        }
    }

    /**
     * M??todo para mostrar todos los Articulo
     */
    public void mostrarArticulos(){
        for (Articulo art : listaArticulos.getLista()){
            System.out.println(art.toString());
        }
    }

    /**
     * M??todo para mostrar un Articulo
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
     * M??todo para eliminar un articulo
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
     * M??todo para eliminar un descuento
     */
    public void eliminarUnDescuento(){
        Teclado t = new Teclado();
        DescTarjeta desc = buscarDescuentoId();

        if(desc != null) {
            listaDescuento.eliminar(desc.getIdDescuento());
        }else{
            t.descuentoNoEncontrado();
        }
    }

    private DescTarjeta buscarDescuentoId() {
        DescTarjeta desc = null;
        
        if(mostrarListaDescuentoOptimizada()){
            Teclado t2 = new Teclado();
            int id = t2.cargarIdDescuento();
            for (DescTarjeta aBuscar : listaDescuento.getLista()) {
                if (aBuscar.getIdDescuento() == id) {
                    desc = aBuscar;
                }
            }
        }
        return desc;
    }
    
    

    /**
     * M??todo para modificar un articulo
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
     * M??todo para mostrar la lista de articulo de fomar optimizada
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

        for (Articulo aux : listaArticulos.getLista()){
            if (val.compararCaracter(nombre, aux.getDepartamento().getNombre())){
                System.out.println(aux.toStringOpt());
                flag = true;
            }
        }
        return flag;
    }

    /**
     * M??todo para mostrar la lista de articulo de fomar optimizada
     */
    public boolean mostrarListaDescuentoOptimizada() {
        boolean flag = false;

        for (DescTarjeta aux : listaDescuento.getLista()){

                System.out.println(aux.toStringOpt());
                flag = true;

        }
        return flag;
    }

    /**
     * M??todo para mostrar lista de clientes
     */
    public void mostrarClientes(){
        for (Cliente cliente : listaClientes.getLista()){
                cliente.toString();
        }
    }

    /**
     * M??todo para mostrar un cliente
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
     * M??todo para eliminar un cliente
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
     * M??todo para modificar un cliente
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
    public boolean mostrarListaProveedorOptimizada() {
        boolean flag = false;

        Teclado t = new Teclado();
        String nombre = t.cargarNombreProveedor();
        Validacion val = new Validacion();

        for (Proveedor aux : listaProveedores.getLista()){
            if (val.compararCaracter(nombre, aux.getNombre())){
                System.out.println(aux.toStringOpt());
                flag = true;
            }
        }
        for (Proveedor aux : listaProveedores.getLista()){
            if (val.compararCaracter(nombre, aux.getApellido())){
                System.out.println(aux.toStringOpt());
                flag = true;
            }
        }
        return flag;
    }

    /**
     * M??todo para mostrar un cliente
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
     * M??todo para eliminar un cliente
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
     * M??todo para modificar un cliente
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
     * M??todo para buscar una nueva marca
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
     * M??todo para buscar un Departamento
     * @return El departamento buscado
     * @return Null, si no se encuentra
     */
    public Departamento buscarDepartamento(){
        Teclado t = new Teclado();
        Departamento aBuscar = null;
        String nombre = t.cargarNombreDepartamentoBuscar();
        for (Departamento depto : listaDepartamento.getLista()){
            if (depto.getNombre().equals(nombre)){
                aBuscar = depto;
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
        if(mostrarListaProveedorOptimizada()){
            String CUIT = t.cargarCuitProv(listaProveedores);
            for (Proveedor aux : listaProveedores.getLista()){
                if(aux.getCuit().equals(CUIT)){
                    proveedor = aux;
                }
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
     * Metodo para buscar un art??culo de la lista de art??culos conociendo su nombre.
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
     * M??todo para verificar si determinado nombre ya figura en los registros vinculado a un art??culo.
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

    /**
     * M??todo para recorrer una lista de descuento y mostrar ventas.
     */
    public void mostrarVentas(){
        for (Operacion aMostrar : listaOperacion.getLista()){
            if (aMostrar instanceof Venta){
                ((Venta) aMostrar).mostrarVenta(listaDescuento);
            }
        }
    }

    /**
     * M??todo para recorrer una lista de ventas y mostrarlas.
     */
    public void mostrarVentas(Caja caja){
        for (Operacion aMostrar : listaOperacion.getLista()){
            if (aMostrar instanceof Venta){
                if(((Venta) aMostrar).getIdCaja() == caja.getIdCaja())
                    ((Venta) aMostrar).mostrarVenta(listaDescuento);
            }
        }
    }

    /**
     * M??todo para recorrer una lista de compras y mostrarlas.
     */
    public void mostrarCompras(){
        for (Operacion aMostrar : listaOperacion.getLista()){
            if (aMostrar instanceof Compra){
                ((Compra) aMostrar).mostrarCompra();
            }
        }
    }

    /**
     * M??todo para recorrer una lista de descuentos y mostrarlos.
     */
    public void mostrarDescuentos(){
        for (Descuento desc : listaDescuento.getLista()){
            if (desc instanceof DescTarjeta){
                System.out.println("------------------------------");
                System.out.println(desc.toString());
                System.out.println("------------------------------");
            }
        }
    }

    /**
     * Funcion para actualizar stock
     * @param art,stockpedido articulo a modificar y stock a restar
     */
    public void menosStock(Articulo art, int stockPedido) {
        art.setStock(art.getStock() - stockPedido);
    }

    /**
     * Metodo para actualizar stock
     * @param art,stockComprado articulo a modificar y stock a sumar
     */
    public void masStock(Articulo art, int stockComprado) {
        art.setStock(art.getStock() + stockComprado);
    }

    /**
     * Meotodo para actualizar el precio
     * @param art
     */
    public void actualizarPrecio(Articulo art){
        art.generarPrecio();
    }


    /**
     * M??todo para buscar una caja sabiendo su id. Retorna la ??ltima de la lista en caso de recibir un id erroneo.
     * @param idCaja
     * @return Caja seleccionada.
     */
    public Caja buscarCaja(int idCaja) {

        if(idCaja > listaCajas.getLista().size() - 1){
            return listaCajas.getElemento(listaCajas.getLista().size()-1);
        }else{
            return listaCajas.getElemento(idCaja);
        }
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

