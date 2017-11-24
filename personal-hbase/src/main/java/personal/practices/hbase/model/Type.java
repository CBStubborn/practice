package personal.practices.hbase.model;

/**
 * Created by CBStubborn on 2017/11/7.
 */
public interface Type<T> {

    public int getSize();

    public T readFromBytes(byte[] item, int offset);

    public byte[] fillInBytes(byte[] item, int offset, T value);
}
