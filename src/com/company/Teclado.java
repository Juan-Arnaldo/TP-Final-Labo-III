package com.company;

import com.company.Persona.Cliente;
import com.company.Persona.Proveedor;

import java.util.Scanner;

public class Teclado {
    private Scanner sc;

    public Teclado() {
        sc = new Scanner(System.in);
    }

//---------- Métodos de Carga Generales ----------

    /**
     * Método para consultar al usuario si desea continuar con lo que está realizando.
     * @return true - En caso de que desee continuar.
     * @return false - En caso de que no desee continuar.     *
     */
    public boolean deseaContinuar(){
        System.out.println("Ingrese 1 si desea continuar \n");
        int aux = sc.nextInt();
        if(aux == 1){
            return true;
        }
        return false;
    }

//---------- Métodos de Carga para Artículos ----------//

    /**
     * Método para cargar por teclado el nombre de un artículo.
     * @return nombre - nombre del artículo cargado.
     */
    public String cargarNombreArticulo() {
        System.out.println("Ingrese el nombre del artículo: ");
        return sc.nextLine();
    }

    /**
     * Método para volver a cargar el nombre de un artículo en caso de que el nombre ingresado anteriormente no sea posible.
     * @param nombre - Nombre cargado anteriormente.
     * @return Nombre presuntamente corregido.
     */
    public String cargarNuevamenteNombreArticulo(String nombre) {
        System.out.println(nombre + " es el nombre de un artículo que ya existe en el registro.");
        System.out.println("Ingrese nuevamente el nombre del  artículo: ");
        return sc.nextLine();
    }

    public  double cargarCostoArticulo(){
        System.out.println("Ingrese el costo del articulo: ");
        return sc.nextDouble();
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
     * Método para volver a cargar la utilidad de un articulo en caso de que el valor ingresado anteriormente no sea posible.
     * @param utilidad - Utilidad cargada anteriormente.
     * @return Utilidad presuntamente corregida.
     */
    public double cargarNuevamenteUtilidadArticulo(double utilidad) {
        System.out.println(utilidad + " no es una utilidad válida. Se desea ganar dinero con las ventas.");
        System.out.println("Ingrese nuevamente la utilidad del articulo: ");
        return sc.nextDouble();
    }

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
    public int cargarNuevamenteCantidadArticulo(){
        System.out.println("No se puede vender la cantidad ingresada.");
        System.out.println("Ingrese nuevamente la cantidad del articulo: ");
        return sc.nextInt();
    }

    /**
     * Método para volver a cargar la cantidad de artículos en caso de que el valor ingresado anteriormente no sea posible.
     * @param cantidad - Cantidad cargada anteriormente.
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
     * @param costo - Cantidad cargada anteriormente.
     * @return Cantidad presuntamente corregida.
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
        System.out.println("Seleccione acción a realizar.");
        return sc.nextInt();
    }

////---------- Métodos de Carga para Personas/Proveedores ----------////

    /**
     * Método para cargar por teclado el nombre de una Persona.
     * @return nombre - nombre de la persana cargado.
     */
    public String cargarNombre() {
        System.out.println("Ingrese el nombre: ");
        return sc.nextLine();
    }
    public String cargarDireccion() {
        System.out.println("Ingrese la direccion: ");
        return sc.nextLine();
    }
    public String cargarTelefono() {
        System.out.println("Ingrese el telefono: ");
        return sc.nextLine();
    }
    public String cargarCuit() {
        System.out.println("Ingrese el cuit: ");
        return sc.nextLine();
    }
    public String cargarEmail() {
        System.out.println("Ingrese el email: ");
        return sc.nextLine();
    }
    public String  cargarLocalidad(){
        System.out.println("Ingrese la localidad: ");
        return sc.nextLine();
    }

    public int costoCeroONegativo(String cuit) {
        System.out.println("El cuit "+ cuit + " ya existe en la base de datos.");
        System.out.println("1 - Intentar nuevamente.");
        System.out.println("2 - Seguir con la compra.");
        System.out.println("Ingrese la accion a realizar: ");
        return sc.nextInt();
    }

    /**
     * Metodo para ingresar el nuevo proveedor por teclado.
     * @return Proveedor creado.
     */

    public int cargarOpMain(){
        System.out.println("Ingrese una opcion para continuar: ");
        System.out.println("1 - Nueva venta.");
        System.out.println("2 - Nueva compra.");
        System.out.println("3 - Nuevo cliente.");
        System.out.println("4 - Nuevo proveedor.");
        System.out.println("5 - Nuevo articulo.");
        System.out.println("6 - Lista clientes.");
        System.out.println("7 - Lista proveedores.");
        System.out.println("8 - Lista articulos.");
        System.out.println("9 - Salir.");
        return sc.nextInt();
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
}
