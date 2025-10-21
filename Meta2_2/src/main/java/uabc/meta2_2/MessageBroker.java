/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uabc.meta2_2;

/**
 * Responsaiidades:
 * - Gestionar suscripciones
 * - Enrutar mensajes
 * - Desacoplar componentes
 * @author Dell
 */
public interface MessageBroker {
    public void subscribe(String topic,Subscriber subscriber);
    public void unsubscribe(String topic,Subscriber subscriber);
    public void publish(String topic,Message message);
    public void addPublisher(Publisher publisher);
}
