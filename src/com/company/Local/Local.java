package com.company.Local;

import com.company.Contenedor.ContenedorArrayList;
import com.company.Operacion.Compra;
import com.company.Operacion.MetodoPago;
import com.company.Operacion.Operacion;
import com.company.Operacion.Venta;
import com.company.Persona.Cliente;
import com.company.Persona.Persona;
import com.company.Persona.Proveedor;
import com.company.Articulo.Articulo;
import com.company.Utilidad.Teclado;
import com.company.Utilidad.Validacion;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;


public class Local {
    private int idLocal;
    private String nombre;
    private String direccion;
    private ContenedorArrayList<Articulo> listaArticulos;
    private ContenedorArrayList<Cliente> listaClientes;
    private ContenedorArrayList<Proveedor> listaProveedores;
    private ContenedorArrayList<Caja> listaCajas;
    private ContenedorArrayList<Operacion> listaOperacion;
    private ContenedorArrayList<Descuento> listaDescuento;


    public Local(int idLocal, String nombre, String direccion) {

        this.idLocal = idLocal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaArticulos = new ContenedorArrayList<Articulo>();
        this.listaClientes = new ContenedorArrayList<Cliente>();
        this.listaProveedores = new ContenedorArrayList<Proveedor>();
        this.listaCajas = new ContenedorArrayList<Caja>();
        this.listaOperacion = new ContenedorArrayList<Operacion>();
        this.listaDescuento = new ContenedorArrayList<Descuento>();
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

    public ContenedorArrayList<Descuento> getListaDescuento() {
        return listaDescuento;
    }

    public void setListaDescuento(ContenedorArrayList<Descuento> listaDescuento) {
        this.listaDescuento = listaDescuento;
    }

    /**
     * Metodo para la creacion de cliente, carga de sus datos y lo agrega a la lista
     * @return El cliente cargado
     */
    public void crearCliente(){
        Teclado teclado = new Teclado();
        Validacion validacion = new Validacion();

        String cuit = teclado.cargarCuit();
        while(validacion.validarCuitCliente(cuit, listaClientes.getLista())) {
            cuit = teclado.cargarNuevamenteCuitPersona(cuit);
        }

        String nombre = teclado.cargarNombre();
        String apellido = teclado.cargarApellido();
        String direc = teclado.cargarDireccion();
        String tel = teclado.cargarTelefono();

        String email = teclado.cargarEmail();
        while(!validacion.validacionEmailValido(email)) {
            email = teclado.cargarNuevamenteEmailPersona(email);
        }

        Cliente cliente = new Cliente(nombre, direc, cuit, tel, email, apellido);
        cliente.setCodInterno(listaClientes.getContadorId());
        listaClientes.aumentarContadorId();
        listaClientes.agregar(cliente);
    }

    /**
     * Metodo para la creacion de proveedor y carga de sus datos
     * @return El proveedor cargado
     */
    public void crearProv(){
        Teclado teclado = new Teclado();
        Validacion validacion = new Validacion();

        String cuit = teclado.cargarCuit();
        while(validacion.validarCuitProveedor(cuit, listaProveedores.getLista())) {
            cuit = teclado.cargarNuevamenteCuitPersona(cuit);
        }

        String nombre = teclado.cargarNombre();
        String apellido = teclado.cargarApellido();
        String direc = teclado.cargarDireccion();
        String tel = teclado.cargarTelefono();
        String email = teclado.cargarEmail();

        while(!validacion.validacionEmailValido(email)) {
            email = teclado.cargarNuevamenteEmailPersona(email);
        }
        String localidad = teclado.cargarLocalidad();

        Proveedor prov = new Proveedor(nombre, direc, cuit, tel, email, localidad, apellido);

        prov.setCodInterno(listaProveedores.getContadorId());
        listaProveedores.aumentarContadorId();
        listaProveedores.agregar(prov);

    }

    /**
     * Metodo para mostrar una lista de clientes optimizada
     */
    public void mostrarListaClienteOptimizada() {
        Teclado teclado = new Teclado();
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
     * Compara caracter por caracter
     * @param nombreABuscar
     * @param nombre
     * @return falso(si no son iguales) o true(si son iguales)
     */
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
    public Cliente buscarCliente(String CUIT) {
        Teclado teclado = new Teclado();
        Cliente cliente = null;
        mostrarListaClienteOptimizada();
        for (Cliente aux : listaClientes.getLista()){
            if(aux.getCuit().equals(CUIT)){
                cliente = aux;
            }
        }

        return cliente;
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
     * Método para crear una nueva caja.
     */
    public void crearCaja() {

        Caja nuevaCaja = new Caja(listaCajas.getContadorId(), 0, this);
        listaCajas.aumentarContadorId();
        listaCajas.agregar(nuevaCaja);
    }

    /**
     * Metodo para buscar un artículo de la lista de artículos conociendo su nombre.
     * @param nombre nombre del artículo a buscar.
     * @return Articulo buscado.
     */
    public Articulo buscarArticuloNombre (String nombre) {
        Articulo articulo = null;
        String aux;
        for (Articulo aBuscar : listaArticulos.getLista()) {
            if (aBuscar.getNombre().equalsIgnoreCase(nombre)) {
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

        nuevaCompra.setIdOperacion(listaOperacion.getContadorId());
        listaOperacion.aumentarContadorId();
        getListaOperacion().agregar(nuevaCompra);
    }

    /**
     * Método cargar un nuevo artículo.
     */
    public void cargarArticulo() {
        Teclado teclado = new Teclado();

        String nombre, departamento, marca;
        int stock = 0;
        double utilidad;
        do {
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
            stock = teclado.cargaStock();
            while(stock < 0){
                stock = teclado.cargaStockNuevamente();
            }

            Articulo nuevo = new Articulo(nombre, departamento, marca, utilidad, stock);
            nuevo.setIdArticulo(listaArticulos.getContadorId());
            listaArticulos.aumentarContadorId();
            listaArticulos.agregar(nuevo);
        } while (teclado.continuarCargandoArticulos());
    }

    public void mostrarArticulos(){
        for (Articulo art : listaArticulos.getLista()){
            System.out.println(art.toString());
        }
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
        Teclado teclado = new Teclado();
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

    private String seleccionTarjeta() {
        int aux;
        String tarjeta = null;
        Teclado teclado = new Teclado();
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


    public void agregarDescuentoTarjeta(){
        Teclado teclado = new Teclado();
        String nombre = teclado.cargarNombre();

        int porcentaje = teclado.ingresePorcentajeDesc();

        while (porcentaje <= 0 || porcentaje > 100){
            porcentaje = teclado.ingresePorcentajeDescNuevamente();
        }

        String tarjeta = seleccionTarjeta();
        if(tarjeta != null){

            Descuento nuevo = new DescTarjeta(porcentaje, tarjeta, nombre);
            listaDescuento.agregar(nuevo);
        }
    }

    public void mostrarDescuentos(){
        for (Descuento desc : listaDescuento.getLista()){
            if (desc instanceof DescTarjeta){
                System.out.println(desc.toString());
            }
        }
    }

    public void modificarArticulo(Articulo articulo) {
        Teclado teclado = new Teclado();
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

