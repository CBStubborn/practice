package personal.practices.basic.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by CBStubborn on 2017/11/23.
 */
public class SemaphorePractice {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 8; i++) {
            new UserThread(semaphore, 1).start();
        }
    }

    static class UserThread extends Thread {
        Semaphore semaphore;
        int permits;

        public UserThread(Semaphore semaphore, int permits) {
            super();
            this.semaphore = semaphore;
            this.permits = permits;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(permits);
                System.out.println(Thread.currentThread().getName() + " got permits");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " release permits");
                semaphore.release(permits);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
