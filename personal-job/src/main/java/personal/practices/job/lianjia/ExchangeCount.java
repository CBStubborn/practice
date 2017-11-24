package personal.practices.job.lianjia;

/**
 * Created by Stubborn on 2017/8/19.
 */
public class ExchangeCount {

    private static int exchange(int[] originArray) {
        int count = 0;
        for (int i = 0; i < originArray.length; i++) {
            int flag = 0;
            int min = originArray[i];
            for (int j = i + 1; j < originArray.length; j++) {
                if (originArray[j] < min) {
                    min = originArray[j];
                    flag = j;
                }
            }
            if (min != originArray[i]) {
                count++;
                int tmp = originArray[i];
                originArray[i] = min;
                originArray[flag] = tmp;
            }
        }
        return count;
    }

    private static void print(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        System.out.println(sb.toString() + " ");
    }

    public static void main(String[] args) {
        int[] origin = new int[]{2, 2, 1, 3, 3, 3, 2, 3, 1};
        System.out.println(exchange(origin));
    }

}
