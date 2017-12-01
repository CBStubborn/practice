package personal.practices.kafka.listeninterface.producer;

public class ProducerProperty {

    private String brokerList;

    private String producerType;

    private String serializerClass;

    private boolean requiredAck;

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    public String getProducerType() {
        return producerType;
    }

    public void setProducerType(String producerType) {
        this.producerType = producerType;
    }

    public String getSerializerClass() {
        return serializerClass;
    }

    public void setSerializerClass(String serializerClass) {
        this.serializerClass = serializerClass;
    }

    public boolean isRequiredAck() {
        return requiredAck;
    }

    public void setRequiredAck(boolean requiredAck) {
        this.requiredAck = requiredAck;
    }

    @Override
    public String toString() {
        return "ProducerProperty{" +
                "brokerList='" + brokerList + '\'' +
                ", producerType='" + producerType + '\'' +
                ", serializerClass='" + serializerClass + '\'' +
                ", requiredAck=" + requiredAck +
                '}';
    }
}
