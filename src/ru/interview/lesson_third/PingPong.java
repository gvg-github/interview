package homework.lesson_third;

import static java.lang.Thread.sleep;

/**
 * @author Valeriy Gyrievskikh
 * @since 17.10.2018
 */
public class PingPong {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        PingPong printer = new PingPong();
        Thread threadPing = new Thread(() -> {
            int count = 0;
            while (count < 20) {
                printer.printString("Ping");
                count++;
            }
            printer.closeThreads();
        });
        Thread threadPong = new Thread(() -> {
            int count = 0;
            while (count < 20) {
                printer.printString("Pong");
                count++;
            }
            printer.closeThreads();
        });
        threadPing.start();
        threadPong.start();
    }

    private synchronized void closeThreads() {
        notifyAll();
    }

    public synchronized void printString(String string) {
        System.out.println("Thread " + Thread.currentThread().getName() + " print: " + string);
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
