/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

/**
 * Banda actúa como:
 * - Publisher: publica BandaTocandoEvent
 * @author Dell
 */
public class Banda implements Publisher{
    private MessageBroker broker;
    private final String nombreBanda;

    public Banda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    @Override
    public void setBroker(MessageBroker broker) {
        this.broker = broker;
    }

    @Override
    public void publish(String topic, Message message) {
        if (broker != null) {
            broker.publish(topic,message);
        }
    }

    // Método específico para tocar canción
    public void tocarCancion(String nombreCancion, int duracionSegundos) {
        System.out.println("La banda " + nombreBanda + " esta tocando: " + nombreCancion);
        publish("BandaTocandoEvent",new BandaTocandoEvent(nombreBanda, nombreCancion, duracionSegundos));
    }
}
