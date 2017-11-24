package personal.practices.job.neteasy;

/**
 * Created by Stubborn on 2017/9/19.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2017网易编程题：射击游戏
 * 小易正在玩一款新出的射击游戏,这个射击游戏在一个二维平面进行,小易在坐标原点(0,0),平面上有n只怪物,每个怪物有所在的坐标(x[i],
 * y[i])。小易进行一次射击会把x轴和y轴上(包含坐标原点)的怪物一次性消灭。
 * 小易是这个游戏的VIP玩家,他拥有两项特权操作:
 * 1、让平面内的所有怪物同时向任意同一方向移动任意同一距离
 * 2、让平面内的所有怪物同时对于小易(0,0)旋转任意同一角度
 * 小易要进行一次射击。小易在进行射击前,可以使用这两项特权操作任意次。
 * 小易想知道在他射击的时候最多可以同时消灭多少只怪物,请你帮帮小易。
 *
 * @author pqf 2017年9月9日
 */
public class SheJiYouXi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x[] = new int[n];
        int y[] = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            y[i] = scan.nextInt();
        scan.close();
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        int maxShoot = 0;//在坐标轴上的点
        if (n < 4)
            maxShoot = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int X1 = x[j] - x[i];
                int Y1 = y[j] - y[i];
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j)
                        continue;
                    int count = 3;
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k)
                            continue;
                        int X2 = x[l] - x[k];
                        int Y2 = y[l] - y[k];
                        int X3 = x[l] - x[i];
                        int Y3 = y[l] - y[i];
                        if (X1 * X2 + Y1 * Y2 == 0 || X1 * Y3 == X3 * Y1 || X1 * Y3 == -X3 * Y1)
                            count++;
                    }
                    if (count > maxShoot)
                        maxShoot = count;
                }
            }
        }
        System.out.println(maxShoot);
    }
}

