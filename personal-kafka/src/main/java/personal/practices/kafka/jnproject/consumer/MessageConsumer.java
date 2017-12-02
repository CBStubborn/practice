package personal.practices.kafka.jnproject.consumer;

import cn.edu.sdu.cs.starry.kafkaConsumer.dynamicConsumer.ConsumerConfig;
import cn.edu.sdu.cs.starry.kafkaConsumer.dynamicConsumer.batch.BatchConsumer;
import cn.edu.sdu.cs.starry.kafkaConsumer.entity.KafkaMessage;
import cn.edu.sdu.cs.starry.kafkaConsumer.exception.ConsumerConfigException;
import cn.edu.sdu.cs.starry.kafkaConsumer.exception.ConsumerLogException;
import cn.edu.sdu.cs.starry.kafkaConsumer.exception.KafkaCommunicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.practices.kafka.jnproject.exception.ConsumerInvalidException;
import personal.practices.kafka.jnproject.exception.ParamsInvalidException;

import java.util.List;
import java.util.Set;


/**
 * Created by CBStubborn on 2017/12/2.
 */
public class MessageConsumer {

    private final Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

    private String defaultConfFile = "";

    private String topic;

    private String consumerName;

    private Set<Integer> managedPartitionsSet;

    private BatchConsumer consumer;

    public MessageConsumer() {

    }

    public MessageConsumer(String confFile, String topic, String consumerName, Set<Integer> partitions) {
        this.defaultConfFile = confFile;
        this.consumerName = consumerName;
        this.topic = topic;
        this.managedPartitionsSet = partitions;
    }

    /**
     * init consumer
     */
    public void init() {
        LOG.info("init consumer, conf file: [{}], consumer name: [{}], topic: [{}], partitions: [{}]",
                defaultConfFile, consumerName, topic, managedPartitionsSet);
        ConsumerConfig consumerConfig = new ConsumerConfig(defaultConfFile);
        try {
            consumer = new BatchConsumer(consumerConfig, consumerName, topic, managedPartitionsSet);
            consumer.prepare();
        } catch (ConsumerConfigException | ConsumerLogException e) {
            LOG.error("error while generate batch consumer", e);
            System.exit(1);
        }
    }

    /**
     * get kafka messages
     *
     * @param size is the number of messages that user want to fetch
     * @return messages
     * @throws ConsumerInvalidException    if consumer is invalid
     * @throws ParamsInvalidException      if size is negative
     * @throws KafkaCommunicationException while get message
     */
    public List<KafkaMessage> getMessages(int size) throws ConsumerInvalidException, ParamsInvalidException, KafkaCommunicationException {
        if (consumer == null) {
            throw new ConsumerInvalidException("consumer is invalid, please init before use it!");
        }
        if (size <= 0) {
            throw new ParamsInvalidException("parameters is invalid " + size);
        }
        return consumer.fetchMessage(size);
    }

    /**
     * charge consumer whether is valid
     *
     * @return true if consumer is valid, else false
     */
    public boolean isValid() {
        return consumer == null ? false : true;
    }

    public static void main(String[] args) {

    }
}