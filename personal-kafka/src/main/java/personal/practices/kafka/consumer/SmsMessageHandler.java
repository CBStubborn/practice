package personal.practices.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

/**
 * Created by CBStubborn on 2017/11/21.
 */
public class SmsMessageHandler implements MessageListener {

    public static final Logger LOG = LoggerFactory.getLogger(SmsMessageHandler.class);

    @Override
    public void onMessage(ConsumerRecord consumerRecord) {


    }

}

