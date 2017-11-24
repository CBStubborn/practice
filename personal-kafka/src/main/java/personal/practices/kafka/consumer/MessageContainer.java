package personal.practices.kafka.consumer;

import org.springframework.kafka.listener.MessageListener;

/**
 * Created by CBStubborn on 2017/11/21.
 */
public class MessageContainer {

    private String topic;

    private MessageListener messageHandle;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public MessageListener getMessageHandle() {
        return messageHandle;
    }

    public void setMessageHandle(MessageListener messageHandle) {
        this.messageHandle = messageHandle;
    }
}
