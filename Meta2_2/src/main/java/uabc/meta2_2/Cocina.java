/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

import java.util.List;

/**
 * Cocina actúa como:
 * - Subscriber: recibe PedidoRealizadoEvent
 * - Publisher: publica ComidaPreparadaEvent
 * @author Dell
 */
public class Cocina implements Subscriber,Publisher{
    private MessageBroker broker;

    public Cocina() { }

    @Override
    public void setBroker(MessageBroker broker) {
        this.broker = broker;
    }

    @Override
    public void publish(String topic, Message message) {
        if (broker != null) {
            broker.publish(topic, message);
        }
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof PedidoRealizadoEvent pedido) {
            List<String> comidas = pedido.getItems().stream()
                    .filter(i -> !i.toLowerCase().contains("cerveza") && !i.toLowerCase().contains("vino") && !i.toLowerCase().contains("coca coal"))
                    .toList();

            for (String plato : comidas) {
                System.out.println("Cocina preparando plato: " + plato + " del pedido " + pedido.getPedidoId());
                try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
                publish("ComidaPreparadaEvent", new ComidaPreparadaEvent(pedido.getPedidoId(), plato));
            }
        }
    }
}
