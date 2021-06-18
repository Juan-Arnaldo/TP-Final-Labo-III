package com.company.Local;

import com.company.Articulo.Articulo;
import com.company.Operacion.Venta;
import com.company.Persona.Cliente;
import com.company.Utilidad.Menu;

import java.util.Scanner;

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

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    /**
     * Metodo para actualizar dinero en caja
     * @param dineroEntrante dinero a sumar al total de la caja
     */
    public void actualizarDinero(double dineroEntrante) {
        setDinero(dineroEntrante + getDinero());
    }

    /**
     * Metodo para cargar una nueva venta
     * @param nuevaVenta a cargar en el registro
     * @param local en cuyo registro se cargará la nueva venta
     */
    public void nuevaVenta(Venta nuevaVenta, Local local) {
        if(nuevaVenta.getListaLinea().getLista().size() > 0){
            nuevaVenta.setIdOperacion(local.getListaOperacion().getContadorId());
            local.getListaOperacion().agregar(nuevaVenta);
        }
    }

    /**
     * Metodo para mostrar el dinero ingresado en la caja.
     */
    public void mostrarDinero() {
        System.out.println("\nDinero generado en la Caja " + idCaja + ": $" + dinero + ".\n");
        System.out.println("Presione ENTER para volver.");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    @Override
    public String toString() {
        return "Caja " + idCaja + "\n";
    }
}
