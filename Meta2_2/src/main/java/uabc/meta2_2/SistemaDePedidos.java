/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

import java.util.List;

/**
 *
 * @author Dell
 */
public class SistemaDePedidos implements Publisher{
    private MessageBroker broker;

    public SistemaDePedidos() { }

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

    public void realizarPedido(int mesaId, int pedidoId, List<String> items) {
        System.out.println("[Pedidos] Nuevo pedido: " + pedidoId + " para mesa " + mesaId);
        publish("PedidoRealizadoEvent", new PedidoRealizadoEvent(mesaId, pedidoId, items));
    }
}
