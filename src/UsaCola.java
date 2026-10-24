/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import cola.ColaLenta;
import cola.Consumidor;
import cola.Productor;
import java.util.Random;

/**
 * Clase principal para probar el funcionamiento de la cola circular.
 *
 * @author javi
 */
public class UsaCola {

    /**
     * Punto de entrada de la aplicación. Prueba el funcionamiento con una cola
     * de 4 elementos realizando 10 iteraciones donde se inserta o extrae
     * aleatoriamente según el valor obtenido (0 o 1).
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaLenta cola = new ColaLenta(10);
        Random random = new Random();

        Productor prod = new Productor("P1", cola);
        prod.start();
        try {
            prod.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Consumidor consum;
        Thread[] hiloConsumidor = new Thread[2];

        for (int i = 0; i < 2; i++) {
            consum = new Consumidor("C" + (i + 1), cola);
            hiloConsumidor[i] = new Thread(consum);
        }

        for (int i = 0; i < 2; i++) {
            hiloConsumidor[i].start();
        }

        for (int i = 0; i < 2; i++) {
            try {
                hiloConsumidor[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        System.out.println("Elementos finales en la cola: " + cola.getNum());

    }
}
