package com.company.Utilidad;

import com.company.Articulo.Articulo;
import com.company.Articulo.Departamento;
import com.company.Articulo.Marca;
import com.company.Local.Caja;
import com.company.Local.DescTarjeta;
import com.company.Local.Local;
import com.company.Operacion.Compra;
import com.company.Operacion.MetodoPago;
import com.company.Operacion.Venta;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;

import java.util.Scanner;

public class Menu {
    private final Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }

    /**
     * Método para el menú que aparecerá al inicio del programa.
     * @param local en el que se trabajará.
     */
    public void menuInicio(Local local) {
        System.out.println("\n-------------------------------------------");
        System.out.println("------- Sistema de Gestión Contable -------");
        System.out.println("-------------------------------------------\n");
        Teclado t = new Teclado();
        int opc;
        do{
            opc = t.cargarOpcionMenuInicio();
            Caja caja;

            switch (opc) {
                case 1 -> {
                    caja = menuSeleccionCaja(local);
                    menuCaja(local, caja);
                }
                case 2 -> {
                    local.nuevaCaja();
                    caja = local.getListaCajas().getElemento(local.getListaCajas().getLista().size() - 1);
                    menuCaja(local, caja);
                }
                case 0 -> System.out.println("\nSaliendo...\n");
                default -> System.out.println("Opcion erronea.\nVuelva a intentarlo.\n");
            }
        }while (opc != 0);
    }

    /**
     * Menú que se encarga de mostrar las cajas disponibles y le permite al usuario seleccionar una para trabajar.
     * @param local al que pertenecen las cajas
     */
    public Caja menuSeleccionCaja(Local local) {
        System.out.println("\n---------------------------------");
        System.out.println("------- Selección de Caja -------");
        System.out.println("---------------------------------\n");
        Teclado teclado = new Teclado();
        if(local.getListaCajas().listaVacia())
            local.nuevaCaja();
        mostrarCajas(local);
        int idCaja = teclado.cargarIdCaja();
        return local.buscarCaja(idCaja);
    }

    /**
     * Método para mostrar las cajas disponibles en el local que llega como parámetro.
     * @param local
     */
    public void mostrarCajas(Local local){
        System.out.println("Cajas disponibles en local:\n");
        for (Caja caja : local.getListaCajas().getLista()){
            System.out.println(caja.toString());
        }
    }

    /**
     * Método para mostrar las opciones dentro del menú de caja.
     * @param local
     */
    public void menuCaja (Local local, Caja caja) {
        Teclado t = new Teclado();
        int opc;
        do{
            System.out.println("\n----------------------------");
            System.out.println("------- MENÚ DE CAJA -------");
            System.out.println("----------------------------\n");
            System.out.println("    Bienvenido a la Caja " + caja.getIdCaja() + "\n");
            opc = t.cargarOpcionMenuCaja();

            switch (opc) {
                case 1 -> caja.nuevaVenta(cargarNuevaVenta(local, caja), local);
                case 2 -> menuDetalles(local, caja);
                case 3 -> menuArticulo(local);
                case 4 -> menuCliente(local);
                case 5 -> local.nuevaCompra(cargarNuevaCompra(local));
                case 6 -> menuProveedor(local);
                case 7 -> menuDescuento(local);
                case 0 -> System.out.println("\nSaliendo...\n");
                default -> System.out.println("Opcion erronea.\nVuelva a intentarlo.\n");
            }
        }while (opc != 0);
    }

    /**
     * Método para mostrar las opciones dentro del menú de caja.
     * @param local
     */
    public void menuDetalles (Local local, Caja caja) {
        System.out.println("\n-----------------------------");
        System.out.println("------- MENÚ DETALLES -------");
        System.out.println("-----------------------------\n");
        Teclado t = new Teclado();
        int opc;
        do{
            opc = t.cargarOpcionMenuDetalles(caja.getIdCaja());

            switch (opc) {
                case 1 -> caja.mostrarDinero();
                case 2 -> local.mostrarVentas(caja);
                case 3 -> local.mostrarCompras();
                case 0 -> System.out.println("\nSaliendo...\n");
                default -> System.out.println("Opcion erronea.\nVuelva a intentarlo.\n");
            }
        }while (opc != 0);
    }

    /**
     * Método para mostrar las opciones dentro del menú de articulo.
     * @param local
     */
    public void menuArticulo(Local local) {
        Teclado t = new Teclado();
        int opc;
        do {
            System.out.println("\n--------------------------------");
            System.out.println("------- MENÚ DE ARTICULO -------");
            System.out.println("--------------------------------\n");
            opc = t.cargarOpcionMenuArticulo();
            switch (opc) {
                case 1 -> local.nuevoArticulo(cargarNuevoArticulo(local));
                case 2 -> local.modificarUnArticulo();
                case 3 -> local.eliminarUnArticulo();
                case 4 -> local.mostrarUnArticulo();
                default -> System.out.println("\nLa opcion ingresada no es valida.\n");
            }
        } while (opc != 0);
    }

    /**
     * Método para mostrar las opciones dentro del menú de articulo.
     * @param local
     */
    public void menuDescuento(Local local) {
        Teclado t = new Teclado();
        int opc;
        do {
            System.out.println("\n--------------------------------");
            System.out.println("------- MENÚ DE DESCUENTOS -------");
            System.out.println("--------------------------------\n");
            opc = t.cargarOpcionMenuDescuento();
            switch (opc) {
                case 1 -> local.nuevoDescuentoTarjeta(cargarNuevoDescuentoTarjeta(local));
                case 2 -> local.eliminarUnDescuento();
                case 3 -> local.mostrarDescuentos();
                default -> System.out.println("\nLa opcion ingresada no es valida.\n");
            }
        } while (opc != 0);
    }

    /**
     * Método para mostrar las opciones dentro del menú de cliente.
     * @param local
     */
    public void menuCliente(Local local) {
        Teclado t = new Teclado();
        int opc;
        do {
            System.out.println("\n-------------------------------");
            System.out.println("------- MENÚ DE CLIENTE -------");
            System.out.println("-------------------------------\n");
            opc = t.cargarOpcionMenuCliente();
            switch (opc) {
                case 1 -> local.nuevoCliente(cargarNuevoCliente(local));
                case 2 -> local.modificarUnCliente();
                case 3 -> local.eliminarUnCliente();
                case 4 -> local.mostrarUnCliente();
                default -> System.out.println("\nLa opcion ingresada no es valida.\n");
            }
        } while (opc != 0);
    }

    /**
     * Método para mostrar las opciones dentro del menú de proveedor.
     * @param local
     */
    public void menuProveedor(Local local) {
        Teclado t = new Teclado();
        int opc;
        do {
            System.out.println("\n---------------------------------");
            System.out.println("------- MENÚ DE PROVEEDOR -------");
            System.out.println("---------------------------------\n");
            opc = t.cargarOpcionMenuProv();
            switch (opc) {
                case 1 -> local.nuevoProveedor(cargarNuevoProveedor(local));
                case 2 -> local.modificarUnProv();
                case 3 -> local.eliminarUnProv();
                case 4 -> local.mostrarUnProveedor();
                default -> System.out.println("\nLa opcion ingresada no es valida.\n");
            }
        } while (opc != 0);
        System.out.println("---------------------------------------\n");
    }

    /**
     * Método para cargar los datos de un nuevo cliente, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará el nuevo cliente.
     * @return cliente nuevo a registrar.
     */
    public Cliente cargarNuevoCliente(Local local) {
        System.out.println("\n-----------------------------");
        System.out.println("------- NUEVO CLIENTE -------");
        System.out.println("-----------------------------\n");
        Teclado t = new Teclado();
        Validacion validacion = new Validacion();

        String cuit = t.cargarCuitCliente(local.getListaClientes());
        while(validacion.validarCuitCliente(cuit, local.getListaClientes().getLista())) {
            cuit = t.cargarNuevamenteCuitPersona(cuit);
        }

        String nombre = t.cargarNombreCliente();
        String apellido = t.cargarApellido();
        String direc = t.cargarDireccion();
        String tel = t.cargarTelefono();
        String email = t.cargarEmail();

        System.out.println("Cliente cargado exitosamente.");
        System.out.println("---------------------------------------\n");

        return new Cliente(nombre, direc, cuit, tel, email, apellido);
    }

    /**
     * Método para cargar los datos de un nuevo proveedor, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará el nuevo proveedor.
     * @return proveedor nuevo a registrar.
     */
    public Proveedor cargarNuevoProveedor(Local local) {
        System.out.println("\n-------------------------------");
        System.out.println("------- NUEVO PROVEEDOR -------");
        System.out.println("-------------------------------\n");
        Teclado t = new Teclado();

        String cuit = t.cargarCuitProv(local.getListaProveedores());

        String nombre = t.cargarNombreProveedor();
        String apellido = t.cargarApellido();
        String direc = t.cargarDireccion();
        String tel = t.cargarTelefono();
        String email = t.cargarEmail();
        String localidad = t.cargarLocalidad();

        System.out.println("Proveedor cargado exitosamente.");
        System.out.println("---------------------------------------\n");

        return new Proveedor(nombre, direc, cuit, tel, email, localidad, apellido);
    }

    /**
     * Método para cargar los datos de un nuevo artículo, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará el nuevo artículo.
     * @return artículo nuevo a registrar.
     */
    public Articulo cargarNuevoArticulo(Local local) {
        System.out.println("\n------------------------------");
        System.out.println("------- NUEVO ARTICULO -------");
        System.out.println("------------------------------\n");
        Teclado t = new Teclado();
        Validacion v = new Validacion();

        String nombre;
        int stock ;
        double utilidad, costo;
        nombre = t.cargarNombreArticulo();
        while (local.nombreArticuloRepetido(nombre)) {
            nombre = t.cargarNuevamenteNombreArticulo(nombre);
        }
        Departamento departamento = local.buscarDepartamento();
        while (departamento == null){
            departamento = menuDepartamentoNoExiste(local);
        }

        Marca marca = local.buscarMarca();
        while (marca == null){
            marca = menuMarcaNoExiste(local);
        }

        costo = t.cargarCosto();
        while (!v.mayorQueCero(costo)){
            costo = t.cargarNuevamenteCostoNegativo(costo);
        }

        utilidad = t.cargarUtilidadArticulo();
        while (utilidad < 0 || utilidad > 1000) {
            if (utilidad < 0)
                utilidad = t.cargarNuevamenteUtilidadNegativa(utilidad);
            if (utilidad > 1000)
                utilidad = t.cargarNuevamenteUtilidadExcesiva(utilidad);
        }

        stock = t.cargarStock();
        while(stock < 0){
            stock = t.cargarNuevamenteStockNegativo(stock);
        }

        System.out.println("Articulo cargado exitosamente.");
        System.out.println("---------------------------------------\n");

        return new Articulo(nombre, departamento, marca, costo, utilidad, stock);
    }

    /**
     * Método para decidir qué hacer en caso de que la marca igresada no exista.
     * @param local
     * @return
     */
    public Marca menuMarcaNoExiste(Local local) {
        Teclado t = new Teclado();
        Marca marca;

        int aux = t.marcaBuscadaNoSeEncuentra();
        switch (aux) {
            case 1 -> {
                marca = cargarNuevaMarca(local); //TODO debería recibir el strin del nombre intentado, mostrarlo y cargarlo directamente.
                local.nuevaMarca(marca);
                System.out.println("\nMarca cargada exitosamente.\n");
                return marca;
            }
            case 2 -> {
                marca = local.buscarMarca();
                return marca;
            }
            default -> {
                System.out.println("\nLa opcion ingresada no es valida.\n");
                return null;
            }
        }
    }


    /**
     * Método para decidir qué hacer en caso de que el departamento no exista
     * @param local
     * @return
     */
    public Departamento menuDepartamentoNoExiste(Local local) {
        Teclado t = new Teclado();
        Departamento depto;

        int aux = t.departamentoBuscadoNoSeEncuentra();
        switch (aux) {
            case 1 -> {
                depto = cargarNuevoDepartamento(local); //TODO debería recibir el strin del nombre intentado, mostrarlo y cargarlo directamente.
                local.nuevoDepartamento(depto);
                return depto;
            }
            case 2 -> {
                depto = local.buscarDepartamento();
                return depto;
            }
            default -> {
                System.out.println("\nLa opcion ingresada no es valida.\n");
                return null;
            }
        }
    }





    /**
     * Método para cargar los datos de una nueva compra, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará la nueva compra.
     * @return compra nuevo a registrar.
     */
    public Compra cargarNuevaCompra(Local local) {
        System.out.println("\n----------------------------");
        System.out.println("------- NUEVA COMPRA -------");
        System.out.println("----------------------------\n");
        Teclado t = new Teclado();

        Articulo articuloComprado;
        int cantidadComprada;
        double costoLinea;

        Proveedor proveedor = local.buscarProveedor();

        while (proveedor == null){
            int aux = t.proveedorNoExiste();
            switch (aux) {
                case 1 -> proveedor = local.buscarProveedor();
                case 2 -> {
                    local.nuevoProveedor(cargarNuevoProveedor(local));
                    proveedor = local.getListaProveedores().getElemento(local.getListaProveedores().getLista().size() - 1);
                }
                default -> System.out.println("\nLa opcion ingresada no es valida.\n");
            }
        }

        Compra nuevaCompra = new Compra(proveedor);

        do {

            articuloComprado = local.buscarArticuloID();
            boolean flag = false;
            while(articuloComprado == null) {
                int aux = t.nombreArticuloCompradoNoExiste();
                switch (aux) {
                    case 1 -> articuloComprado = local.buscarArticuloID();
                    case 2 ->{
                        local.nuevoArticulo(cargarNuevoArticulo(local));
                        articuloComprado = local.getListaArticulos().getElemento(local.getListaArticulos().getLista().size() - 1);
                        flag = true;
                    }
                    default -> System.out.println("\nLa opcion ingresada no es valida.\n");
                }
            }

            if(!flag){
                cantidadComprada = t.cargarCantidadArticulo();
                while(cantidadComprada < 1){
                    cantidadComprada = t.cantidadCeroONegativa(cantidadComprada);
                }

                costoLinea = t.cargarCostoLinea();
                while(costoLinea <= 0){
                    costoLinea = t.costoCeroONegativo(costoLinea);
                }
                nuevaCompra.agregarLinea(articuloComprado, cantidadComprada, costoLinea);
                local.masStock(articuloComprado, cantidadComprada);
                local.actualizarPrecio(articuloComprado);
            }else {
                nuevaCompra.agregarLinea(articuloComprado, articuloComprado.getStock(), articuloComprado.getCosto());
            }

        } while(t.continuarCargandoLineasCompra());

        return nuevaCompra;
    }

    /**
     * Método para cargar los datos de una nueva venta, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará la nueva venta.
     * @return venta nuevo a registrar.
     */
    public Venta cargarNuevaVenta(Local local, Caja caja) {
        System.out.println("\n---------------------------");
        System.out.println("------- NUEVA VENTA -------");
        System.out.println("---------------------------\n");

        Teclado t = new Teclado();
        int cuitCliente = -1;
        Cliente cliente = local.buscarCliente();

        while (cliente == null){
            cuitCliente = t.clienteNoExiste();
            switch (cuitCliente) {
                case 1 -> cliente = local.buscarCliente();
                case 2 -> cliente = local.getListaClientes().getElemento(0);
                case 3 -> {
                    local.nuevoCliente(cargarNuevoCliente(local));
                    cliente = local.getListaClientes().getElemento(local.getListaClientes().getContadorId() - 1);
                }
                default -> System.out.println("\nLa opcion ingresada no es valida.\n");
            }
        }

        Venta nuevaVenta = new Venta(cliente, caja.getIdCaja());

        String metodoPago = cargarMetodoDePago();
        nuevaVenta.setMetodoPago(metodoPago);
        if(metodoPago != null){
            do {
                Articulo art = local.buscarArticuloID();

                while(art == null && cuitCliente != 0) {
                    cuitCliente = t.articuloNoExiste();
                    switch (cuitCliente){
                        case 1 :
                            art = local.buscarArticuloID();
                            break;
                        case 2 :
                            local.nuevoArticulo(cargarNuevoArticulo(local));
                            art = local.getListaArticulos().getElemento(local.getListaArticulos().getContadorId() - 1);
                            break;
                        case 0 :
                            break;
                        default:
                            System.out.println("\nLa opcion ingresada no es valida.\n");
                    }
                }

                if (art != null) {
                    int cant = nuevaVenta.cargarCantidadArticulo(art);
                    if(cant != 0){
                        nuevaVenta.agregarLinea(art, cant);
                        local.menosStock(art,cant);
                        caja.actualizarDinero(nuevaVenta.generarTotal(local.getListaDescuento()));
                    }
                }
                else
                    System.out.println("Se cancelo la carga \n");

            }while (t.continuarCargandoLineasVenta());
        }

        return nuevaVenta;
    }


    /**
     * Método para cargar los datos de un nuevo descuento del tipo tarjeta, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará el nuevo descuento.
     * @return descuento nuevo a registrar.
     */
    public DescTarjeta cargarNuevoDescuentoTarjeta(Local local) {
        System.out.println("\n----------------------------------");
        System.out.println("------- NUEVO DTO. TARJETA -------");
        System.out.println("----------------------------------\n");
        Teclado t = new Teclado();
        String nombre = t.cargarNombreDescuentoTarjeta();
        int porcentaje = t.ingresePorcentajeDesc();
        String tarjeta = cargarTarjeta();

        return new DescTarjeta(porcentaje, tarjeta, nombre);
    }

    /**
     * Método para cargar una nueva marca
     * @param local
     * @return La nueva marca creada
     * Null, en caso de que ya exista
     */
    public Marca cargarNuevaMarca(Local local){
        System.out.println("\n---------------------------");
        System.out.println("------- NUEVA MARCA -------");
        System.out.println("---------------------------\n");
        Teclado t = new Teclado();
        Validacion v = new Validacion();
        String nombre = t.cargarNombreMarca();

        if (!v.validacionMarcaNueva(local.getListaMarca(), nombre)){
            return new Marca(nombre);
        }else{
            t.marcaYaExiste();
        }

        return null;
    }

    /**
     * Método para cargar una nueva marca
     * @param local
     * @return El nuevo departamento creado
     * Null, en caso de que ya exista
     */
    public Departamento cargarNuevoDepartamento(Local local){
        System.out.println("\n--------------------------------");
        System.out.println("------- NUEVO DEPARTAMENTO -------");
        System.out.println("----------------------------------\n");
        Teclado t = new Teclado();
        Validacion v = new Validacion();
        String nombre = t.cargarNombreDepartamento();

        if (!v.validacionDepartamentoNuevo(local.getListaDepartamento(), nombre)){
            return new Departamento(nombre);
        }else{
            t.departamentoYaExiste();
        }

        return null;
    }

    /**
     * Método para ingresar el metodo de pago
     * @return un String con el nombre del Enum
     */
    public String cargarMetodoDePago() {
        System.out.println("\n------- Selección de Método de Pago -------\n");
        int aux;
        MetodoPago metodoPago = null;
        Teclado t = new Teclado();
        do {
            aux = t.cargarMetodoPago();
            switch (aux) {
                case 1 -> metodoPago = MetodoPago.Efectivo;
                case 2 -> {
                    return cargarTarjeta();
                }
                case 3 -> metodoPago = MetodoPago.Cheque;
                default -> System.out.println("\nLa opcion ingresada no es valida.\n");
            }
        } while (aux != 1 && aux != 3 && aux != 0);

        return metodoPago.name();
    }

    /**
     * Método para la seleccion de la tarjeta.
     * @return el nombre de la tarjeta seleccionada.
     */
    public String cargarTarjeta() {
        System.out.println("\n------- Selección de Tarjeta -------\n");
        int aux;
        String tarjeta = null;
        Teclado t = new Teclado();
        do {
            aux = t.cargarTarjeta();
            switch (aux) {
                case 1 -> tarjeta = "Visa";
                case 2 -> tarjeta = "Mastercad";
                case 3 -> tarjeta = "Cabal";
                case 4 -> tarjeta = "American Express";
                case 5 -> tarjeta = "Maestro";
                case 6 -> tarjeta = "Naranja";
                default -> System.out.println("\nLa opcion ingresada es incorrecta, ingrese 0 de si desea salir.\n");
            }

        } while (aux != 1 && aux != 2 && aux != 3 && aux != 4 && aux != 5 && aux != 6 && aux != 0);

        return tarjeta;
    }

    /**
     * Método para modificar el articulo recibido por parámetro.
     * @param articulo a modificar
     * @param local en el que se encuentra el artículo.
     */
    public void modificarArticuloSalida(Articulo articulo, Local local) {
        System.out.println("\n----------------------------------------");
        System.out.println("------- MODIFICACION DE ARTICULO -------");
        System.out.println("----------------------------------------\n");
        Teclado t = new Teclado();
        int aux;
        do{
            switch (aux = t.menuModificiarArticulo(articulo)) {
                case 1 -> {
                    articulo.setNombre(t.cargarNombreArticulo());
                    System.out.println("Nombre editado con exito.");
                }
                case 2 -> {
                    Departamento depto = local.buscarDepartamento();
                    while (depto == null) {
                        depto = menuDepartamentoNoExiste(local);
                    }
                    articulo.setDepartamento(depto);
                    System.out.println("Departamento editad con exito.");
                }
                case 3 -> {
                    Marca marca = local.buscarMarca();
                    while (marca == null) {
                        marca = menuMarcaNoExiste(local);
                    }
                    articulo.setMarca(marca);
                    System.out.println("Marca editada con exito.");
                }
                case 4 -> {
                    articulo.setCosto(t.cargarCosto());
                    System.out.println("Costo editado con exito.");
                }
                case 5 -> {
                    articulo.setUtilidad(t.cargarUtilidadArticulo());
                    System.out.println("Utilidad editada con exito.");
                }
                case 6 -> {
                    articulo.setStock(t.cargarStock());
                    System.out.println("Stock editado con exito.");
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("\nLa opcion ingresada no es valida.\n");
            }
        }while(aux != 0);
    }

    /**
     * Método para modificar el cliente recibido por parámetro.
     * @param cliente a modificar.
     */
    public void modificarClienteSalida(Cliente cliente){

        Teclado t = new Teclado();
        int aux;
        do{
            System.out.println("\n---------------------------------------");
            System.out.println("------- MODIFICACION DE CLIENTE -------");
            System.out.println("---------------------------------------\n");
            switch (aux = t.menuModificarCliente(cliente)) {
                case 1 -> {
                    cliente.setNombre(t.cargarNombreCliente());
                    System.out.println("Nombre editado con exito.");
                }
                case 2 -> {
                    cliente.setApellido(t.cargarApellido());
                    System.out.println("Apellido editado con exito.");
                }
                case 3 -> {
                    cliente.setDomicilio(t.cargarDireccion());
                    System.out.println("Domicilio editado con exito.");
                }
                case 4 -> {
                    cliente.setTelefono(t.cargarTelefono());
                    System.out.println("Telefono editado con exito.");
                }
                case 5 -> {
                    cliente.setEmail(t.cargarEmail());
                    System.out.println("Email editado con exito.");
                }
                case 0 -> System.out.println("Saliendo..");
                default -> System.out.println("\nLa opcion ingresada no es valida.\n");
            }
        }while(aux != 0);
    }

    /**
     * Método para modificar el proveedor recibido por parámetro.
     * @param proveedor a modificar.
     */
    public void modificarProvSalida(Proveedor proveedor){
        System.out.println("\n-----------------------------------------");
        System.out.println("------- MODIFICACION DE PROVEEDOR -------");
        System.out.println("-----------------------------------------\n");
        int aux;
        Teclado t = new Teclado();
        do{
            switch (aux = t.menuModificarProveedor(proveedor)){
                case 1:
                    proveedor.setNombre(t.cargarNombreCliente());
                    System.out.println("Nombre editado con exito.");
                    break;
                case 2:
                    proveedor.setApellido(t.cargarApellido());
                    System.out.println("Apellido editado con exito.");
                    break;
                case 3:
                    proveedor.setDomicilio(t.cargarDireccion());
                    System.out.println("Domicilio editado con exito.");
                    break;
                case 4:
                    proveedor.setTelefono(t.cargarTelefono());
                    System.out.println("Telefono editado con exito.");
                    break;
                case 5:
                    proveedor.setEmail(t.cargarEmail());
                    System.out.println("Email editado con exito.");
                    break;
                case 6:
                    proveedor.setLocalidad(t.cargarLocalidad());
                    System.out.println("Localidad editada con exito.");
                case 0:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("\nLa opcion ingresada no es valida.\n");
            }
        }while(aux != 0);
    }
}
