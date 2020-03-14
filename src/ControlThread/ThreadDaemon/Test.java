package ControlThread.ThreadDaemon;

/**
 * jvm的停止，不会等待守护线程的完成
 * jvm的停止，会等待用户线程的完成
 */
public class Test {
    public static void main(String[] args) {
        /*没有main, god 和 me 均为用户线程，所以jvm会一直等待用户线程的完成再结束
        Thread god = new Thread(new God());
        god.start();
        new Thread(new Me()).start();
        */

        //将god设置为守护线程后，jvm会随着用户线程me和main的结束而停止
        Thread god = new Thread(new God(),"God");
        //设置为守护线程
        god.setDaemon(true);
        god.start();
        System.out.println(god.getName()+god.isAlive());
        new Thread(new Me(),"Me").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(god.getName()+god.isAlive());
    }
}

class Me implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 36; i++) {
            System.out.println("我生命中的第" + i + "天");
        }
    }
}

class God implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 36 * 2; i++) {
            System.out.println("God bless Me" + i + "天");
        }

    }
}
