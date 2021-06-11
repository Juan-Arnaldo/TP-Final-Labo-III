package com.company.Contenedor;

import java.util.ArrayList;

public class ContenedorArrayList<T> {
    private ArrayList<T> listaDeElementos;
    private int contadorId;

    public ContenedorArrayList()
    {
        this.contadorId = 0;
        this.listaDeElementos = new ArrayList<T>();
    }

    public ContenedorArrayList(ArrayList<T> listaDeElementos, int contadorId)
    {
        super();
        this.listaDeElementos = listaDeElementos;
        this.contadorId = contadorId;
    }

    /**
     * Método que devuelve los elementos del ArrayList
     * @return listaDeElementos
     */
    public ArrayList<T> getElementos()
    {
        return listaDeElementos;
    }

    /**
     * Método para editar un elemento del ArrayList, conociendo su índice.
     * @param nuevoElemento - Elemento que reemplazará al existente.
     * @param id - Índice del ArrayList donde se hará la edición.
     */
    public void editar(T nuevoElemento, int id)
    {
        listaDeElementos.remove(id);
        listaDeElementos.add(id, nuevoElemento);
    }

    /**
     * Método para agregar un objeto al Arraylist.
     * @param obj - Objeto a agregar.
     */
    public void agregar(T obj)
    {
        listaDeElementos.add(obj);
    }

    /**
     * Método para eliminar elemento en el Arraylist conociendo su índice.
     * @param id - Índice del elemento a eliminar.
     * @return Elemento eliminado.
     */
    public T eliminar(int id)
    {
        return listaDeElementos.remove(id);
    }

    /**
     * Método para conseguir la cantidad de elementos presentes en el Arraylist.
     * @return Cantidad de elementos en el ArrayList.
     */
    public int cantidadElementos() {
        return listaDeElementos.size();
    }

    /**
     * Método para conseguir el contador de ID
     * @return contadorId.
     */
    public int getContadorId() {
        return contadorId;
    }

    /**
     * Método para aumentar en 1 el contador de ID.
     */
    public void aumentarContadorId() {
        this.contadorId = contadorId++;
    }
}