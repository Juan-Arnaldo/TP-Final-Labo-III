package com.company.Utilidad;

import com.company.Articulo.Articulo;
import com.company.Contenedor.ContenedorArrayList;
import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;
import java.util.Scanner;

public class Teclado {
    private Scanner sc = new Scanner(System.in);

    /**
     * Método para cargar la opción a elegir en el menú principal.
     * @return opción.
     */
    public String cargarOpcionMenuInicio() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Seleccionar caja.");
        System.out.println("2 - Nueva caja.");
        System.out.println("0 - Salir.");
        return sc.nextLine();
    }


    /**
     * Método para cargar la opción a elegir en el menú de caja.
     * @return opción.
     */
    public String cargarOpcionMenuCaja() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Nueva Venta.");
        System.out.println("2 - Detalles.");
        System.out.println("3 - Menú Artículos.");
        System.out.println("4 - Menú Clientes.");
        System.out.println("5 - Nueva Compra.");
        System.out.println("6 - Menú Proveedores.");
        System.out.println("7 - Menú Descuentos.");
        System.out.println("0 - Salir.");
        return sc.nextLine();
    }

    /**
     * Método para cargar la opción a elegir en el menú de caja.
     * @return opción.
     */
    public String cargarOpcionMenuDetalles(int idCaja) {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Mostrar Dinero de la Caja " + idCaja + ".");
        System.out.println("2 - Mostrar Ventas de la Caja " + idCaja + ".");
        System.out.println("3 - Mostrar Compras.");
        System.out.println("0 - Salir.");
        return sc.nextLine();
    }

    /**
     * Método para cargar la opción a elegir en el menú de artículo.
     * @return opción.
     */
    public String cargarOpcionMenuArticulo() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Nuevo Articulo.");
        System.out.println("2 - Editar Articulo.");
        System.out.println("3 - Eliminar Articulo.");
        System.out.println("4 - Mostrar Articulo.");
        System.out.println("0 - Salir.");
        return sc.nextLine();
    }

    /**
     * Método para cargar la opción a elegir en el menú de artículo.
     * @return opción.
     */
    public String cargarOpcionMenuDescuento() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Nuevo Descuento.");
        System.out.println("2 - Eliminar Descuento.");
        System.out.println("3 - Mostrar Descuento.");
        System.out.println("0 - Salir.");
        return sc.nextLine();
    }
    /**
     * Método para cargar la opción a elegir en el menú de cliente.
     * @return opción.
     */
    public String cargarOpcionMenuCliente() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Nuevo Cliente.");
        System.out.println("2 - Editar Cliente.");
        System.out.println("3 - Eliminar Cliente.");
        System.out.println("4 - Mostrar Cliente.");
        System.out.println("0 - Salir.");
        return sc.nextLine();
    }
    /**
     * Método para cargar la opción a elegir en el menú de proveedor.
     * @return opción.
     */
    public String cargarOpcionMenuProv() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Nuevo Proveedor.");
        System.out.println("2 - Editar Proveedor.");
        System.out.println("3 - Eliminar Proveedor.");
        System.out.println("4 - Mostrar Proveedor.");
        System.out.println("0 - Salir.");
        return sc.nextLine();
    }

    /**
     * Método para consultar al usuario si desea continuar con lo que está realizando.
     * @return true en caso de que desee continuar; false en caso de que no desee continuar.
     */
    public boolean deseaContinuar() {
        System.out.println("Ingrese 1 si desea continuar \n");
        int aux = sc.nextInt();
        if (aux == 1) {
            return true;
        }
        return false;
    }

    /**
     * Método para cargar por teclado el ID de la caja a seleccionar.
     * @return id de la caja seleccionada.
     */
    public String cargarIdCaja() {
        System.out.println("Ingrese el ID de la caja a seleccionar: ");
        return sc.nextLine();
    }
    /**
     * Método para cargar por teclado el stock de un artículo.
     * @return stock cargado.
     */
    public int cargarStock() {
        System.out.println("Ingrese el stock: ");
        return sc.nextInt();
    }

    /**
     * Método para cargar nuevamente por teclado stock en caso de que el ingresado sea negativo.
     * @return stock cargado.
     */
    public int cargarNuevamenteStockNegativo(int stock){
        System.out.println(stock + "no es un valor de stock válido. Debe ser positivo");
        System.out.println("Intente nuevamente: ");
        return sc.nextInt();
    }

    /**
     * Método para cargar por teclado el ID del artículo a seleccionar.
     * @return id del artículo seleccionado.
     */
    public int cargarIDArticulo(){
        System.out.println("Ingrese el id del art: ");
        return sc.nextInt();
    }

    /**
     * Método para cargar por teclado el ID del artículo a seleccionar.
     * @return id del artículo seleccionado.
     */
    public int cargarIdDescuento(){
        System.out.println("Ingrese el id del descuento: ");
        return sc.nextInt();
    }

    /**
     * Método para cargar por teclado el nombre de un artículo.
     * @return nombre del artículo cargado.
     */
    public String cargarNombreArticulo() {
        System.out.println("Ingrese el nombre del artículo: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar el nombre de un artículo en caso de que el nombre ingresado anteriormente no sea posible.
     * @param nombre cargado anteriormente.
     * @return Nombre presuntamente corregido.
     */
    public String cargarNuevamenteNombreArticulo(String nombre) {
        System.out.println(nombre + " es el nombre de un artículo que ya existe en el registro.");
        System.out.println("Ingrese nuevamente el nombre del  artículo: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el departamento de un artículo.
     * @return departamento del artículo cargado.
     */
    public String cargarDepartamentoArticulo() {
        System.out.println("Ingrese el departamento del artículo: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el costo de un artículo.
     * @return costo del artículo cargado.
     */
    public double cargarCosto(){
        System.out.println("Ingrese el costo: ");
        return sc.nextDouble();
    }

    /**
     * Método para cargar nuevamente por teclado stock en caso de que el ingresado sea negativo.
     * @return stock cargado.
     */
    public double cargarNuevamenteCostoNegativo(double costo){
        System.out.println(costo + "no es un valor de costo válido. Debe ser positivo");
        System.out.println("Intente nuevamente: ");
        return sc.nextInt();
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
    public boolean continuarCargandoLineasVenta(){
        System.out.println("¿Desea continuar cargando lineas en la venta?");
        System.out.println("Presione 1 si es así. Para finalizar venta presione cualquier otro número.");
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
        System.out.println("Ingrese el costo del articulo (Unitario): ");
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
    public String cargarMetodoPago(){
        System.out.println("1 - Efectivo");
        System.out.println("2 - Tarjeta");
        System.out.println("3 - Cheque");
        System.out.println("Ingrese el metodo con el que va a pagar: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el nombre de la tarjeta con la que se realizará el pago.
     * @return Opción elegida en forma de int.
     */
    public int cargarTarjeta(){
        System.out.println("1 - Visa");
        System.out.println("2 - Mastercard");
        System.out.println("3 - Cabal");
        System.out.println("4 - American Express");
        System.out.println("5 - Maestro");
        System.out.println("6 - Naranja");
        System.out.println("Ingrese la tarjeta del cliente: ");

        return sc.nextInt();
    }

    /**
     * Método para elegir cómo seguir en caso de que el nombre ingresado no corresponda a un artículo existente en los registros de local.
     * @return Opción elegida en forma de int:
     *  1 - Intentar nuevamente.
     *  2 - Agregar " + " al registro.");.
     */
    public String nombreArticuloCompradoNoExiste() {
        System.out.println("El nombre no corresponde a un artículo registrado.");
        System.out.println("1 - Intentar nuevamente.");
        System.out.println("2 - Agregar nuevo Articulo. ");
        System.out.println("Seleccione la acción a realizar:");
        return sc.nextLine();
    }

    /**
     * Método para elegir cómo seguir en caso de que el cuit ingresado no corresponda a un cliente existente en los registros de local.
     * @return 1 - Intentar nuevamente.
     *         2 - Pasar Venta como Consumidor Final
     *         3 - Crear Nuevo Cliente
     */
    public int clienteNoExiste(){
        System.out.println( "El cliente buscado no existe. ");
        System.out.println("1 - Volver a cargar el nombre.");
        System.out.println("2 - Pasar venta como consumidor final.");
        System.out.println("3 - Crear nuevo cliente.");
        System.out.println("Ingrese la accion a realizar: ");
        return sc.nextInt();
    }

    /**
     * Método para elegir cómo seguir en caso de que el cuit ingresado no corresponda a un proveedor existente en los registros de local.
     * @return 1 - Intentar nuevamente.
     *         2 - Crear Nuevo Proveedor
     */
    public String proveedorNoExiste(){
        System.out.println("El proveedor buscado no existe. ");
        System.out.println("1 - Volver a cargar el nombre.");
        System.out.println("2 - Crear nuevo proveedor.");
        System.out.println("Ingrese la accion a realizar: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado un porcentaje de un descuento de tipo tarjeta.
     * @return porcentaje cargado.
     */
    public int ingresePorcentajeDesc(){
        String porcentaje;
        boolean aux = false;
        Validacion val = new Validacion();

        System.out.println("Ingrese el porcentaje para el descuento: ");
        porcentaje = sc.nextLine();

        while(!aux){
            aux = val.contieneNumPorcentaje(porcentaje);
            if(!aux){
                porcentaje = ingresePorcentajeDescNuevamente(porcentaje);
            }
        }

        return Integer.parseInt(porcentaje);
    }

    /**
     * Método para cargar nuevamente por teclado un porcentaje de un descuento de tipo tarjeta en caso de eque el ingresado no sea válido.
     * @return nombre cargado.
     * @param porcentaje
     */
    public String ingresePorcentajeDescNuevamente(String porcentaje) {
        System.out.println( porcentaje + " no es un porcentaje válido.");
        System.out.println("Debe ser mayor a 0 y menor o igual a 100.");
        System.out.println("Ingrese nuevamente el porcentaje a descontar: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado un nombre de un descuento de tipo tarjeta.
     * @return nombre cargado.
     */
    public String cargarNombreDescuentoTarjeta() {
        System.out.println("Ingrese el nombre del descuento: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el nombre de una Persona.
     * @return nombre de la persona cargado.
     */
    public String cargarNombreCliente() {
        Validacion validacion = new Validacion();

        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        while(!validacion.contieneSoloLetras(nombre)) {
            nombre = cargarNuevamenteNombrePersona(nombre);
        }
        return nombre;
    }

    /**
     * Método para cargar por teclado el nombre de una Persona.
     * @return nombre de la persona cargado.
     */
    public String cargarNombreProveedor() {
        Validacion validacion = new Validacion();

        System.out.println("Ingrese el nombre del proveedor: ");
        String nombre = sc.nextLine();
        while(!validacion.contieneSoloLetras(nombre)) {
            nombre = cargarNuevamenteNombrePersona(nombre);
        }
        return nombre;
    }

    /**
     * Método para cargar por teclado el apellido de una Persona.
     * @return apellido de la persona cargada.
     */
    public String cargarApellido() {
        Validacion validacion = new Validacion();

        System.out.println("Ingrese el apellido: ");
        String apellido = sc.nextLine();
        while(!validacion.contieneSoloLetras(apellido)) {
            apellido = cargarNuevamenteApellidoPersona(apellido);
        }
        return apellido;
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
        Validacion validacion = new Validacion();

        System.out.println("Ingrese el telefono: ");
        String telefono = sc.nextLine();
        while(!validacion.contieneNumTel(telefono)) {
            telefono = cargarNuevamenteTelefonoPersona(telefono);
        }
        return telefono;
    }

    /**
     * Método para cargar por teclado la localidad de un Proveedor.
     * @return localidad del proveedor cargado.
     */
    public String cargarLocalidad() {
        Validacion validacion = new Validacion();

        System.out.println("Ingrese la localidad: ");
        String localidad = sc.nextLine();
        while(!validacion.contieneSoloLetras(localidad)) {
            localidad = cargarNuevamenteLocalidadPersona(localidad);
        }
        return localidad;
    }

    /**
     * Método para cargar por teclado el CUIT de una Persona.
     * @return CUIT de la persana cargado.
     */
    public String cargarCuitCliente(ContenedorArrayList<Cliente>listaCliente) {
        Validacion validacion = new Validacion();
        System.out.println("Ingrese el cuit: ");
        String cuit = sc.nextLine();
        while(!validacion.contieneNumCuit(cuit)) {
            cuit = cargarNuevamenteCuitInvalido(cuit);
            while(validacion.validarCuitCliente(cuit, listaCliente.getLista())) {
                cuit = cargarNuevamenteCuitPersona(cuit);
            }
        }
        return cuit;
    }

    /**
     * Método para cargar por teclado el CUIT de una Persona.
     * @return CUIT de la persana cargado.
     */
    public String cargarCuitProv(ContenedorArrayList<Proveedor> listaProv) {
        Validacion validacion = new Validacion();
        System.out.println("Ingrese el cuit: ");
        String cuit = sc.nextLine();
        while(!validacion.contieneNumCuit(cuit)) {
            cuit = cargarNuevamenteCuitInvalido(cuit);
            while(validacion.validarCuitProveedor(cuit, listaProv.getLista())) {
                cuit = cargarNuevamenteCuitPersona(cuit);
            }
        }
        return cuit;
    }

    /**
     * Método para volver a cargar el CUIT de una persona en caso de que el CUIT ingresado anteriormente no sea posible.
     * @param cuit cargado anteriormente.
     * @return CUIT presuntamente corregido.
     */
    public String cargarNuevamenteCuitInvalido(String cuit) {
        System.out.println(cuit + " no cumple con las condiciones para ser un CUIT válido.");
        System.out.println("Ingrese nuevamente el CUIT: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar nuevamente el CUIT de una persona en caso de que el CUIT ingresado pertenezca a un cliente registrado.
     * @param cuit cargado anteriormente.
     * @return CUIT presuntamente corregido.
     */
    public String cargarNuevamenteCuitPersona(String cuit) {
        System.out.println(cuit + " es el CUIT de una persona que ya existe en el registro.");
        System.out.println("Ingrese nuevamente el CUIT: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar el telefono de una persona en caso de que el telefono ingresado anteriormente no sea posible.
     * @param telefono cargado anteriormente.
     * @return telefono presuntamente corregido.
     */
    public String cargarNuevamenteTelefonoPersona(String telefono) {
        System.out.println(telefono + " no es un numero de telefono valido.");
        System.out.println("Ingrese nuevamente el telefono: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar la localidad de una persona en caso de que la localidad ingresada anteriormente no sea posible.
     * @param localidad cargada anteriormente.
     * @return localidad presuntamente corregida.
     */
    public String cargarNuevamenteLocalidadPersona(String localidad) {
        System.out.println(localidad + " no es una localidad válida.");
        System.out.println("Ingrese nuevamente la localidad: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar el apellido de una persona en caso de que el apellido ingresado anteriormente no sea posible.
     * @param apellido cargado anteriormente.
     * @return apellido presuntamente corregido.
     */
    public String cargarNuevamenteApellidoPersona(String apellido) {
        System.out.println(apellido + " no es un apellido válido.");
        System.out.println("Ingrese nuevamente el apellido: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el email de una Persona.
     * @return email de la persana cargado.
     */
    public String cargarEmail() {
        Validacion validacion = new Validacion();

        System.out.println("Ingrese el email: ");
        String email = sc.nextLine();
        while(!validacion.validacionEmailValido(email)) {
            email = cargarNuevamenteEmailPersona(email);
        }
        return email;
    }

    /**
     * Método para volver a cargar el email de una persona en caso de que el email ingresado anteriormente no sea posible.
     * @param email cargado anteriormente.
     * @return email presuntamente corregido.
     */
    public String cargarNuevamenteEmailPersona(String email) {
        System.out.println(email + " no es una dirección de correo electrónico válida.");
        System.out.println("Ingrese nuevamente el email: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar el nombre de una persona en caso de que el nombre ingresado anteriormente no sea posible.
     * @param nombre cargado anteriormente.
     * @return nombre presuntamente corregido.
     */
    public String cargarNuevamenteNombrePersona(String nombre) {
        System.out.println("\n" + nombre + " no es un nombre válido.");
        System.out.println("Ingrese nuevamente el nombre: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar el porcentaje de un descuento.
     * @param porcentaje cargado anteriormente.
     * @return numero presuntamente corregido.
     */
    public int cargarNuevamentePorcentaje(int porcentaje) {
        System.out.println("\n" + porcentaje + " no es un numero válido.");
        System.out.println("Ingrese nuevamente el porcentaje: ");
        return sc.nextInt();
    }

    /**
     * Método para cargar por teclado el nombre de una marca.
     * @return nombre de la marca cargado.
     */
    public String cargarNombreMarca() {
        System.out.println("Ingrese el nombre de la marca: ");
        return sc.nextLine();
    }


    public String cargarNombreDepartamento() {
        System.out.println("Ingrese el nombre del Departamento: ");
        return sc.nextLine();
    }

    /**
     * Método para cargar por teclado el nombre de una marca a buscar.
     * @return nombre de la marca a buscar.
     */
    public String cargarNombreMarcaBuscar(){
        System.out.println("Ingrese el nombre de la marca a buscar: ");
        return sc.nextLine();
    }


    public String cargarNombreDepartamentoBuscar(){
        System.out.println("Ingrese el nombre del departamento a buscar: ");
        return sc.nextLine();
    }


    /**
     * Método para imprimir que una marca ya existe.
     */

    public void marcaYaExiste(){
        System.out.println("La marca que desea crear ya existe! ");
    }

    public void departamentoYaExiste(){
        System.out.println("El departamento que desea crear ya existe! ");
    }

    /**
     * Metodo para ingresar lo que quiere modificar
     * @param cliente
     * @return el numero
     */
    public String menuModificarCliente(Cliente cliente){
        System.out.println("1 - Nombre: " + cliente.getNombre());
        System.out.println("2 - Apellido: " + cliente.getApellido());
        System.out.println("3 - Domicilio: " + cliente.getDomicilio());
        System.out.println("4 - Telefono: " + cliente.getTelefono());
        System.out.println("5 - Email: " + cliente.getEmail());
        System.out.println("0 - Salir");
        System.out.println("\nIngrese la opcion que quiera: ");
        return sc.nextLine();
    }

    /**
     * Metodo para ingresar lo que quiere modificar
     * @param proveedor cargado anteriormente.
     * @return el numero
     */
    public String menuModificarProveedor(Proveedor proveedor){
        System.out.println("1 - Nombre: " + proveedor.getNombre());
        System.out.println("2 - Apellido: " + proveedor.getApellido());
        System.out.println("3 - Domicilio: " + proveedor.getDomicilio());
        System.out.println("4 - Telefono: " + proveedor.getTelefono());
        System.out.println("5 - Email: " + proveedor.getEmail());
        System.out.println("6 - Localidad: " + proveedor.getLocalidad());
        System.out.println("0 - Salir");
        System.out.println("\nIngrese la opcion que quiera: ");
        return sc.nextLine();
    }

    /**
     * Método para imprimir que un articulo no existe.
     */
    public void articuloNoEncontrado(){
        System.out.println("El articulo que busca no existe...");
    }

    /**
     * Método para imprimir que un articulo no existe.
     */
    public void descuentoNoEncontrado(){
        System.out.println("El descuento que busca no existe...");
    }

    /**
     * Método para imprimir que un cliente no existe.
     */
    public void clienteNoEncontrado(){
        System.out.println("El cliente que busca no existe...");
    }

    /**
     * Metodo para ingresar lo que quiere modificar.
     * @param articulo cargado anteriormente.
     * @return el numero ingresado.
     */
    public String menuModificiarArticulo(Articulo articulo){
        System.out.println("1 - Nombre: " + articulo.getNombre());
        System.out.println("2 - Departamento: " + articulo.getDepartamento());
        System.out.println("3 - Marca: " + articulo.getMarca().getNombre());
        System.out.println("4 - Costo: " + articulo.getCosto());
        System.out.println("5 - Utilidad: " + articulo.getUtilidad());
        System.out.println("6 - Stock: " + articulo.getStock());
        System.out.println("0 - Salir");
        System.out.println("Ingrese lo que quiere modificar: ");
        return sc.nextLine();
    }

    /**
     * Método para imprimir que un proveedor no existe.
     */
    public void provNoEncontrado(){
        System.out.println("El proveedor que busca no existe...");
    }

    /**
     * Método para imprimir que una marca no existe y pedir una opcion por teclado.
     * @return el numero ingresado:
     *  @return Opción elegida en forma de int:
     *    1 - Marca nueva.
     *    2 - Volver a intentarlo.
     */
    public int marcaBuscadaNoSeEncuentra(){
        System.out.println("La marca buscada no existe. ");
        System.out.println("1 - Crear una nueva marca. ");
        System.out.println("2 - Ingresar nuevamente. ");
        System.out.println("Seleccione la accion a realizar: ");
        return sc.nextInt();
    }


    public int departamentoBuscadoNoSeEncuentra(){
        System.out.println("El departamento buscado no existe, ingrese lo que quiera hacer: ");
        System.out.println("1. Crear un nuevo departamento ");
        System.out.println("2. Ingresar nuevamente ");
        return sc.nextInt();
    }


    /**
     * Método para imprimir que un articulo no existe y pedir una opcion por teclado.
     * @return el numero ingresado.
     *          1 - Ingresar ID nuevamente.
     *          2 - Articulo nuevo.
     *          0 - Salir.
     */
    public int articuloNoExiste(){
        System.out.println("El articulo no existe.");
        System.out.println("1 - Volver a cargar el nombre");
        System.out.println("2 - Cargar un nuevo articulo");
        System.out.println("0 - No cargar el articulo");
        System.out.println("Seleccione la accion a realizar: ");
        return sc.nextInt();
    }

    public void soloNumerosException(){
        System.out.println("Error, solo se permite numeros!!\n");
    }
}

