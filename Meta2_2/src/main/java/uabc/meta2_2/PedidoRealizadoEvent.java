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
public class PedidoRealizadoEvent extends Message{
    private final int mesaId;
    private final int pedidoId;
    private final List<String> items;

    public PedidoRealizadoEvent(int mesaId, int pedidoId, List<String> items) {
        super("PedidoRealizadoEvent");
        this.mesaId = mesaId;
        this.pedidoId = pedidoId;
        this.items = List.copyOf(items); // inmutable
    }
    
    @Override
    public Object getPayload() {
        return this;
    }
    
    public int getMesaId() {
        return mesaId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "PedidoRealizadoEvent{mesaId=" + mesaId + ", pedidoId=" + pedidoId + ", items=" + items + "}";
    }
}
