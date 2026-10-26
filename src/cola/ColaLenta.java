/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cola;

/**
 * Implementación de una cola circular usando un vector. Reutiliza las
 * componentes del vector que contenían elementos ya eliminados calculando las
 * nuevas posiciones mediante aritmética modular.
 *
 * @author javi
 */
public class ColaLenta implements ICola {

    private int head;
    private int tail;
    private final int capacidad;
    private int numElementos;
    private final Object[] datos;
    private CanvasCola canvas;
    /**
     * Constructor de la clase. Inicializa la cola y los atributos de la clase.
     *
     * @param capacidad Cantidad de elementos con que se inicializa el vector.
     */
    public ColaLenta(int capacidad, CanvasCola canvas) {
        head = 0;
        tail = 0;
        numElementos = 0;
        this.capacidad = capacidad;
        datos = new Object[capacidad];
        this.canvas = canvas;
    }

    /**
     * Devuelve el número de elementos que hay en la cola. Implementa getNum de
     * interface ICola.
     *
     * @return Devuelve el número de elementos que hay en la cola.
     */
    @Override
    public int getNum() {
        return numElementos;
    }

    /**
     * Añade el elemento a la cola si no está llena. Implementa acola de
     * interface ICola.
     *
     * @param elemento Que se acola.
     * @throws java.lang.Exception Si la cola está llena.
     */
    @Override
    public synchronized void acola(Object elemento) throws Exception {
        Thread.sleep(100);
        
        if (colallena()) {
            canvas.avisa("COLA LLENA");
            throw new Exception("Error acolando: La cola está llena");
        }
        
        datos[tail] = elemento;
        numElementos++;
        tail++;
        tail %= capacidad;
        
        canvas.representa(head, tail, numElementos, datos);
        
    }
    
    /**
     * Extrae el primer elemento de la cola si existe. Implementa desacola de
     * interface ICola.
    *
    * @return Elemento que se extrae.
    * @throws java.lang.Exception Si la cola está vacía.
    */
   @Override
   public synchronized Object desacola() throws Exception {
       Thread.sleep(100); 
       
        if (colavacia()) {
            canvas.avisa("COLA VACIA");
            throw new Exception("Error desacolando: La cola está vacía");
        }

        Object objetoDesacola;

        objetoDesacola = datos[head];
        numElementos--;
        head++;
        head %= capacidad;

        canvas.representa(head, tail, numElementos, datos);
        
        return objetoDesacola;
    }

    /**
     * Devuelve el primer elemento de la cola sin extraerlo. Implementa primero
     * de interface ICola.
     *
     * @return Elemento que está el primero en la cola.
     * @throws java.lang.Exception Si la cola está vacía.
     */
    @Override
    public Object primero() throws Exception {
        if (colavacia()) {
            canvas.avisa("COLA VACIA");
            throw new Exception("Error obteniendo elemento: La cola está vacía");
        }

        return datos[head];
    }

    /**
     * Comprueba si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    private boolean colavacia() {
        return numElementos == 0;
    }

    /**
     * Comprueba si la cola está llena.
     *
     * @return true si la cola está llena, false en caso contrario.
     */
    private boolean colallena() {
        return numElementos == capacidad;
    }
}
