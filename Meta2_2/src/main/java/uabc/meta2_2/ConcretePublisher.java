/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

/**
 *
 * @author Dell
 */
public class ConcretePublisher implements Publisher{
    private MessageBroker broker;
    private String publisherId;

    public ConcretePublisher(String publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public void publish(String topic, Message message) {
        if (broker != null){
            broker.publish(topic,message);
        }
    }

    @Override
    public void setBroker(MessageBroker broker) {
        this.broker = broker;
    }
    
    public String getPublisherId(){
        return publisherId;
    }
}
