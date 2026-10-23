/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import cola.Cola;
import java.util.Random;

/**
 * Clase principal para probar el funcionamiento de la cola circular.
 *
 * @author javi
 */
public class UsaCola {

    /**
     * Punto de entrada de la aplicación.
     * Prueba el funcionamiento con una cola de 4 elementos realizando 10 iteraciones
     * donde se inserta o extrae aleatoriamente según el valor obtenido (0 o 1).
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola cola = new Cola(4);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int aleatorio = random.nextInt(2); // Genera 0 o 1 aleatoriamente

            try {
                if (aleatorio == 0) {
                    System.out.println("Iteración " + i + " [Aleatorio = 0]: Extrayendo...");
                    Object extraido = cola.desacola();
                    System.out.println("\t-> Elemento extraído: " + extraido + " (Elementos en cola: " + cola.getNum() + ")");
                } else {
                    System.out.println("Iteración " + i + " [Aleatorio = 1]: Insertando " + i + "...");
                    cola.acola(i);
                    System.out.println("\t-> Elemento insertado: " + i + " (Elementos en cola: " + cola.getNum() + ")");
                }
            } catch (Exception e) {
                System.out.println("\t-> Excepción: " + e.getMessage());
            }
            System.out.println();
        }
    }
}
