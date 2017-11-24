package personal.practices.hbase.model;

/**
 * Created by CBStubborn on 2017/11/7.
 */
public class LongType extends StaticType<Long> {

    public LongType() {
        setSize(8);
    }

    @Override
    protected void setSize(int size) {
        this.size = size;
    }

    @Override
    protected Long readBytes(byte[] item, int offset) {
        return null;
    }

    @Override
    protected byte[] fillBytes(byte[] item, int offset, Long value) {
        return null;
    }
}
