package ControlThread.ThreadJoin;

/**
 * Bar 酒吧
 * Customer 顾客
 * Waiter 服务员
 */
public class Bar {
    public static void main(String[] args) {
        new Thread(new Customer()).start();
    }
}

class Customer extends Thread {
    @Override
    public void run() {
        System.out.println("Customer:I need wine please.");
        Waiter waiter = new Waiter();
        waiter.start();
        try {
            waiter.join();
        } catch (InterruptedException e) {
        }
        System.out.println("Customer:Thanks,this is 25000$ and 5000$ is your tip.");
    }
}

class Waiter extends Thread {
    @Override
    public void run() {
        System.out.println("Waiter:Ok sir just moment.");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Waiter:Soory sir you need pay 20000$ first");
        Thread.yield();
        System.out.println("Watiter:Thank you very much");
    }
}