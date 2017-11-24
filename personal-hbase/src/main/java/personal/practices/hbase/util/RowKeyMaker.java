package personal.practices.hbase.util;

import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.practices.hbase.beans.Record;

/**
 * Created by CBStubborn on 2017/11/7.
 */
public class RowKeyMaker {

    private static final Logger LOG = LoggerFactory.getLogger(RowKeyMaker.class);

    public RowKeyMaker() {

    }

    public static byte[] generateRowKey(Record record) {
        LOG.info("generate row key for record: [{}]", record);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(record.getId() + "-" + record.getTimestamp() + "-" + record.getTitle() + "-" + record.getAuthor());
        return Bytes.toBytes(stringBuilder.toString());
    }

    public static void main(String[] args) {

    }
}
