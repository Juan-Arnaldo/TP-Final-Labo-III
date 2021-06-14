package com.company.Local;

import com.company.Articulo.Articulo;
import com.company.Operacion.MetodoPago;
import com.company.Operacion.Venta;
import com.company.Persona.Cliente;
import com.company.Utilidad.Teclado;

public class Caja {
    private int idCaja;
    private double dinero;
    private final Local local;

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



    /**
     * Metodo para cargar una nueva venta
     */

    public void cargaVenta() {
        Teclado teclado = new Teclado();
        Cliente cliente = local.buscarCliente();

        while (cliente == null){
            int aux = teclado.clienteNoExiste();
            switch (aux){
                case 1:
                    cliente = local.buscarCliente();
                    break;
                case 2:
                    cliente = local.getListaClientes().getElemento(0);
                    break;
                case 3:
                    local.crearCliente();
                    cliente = local.buscarCliente();
                    break;
                default:
                    System.out.println("\nLa opcion ingresada es incorrecta");
                    break;
            }
        }

        Venta nueva = new Venta(cliente, idCaja);
        do {
            Articulo art = local.buscarArticuloNombre(teclado.cargarNombreArticulo());
            if (art != null) {
                int cant = nueva.cargarCantidadArticulo(art);
                if(cant != 0){
                    nueva.agregarArticulo(art, cant, local.getListaDescuento());
                }
            }

        }while (teclado.deseaContinuar());

        String metodoPago = local.cargarMetodoDePago();

        if(metodoPago != null && nueva.getListaLinea().size() > 0){
            nueva.setMetodoPago(metodoPago);
            local.getListaOperacion().agregar(nueva);
        }
    }
}

