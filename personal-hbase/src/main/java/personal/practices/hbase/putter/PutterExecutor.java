package personal.practices.hbase.putter;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.practices.hbase.beans.Record;
import personal.practices.hbase.util.Client;
import personal.practices.hbase.model.RecordModel;
import personal.practices.hbase.util.RowKeyMaker;
import personal.practices.hbase.util.TableInfos;

import java.io.IOException;

/**
 * Created by CBStubborn on 2017/11/7.
 */
public class PutterExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(PutterExecutor.class);

    public Table table;

    public PutterExecutor() {
        this.table = Client.getInstance().table;
    }

    public void put(Record record) throws IOException {
        LOG.info("Putting record: [{}] to HBase", record);
        RecordModel.fillModel(record);
        byte[] value = RecordModel.toBytes();
        long timestamp = System.currentTimeMillis();
        byte[] rowKey = RowKeyMaker.generateRowKey(record);
        final Put put = new Put(rowKey, timestamp);
        put.addColumn(Bytes.toBytes(TableInfos.COLUMN_FAMILY), Bytes.toBytes(TableInfos.COLUMN_QUALIFIER), value);
        table.put(put);
    }

    public Record getRecord() {
        //TODO get a record

        return null;
    }


}
