package personal.practices.job.zywl;


/**
 * Created by Stubborn on 2017/9/26.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(calculate(3));
    }

    public static int calculate(int year) {
        if (year == 1) {
            return 10;
        }
        return 3 * calculate(year - 1) - 2 * (year - 1);
    }
}
