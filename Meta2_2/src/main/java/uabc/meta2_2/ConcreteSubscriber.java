/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author Dell
 */
public class ConcreteSubscriber implements Subscriber{
    private String subscriberId;
    private Set<String> subscribedTopics = new HashSet<>();
    private MessageBroker broker;

    public ConcreteSubscriber(String subscriberId, MessageBroker broker) {
        this.subscriberId = subscriberId;
        this.broker = broker;
    }
    
    @Override
    public void onMessage(Message message){
        processMessage(message);
    }
    
    public String getSubscribersId(){
        return subscriberId;
    }
    public void processMessage(Message message){
        System.out.println("["+subscriberId+"] Procesando mensaje de topic '"+message.getTopic()+"' con payload: "+message.getPayload());
    }
}
