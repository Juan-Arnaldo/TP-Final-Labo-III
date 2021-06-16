package com.company.Utilidad;

import com.company.Articulo.Articulo;
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
    private Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }

    /**
     * Método para el menú que aparecerá al inicio del programa.
     * @param local en el que se trabajará.
     */
    public void menuInicio(Local local) {
        System.out.println("\nBienvenido\n");
        int opc = 0;
        do{
            opc = cargarOpcionMenuInicio();
            Caja caja = null;

            switch (opc) {
                case 1:
                    caja = menuSeleccionCaja(local);
                    menuCaja(local, caja);
                    break;
                case 2:
                    local.nuevaCaja();
                    caja = local.getListaCajas().getElemento(local.getListaCajas().getLista().size()-1);
                    menuCaja(local, caja);
                    break;
                case 3:
                    System.out.println("\nSaliendo...\n");
                    break;
                default:
                    System.out.println("Opcion erronea.\nVuelva a intentarlo.\n");
                    break;
            }
        }while (opc != 3);
    }

    /**
     * Método para cargar la opción a elegir en el menú principal.
     * @return opción.
     */
    public int cargarOpcionMenuInicio() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Seleccionar caja.");
        System.out.println("2 - Nueva caja.");
        System.out.println("3 - Salir.");
        return sc.nextInt();
    }

    /**
     * Menú que se encarga de mostrar las cajas disponibles y le permite al usuario seleccionar una para trabajar.
     * @param local al que pertenecen las cajas
     */
    public Caja menuSeleccionCaja(Local local) {
        mostrarCajas(local);
        int idCaja = cargarIdCaja();
        return local.buscarCaja(idCaja);
    }

    /**
     * Método para cargar por teclado el ID de la caja a seleccionar.
     * @return id de la caja seleccionada.
     */
    public int cargarIdCaja() {
        System.out.println("Ingrese el ID de la caja a seleccionar: ");
        return sc.nextInt();
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

    public void menuCaja (Local local, Caja caja) {
        System.out.println("\nBienvenido a la Caja " + caja.getIdCaja() + "\n");
        int opc = 0;
        do{
            opc = cargarOpcionMenuCaja();

            switch (opc) {
                case 1:
                    caja.nuevaVenta(cargarNuevaVenta(local, caja), local);
                    break;
                case 2:
                    //TODO codear detalle del día para la caja
                    break;
                case 3:
                    //menuArticulos();
                    break;
                case 4:
                    //menuClietes();
                    break;
                case 5:
                    local.nuevaCompra(cargarNuevaCompra(local));
                    break;
                case 6:
                    //menuProveedores();
                    break;
                case 7:
                    System.out.println("\nSaliendo...\n");
                    break;
                default:
                    System.out.println("Opcion erronea.\nVuelva a intentarlo.\n");
                    break;
            }
        }while (opc != 7);
    }

    /**
     * Método para cargar la opción a elegir en el menú de caja.
     * @return opción.
     */
    public int cargarOpcionMenuCaja() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Nueva Venta.");
        System.out.println("2 - Detalles del día.");
        System.out.println("3 - Menú Artículos.");
        System.out.println("4 - Menú Clientes.");
        System.out.println("5 - Nueva Compra.");
        System.out.println("6 - Menú Proveedores.");
        System.out.println("6 - Menú Descuentos.");
        System.out.println("7 - Salir.");
        return sc.nextInt();
    }

    /**
     * Método para cargar los datos de un nuevo cliente, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará el nuevo cliente.
     * @return cliente nuevo a registrar.
     */
    public Cliente cargarNuevoCliente(Local local) {
        Teclado t = new Teclado();
        Validacion validacion = new Validacion();

        String cuit = t.cargarCuit();
        while(validacion.validarCuitCliente(cuit, local.getListaClientes().getLista())) {
            cuit = t.cargarNuevamenteCuitPersona(cuit);
        }

        String nombre = t.cargarNombre();
        String apellido = t.cargarApellido();
        String direc = t.cargarDireccion();
        String tel = t.cargarTelefono();

        String email = t.cargarEmail();
        while(!validacion.validacionEmailValido(email)) {
            email = t.cargarNuevamenteEmailPersona(email);
        }

        return new Cliente(nombre, direc, cuit, tel, email, apellido);
    }

    /**
     * Método para cargar los datos de un nuevo proveedor, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará el nuevo proveedor.
     * @return proveedor nuevo a registrar.
     */
    public Proveedor cargarNuevoProveedor(Local local) {
        Teclado t = new Teclado();
        Validacion validacion = new Validacion();

        String cuit = t.cargarCuit();
        while(validacion.validarCuitProveedor(cuit, local.getListaProveedores().getLista())) {
            cuit = t.cargarNuevamenteCuitPersona(cuit);
        }

        String nombre = t.cargarNombre();
        String apellido = t.cargarApellido();
        String direc = t.cargarDireccion();
        String tel = t.cargarTelefono();
        String email = t.cargarEmail();

        while(!validacion.validacionEmailValido(email)) {
            email = t.cargarNuevamenteEmailPersona(email);
        }
        String localidad = t.cargarLocalidad();

        return new Proveedor(nombre, direc, cuit, tel, email, localidad, apellido);
    }

    /**
     * Método para cargar los datos de un nuevo artículo, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará el nuevo artículo.
     * @return artículo nuevo a registrar.
     */
    public Articulo cargarNuevoArticulo(Local local) {
        Teclado t = new Teclado();
        Validacion v = new Validacion();

        String nombre, departamento, marca;
        int stock = 0;
        double utilidad, costo;
        nombre = t.cargarNombreArticulo();
        while (local.nombreArticuloRepetido(nombre)) {
            nombre = t.cargarNuevamenteNombreArticulo(nombre);
        }
        departamento = t.cargarDepartamentoArticulo();
        //TODO - Buscar la forma de validar existencia de departamentos. ¿Enum?
        marca = t.cargarMarcaArticulo();
        //TODO - Buscar la forma de validar existencia de marca. ¿Enum?

        costo = t.cargarCosto();
        while (!v.mayorQueCero(costo)){
            costo = t.cargarCostoNuevamente();
        }

        utilidad = t.cargarUtilidadArticulo();
        while (utilidad < 0 || utilidad > 1000) {             // ¿Puede haber artículos que se vendan al costo? (Utilidad = 0)
            if (utilidad < 0)
                utilidad = t.cargarNuevamenteUtilidadNegativa(utilidad);
            if (utilidad > 1000)
                utilidad = t.cargarNuevamenteUtilidadExcesiva(utilidad);
        }

        stock = t.cargaStock();
        while(stock < 0){
            stock = t.cargaStockNuevamente();
        }

        return new Articulo(nombre, departamento, marca, costo, utilidad, stock);
    }

    /**
     * Método para cargar los datos de una nueva compra, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará la nueva compra.
     * @return compra nuevo a registrar.
     */
    public Compra cargarNuevaCompra(Local local) {
        Teclado t = new Teclado();
        Compra nuevaCompra = new Compra();

        int idArticuloComprado;
        Articulo articuloComprado = null;
        int cantidadComprada = 0;
        double costoLinea = 0;

        Proveedor proveedor = local.buscarProveedor();

        while (proveedor == null){
            int aux = t.proveedorNoExiste();
            switch (aux){
                case 1:
                    proveedor = local.buscarProveedor();
                    break;
                case 2:
                    local.nuevoProveedor(cargarNuevoProveedor(local));
                    proveedor = local.buscarProveedor();
                    break;
                default:
                    System.out.println("\nLa opcion ingresada es incorrecta");
                    break;
            }
        }

        do {

            idArticuloComprado = t.cargarID();
            articuloComprado = local.buscarArticuloID(idArticuloComprado);

            while(articuloComprado == null) {                                            // En caso de que el nombre ingresado no corresponda con un artículo registrado
                switch (t.nombreArticuloCompradoNoExiste(idArticuloComprado)) {        // Le pregunto al usuario qué desea hacer
                    case 1 :
                        idArticuloComprado = t.cargarID();                 // Corrige el nombre cargado
                        break;
                    case 2 :
                        local.nuevoArticulo(cargarNuevoArticulo(local));                 // El nombre es correcto y decide cargarlo en el registro de artículos
                        break;
                    default:
                        System.out.println("La opcion ingresada no es valida.");         // Toca tecla que no va
                        break;
                }
            }

            cantidadComprada = t.cargarCantidadArticulo();                                 // Carga de la Cantidad de Artículos en la Línea
            while(cantidadComprada < 1){
                cantidadComprada = t.cantidadCeroONegativa(cantidadComprada);
            }

            costoLinea = t.cargarCostoLinea();                                             // Carga del Costo de la Línea
            while(costoLinea <= 0){
                costoLinea = t.costoCeroONegativo(costoLinea);
            }

            nuevaCompra.agregarLinea(articuloComprado, cantidadComprada, costoLinea);
        } while(t.continuarCargandoLineasCompra());

        return nuevaCompra;
    }

    /**
     * Método para cargar los datos de una nueva venta, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará la nueva venta.
     * @return venta nuevo a registrar.
     */
    public Venta cargarNuevaVenta(Local local, Caja caja) {
        Teclado t = new Teclado();
        Cliente cliente = local.buscarCliente();

        while (cliente == null){
            int aux = t.clienteNoExiste();
            switch (aux){
                case 1:
                    cliente = local.buscarCliente();
                    break;
                case 2:
                    cliente = local.getListaClientes().getElemento(0);
                    break;
                case 3:
                    local.nuevoCliente(cargarNuevoCliente(local));
                    cliente = local.buscarCliente();
                    break;
                default:
                    System.out.println("\nLa opcion ingresada es incorrecta");
                    break;
            }
        }

        Venta nuevaVenta = new Venta(cliente, caja.getIdCaja());

        String metodoPago = cargarMetodoDePago();
        nuevaVenta.setMetodoPago(metodoPago);
        if(metodoPago != null){
            do {

                local.mostrarListaArticuloOptimizada();
                int  id = t.cargarID();
                Articulo art = local.buscarArticuloID(id);

                if (art != null) {
                    int cant = nuevaVenta.cargarCantidadArticulo(art);
                    if(cant != 0){
                        nuevaVenta.agregarLinea(art, cant);
                        local.nuevoStock(art,cant);///TODO borrar estas, es solo para mostrar ahora xd
                        System.out.println("viejo "+ caja.getDinero());
                        caja.actualizarDinero(nuevaVenta.generarTotal(local.getListaDescuento()));
                        System.out.println("nuevo "+ caja.getDinero());
                    }
                }
                else
                    System.out.println("El articulo no existe");

            }while (t.deseaContinuar());
        }

        return nuevaVenta;
    }


    /**
     * Método para cargar los datos de un nuevo descuento del tipo tarjeta, con sus correspondientes validaciones.
     * @param local en cuyo registro se cargará el nuevo descuento.
     * @return descuento nuevo a registrar.
     */
    public DescTarjeta cargarNuevoDescuentoTarjeta(Local local) {
        Teclado t = new Teclado();
        String nombre = t.cargarNombre();

        int porcentaje = t.ingresePorcentajeDesc();

        while (porcentaje <= 0 || porcentaje > 100){
            porcentaje = t.ingresePorcentajeDescNuevamente();
        }
        String tarjeta = seleccionTarjeta();

        return new DescTarjeta(porcentaje, tarjeta, nombre);
    }

    /**
     * Método para cargar por teclado la marca de un artículo.
     * @return marca del artículo cargado.
     */
    public String cargarMarcaArticulo() {
        System.out.println("Ingrese la marca del artículo: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado la utilidad de un articulo.
     * @return utilidad del articulo.
     */
    public double cargarUtilidadArticulo() {
        System.out.println("Ingrese la utilidad del articulo: ");
        return sc.nextDouble();
    }

    /**
     * Método para volver a cargar la utilidad de un articulo en caso de que el valor ingresado anteriormente sea negativo.
     * @param utilidad cargada anteriormente.
     * @return Utilidad presuntamente corregida.
     */
    public double cargarNuevamenteUtilidadNegativa(double utilidad) {
        System.out.println(utilidad + " no es una utilidad válida. Se desea ganar dinero con las ventas.");
        System.out.println("Ingrese nuevamente la utilidad del articulo: ");
        return sc.nextDouble();
    }

    /**
     * Método para volver a cargar la utilidad de un articulo en caso de que el valor ingresado anteriormente sea excesivo.
     * @param utilidad cargada anteriormente.
     * @return Utilidad presuntamente corregida.
     */
    public double cargarNuevamenteUtilidadExcesiva(double utilidad) {
        System.out.println(utilidad + " no es una utilidad válida.");
        System.out.println("Ingrese nuevamente la utilidad del articulo: ");
        return sc.nextDouble();
    }

    /**
     * Método para consultar al usuario si desea continuar cargando artículos.
     * @return true en caso de que desee continuar; false en caso de que no desee continuar.
     */
    public boolean continuarCargandoArticulos(){
        System.out.println("¿Desea continuar cargando artículos?");
        System.out.println("Presione 1 si es así. En caso contrario presione cualquier otro número.");
        int aux = sc.nextInt();
        if(aux == 1){
            return true;
        }
        return false;
    }

    /**
     * Método para consultar al usuario si desea continuar cargando artículos.
     * @return true en caso de que desee continuar; false en caso de que no desee continuar.
     */
    public boolean continuarCargandoLineasCompra(){
        System.out.println("¿Desea continuar cargando lineas en la compra?");
        System.out.println("Presione 1 si es así. Para finalizar compra presione cualquier otro número.");
        int aux = sc.nextInt();
        if(aux == 1){
            return true;
        }
        return false;
    }

    /**
     * Método para cargar por teclado la cantidad deseada.
     * @return cantidad deseada
     */
    public int cargarCantidadArticulo(){
        System.out.println("Ingrese la cantidad del articulo: ");
        return sc.nextInt();
    }

    /**
     * Método para volver a cargar por teclado la cantidad deseada luego de la validación fallida.
     * @return cantidad deseada
     */
    public int cargarNuevamenteCantidadArticulo(int cantidad){
        System.out.println("No se puede vender la cantidad ingresada. ("+ cantidad+" en stock)");
        System.out.println("Ingrese nuevamente la cantidad del articulo: ");
        return sc.nextInt();
    }

    /**
     * Método para volver a cargar la cantidad de artículos en caso de que el valor ingresado anteriormente no sea posible.
     * @param cantidad cargada anteriormente.
     * @return Cantidad presuntamente corregida.
     */
    public int cantidadCeroONegativa(int cantidad) {
        System.out.println(cantidad + " no es una cantidad de artículos válida.");
        System.out.println("Ingrese nuevamente la cantidad del articulo: ");
        return sc.nextInt();
    }

    /**
     * Método para cargar el costo de la linea comprada.
     * @return costo de la linea.
     */
    public double cargarCostoLinea() {
        System.out.println("Ingrese el costo de la linea: ");
        return sc.nextDouble();
    }

    /**
     * Método para volver a cargar el costo de una linea en caso de que el valor ingresado anteriormente no sea posible.
     * @param costo cargado anteriormente.
     * @return costo presuntamente corregido.
     */
    public double costoCeroONegativo(double costo) {
        System.out.println(costo + " no es un costo de línea válida.");
        System.out.println("Ingrese nuevamente el costo de la linea: ");
        return sc.nextDouble();
    }

    /**
     * Método para cargar por teclado el metodo de pago
     * @return
     */
    public int cargarMetodoPago(){
        System.out.println("1.Efectivo");
        System.out.println("\n2.Tarjeta");
        System.out.println("\n3.Cheque");
        System.out.println("\nIngrese el metodo con el que va a pagar: ");
        return sc.nextInt();
    }

    /**
     * Método para cargar por teclado el nombre de la tarjeta con la que se realizará el pago.
     * @return Opción elegida en forma de int.
     */
    public int cargarTarjeta(){
        System.out.println("1. Visa");
        System.out.println("\n2. Mastercard");
        System.out.println("\n3. Cabal");
        System.out.println("\n4. American Express");
        System.out.println("\n5. Maestro");
        System.out.println("\n6. Naranja");
        System.out.println("\nIngrese la tarjeta del cliente: ");

        return sc.nextInt();
    }

    /**
     * Método para elegir cómo seguir en caso de que el nombre ingresado no corresponda a un artículo existente en los registros de local.
     * @param nombre - Nombre ingresado.
     * @return Opción elegida en forma de int. 1 - Intentar nuevamente. 2 - Agregar " + " al registro.");.
     */
    public int nombreArticuloCompradoNoExiste(String nombre) {
        System.out.println(nombre + " no corresponde a un artículo registrado.");
        System.out.println("1 - Intentar nuevamente.");
        System.out.println("2 - Agregar " + nombre + " al registro.");
        System.out.println("Seleccione la acción a realizar:");
        return sc.nextInt();
    }

    public int clienteNoExiste(){
        System.out.println("\nEl cliente buscado no existe. ");
        System.out.println("\n1. Volver a cargar el CUIT");
        System.out.println("\n2. Pasar venta como consumidor final");
        System.out.println("\n3. Crear nuevo cliente");
        System.out.println("\n4. Ingrese la accion a realizar: ");
        return sc.nextInt();
    }

    public int proveedorNoExiste(){
        System.out.println("\nEl proveedor buscado no existe. ");
        System.out.println("\n1. Volver a cargar el CUIT");
        System.out.println("\n2. Crear nuevo proveedor");
        System.out.println("\n3. Ingrese la accion a realizar: ");
        return sc.nextInt();
    }

    public int ingresePorcentajeDesc(){
        System.out.println("Ingrese el porcentaje que quiere que tenga: ");
        return sc.nextInt();
    }

    public int ingresePorcentajeDescNuevamente(){
        System.out.println("El porcentaje ingresado no es correcto, ingreselo nuevamente");
        System.out.println("(tiene que ser mayor a 0 y menor o igual a 100):");
        return sc.nextInt();
    }

    /**
     * Método para cargar por teclado un nombre.
     * @return nombre cargado.
     */
    public String cargarNombre() {
        System.out.println("Ingrese el nombre: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el nombre de una Persona.
     * @return nombre de la persana cargado.
     */
    public String cargarApellido() {
        System.out.println("Ingrese el apellido: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado la dirección de una Persona.
     * @return dirección de la persana cargado.
     */
    public String cargarDireccion() {
        System.out.println("Ingrese la direccion: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el teléfono de una Persona.
     * @return teléfono de la persana cargado.
     */
    public String cargarTelefono() {
        System.out.println("Ingrese el telefono: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el CUIT de una Persona.
     * @return CUIT de la persana cargado.
     */
    public String cargarCuit() {
        System.out.println("Ingrese el cuit: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar el CUIT de una persona en caso de que el CUIT ingresado anteriormente no sea posible.
     * @param cuit cargado anteriormente.
     * @return CUIT presuntamente corregido.
     */
    public String cargarNuevamenteCuitPersona(String cuit) {
        System.out.println(cuit + " es el CUIT de una persona que ya existe en el registro.");
        System.out.println("Ingrese nuevamente el CUIT: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el email de una Persona.
     * @return email de la persana cargado.
     */
    public String cargarEmail() {
        System.out.println("Ingrese el email: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar por teclado el email luego de la validación fallida.
     * @param email cargado anteriormente.
     * @return email presuntamente corregido.
     */
    public String cargarNuevamenteEmailPersona(String email) {
        System.out.println(email + " no es una dirección de correo electrónico válida.");
        System.out.println("Ingrese nuevamente el email: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado la localidad de un Proveedor.
     * @return localidad del proveedor cargado.
     */
    public String cargarLocalidad(){
        System.out.println("Ingrese la localidad: ");
        return sc.nextLine();
    }

    /**
     * Metodo para ingresar lo que quiere modificar
     * @return el numero
     */
    public int modificiarArticulo(){
        System.out.println("1. Nombre");
        System.out.println("\n2. Departamento");
        System.out.println("\n3. Marca");
        System.out.println("\n4. Costo");
        System.out.println("\n5. Utilidad");
        System.out.println("\n6. Precio");
        System.out.println("\n0. Salir");
        System.out.println("\nIngrese lo que quiere modificar: ");
        return sc.nextInt();
    }

    public int numeroCaja(){
        System.out.println("Ingrese el numero de caja a operar: ");
        return sc.nextInt();
    }

    public String cargarMetodoDePago() {
        int aux;
        MetodoPago metodoPago = null;
        Teclado t = new Teclado();
        do {
            aux = t.cargarMetodoPago();
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
                    System.out.println("La opcion ingresada no es valida");
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
        Teclado t = new Teclado();
        do {
            aux = t.cargarTarjeta();
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

    public void modificarArticulo(Articulo articulo) {
        Teclado t = new Teclado();
        int aux;
        do{
            aux = t.modificiarArticulo();
            switch (aux){
                case 1:
                    articulo.setNombre(t.cargarNombreArticulo());
                    break;
                case 2:
                    articulo.setDepartamento(t.cargarDepartamentoArticulo());
                    break;
                case 3:
                    articulo.setMarca(t.cargarMarcaArticulo());
                    break;
                case 4:
                    articulo.setCosto(t.cargarCostoArticulo());
                    break;
                case 5:
                    articulo.setUtilidad(t.cargarUtilidadArticulo());
                    break;
                case 6:
                    articulo.setStock(t.cargarCantidadArticulo());
                    break;
                default:
                    System.out.println("La opcion ingresada no es correcta!\n");
                    break;
            }
        }while(aux != 1 && aux != 2 && aux != 3 && aux != 4 && aux != 5 && aux != 6 && aux != 0);
    }

}
