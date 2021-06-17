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
        System.out.println("\nBienvenido al Sistema de Gestión Contable\n");
        int opc = 0;
        do{
            opc = cargarOpcionMenuInicio();
            Caja caja = null;

            switch (opc) {
                case 0:
                    System.out.println("Saliendo del Programa...");
                    break;
                case 1:
                    caja = menuSeleccionCaja(local);
                    menuCaja(local, caja);
                    break;
                case 2:
                    local.nuevaCaja();
                    caja = local.getListaCajas().getElemento(local.getListaCajas().getLista().size()-1);
                    menuCaja(local, caja);
                    break;
                default:
                    System.out.println("Opcion erronea.\nVuelva a intentarlo.\n");
                    break;
            }
        }while (opc != 0);
    }

    /**
     * Método para cargar la opción a elegir en el menú principal.
     * @return opción.
     */
    public int cargarOpcionMenuInicio() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Seleccionar caja.");
        System.out.println("2 - Nueva caja.");
        System.out.println("0 - Salir.");
        return sc.nextInt();
    }

    /**
     * Menú que se encarga de mostrar las cajas disponibles y le permite al usuario seleccionar una para trabajar.
     * @param local al que pertenecen las cajas
     */
    public Caja menuSeleccionCaja(Local local) {
        Teclado teclado = new Teclado();
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

    public void menuCaja (Local local, Caja caja) {
        int opc;
        do{
            System.out.println("\nBienvenido a la Caja " + caja.getIdCaja() + "\n");
            opc = cargarOpcionMenuCaja();

            switch (opc) {
                case 0:
                    System.out.println("Saliendo de Menú de Caja...");
                    break;
                case 1:
                    caja.nuevaVenta(cargarNuevaVenta(local, caja), local);
                    break;
                case 2:
                    local.mostrarVentas();
                    break;
                case 3:
                    menuArticulo(local);
                    break;
                case 4:
                    //menuClientes();
                    break;
                case 5:
                    local.nuevaCompra(cargarNuevaCompra(local));
                    break;
                case 6:
                    menuProveedor(local);
                    break;
                default:
                    System.out.println("Opcion erronea.\nVuelva a intentarlo.\n");
                    break;
            }
        }while (opc != 0);
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
        System.out.println("0 - Salir.");
        return sc.nextInt();
    }

    /**
     * Método para cargar la opción a elegir en el menú de Articulos.
     * @return opción.
     */
    public void menuArticulo(Local local) {
        Teclado t = new Teclado();
        int opc = 0;
        do {
            System.out.println("\nBienvenido al Menú de Gestión de Artículos\n");
            opc = cargarOpcionMenuArticulo();
            switch (opc) {
                case 0:
                    System.out.println("Saliendo de Menú de Artículos...");
                    break;
                case 1:
                    local.nuevoArticulo(cargarNuevoArticulo(local));
                    break;
                case 2:
                    local.modificarUnArticulo();
                    break;
                case 3:
                    local.eliminarUnArticulo();
                    break;
                case 4:
                    local.mostrarUnArticulo();
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida");
                    break;
            }
        } while (opc != 0);
    }

    public void menuProveedor(Local local) {
        Teclado t = new Teclado();
        int opc = 0;
        do {
            opc = t.menuModificarProveedor();
            switch (opc) {
                case 1:
                    local.nuevoProveedor(cargarNuevoProveedor(local));
                    break;
                case 2:
                    local.modificarUnProv();
                    break;
                case 3:
                    local.eliminarUnProv();
                    break;
                case 4:
                    local.mostrarUnProveedor();
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida");
                    break;
            }
        } while (opc != 0);
    }

    /**
     * Método para cargar la opción a elegir en el menú de artículo.
     * @return opción.
     */
    public int cargarOpcionMenuArticulo() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Nuevo Articulo.");
        System.out.println("2 - Nueva Marca.");
        System.out.println("3 - Nuevo Departamento.");
        System.out.println("4 - Editar Articulo.");
        System.out.println("5 - Eliminar Articulo.");
        System.out.println("6 - Mostrar Articulo.");
        System.out.println("0 - Salir.");
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

        String nombre = t.cargarNombreCliente();
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

        String nombre = t.cargarNombreProveedor();
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
            int aux = proveedorNoExiste();
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

            articuloComprado = local.buscarArticuloID();

            while(articuloComprado == null) {                   // En caso de que el nombre ingresado no corresponda con un artículo registrado
                switch (nombreArticuloCompradoNoExiste()) {        // Le pregunto al usuario qué desea hacer
                    case 1 :
                        articuloComprado = local.buscarArticuloID();                 // Corrige el nombre cargado
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
            int aux = clienteNoExiste();
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
                Articulo art = local.buscarArticuloID();

                if (art != null) {
                    int cant = nuevaVenta.cargarCantidadArticulo(art);
                    if(cant != 0){
                        nuevaVenta.agregarLinea(art, cant);
                        local.nuevoStock(art,cant);
                        caja.actualizarDinero(nuevaVenta.generarTotal(local.getListaDescuento()));
                    }
                }
                else
                    System.out.println("El articulo no existe");

            }while (t.continuarCargandoArticulos());
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
        String nombre = t.cargarNombreDescuentoTarjeta();

        int porcentaje = t.ingresePorcentajeDesc();

        while (porcentaje <= 0 || porcentaje > 100){
            porcentaje = t.ingresePorcentajeDescNuevamente();
        }
        String tarjeta = seleccionTarjeta();

        return new DescTarjeta(porcentaje, tarjeta, nombre);
    }

    /**
     * Método para elegir cómo seguir en caso de que el nombre ingresado no corresponda a un artículo existente en los registros de local.
     * @return Opción elegida en forma de int. 1 - Intentar nuevamente. 2 - Agregar " + " al registro.");.
     */
    public int nombreArticuloCompradoNoExiste() {
        System.out.println("El id no corresponde a un artículo registrado.");
        System.out.println("1 - Intentar nuevamente.");
        System.out.println("2 - Agregar nuevo Articulo ");
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

    /**
     * Método para ingresar el metodo de pago
     * @return un String con el nombre del Enum
     */
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

    /**
     * Salida para modificar el articulo
     * Y aplicar los cambios
     * @param articulo
     */
    public void modificarArticuloSalida(Articulo articulo) {
        Teclado t = new Teclado();
        int aux;
        do{
            aux = menuModificiarArticulo();
            switch (aux){
                case 0:
                    System.out.println("Saliendo de Modificación de Artículo...");
                    break;
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
        }while(aux != 0);
    }

    /**
     * Metodo para ingresar lo que quiere modificar
     * @return el numero
     */
    public int menuModificiarArticulo(){
        System.out.println("1 - Nombre");
        System.out.println("2 - Departamento");
        System.out.println("3 - Marca");
        System.out.println("4 - Costo");
        System.out.println("5 - Utilidad");
        System.out.println("6 - Stock");
        System.out.println("0 - Salir");
        System.out.println("Ingrese lo que quiere modificar: ");
        return sc.nextInt();
    }

    /**
     * Salida para modificar el cliente
     * Y aplicar los cambios
     * @param cliente
     */
    public void modificarClienteSalida(Cliente cliente){
        Teclado t = new Teclado();
        int opc;
        do{
            opc = modificarCliente();
            switch (opc){
                case 0:
                    System.out.println("Saliendo de Modificación de Cliente...");
                    break;
                case 1:
                    cliente.setNombre(t.cargarNombreCliente());
                    break;
                case 2:
                    cliente.setApellido(t.cargarApellido());
                    break;
                case 3:
                    cliente.setDomicilio(t.cargarDireccion());
                    break;
                case 4:
                    cliente.setTelefono(t.cargarTelefono());
                    break;
                case 5:
                    cliente.setEmail(t.cargarEmail());
                    break;
                default:
                    System.out.println("La opcion ingresada no es correcta!\n");
            }
        }while(opc != 0);
    }

    public void modificarProvSalida(Proveedor proveedor){
        Teclado t = new Teclado();
        int opc;
        do{
            opc = t.menuModificarProveedor();
            switch (opc){
                case 1:
                    proveedor.setNombre(t.cargarNombreCliente());
                    break;
                case 2:
                    proveedor.setApellido(t.cargarApellido());
                    break;
                case 3:
                    proveedor.setDomicilio(t.cargarDireccion());
                    break;
                case 4:
                    proveedor.setTelefono(t.cargarTelefono());
                    break;
                case 5:
                    proveedor.setEmail(t.cargarEmail());
                    break;
                case 0:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("La opcion ingresada no es correcta!\n");
            }
        }while(opc != 0);
    }

    /**
     * Método para seleccionar qué atributo se modificará en cliente.
     * @return
     */
    public int modificarCliente(){
        System.out.println("1 - Nombre");
        System.out.println("\n2 - Apellido");
        System.out.println("\n3 - Domicilio");
        System.out.println("\n4 - Telefono");
        System.out.println("\n5 - Email");
        System.out.println("\n0 - Salir");
        return sc.nextInt();
    }
}
