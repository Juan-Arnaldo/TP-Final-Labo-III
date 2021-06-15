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
     * Metodo para cargar una nueva venta
     */

    public void cargaVenta() {
        Teclado teclado = new Teclado();
        String CUIT = teclado.cargarCuit();
        Cliente cliente = local.buscarCliente(CUIT);

        while (cliente == null){
            int aux = teclado.clienteNoExiste();
            switch (aux){
                case 1:
                    cliente = local.buscarCliente(CUIT);
                    break;
                case 2:
                    cliente = local.getListaClientes().getElemento(0);
                    break;
                case 3:
                    local.crearCliente();
                    cliente = local.buscarCliente(CUIT);
                    break;
                default:
                    System.out.println("\nLa opcion ingresada es incorrecta");
                    break;
            }
        }

        Venta nueva = new Venta(cliente, idCaja);
        String metodoPago = local.cargarMetodoDePago();
        nueva.setMetodoPago(metodoPago);
        if(metodoPago != null){
            do {
                Teclado t2 = new Teclado(); //TODO a consultar al profesor
                String nombre = t2.cargarNombreArticulo();
                Articulo art = local.buscarArticuloNombre(nombre);
                if (art != null) {
                    int cant = nueva.cargarCantidadArticulo(art);
                    if(cant != 0){
                        nueva.agregarLinea(art, cant);
                    }
                }

            }while (teclado.deseaContinuar());

            if(nueva.getListaLinea().size() > 0){
                nueva.setIdOperacion(local.getListaOperacion().getContadorId());
                local.getListaOperacion().aumentarContadorId();
                local.getListaOperacion().agregar(nueva);
            }
        }
    }
}

