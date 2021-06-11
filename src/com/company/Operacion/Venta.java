package com.company.Operacion;

import com.company.Articulo.Articulo;
import com.company.Contenedor.ContenedorArrayList;
import com.company.Local.DescTarjeta;
import com.company.Local.Descuento;
import com.company.Persona.Persona;
import com.company.Teclado;

import java.util.ArrayList;

public class Venta extends Operacion {
    private int idVenta;
    private int idCaja;
    private String metodoPago;
    private ArrayList<Linea> listaLinea;

    public Venta(Persona persona,int idCaja) {
        super(persona);
        this.idCaja = idCaja;
    }

    public Venta(Persona persona, int idVenta, int idCaja, String metodoPago, ArrayList<Linea> listaLinea) {
        super(persona);
        this.idVenta = idVenta;
        this.idCaja = idCaja;
        this.metodoPago = metodoPago;
        this.listaLinea = listaLinea;
    }

    public ArrayList<Linea> getListaLinea() {
        return listaLinea;
    }

    public void setListaLinea(ArrayList<Linea> listaLinea) {
        this.listaLinea = listaLinea;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Funcion para sacar el precio final del articulo
     * @param articulo
     * @param cantidad
     * @return double
     */
    private double generarPrecioFinal(Articulo articulo, int cantidad, ContenedorArrayList<Descuento> listaDesc) {
        double aux = articulo.getCosto() + (articulo.getCosto() * articulo.getUtilidad() / 100) * cantidad;
        for (Descuento desc : listaDesc.getElementos()) {
            if (desc instanceof DescTarjeta) {
                if (((DescTarjeta) desc).getNombreTarjeta().equals(metodoPago)) {
                    return aux - (aux * desc.getPorcentaje() / 100);
                }
            }
        }
        return aux;
    }

    /**
     * Funcion para cargar la cantidad del articulo que desea llevar
     * @param articulo
     * @return int
     */
    public int cargarCantidadArticulo(Articulo articulo) {
        Teclado teclado = new Teclado();
        int cant = teclado.cargarCantidadArticulo();

        if(cant <= 0 && cant > articulo.getStock()){
            do{
                cant = teclado.cargarNuevamenteCantidadArticulo();
            }while(cant > 0 && cant <= articulo.getStock() && cant == -1);
        }
        return cant;
    }

    /**
     * Funcion para agregar el articulo en la lista de lineas
     * @param aAgregar,
     * @param cant
     * @param listaDescuento
     */
    public void agregarArticulo(Articulo aAgregar, int cant, ContenedorArrayList<Descuento> listaDescuento){
        if(cant != -1){
            Linea nueva = new Linea(aAgregar, cant, generarPrecioFinal(aAgregar, cant, listaDescuento));
            listaLinea.add(nueva);
        }
    }
}
