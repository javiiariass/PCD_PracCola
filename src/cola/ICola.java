/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cola;

/**
 * Interfaz que define las operaciones básicas de una cola FIFO.
 *
 * @author javi
 */
public interface ICola {

    /**
     * Devuelve el número de elementos que hay en la cola.
     *
     * @return Devuelve el número de elementos que hay en la cola.
     */
    public int getNum();

    /**
     * Añade el elemento a la cola si no está llena.
     *
     * @param elemento Elemento que se acola.
     * @throws java.lang.Exception Si la cola está llena.
     */
    public void acola(Object elemento) throws Exception;

    /**
     * Extrae el primer elemento de la cola si existe.
     *
     * @return Elemento que se extrae.
     * @throws java.lang.Exception Si la cola está vacía.
     */
    public Object desacola() throws Exception;

    /**
     * Devuelve el primer elemento de la cola sin extraerlo.
     *
     * @return Elemento que está el primero en la cola.
     * @throws java.lang.Exception Si la cola está vacía.
     */
    public Object primero() throws Exception;

}
