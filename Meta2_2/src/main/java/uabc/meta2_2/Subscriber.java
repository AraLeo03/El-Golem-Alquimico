/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uabc.meta2_2;

/**
 * Responsabilidades:
 * - Suscribirse a topics
 * - Procesar mensajes
 * - No conoce a los publishers
 * @author Dell
 */
public interface Subscriber {
    public void onMessage(Message message);
}
