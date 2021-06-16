package com.company.Local;

import com.company.Articulo.Articulo;
import com.company.Operacion.Venta;
import com.company.Persona.Cliente;
import com.company.Utilidad.Menu;

public class Caja {
    private int idCaja;
    private double dinero;
    private int idLocal;

    public Caja(int idCaja, int idLocal, double dinero) {
        this.idCaja = idCaja;
        this.dinero = dinero;
        this.idLocal = idLocal;
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

    public void cargaVenta(Venta nuevaVenta, Local local) {
        if(nuevaVenta.getListaLinea().size() > 0){
            nuevaVenta.setIdOperacion(local.getListaOperacion().getContadorId());
            local.getListaOperacion().agregar(nuevaVenta);
        }
    }
}
