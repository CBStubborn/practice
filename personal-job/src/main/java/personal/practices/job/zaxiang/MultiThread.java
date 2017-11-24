package personal.practices.job.zaxiang;


/**
 * Created by Stubborn on 2017/9/10.
 */
public class MultiThread extends Thread {
    public MultiThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动子进程
        new MultiThread("new thread").start();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                MultiThread mt = new MultiThread("joined thread");
                mt.sleep(1000);
                mt.start();
                mt.join();
            }
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}
