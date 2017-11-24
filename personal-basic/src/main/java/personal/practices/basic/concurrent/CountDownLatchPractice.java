package personal.practices.basic.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by CBStubborn on 2017/11/23.
 */
public class CountDownLatchPractice {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new UserThread(count).start();
        }
        System.out.println("waiting all threads done");
        count.await();
        System.out.println("done!!!");
    }

    static class UserThread extends Thread {

        CountDownLatch count;

        public UserThread(CountDownLatch count) {
            super();
            this.count = count;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is done");
            count.countDown();
        }
    }
}
