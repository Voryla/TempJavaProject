package com.zwk.producers_and_consumers;

public class Main {
	public static void main(String[] args) {
		new Thread(new Producer()).start();
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
		new Thread(new Consumer()).start();
		try {
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
