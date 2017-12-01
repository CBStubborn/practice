package personal.practices.kafka.listeninterface;

import personal.practices.kafka.listeninterface.consumer.ConsumerProperty;
import personal.practices.kafka.listeninterface.producer.ProducerProperty;

public class PropertyFactory {

    public static ConsumerProperty consumerProperty;

    public static ProducerProperty producerProperty;

    public static ConsumerProperty getConsumerProperty() {
        return consumerProperty;
    }

    public static void setConsumerProperty(ConsumerProperty consumerProperty) {
        PropertyFactory.consumerProperty = consumerProperty;
    }

    public static ProducerProperty getProducerProperty() {
        return producerProperty;
    }

    public static void setProducerProperty(ProducerProperty producerProperty) {
        PropertyFactory.producerProperty = producerProperty;
    }


}
