package personal.practices.kafka.jnproject;


import java.io.File;
import java.util.Properties;

public class MessageProducer {

    private String defaultConfFile = "conf/kafka/kafka-producer.properties";

    private ProducerConfig producerConfig;

    private Producer<String, byte[]> producer;

    public MessageProducer(String confFile) {
        this.defaultConfFile = confFile;
    }

    public void init() {
        File file = new File(defaultConfFile);
        Properties properties = new Properties();

    }
}
