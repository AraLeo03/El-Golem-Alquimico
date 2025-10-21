/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

/**
 * SistemaDeHumo actúa como subscriber.
 * Solo reacciona a BandaTocandoEvent con una canción específica.
 * @author Dell
 */
public class SistemaDeHumo implements Subscriber{

    @Override
    public void onMessage(Message message) {
        if (message instanceof BandaTocandoEvent bandaEvent) {
            if (bandaEvent.getNombreCancion().equalsIgnoreCase("Through the Fire and Flames")) {
                System.out.println("SistemaDeHumo: Activando efectos de humo para " 
                                    + bandaEvent.getNombreCancion());
            }
        }
    }
    
}
