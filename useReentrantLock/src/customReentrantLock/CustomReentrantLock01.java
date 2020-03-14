package customReentrantLock;

/**
 * 不可重入锁必须lock和unlock结对使用
 */
public class CustomReentrantLock01 {
    public static void main(String[] args) {
        Count01 count01 = new Count01();
            new Thread(() -> {
                try {
                    count01.print();
                    count01.doSomeThing();
                } catch (InterruptedException e) {
                }
            }).start();
    }
}

class Count01 {
    Lock01 lock01 = new Lock01();

    public void print() throws InterruptedException {
        //设置为锁定
        lock01.lock();
        doSomeThing();
        lock01.unLock();
    }

    public void doSomeThing() throws InterruptedException {
        //第二次进入锁，导致自身自旋
        lock01.lock();
        System.out.println(Thread.currentThread().getName() + "doSomeThing");
        lock01.unLock();
    }
}

class Lock01 {
    private boolean locked = false;

    public synchronized void lock() throws InterruptedException {
        while (locked) {
            wait();
            System.out.println(Thread.currentThread().getName() + "lock");
        }
        System.out.println(Thread.currentThread().getName());
        locked = true;
    }

    public synchronized void unLock() {
        locked = false;
        notify();
    }
}
