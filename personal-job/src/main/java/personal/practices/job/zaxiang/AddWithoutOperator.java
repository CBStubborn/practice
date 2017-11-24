package personal.practices.job.zaxiang;

/**
 * Created by Stubborn on 2017/9/12.
 */
public class AddWithoutOperator {

    /**
     * 两个数相加，不能用加号
     * @param a
     * @param b
     * @return
     */
    private static int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

    /**
     * 1加至n，只能用加减，不能用if，while，for等控制语句
     *
     * @param n
     * @return
     */
    public static int add(int n) {
        int t = 0;
        boolean b = (n > 0) && ((t = add(n - 1)) > 0);
        return n + t;
    }

    public static void main(String[] args) {
        System.out.println(add(20, 30));
        System.out.println(add(6));
    }

}
