# El-Golem-Alquimico
Repositorio donde se sube el codigo de la Meta 2.2 sobre la taberna del bus de eventos aplicando el patron publisher/subscriber

Este proyecto implementa un EventBus con el patrón Publisher/Subscriber en Java, desacoplando completamente los componentes.

Componentes principales

- Message → clase base de todos los eventos (inmutable)
- Publisher → interfaz para cualquier publicador
- Subscriber → interfaz para cualquier suscriptor
- EventBus → gestor de eventos y suscripciones

---

## 1️⃣ Crear un nuevo Subscriber

Para crear un subscriber, implementa la interfaz Subscriber:

public class NuevoSubscriber implements Subscriber {
    private final EventBus bus;

    public NuevoSubscriber(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void onMessage(Message message) {
        // Procesa el mensaje
        System.out.println("Recibido: " + message);
    }

    @Override
    public void subscribe(String topic) {
        bus.subscribe(topic, this);
    }

    @Override
    public void unsubscribe(String topic) {
        bus.unsubscribe(topic, this);
    }
}

Para crear un nuevo publisher, implementa la interfaz Publisher:

public class NuevoPublisher implements Publisher {
    private MessageBroker broker;

    @Override
    public void publish(String topic, Message message) {
        broker.publish(topic, message);
    }

    @Override
    public void setBroker(MessageBroker broker) {
        this.broker = broker;
    }

    public void realizarAccion() {
        // Crear evento y publicarlo
        Message evento = new PedidoRealizadoEvent(1, 101, List.of("Cerveza"));
        publish("PedidoRealizadoEvent", evento);
    }
}

Para crear un componente que implemente ambas interfaces:

public class Barra implements Publisher, Subscriber {
    private EventBus bus;

    public Barra(EventBus bus) {
        this.bus = bus;
        bus.subscribe("PedidoRealizadoEvent", this);
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof PedidoRealizadoEvent pedido) {
            System.out.println("Preparando bebida para la mesa " + pedido.getMesaId());
            publish("BebidaServidaEvent", new BebidaServidaEvent(pedido.getMesaId(), "Cerveza"));
        }
    }

    @Override
    public void publish(String topic, Message message) {
        bus.publish(topic, message);
    }

    @Override
    public void setBroker(MessageBroker broker) {
        this.bus = (EventBus) broker;
    }

    @Override
    public void subscribe(String topic) { bus.subscribe(topic, this); }

    @Override
    public void unsubscribe(String topic) { bus.unsubscribe(topic, this); }
}

Para suscribirse a eventos existentes:

EventBus bus = new EventBus();

// Crear subscriber
PanelLED panel = new PanelLED(bus);
panel.suscribirse();

// Crear publisher
SistemaDePedidos pedidos = new SistemaDePedidos(bus);
pedidos.realizarPedido(5, 123, List.of("Cerveza", "Hamburguesa"));

Para crear nuevos eventos:
public class HumoEvent extends Message {
    private final String efecto;
    private final String cancion;

    public HumoEvent(String efecto, String cancion) {
        super("HumoEvent");  // topic
        this.efecto = efecto;
        this.cancion = cancion;
    }

    @Override
    public Object getPayload() {
        return Map.of("efecto", efecto, "cancion", cancion);
    }

    public String getEfecto() { return efecto; }
    public String getCancion() { return cancion; }
}

Y para publicar este evento:

HumoEvent humo = new HumoEvent("Niebla", "Through the Fire and Flames");
publish(humo.getTopic(), humo);
