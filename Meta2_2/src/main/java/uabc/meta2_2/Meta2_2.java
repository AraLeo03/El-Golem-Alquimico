/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package uabc.meta2_2;

import java.util.*;

/**
 * Taberna
 * @author Dell
 */
public class Meta2_2 {

    public static void main(String[] args) throws InterruptedException{
       //Crear el bus de eventos
       EventBus bus = new EventBus();
       
       //Crear a los actores
       SistemaDePedidos pedidos = new SistemaDePedidos();
       Barra barra = new Barra();
       Cocina cocina = new Cocina();
       Banda banda = new Banda("Los Seguidores de Dijkstra");
       SistemaDeSonido sonido = new SistemaDeSonido(bus);
       PanelLED panel = new PanelLED(bus);
       
       //Establecer el broker con los actores Publisher
       pedidos.setBroker(bus);
       barra.setBroker(bus);
       cocina.setBroker(bus);
       banda.setBroker(bus);
       
       //Suscribir a los actores suscriptores a los eventos
       bus.subscribe("PedidoRealizadoEvent", barra);
       bus.subscribe("PedidoRealizadoEvent", cocina);
       bus.subscribe("BandaTocandoEvent",sonido );
       bus.subscribe("PedidoRealizadoEvent", panel);
       bus.subscribe("BebidaServidaEvent", panel);
       bus.subscribe("ComidaPreparadaEvent", panel);
       bus.subscribe("BandaTocandoEvent", panel);
       
       //Sistema de humo
       SistemaDeHumo humo = new SistemaDeHumo();
       bus.subscribe("BandaTocandoEvent", humo);
       
       //Simulacion en paralelo con Threads
       new Thread(() -> {
         pedidos.realizarPedido(5, 123, List.of("Cerveza","Hamburguesa"));
       }).start();
       
       new Thread(() -> {
           banda.tocarCancion("El Algoritmo del Amor", 180);
       }).start();
       Thread.sleep(500);
       new Thread (() -> {
           pedidos.realizarPedido(3, 666, List.of("Coca Coal","Arrachera"));
       }).start();
       
       new Thread(() -> {
           banda.tocarCancion("Through the Fire and Flames", 442);
       }).start();
    }
}


/*
asi se crea una suscripcion
EventBus bus = new ConcreteEventBus();
Subscriber barra = new Barra(bus);
bus.suscribir("PedidoRealizadoEvent", barra);
*/