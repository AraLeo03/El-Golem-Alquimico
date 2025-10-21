/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

/**
 *
 * @author Dell
 */
public class BebidaServidaEvent extends Message{
    private final int mesaId;
    private final String bebida;

    public BebidaServidaEvent(int mesaId, String bebida) {
        super("BebidaServidaEvent");
        this.mesaId = mesaId;
        this.bebida = bebida;
    }

    @Override
    public Object getPayload() {
        return this;
    }

    public int getMesaId() {
        return mesaId;
    }

    public String getBebida() {
        return bebida;
    }

    @Override
    public String toString() {
        return "BebidaServidaEvent{mesaId=" + mesaId + ", bebida='" + bebida + "'}";
    }
}
