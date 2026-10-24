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

    public Productor(String id, ColaLenta cola) {
        lacola = cola;
        idHilo = id;
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
        for (int i = 0; i < 10; i++) {
            producir();
        }
    }

}
