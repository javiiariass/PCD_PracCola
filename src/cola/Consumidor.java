/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cola;

/**
 *
 * @author javi
 */
public class Consumidor extends Thread {

    private final ColaLenta lacola;
    private final String idHilo;

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
        for (int i = 0; i < 10; i++) {
            consumir();
        }
    }

}
