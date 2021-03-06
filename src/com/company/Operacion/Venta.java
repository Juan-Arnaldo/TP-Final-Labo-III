package com.company.Operacion;

import com.company.Articulo.Articulo;
import com.company.Contenedor.ContenedorArrayList;
import com.company.Local.DescTarjeta;
import com.company.Local.Descuento;
import com.company.Persona.Persona;
import com.company.Utilidad.Menu;
import com.company.Utilidad.Teclado;
import com.company.Utilidad.Validacion;

import java.util.ArrayList;

public class Venta extends Operacion {
    private int idVenta;
    private int idCaja;
    private String metodoPago;

    public Venta(Persona persona, int idCaja) {
        super(persona);
        this.idCaja = idCaja;
    }

    public Venta(Persona persona, int idVenta, int idCaja, String metodoPago) {
        super(persona);
        this.idVenta = idVenta;
        this.idCaja = idCaja;
        this.metodoPago = metodoPago;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Metodo para generar el total de la venta, con o sin descuento
     * @param listaDesc
     * @return double, el total de la venta
     */
    public double generarTotal(ContenedorArrayList<DescTarjeta> listaDesc){
        int aux = 0;
        for (Linea linea : super.getListaLinea().getLista()){
            aux += linea.getTotalLinea();
        }

        Validacion validacion = new Validacion();
        Descuento desc = validacion.validacionDescuento(metodoPago, listaDesc);

        if(desc != null){
            aux = (aux - (aux * desc.getPorcentaje() / 100));
        }
        return aux;
    }

    /**
     * Funcion para cargar la cantidad del articulo que desea llevar
     * @param articulo
     * @return int
     */
    public int cargarCantidadArticulo(Articulo articulo) {
        Teclado t = new Teclado();
        int cant = t.cargarCantidadArticulo();

        while(cant < 0 || cant > articulo.getStock()){
                cant = t.cargarNuevamenteCantidadArticulo(articulo.getStock());
        }

        return cant;
    }

    /**
     * Funcion para agregar el articulo en la lista de lineas
     * @param aAgregar,
     * @param cant
     */
    public void agregarLinea(Articulo aAgregar, int cant){
        Linea nueva = new Linea(aAgregar, cant);
        super.getListaLinea().agregar(nueva);
    }

    public void mostrarVenta(ContenedorArrayList<DescTarjeta> listaDesc){
        Validacion v = new Validacion();
        Descuento desc = v.validacionDescuento(metodoPago, listaDesc);
        if(desc != null){
            mostrarVentaConDesc(generarTotal(listaDesc), desc);
        }else{
            mostrarVentaSinDesc(generarTotal(listaDesc));
        }
    }

    public void mostrarVentaConDesc(double total, Descuento desc){
        System.out.println("Cliente: " + getPersona().getNombre() + " " +getPersona().getApellido() + " " + getPersona().getCuit() +
                "\nID venta: " + getIdOperacion() +
                "\nMetodo de Pago: " + metodoPago);

        mostrarLineas();
        System.out.println("\nSe le aplico un: " + desc.getPorcentaje() + "% de descuento" + "\nTotal: \t\t " + total);
    }

    public void mostrarVentaSinDesc(double total){
        System.out.println("\nID venta: " + getIdOperacion());
        System.out.println("Cliente: " +getPersona().getApellido() + ", " + getPersona().getNombre() + ". CUIT: " + getPersona().getCuit());
        System.out.println("\nMetodo de Pago: " + metodoPago + "\n");
        mostrarLineas();
        System.out.println("\nTotal: \t\t " + total);
        System.out.println("\n---------------------------------------\n");
    }
}
