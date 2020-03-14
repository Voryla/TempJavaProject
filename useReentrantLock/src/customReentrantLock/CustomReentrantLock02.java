package customReentrantLock;

/**
 * 用lock来保证原子性（this.count++这段代码称为临界区）
 * 什么是原子性，就是不可分，从头执行到尾，不能被其他线程同时执行。
 */
public class CustomReentrantLock02 {
    public static void main(String[] args) {
         Count02 count02 = new Count02();
        /*
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {

                try {
                    count02.print();
                } catch (InterruptedException e) {
                }
            }).start();
        }
       */
        new Thread(() -> {

            try {
                count02.print();
            } catch (InterruptedException e) {
            }
        }).start();
    }
}

class Count02 {
    Lock02 lock02 = new Lock02();

    public void print() throws InterruptedException {
        lock02.lock();
        doSomeThing();
        lock02.unLock();
    }

    public void doSomeThing() throws InterruptedException {
        lock02.lock();
        System.out.println(Thread.currentThread().getName() + "doSomeThing");
        lock02.unLock();
    }
}

class Lock02 {
    private int lockCount = 0;
    private boolean locked = false;
    private Thread threadBy = null;

    public synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (locked && thread != threadBy) {
            wait();
            System.out.println(Thread.currentThread().getName() + "wait");
        }
        lockCount++;
        locked = true;
        threadBy = thread;
    }

    public synchronized void unLock() {
        if (Thread.currentThread() == this.threadBy) {
            lockCount--;
            if (lockCount == 0) {
                notify();
                System.out.println(Thread.currentThread().getName() + "unlock");
            }
        }
    }
}