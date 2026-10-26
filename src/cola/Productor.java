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
public class Productor extends Thread {

    Random random = new Random();
    private final ColaLenta lacola;
    private final String idHilo;
    private final int NUM_PRODUCCIONES = 15;
    private final int[] RANGO_ESPERA_SEGUNDOS = {1,3};

    public Productor(String id, ColaLenta cola) {
        lacola = cola;
        idHilo = id;
        this.setName(id);
    }

    public void producir() {
        float aleatorio = (random.nextFloat()*100)+1; // [1-100]

        try {
            lacola.acola(aleatorio);
            System.out.println("Hilo " + idHilo + ": producido " + aleatorio);
        } catch (Exception ex) {
            System.out.println("Hilo " + idHilo + ": " + ex.getMessage());
        }
    }

    @Override
    public void run() {
        int aleatorio;
        for (int i = 0; i < NUM_PRODUCCIONES; i++) {
            try {
                aleatorio = random.nextInt(RANGO_ESPERA_SEGUNDOS[1]) + 
                        RANGO_ESPERA_SEGUNDOS[0];
                Thread.sleep(aleatorio*1000);
            } catch (InterruptedException ex) {
                System.getLogger(Productor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            producir();
        }
    }

}
