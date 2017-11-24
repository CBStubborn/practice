package personal.practices.job.zaxiang;

/**
 * Created by CBStubborn on 2017/11/9.
 * 注意观察输出，具体解释请参考：
 * http://blog.csdn.net/u013256816/article/details/50837863
 * http://www.importnew.com/18548.html
 */
public class StaticStudy {

    public static void main(String[] args) {
        staticFunction();
    }

    static StaticStudy ss = new StaticStudy();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticStudy() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b + ", c=" + c);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 111;
    static final int c = 112;
}
