/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

/**
 * Responsabilidades:
 * - Crear mensajes
 * - Publicar en el broker
 * - No conoces a los suscribers
 * @author Dell
 */
public interface Publisher {
    public void publish(String topic, Message message);
    public void setBroker(MessageBroker broker);
}
