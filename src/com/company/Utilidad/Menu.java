package com.company.Utilidad;

import com.company.Articulo.Articulo;
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
        System.out.println("\nBienvenido\n");
        int opc;
        do{
            opc = cargarOpcionMenuInicio();
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
                case 3 -> System.out.println("\nSaliendo...\n");
                default -> System.out.println("Opcion erronea.\nVuelva a intentarlo.\n");
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

    public void menuCaja (Local local, Caja caja) {
        int opc;
        do{
            System.out.println("\nBienvenido a la Caja " + caja.getIdCaja() + "\n");
            opc = cargarOpcionMenuCaja();

            switch (opc) {
                case 1 -> caja.nuevaVenta(cargarNuevaVenta(local, caja), local);
                case 2 -> local.mostrarVentas();
                case 3 -> menuArticulo(local);
                case 4 -> menuCliente(local);
                case 5 -> local.nuevaCompra(cargarNuevaCompra(local));
                case 6 -> menuProveedor(local);
                case 0 -> System.out.println("\nSaliendo...\n");
                default -> System.out.println("Opcion erronea.\nVuelva a intentarlo.\n");
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
        int opc;
        do {
            opc = cargarOpcionMenuArticulo();
            switch (opc) {
                case 1 -> local.nuevoArticulo(cargarNuevoArticulo(local));
                case 2 -> local.modificarUnArticulo();
                case 3 -> local.eliminarUnArticulo();
                case 4 -> local.mostrarUnArticulo();
                default -> System.out.println("La opcion ingresada no es valida");
            }
        } while (opc != 0);
    }

    public void menuCliente(Local local) {
        int opc;
        do {
            opc = cargarOpcionMenuCliente();
            switch (opc) {
                case 1 -> local.nuevoCliente(cargarNuevoCliente(local));
                case 2 -> local.modificarUnCliente();
                case 3 -> local.eliminarUnCliente();
                case 4 -> local.mostrarUnCliente();
                default -> System.out.println("La opcion ingresada no es valida");
            }
        } while (opc != 0);
    }

    public void menuProveedor(Local local) {
        int opc;
        do {
            opc = cargarOpcionMenuProv();
            switch (opc) {
                case 1 -> local.nuevoProveedor(cargarNuevoProveedor(local));
                case 2 -> local.modificarUnProv();
                case 3 -> local.eliminarUnProv();
                case 4 -> local.mostrarUnProveedor();
                default -> System.out.println("La opcion ingresada no es valida");
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
        System.out.println("2 - Editar Articulo.");
        System.out.println("3 - Eliminar Articulo.");
        System.out.println("4 - Mostrar Articulo.");
        System.out.println("0 - Salir.");
        return sc.nextInt();
    }

    public int cargarOpcionMenuCliente() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Nuevo Cliente.");
        System.out.println("2 - Editar Cliente.");
        System.out.println("3 - Eliminar Cliente.");
        System.out.println("4 - Mostrar Cliente.");
        System.out.println("0 - Salir.");
        return sc.nextInt();
    }

    public int cargarOpcionMenuProv() {
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Nuevo Proveedor.");
        System.out.println("2 - Editar Proveedor.");
        System.out.println("3 - Eliminar Proveedor.");
        System.out.println("4 - Mostrar Proveedor.");
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

        String cuit = t.cargarCuitProv(local.getListaProveedores());

        String nombre = t.cargarNombreCliente();
        String apellido = t.cargarApellido();
        String direc = t.cargarDireccion();
        String tel = t.cargarTelefono();
        String email = t.cargarEmail();
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

        String nombre, departamento;
        int stock ;
        double utilidad, costo;
        nombre = t.cargarNombreArticulo();
        while (local.nombreArticuloRepetido(nombre)) {
            nombre = t.cargarNuevamenteNombreArticulo(nombre);
        }
        departamento = t.cargarDepartamentoArticulo();

        Marca marca = local.buscarMarca();
        while (marca == null){
            marca = menuMarcaNoExiste(local);
        }

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

    public Marca menuMarcaNoExiste(Local local) {
        Teclado t = new Teclado();
        Marca marca;

        int aux = t.marcaBuscadaNoSeEncuentra();
        switch (aux) {
            case 1 -> {
                marca = cargarNuevaMarca(local);
                local.nuevaMarca(marca);
                return marca;
            }
            case 2 -> {
                marca = local.buscarMarca();
                return marca;
            }
            default -> {
                System.out.println("La opcion ingresada no es correcta...!\n");
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
        Teclado t = new Teclado();

        Articulo articuloComprado;
        int cantidadComprada;
        double costoLinea;

        Proveedor proveedor = local.buscarProveedor();

        while (proveedor == null){
            int aux = proveedorNoExiste();
            switch (aux) {
                case 1 -> proveedor = local.buscarProveedor();
                case 2 -> {
                    local.nuevoProveedor(cargarNuevoProveedor(local));
                    proveedor = local.buscarProveedor();
                }
                default -> System.out.println("\nLa opcion ingresada es incorrecta");
            }
        }

        Compra nuevaCompra = new Compra(proveedor);

        do {

            articuloComprado = local.buscarArticuloID();

            while(articuloComprado == null) {
                switch (nombreArticuloCompradoNoExiste()) {
                    case 1 -> articuloComprado = local.buscarArticuloID();
                    case 2 -> local.nuevoArticulo(cargarNuevoArticulo(local));                 // El nombre es correcto y decide cargarlo en el registro de artículos
                    default -> System.out.println("La opcion ingresada no es valida.");         // Toca tecla que no va
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
        System.out.println("\n---------------------------");
        System.out.println("------- NUEVA VENTA -------");
        System.out.println("---------------------------\n");

        Teclado t = new Teclado();
        int aux = -1;
        Cliente cliente = local.buscarCliente();

        while (cliente == null){
            aux = clienteNoExiste();
            switch (aux) {
                case 1 -> cliente = local.buscarCliente();
                case 2 -> cliente = local.getListaClientes().getElemento(0);
                case 3 -> {
                    local.nuevoCliente(cargarNuevoCliente(local));
                    cliente = local.getListaClientes().getElemento(local.getListaClientes().getContadorId() - 1);
                }
                default -> System.out.println("\nLa opcion ingresada es incorrecta");
            }
        }

        Venta nuevaVenta = new Venta(cliente, caja.getIdCaja());

        String metodoPago = cargarMetodoDePago();
        nuevaVenta.setMetodoPago(metodoPago);
        if(metodoPago != null){
            do {
                Articulo art = local.buscarArticuloID();

                while(art == null && aux != 0) {
                    aux = t.articuloNoExiste();
                    switch (aux){
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
                            System.out.println("Opcion ingresada no es correcta... !\n");
                    }
                }

                if (art != null) {
                    int cant = nuevaVenta.cargarCantidadArticulo(art);
                    if(cant != 0){
                        nuevaVenta.agregarLinea(art, cant);
                        local.nuevoStock(art,cant);
                        caja.actualizarDinero(nuevaVenta.generarTotal(local.getListaDescuento()));
                    }
                }
                else
                    System.out.println("Se cancelo la carga \n");

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
     * Método para cargar una nueva marca
     * @param local
     * @return La nueva marca creada
     * Null, en caso de que ya exista
     */
    public Marca cargarNuevaMarca(Local local){
        Teclado t = new Teclado();
        Validacion v = new Validacion();
        String nombre = t.cargarNombreNuevaMarca();

        if (!v.validacionMarcaNueva(local.getListaMarca(), nombre)){
            return new Marca(nombre);
        }else{
            t.marcaYaExiste();
        }

        return null;
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
        System.out.println("El cliente buscado no existe. ");
        System.out.println("1 - Volver a cargar el CUIT");
        System.out.println("2 - Pasar venta como consumidor final");
        System.out.println("3 - Crear nuevo cliente");
        System.out.println("4 - Ingrese la accion a realizar: ");
        return sc.nextInt();
    }

    public int proveedorNoExiste(){
        System.out.println("El proveedor buscado no existe. ");
        System.out.println("1 - Volver a cargar el CUIT");
        System.out.println("2 - Crear nuevo proveedor");
        System.out.println("3 - Ingrese la accion a realizar: ");
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
                case 1 -> metodoPago = MetodoPago.Efectivo;
                case 2 -> {
                    return seleccionTarjeta();
                }
                case 3 -> metodoPago = MetodoPago.Cheque;
                default -> System.out.println("La opcion ingresada no es valida");
            }
        } while (aux != 1 && aux != 3 && aux != 0);

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
                case 1 -> tarjeta = "Visa";
                case 2 -> tarjeta = "Mastercad";
                case 3 -> tarjeta = "Cabal";
                case 4 -> tarjeta = "American Express";
                case 5 -> tarjeta = "Maestro";
                case 6 -> tarjeta = "Naranja";
                default -> System.out.println("La opcion ingresada es incorrecta, ingrese 0 de si desea salir");
            }

        } while (aux != 1 && aux != 2 && aux != 3 && aux != 4 && aux != 5 && aux != 6 && aux != 0);

        return tarjeta;
    }

    /**
     * Salida para modificar el articulo
     * Y aplicar los cambios
     * @param articulo
     */
    public void modificarArticuloSalida(Articulo articulo, Local local) {
        Teclado t = new Teclado();
        int aux;
        do{
            switch (aux = t.menuModificiarArticulo(articulo)) {
                case 1 -> {
                    articulo.setNombre(t.cargarNombreArticulo());
                    System.out.println("Nombre editado con exito.");
                }
                case 2 -> {
                    articulo.setDepartamento(t.cargarDepartamentoArticulo());
                    System.out.println("Departamento editado con exito.");
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
                    articulo.setCosto(t.cargarCostoArticulo());
                    System.out.println("Costo editado con exito.");
                }
                case 5 -> {
                    articulo.setUtilidad(t.cargarUtilidadArticulo());
                    System.out.println("Utilidad editada con exito.");
                }
                case 6 -> {
                    articulo.setStock(t.cargarCantidadArticulo());
                    System.out.println("Stock editado con exito.");
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("La opcion ingresada no es correcta!\n");
            }
        }while(aux != 0);
    }


    /**
     * Salida para modificar el cliente
     * Y aplicar los cambios
     * @param cliente
     */
    public void modificarClienteSalida(Cliente cliente){
        Teclado t = new Teclado();
        int aux;
        do{
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
                default -> System.out.println("La opcion ingresada no es correcta!\n");
            }
        }while(aux != 0);
    }

    public void modificarProvSalida(Proveedor proveedor){
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
                    System.out.println("La opcion ingresada no es correcta!\n");
            }
        }while(aux != 0);
    }
}
