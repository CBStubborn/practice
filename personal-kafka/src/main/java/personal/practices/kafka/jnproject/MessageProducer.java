package personal.practices.kafka.jnproject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MessageProducer {

    private static final Logger LOG = LoggerFactory.getLogger(MessageProducer.class);

    private String defaultConfFile = "conf/kafka/kafka-producer.properties";

    private ProducerConfig producerConfig;

    private Producer<String, byte[]> producer;

    public MessageProducer(String confFile) {
        this.defaultConfFile = confFile;
    }

    public void init() {
        FileReader file = null;
        try {
            file = new FileReader(defaultConfFile);
            Properties properties = new Properties();
            properties.load(file);
            producerConfig = new ProducerConfig(properties);
        } catch (FileNotFoundException e) {
            LOG.error("Cannot found the file: [{}], please check it!", defaultConfFile);
            System.exit(1);
        } catch (IOException e) {
            LOG.error("IOException while read the file: [{}]", defaultConfFile);
        }


    }
}
