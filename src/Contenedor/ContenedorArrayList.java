package Contenedor;

import java.util.ArrayList;
import java.util.Iterator;

public class ContenedorArrayList<T> {
    private ArrayList<T> listaDeElementos;

    public ContenedorArrayList()
    {
        this.listaDeElementos = new ArrayList<T>();
    }

    public ContenedorArrayList(ArrayList<T> listaDeElementos)
    {
        super();
        this.listaDeElementos = listaDeElementos;
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

}