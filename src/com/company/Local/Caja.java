package com.company.Local;

import com.company.Articulo.Articulo;
import com.company.Operacion.MetodoPago;
import com.company.Operacion.Venta;
import com.company.Teclado;

public class Caja {
    private int idCaja;
    private double dinero;
    private Local local;

    public Caja(int idCaja, double dinero, Local local) {
        this.idCaja = idCaja;
        this.dinero = dinero;
        this.local = local;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    /**
     * Metodo para elegir el metodo de pago
     * @return de retorna un String del metodo seleccionado
     */

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

    /**
     * Metodo para cargar una nueva venta
     */

    public void cargaVenta() {
        Teclado teclado = new Teclado();

        Venta nueva = new Venta(local.buscarCliente(), idCaja);
        do {
            Articulo art = local.buscarArticuloNombre(teclado.cargarNombreArticulo());
            if (art != null) {
                int cant = nueva.cargarCantidadArticulo(art);
                if(cant != -1){
                    nueva.agregarArticulo(art, cant, local.getListaDescuento());
                }
            }

        }while (teclado.deseaContinuar());

        String metodoPago = cargarMetodoDePago();

        if(metodoPago != null && nueva.getListaLinea().size() > 0){
            nueva.setMetodoPago(metodoPago);
            local.getListaOperacion().add(nueva);
        }
    }
}

