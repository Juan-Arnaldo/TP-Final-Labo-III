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

    public String cargarMetodoDePago(){
        int aux;
        MetodoPago metodoPago = null ;
        Teclado teclado = new Teclado();
        do{
            aux = teclado.cargarMetodoPago();
            switch (aux){
                case 1 :
                    metodoPago = MetodoPago.Efectivo;
                    break;
                case 2 :
                    metodoPago = MetodoPago.Tarjeta;
                    return seleccionTarjeta();
                case 3 :
                    metodoPago = MetodoPago.Cheque;
                    break;
                default:
                    System.out.println("La opcion que ingresaste no es valida");
                    break;
            }
        }while(aux != 1 && aux !=2 && aux != 3 && aux != 0);

        return metodoPago.name();
    }

    private String seleccionTarjeta(){
        int aux;
        String tarjeta = null;
        Teclado teclado = new Teclado();
        do{
            aux = teclado.cargarTarjeta();
            switch (aux){
                case 1:
                    tarjeta = "Visa";
                    break;
                case 2:
                    tarjeta = "Mastercad";
                    break;
                case 3:
                    tarjeta = "Cabal";
                    break;
                case 4 :
                    tarjeta = "American Express";
                    break;
                case 5 :
                    tarjeta = "Maestro";
                    break;
                case 6 :
                    tarjeta = "Naranja";
                    break;
                default:
                    System.out.println("La opcion ingresada es incorrecta, ingrese 0 de si desea salir");
                    break;
            }

        }while(aux !=1 && aux !=2 && aux !=3 && aux !=4 && aux !=5 && aux !=6 && aux !=0);

        return  tarjeta;
    }

    public void cargarVenta() {
        Teclado teclado = new Teclado();
        Venta nueva = new Venta(local.corroborarCliente(5), idCaja);  //TODO - Falta hacer bien lo de corroborrar el cliente
        int aux;
        Articulo aux2 = null;
        String aux3 = cargarMetodoDePago();

        do{
            aux2 = local.buscarArticuloNombre("Metodo");
            if (aux2 != null){
                aux = nueva.cargarCantidadArticulo(aux2);
                if(aux != -1){
                    nueva.agregarArticulo(aux2, aux);
                }
            }

        }while (teclado.deseaContinuar());

        if(aux3 != null){
            nueva.setMetodoPago(aux3);
            local.getListaOperacion().add(nueva);
        }
    }
}

