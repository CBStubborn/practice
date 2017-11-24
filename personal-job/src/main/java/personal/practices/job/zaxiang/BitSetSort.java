package personal.practices.job.zaxiang;

import java.util.BitSet;

/**
 * Created by CBStubborn on 2017/11/14.
 */
public class BitSetSort {

    public static void main(String[] args) {
        int range = 10000;
        BitSet bitSet = new BitSet(range);
        for (int i = 0; i < 1000; i++) {
            bitSet.set((int) (Math.random() * range));

        }
        for (int index = 0; index < range; index++) {
            if (bitSet.get(index)) {
                System.out.print(index + ", ");
            }
        }
    }
}
