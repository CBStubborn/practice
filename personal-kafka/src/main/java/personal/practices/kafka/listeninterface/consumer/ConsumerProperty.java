package personal.practices.kafka.listeninterface.consumer;

import java.util.List;

/**
 * Created by CBStubborn on 2017/11/21.
 */
public class ConsumerProperty {

    private String brokerList;

    private String groupId;

    private  String enableAutoCommit="true";

    private String autoCommitInterval="1000";

    private String sessionTimeout="30000";

    private String keySerializer="org.apache.kafka.common.serialization.StringDeserializer";

    private String valueSerializer="org.apache.kafka.common.serialization.StringDeserializer";
    /**
     * topic以及消费的实现类
     */
    private List<MessageContainer> messageContainers;

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getEnableAutoCommit() {
        return enableAutoCommit;
    }

    public void setEnableAutoCommit(String enableAutoCommit) {
        this.enableAutoCommit = enableAutoCommit;
    }

    public String getAutoCommitInterval() {
        return autoCommitInterval;
    }

    public void setAutoCommitInterval(String autoCommitInterval) {
        this.autoCommitInterval = autoCommitInterval;
    }

    public String getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(String sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
    }

    public List<MessageContainer> getMessageContainers() {
        return messageContainers;
    }

    public void setMessageContainers(List<MessageContainer> messageContainers) {
        this.messageContainers = messageContainers;
    }

    @Override
    public String toString() {
        return "ConsumerProperty{" +
                "brokerList='" + brokerList + '\'' +
                ", groupId='" + groupId + '\'' +
                ", enableAutoCommit='" + enableAutoCommit + '\'' +
                ", autoCommitInterval='" + autoCommitInterval + '\'' +
                ", sessionTimeout='" + sessionTimeout + '\'' +
                ", keySerializer='" + keySerializer + '\'' +
                ", valueSerializer='" + valueSerializer + '\'' +
                ", messageContainers=" + messageContainers +
                '}';
    }
}
