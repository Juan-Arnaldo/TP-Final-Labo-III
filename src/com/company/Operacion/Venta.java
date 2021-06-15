package com.company.Operacion;

import com.company.Articulo.Articulo;
import com.company.Contenedor.ContenedorArrayList;
import com.company.Local.Descuento;
import com.company.Persona.Persona;
import com.company.Utilidad.Menu;
import com.company.Utilidad.Validacion;

import java.util.ArrayList;

public class Venta extends Operacion {
    private int idVenta;
    private int idCaja;
    private String metodoPago;
    private ContenedorArrayList<Linea> listaLinea;

    public Venta(Persona persona, int idCaja) {
        super(persona);
        this.idCaja = idCaja;
        this.listaLinea = new ContenedorArrayList<Linea>();
    }

    public Venta(Persona persona, int idVenta, int idCaja, String metodoPago) {
        super(persona);
        this.idVenta = idVenta;
        this.idCaja = idCaja;
        this.metodoPago = metodoPago;
    }

    public ArrayList<Linea> getListaLinea() {
        return listaLinea.getLista();
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Metodo para generar el total de la venta, con o sin descuento
     * @param listaDesc
     * @return double, el total de la venta
     */
    private double generarTotal(ContenedorArrayList<Descuento> listaDesc){
        int aux = 0;
        for (Linea linea : listaLinea.getLista()){
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
        Menu teclado = new Menu();
        int cant = teclado.cargarCantidadArticulo();

        while(cant < 0 || cant > articulo.getStock()){
                cant = teclado.cargarNuevamenteCantidadArticulo();
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
        listaLinea.agregar(nueva);
    }

    private void mostrarLineas() {
        System.out.println("Cantidad \t Nombre Articulo \t Precio");
        for (Linea linea : listaLinea.getLista()){
            System.out.println(linea.toString());
        }
    }

    public void MostrarVenta(ContenedorArrayList<Descuento> listaDesc){
        System.out.println("\nID venta: " + idVenta +
                             "\nFecha: " + getFecha() + " Hora: " + getHora() +
                            "\nMetodo de Pago: " + metodoPago + "\n");
        mostrarLineas();
        System.out.println("Total: " + generarTotal(listaDesc));
    }

//    @Override
//    public String toString() {
//        return  "\nID venta: " + idVenta +
//                "\nFecha: " + getFecha() + " Hora: " + getHora() +
//                "\nMetodo de Pago: " + metodoPago + "\n" + mostrarLineas();
//    }
}
