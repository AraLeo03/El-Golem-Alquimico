/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

import java.util.Date;
import java.util.UUID;

/**
 * Responsabilidades:
 * - Transporta datos
 * - Mantener metadata
 * - Ser inmutable (idealmente)
 * @author Dell
 */
public abstract class Message {
    String id;
    Date timeStamp;
    String topic;
    
    protected Message(String topic) {
        this.id = UUID.randomUUID().toString();
        this.timeStamp = new Date();
        this.topic = topic;
    }
    
    public abstract Object getPayload();
    
    //public abstract void setPayload(Object payload);
    
    public String getId(){
        return id;
    }
    
    public Date getTimeStamp(){
        return timeStamp;
    }
    
    public String getTopic(){
        return topic;
    }
}
