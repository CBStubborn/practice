package personal.practices.basic.concurrent;


import java.util.concurrent.Exchanger;

/**
 * Created by CBStubborn on 2017/11/23.
 */
public class ExchangerPractice {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        new ClientThread(exchanger).start();
        new ServerThread(exchanger).start();
    }

    static class ClientThread extends Thread {

        Exchanger exchanger;

        public ClientThread(Exchanger exchanger) {
            super();
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                System.out.println("Client received message: " + exchanger.exchange("Hello, I'm Client"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ServerThread extends Thread {

        Exchanger exchanger;

        public ServerThread(Exchanger exchanger) {
            super();
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                System.out.println("Server received message: " + exchanger.exchange("Hello, I'm server"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
