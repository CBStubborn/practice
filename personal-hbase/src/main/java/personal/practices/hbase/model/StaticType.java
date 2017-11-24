package personal.practices.hbase.model;

/**
 * Created by CBStubborn on 2017/11/7.
 */
public abstract class StaticType<T> implements Type<T> {

    public int size;

    @Override
    public T readFromBytes(byte[] item, int offset) {
        if (item == null || item.length <= offset + this.getSize() - 1) {
            return null;
        }
        return readBytes(item, offset);
    }

    @Override
    public byte[] fillInBytes(byte[] item, int offset, T value) {
        if (item == null || item.length <= offset + this.getSize() - 1) {
            return null;
        }
        return fillBytes(item, offset, value);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    protected abstract void setSize(int size);

    protected abstract T readBytes(byte[] item, int offset);

    protected abstract byte[] fillBytes(byte[] item, int offset, T value);

}
