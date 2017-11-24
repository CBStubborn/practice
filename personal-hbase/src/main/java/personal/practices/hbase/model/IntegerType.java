package personal.practices.hbase.model;

/**
 * Created by CBStubborn on 2017/11/7.
 */
public class IntegerType extends StaticType<Integer> {

    public IntegerType() {
        setSize(4);
    }

    @Override
    protected void setSize(int size) {
        this.size = size;
    }

    @Override
    protected Integer readBytes(byte[] item, int offset) {
        return null;
    }

    @Override
    protected byte[] fillBytes(byte[] item, int offset, Integer value) {
        return null;
    }
}
