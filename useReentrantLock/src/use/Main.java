package use;
/**
 * JDK 可重入锁  ReentrantLock
 */

import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) {
		CountUse countUse = new CountUse();
		new Thread(() -> {
			try {
				countUse.print();
			} catch (InterruptedException e) {
			}
		}).start();
	}
}

class CountUse {
	ReentrantLock lock = new ReentrantLock();

	public void print() throws InterruptedException {
		lock.lock();
		doSomeThing();
		lock.unlock();
	}

	public void doSomeThing() throws InterruptedException {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "doSomeThing");
		lock.unlock();
	}
}
