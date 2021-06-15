package com.company.Local;

import com.company.Articulo.Articulo;
import com.company.Operacion.Venta;
import com.company.Persona.Cliente;
import com.company.Utilidad.Menu;

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

    public void cargaVenta(Venta nuevaVenta) {
        if(nuevaVenta.getListaLinea().size() > 0){
            nuevaVenta.setIdOperacion(local.getListaOperacion().getContadorId());
            local.getListaOperacion().aumentarContadorId();
            local.getListaOperacion().agregar(nuevaVenta);
        }
    }
}
