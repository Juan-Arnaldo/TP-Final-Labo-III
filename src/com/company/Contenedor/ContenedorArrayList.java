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

    public void setListaDeElementos(ArrayList<T> listaDeElementos) {
        this.listaDeElementos = listaDeElementos;
    }

    /**
     * Método que devuelve los elementos del ArrayList
     * @return listaDeElementos
     */
    public ArrayList<T> getLista()
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
     * Y aumenta el id del contador
     * @param obj - Objeto a agregar.
     */
    public void agregar(T obj)
    {
        listaDeElementos.add(obj);
        this.contadorId++;
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
     * Metodo para conseguir un elemento por id
     * @param id
     * @return El object deseado
     */
    public T getElemento(int id){
        return listaDeElementos.get(id);
    }

    public void mostrarElementos(T a){
        for (T aMostrar : listaDeElementos){
            aMostrar.toString();
        }
    }

    public boolean listaVacia(){
        return listaDeElementos.isEmpty();
    }
}