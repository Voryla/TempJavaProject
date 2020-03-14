package com.zwk.producers_and_consumers;

public class Producer implements Runnable{
	private ShareResource shareResource=ShareResource.getInstance();
	public void run(){
			for (int i = 0; i < 10; i++) {
				System.out.println("生产车辆中。。。");
				if(i%2==0){
					shareResource.push(new Car("奔驰","123"));
				}else {
					shareResource.push(new Car("法拉利","666"));
				}
				System.out.println("生产了第"+(i+1)+"辆车");
			}

	}
}
