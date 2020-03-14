package com.zwk.producers_and_consumers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareResource {
	private ShareResource() {
	}

	private static ShareResource shareResource = new ShareResource();
	// Lock对象 代表了synchronized  同步作用
	private final Lock lock=new ReentrantLock();   //注意Condition要在Lock对象的 lock和unlock中间使用
	// 从lock对象获取的Condition对象代表了wait和notify 线程通信作用
	private Condition condition=lock.newCondition();
	public static ShareResource getInstance() {
		return shareResource;
	}

	private boolean isEmpty = true;
	private Car car = null;

	public Car getCar() {
		return car;
	}

	public  void push(Car car) {
		lock.lock();
		while (!isEmpty) {
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//
		}

		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {

		}
		this.car = car;
		isEmpty = false;

		condition.signalAll();
		lock.unlock();
	}

	public synchronized Car get() {
		lock.lock();
		while (isEmpty) {
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		try {
			Thread.sleep(1* 1000);
		} catch (InterruptedException e) {

		}
		Car cars = this.car;
		this.car = null;
		isEmpty = true;
		condition.signalAll();
		lock.unlock();
		return cars;
	}
}
