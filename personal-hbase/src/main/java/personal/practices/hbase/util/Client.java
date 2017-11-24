package personal.practices.hbase.util;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by CBStubborn on 2017/11/7.
 */
public class Client {

    public static final Logger LOG = LoggerFactory.getLogger(Client.class);

    public Table table;

    private Client() {
        try {
            table = BasicTool.createAndGetTable(TableInfos.TABLE_NAME);
        } catch (IOException e) {
            LOG.error("IOException while create table", e);
            System.exit(1);
        }
    }

    public static Client getInstance() {
        return ClientFactory.instance;
    }

    private static class ClientFactory {

        private static Client instance = new Client();

    }

    public static void main(String[] args) {
        Client client = getInstance();
        if (client.table != null) {
            try {
                HTableDescriptor descriptor = client.table.getTableDescriptor();
                System.out.println("table description: " + descriptor.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
