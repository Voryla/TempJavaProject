package com.zwk.producers_and_consumers;

public class Consumer implements Runnable {
	private ShareResource shareResource = ShareResource.getInstance();

	public void run() {
		for (int i = 0; i < 10; i++) {

			Car car = shareResource.get();
			if (car != null) {
				System.out.print(Thread.currentThread().getName() + "买到了车");
				car.showInformation();
				continue;
			} else {
				System.out.println(Thread.currentThread().getName() + "库存没车了");
			}
			try {
				Thread.sleep(2 * 10);
			} catch (InterruptedException e) {

			}

		}
	}
}
