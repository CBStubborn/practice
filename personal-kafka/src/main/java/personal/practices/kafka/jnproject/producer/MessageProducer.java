package personal.practices.kafka.jnproject.producer;


import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.practices.kafka.jnproject.exception.ProducerInvalidException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MessageProducer {

    private static final Logger LOG = LoggerFactory.getLogger(MessageProducer.class);

    private String defaultConfFile = "conf/kafka/kafka-producer.properties";

    private ProducerConfig producerConfig;

    private Producer<String, byte[]> producer;

    public MessageProducer() {

    }

    public MessageProducer(String confFile) {
        this.defaultConfFile = confFile;
    }

    /**
     * you should init producer before use it.
     */
    public void init() {
        try {
            LOG.info("init producer, conf file is: [{}]", defaultConfFile);
            FileReader reader = new FileReader(defaultConfFile);
            Properties properties = new Properties();
            properties.load(reader);
            producerConfig = new ProducerConfig(properties);
            producer = new Producer<String, byte[]>(producerConfig);
            reader.close();
        } catch (FileNotFoundException e) {
            LOG.error("Cannot found the file: [{}], please check it!", defaultConfFile);
            System.exit(1);
        } catch (IOException e) {
            LOG.error("IOException while read the file: [{}]", defaultConfFile);
        }
    }

    /**
     * send message to kafka
     *
     * @param topic
     * @param message
     */
    public void send(String topic, byte[] message) throws ProducerInvalidException {
        LOG.debug("send message to topic: [{}]", topic);
        if (producer == null) {
            throw new ProducerInvalidException("Producer is invalid, please init before use it!");
        }
        producer.send(new KeyedMessage<String, byte[]>(topic, message));
    }

    /**
     * charge producer whether is valid
     *
     * @return true if producer is valid, else false
     */
    public boolean isValid() {
        return producer == null ? false : true;
    }

    /**
     * close producer
     */
    public void close() {
        LOG.info("closing producer...");
        producer.close();
    }

    public static void main(String[] args) {
        MessageProducer messageProducer = new MessageProducer();
        messageProducer.init();
        System.out.println("producer: " + messageProducer.producer.toString());
    }
}
