/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

import java.util.List;

/**
 * Barra actúa como:
 * - Subscriber: recibe PedidoRealizadoEvent
 * - Publisher: publica BebidaServidaEvent
 * @author Dell
 */
public class Barra implements Subscriber,Publisher{
    private MessageBroker broker;

    public Barra() { }

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
            List<String> bebidas = pedido.getItems().stream()
                    .filter(i -> i.toLowerCase().contains("cerveza") || i.toLowerCase().contains("vino") || i.toLowerCase().contains("coca coal"))
                    .toList();

            for (String bebida : bebidas) {
                System.out.println("Barra preparando bebida: " + bebida + " para mesa " + pedido.getMesaId());
                try{ Thread.sleep(2000); } catch(InterruptedException e){e.printStackTrace();}
                publish("BebidaServidaEvent", new BebidaServidaEvent(pedido.getMesaId(), bebida));
            }
        }
    }
}
