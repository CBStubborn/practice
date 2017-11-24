package personal.practices.job.wmsj;

/**
 * Created by Stubborn on 2017/9/26.
 */
public class RescueYDN {

    public static void main(String[] args) {
        int[][] array = {{2, -1, 1}, {4, -8, 2}, {-3, -2, -5}};
        int result = minBlood(array);
        if (result > 0) {
            System.out.println(0);
        } else {
            System.out.println(1 - result);
        }
    }

    private static int minBlood(int[][] array) {
        int initBlood = array[0][0];
        int min = initBlood;
        int i = 0;
        int j = 0;
        while (i < array.length && j < array[0].length) {
            if (i + 1 == array.length && j + 1 == array[0].length) {
                break;
            } else if (i + 1 == array.length) {
                initBlood += array[i][j + 1];
                if (initBlood < min) {
                    min = initBlood;
                }
                ++j;
            } else if (j + 1 == array[0].length) {
                initBlood += array[i + 1][j];
                if (initBlood < min) {
                    min = initBlood;
                }
                ++i;
            } else {
                int turnRight = 0;
                int turnDown = 0;
                turnRight = initBlood + array[i + 1][j];
                turnDown = initBlood + array[i][j + 1];
                if (turnDown > turnRight) {
                    if (turnDown < min) {
                        min = turnDown;
                    }
                    initBlood = turnDown;
                    ++j;
                } else {
                    if (turnRight < min) {
                        min = turnRight;
                    }
                    initBlood = turnRight;
                    ++i;
                }
            }
        }
        return min;
    }
}
