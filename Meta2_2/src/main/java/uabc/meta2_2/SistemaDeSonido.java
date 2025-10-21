/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

/**
 * SistemaDeSonido actúa como Subscriber.
 * Se suscribe a BandaTocandoEvent y ajusta el ecualizador.
 * @author Dell
 */
public class SistemaDeSonido implements Subscriber{
    private final EventBus eventBus;

    public SistemaDeSonido(EventBus bus) {
        this.eventBus = bus;
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof BandaTocandoEvent bandaEvent) {
            System.out.println("SistemaDeSonido: Ajustando ecualizador para " 
                                + bandaEvent.getNombreCancion() 
                                + " de la banda " + bandaEvent.getNombreBanda());
        }
    }

    // Helper para suscribirse al EventBus
    public void suscribirse() {
        eventBus.subscribe("BandaTocandoEvent", this);
    }
}
