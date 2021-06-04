package com.company.Local;

import com.company.Articulo.Articulo;
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

    //public METODO DE FORMA DE PAGO

    public void cargarVenta() {
        Venta nueva = new Venta(idCaja, "Tarjeta");

  /*    do{

            nueva.agregarArticulo(local.buscarArticulo(), nueva.cargarCantidadArticulo());


        }while (true);

        listaOperaciones.add(nueva);

    }
*/

    }
}
