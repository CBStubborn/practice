package personal.practices.job.zaxiang;

/**
 * 单例模式
 * Created by Stubborn on 2017/8/17.
 */
public class Singleton {

    /**
     * private 是关键，防止在外部实例化
     */
    private Singleton() {

    }

    /**
     * 通过内部类实现单例模式
     */
    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    /**
     * 返回实例
     *
     * @return
     */
    public static Singleton getInstance() {
        return SingletonFactory.instance;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!, This is a singleton class.");
    }
}
