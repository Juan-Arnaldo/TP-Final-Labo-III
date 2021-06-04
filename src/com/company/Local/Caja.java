package com.company.Local;

import com.company.Articulo.Articulo;

public class Caja {
    private int idCaja;
    private double dinero;

    public Caja(int idCaja, double dinero) {
        this.idCaja = idCaja;
        this.dinero = dinero;
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

    boolean cargarVenta() {

        return true;
    }

    /*public static int cargarCantidadArticulo(Articulo articulo, int cant) {
        carga cant
        do{
            if(verificarCantidadArticulo(cant)){
                return cant;
            }else{
                System.out.println("Noy hay stock suficiente (" + articulo.getStock() + "), ingrese una nueva cantidad (en caso de no querer ingrese 0): \n ");
                cant = cargaCantidadTeclado();
            }
        }while(verificarCantidadArticulo(cant) && cant != 0);

        return cant;
    }*/
}
