/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

import java.util.*;

/**
 * ConcreteMessageBroker
 * @author Dell
 */
public class EventBus implements MessageBroker{
    private final Map<String, List<Subscriber>> topics = new HashMap<>();
    private final List<Publisher> publishers = new ArrayList<>();

    @Override
    public synchronized void subscribe(String topic, Subscriber subscriber) {
        topics.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    @Override
    public synchronized void unsubscribe(String topic, Subscriber subscriber) {
        List<Subscriber> subs = topics.get(topic);
        if (subs != null) subs.remove(subscriber);
    }

    @Override
    public synchronized void publish(String topic,Message message) {
        notifySubscribers(topic, message);
    }

    @Override
    public synchronized void addPublisher(Publisher publisher) {
        publishers.add(publisher);
        publisher.setBroker(this);
    }

    private void notifySubscribers(String topic, Message message) {
        List<Subscriber> subs = topics.get(topic);
        if (subs != null) {
            // Hacemos una copia para evitar ConcurrentModificationException si un subscriber se desuscribe
            List<Subscriber> subsCopy = new ArrayList<>(subs);
            for (Subscriber s : subsCopy) {
                //s.onMessage(message);
                new Thread(() -> s.onMessage(message)).start();
            }
        }
    }
}
