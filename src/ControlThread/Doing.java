package ControlThread;

/**
 * 礼让
 */
public class Doing {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->" + i);
                }
            }
        }.start();
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            if (i % 20 == 0) {
                Thread.yield();
            }
        }
    }
}
