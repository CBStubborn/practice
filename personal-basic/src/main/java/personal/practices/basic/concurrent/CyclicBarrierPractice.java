package personal.practices.basic.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by CBStubborn on 2017/11/23.
 */
public class CyclicBarrierPractice {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程: " + Thread.currentThread().getName());
            }
        });
        for (int i = 0; i < 5; i++) {
            new UserThread(barrier).start();
        }
    }

    static class UserThread extends Thread {
        CyclicBarrier barrier;

        public UserThread(CyclicBarrier barrier) {
            super();
            this.barrier = barrier;
        }

        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000);
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
