package personal.practices.kafka.listeninterface.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import personal.practices.kafka.listeninterface.PropertyFactory;

/**
 * Created by CBStubborn on 2017/11/21.
 */
public class ConsumerWorker implements Runnable {

    private ConsumerRecord<String, String> consumerRecord;

    public ConsumerWorker(ConsumerRecord record) {
        this.consumerRecord = record;
    }

    public void run() {
        for (MessageContainer messageContainer : PropertyFactory.consumerProperty.getMessageContainers()) {
            if (consumerRecord.topic().equals(messageContainer.getTopic())) {
                messageContainer.getMessageHandle().onMessage(consumerRecord);
            }
        }
    }
}
