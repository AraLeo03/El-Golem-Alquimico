/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

/**
 *
 * @author Dell
 */
public class ComidaPreparadaEvent extends Message{
    private final int pedidoId;
    private final String plato;

    public ComidaPreparadaEvent(int pedidoId, String plato) {
        super("ComidaPreparadaEvent");
        this.pedidoId = pedidoId;
        this.plato = plato;
    }

    @Override
    public Object getPayload() {
        return this;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public String getPlato() {
        return plato;
    }

    @Override
    public String toString() {
        return "ComidaPreparadaEvent{pedidoId=" + pedidoId + ", plato='" + plato + "'}";
    }
}
