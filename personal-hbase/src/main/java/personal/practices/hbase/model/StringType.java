package personal.practices.hbase.model;

/**
 * Created by CBStubborn on 2017/11/7.
 */
public class StringType extends StaticType<String> {

    public StringType() {
        setSize(4);
    }

    @Override
    protected void setSize(int size) {
        this.size = size;
    }

    @Override
    protected String readBytes(byte[] item, int offset) {
        return null;
    }

    @Override
    protected byte[] fillBytes(byte[] item, int offset, String value) {
        return null;
    }
}
