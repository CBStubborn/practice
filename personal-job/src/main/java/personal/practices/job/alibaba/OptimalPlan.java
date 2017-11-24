package personal.practices.job.alibaba;


import java.util.*;

/**
 * Created by Stubborn on 2017/8/25.
 */

public class OptimalPlan {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static String bike_plan(double distance, double speed) {
        double[] prices = new double[3];
        prices[0] = (double) ofoPrice(distance);
        prices[1] = yaxPrice(distance / speed);
        prices[2] = hbPrice(distance);
        double min = Double.MAX_VALUE;
        List list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (prices[i] < min) {
                min = prices[i];
                list.clear();
                list.add(i);
            } else if (prices[i] == min) {
                list.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (list.contains(0)) {
            sb.append("OFO小黄车" + prices[0] + "（元）");
        }
        if (list.contains(1)) {
            if (sb.length() > 0) {
                sb.append("和");
            }
            sb.append("永安行" + prices[1] + "（元）");
        }
        if (list.contains(2)) {
            if (sb.length() > 0) {
                sb.append("和");
            }
            sb.append("hellobike" + prices[2] + "（元）");
        }
        return sb.toString();
    }

    private static int ofoPrice(double distance) {
        if (distance % 1.5 > 0) {
            return (int) (distance / 1.5) + 1;
        } else {
            return (int) (distance / 1.5);
        }
    }

    private static double yaxPrice(double time) {
        if (time % 1 > 0) {
            return 0.2 * time + 0.2;
        } else {
            return 0.2 * time;
        }
    }

    private static double hbPrice(double distance) {
        if (distance <= 2.0) {
            return 1.0;
        } else if (distance > 2.0 && distance <= 4.0) {
            return 3.0;
        } else if (distance > 4.0 && distance <= 8.0) {
            return 5.0;
        } else {
            return 8.0;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String res;

        double _distance;
        _distance = Double.parseDouble(in.nextLine().trim());

        double _speed;
        _speed = Double.parseDouble(in.nextLine().trim());

        res = bike_plan(_distance, _speed);
        System.out.println("骑行距离" + _distance + "(千米)，匀速骑行速度" + _speed + "(千米/分钟)最省钱方案:");
        System.out.print(res);
    }
}
