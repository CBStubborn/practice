package personal.practices.hbase.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * Created by CBStubborn on 2017/11/6.
 * <p>
 * HBase 基础工具，包含连接，重连，创建表，获取表，等功能
 * </p>
 */
public class BasicTool {

    private static final Logger LOG = LoggerFactory.getLogger(BasicTool.class);

    private static Connection connection;

    private static Configuration configuration;

    static {
        connect();
    }

    /**
     * Connect to HBase
     */
    public static void connect() {
        try {
            connection = ConnectionFactory.createConnection(getConfiguration());
        } catch (IOException e) {
            LOG.error("IOException while connecting to HBase", e);
            System.exit(1);
        }
        LOG.info("Successful to connect with HBase");
    }

    /**
     * Reconnect to HBase
     */
    public static void reconnect() {
        LOG.info("Reconnect to HBase");
        if (connection != null) {
            try {
                connection.close();
            } catch (IOException e) {
                LOG.error("IOException while closing HBase connection", e);
            }
        }
        connect();
    }

    /**
     * create a specific HTable
     *
     * @param tableName
     */
    public static Table createAndGetTable(String tableName) throws IOException {
        Admin admin = connection.getAdmin();
        if (!admin.tableExists(TableName.valueOf(tableName))) {
            HTableDescriptor descriptor = new HTableDescriptor(TableName.valueOf(tableName));
            admin.createTable(descriptor);
        } else {
            LOG.warn("Table: [{}] has already exits", tableName);
        }
        LOG.info("Successful to create a table: [{}]", tableName);
        return getTable(tableName);
    }

    /**
     * Get a specific HBase table
     *
     * @param tableName a specific HBase table name
     * @return a HBase table
     * @throws IOException
     */
    public static Table getTable(String tableName) throws IOException {
        if (connection == null || connection.isClosed()) {
            reconnect();
        }
        return connection.getTable(TableName.valueOf(tableName));
    }

    /**
     * Get configuration
     *
     * @return configuration
     */
    public static Configuration getConfiguration() {
        if (configuration == null) {
            configuration = HBaseConfiguration.create();
        }
        return configuration;
    }

}
