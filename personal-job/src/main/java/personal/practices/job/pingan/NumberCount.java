package personal.practices.job.pingan;

/**
 * Created by Stubborn on 2017/10/11.
 */
public class NumberCount {

    /**
     * 说明：直接用排列组合思想求解，分两种情况
     * 一：其他三位数字中包含3，则总共有 9 * 8 * 3 种可能性
     * 二：其他三位数字中不包含3，则首先在剩余九个数字中选取一个数字作为重复数字，
     * 然后其余八个数字任选，每种情况有三种可能的排列，所以可能的情况为 9 * 8 * 3
     *
     * 所以总共的可能出现的有效数字个数为 9 * 8 * 3 * 2 = 432
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(432);
    }

}
