/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

/**
 * PanelLED actúa como Subscriber.
 * Se suscribe a todos los eventos relevantes y muestra notificaciones.
 * @author Dell
 */
public class PanelLED implements Subscriber{
    private final EventBus eventBus;

    public PanelLED(EventBus bus) {
        this.eventBus = bus;
        org.fusesource.jansi.AnsiConsole.systemInstall();
    }

    @Override
    public void onMessage(Message message) {
        String mensaje = "[PANEL LED] ";
        
        if (message instanceof PedidoRealizadoEvent pedido) {
            mensaje += "Nuevo Pedido Realizado! Pedido ID: " + pedido.getPedidoId()
                     + ", Mesa: " + pedido.getMesaId();
        } else if (message instanceof BebidaServidaEvent bebida) {
            mensaje += "Nueva Bebida Servida en la Mesa " + bebida.getMesaId()
                     + "! Bebida: " + bebida.getBebida();
        } else if (message instanceof ComidaPreparadaEvent comida) {
            mensaje += "Comida Preparada! Pedido ID: " + comida.getPedidoId()
                     + ", Plato: " + comida.getPlato();
        } else if (message instanceof BandaTocandoEvent banda) {
            mensaje += "Banda Tocando! " + banda.getNombreBanda()
                     + " - " + banda.getNombreCancion();
        }

        System.out.println(mensaje);
    }

    // Helper para suscribirse a todos los eventos
    public void suscribirse() {
        eventBus.subscribe("PedidoRealizadoEvent", this);
        eventBus.subscribe("BebidaServidaEvent", this);
        eventBus.subscribe("ComidaPreparadaEvent", this);
        eventBus.subscribe("BandaTocandoEvent", this);
    }
}
