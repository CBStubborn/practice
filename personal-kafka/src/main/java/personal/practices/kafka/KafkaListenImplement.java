package personal.practices.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

/**
 * Created by CBStubborn on 2017/11/21.
 */
public class KafkaListenImplement {


}

class KafkaMessageListener implements AcknowledgingMessageListener<Integer, String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> record, Acknowledgment acknowledgment) {
        Integer key = record.key();
        String value = record.value();
        long offset = record.offset();
        int partition = record.partition();
        acknowledgment.acknowledge();
    }

}
