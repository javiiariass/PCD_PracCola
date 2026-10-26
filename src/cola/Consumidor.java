/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cola;

import java.util.Random;

/**
 *
 * @author javi
 */
public class Consumidor implements Runnable {
    Random random = new Random();
    private final ColaLenta lacola;
    private final String idHilo;
    private final int NUM_CONSUMICIONES = 15;
    private final int[] RANGO_ESPERA_SEGUNDOS = {1, 3};

    public Consumidor(String id, ColaLenta cola) {
        lacola = cola;
        idHilo = id;
    }

    public void consumir() {
        try {
            float num_desacolado = (float) lacola.desacola();
            System.out.println("Hilo " + idHilo + ": consumido " + num_desacolado);
        } catch (Exception ex) {
            System.out.println("Hilo " + idHilo + ": " + ex.getMessage());
        }
    }

    @Override
    public void run() {
        int aleatorio;
        Thread.currentThread().setName(idHilo);
        for (int i = 0; i < NUM_CONSUMICIONES; i++) {
            try {
                aleatorio = random.nextInt(RANGO_ESPERA_SEGUNDOS[1])
                        + RANGO_ESPERA_SEGUNDOS[0];
                Thread.sleep(aleatorio * 1000);
            } catch (InterruptedException ex) {
                System.getLogger(Consumidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            consumir();
        }

        // terminar la cola
        lacola.terminaCola();

    }

}
