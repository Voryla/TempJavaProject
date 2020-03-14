package com.zwk.learn.learn.example;

public class WE {
	private MyInterface myInterface;
	public void addInterfaceImpl(MyInterface myInterface){
		this.myInterface=myInterface;
	}
	public void doWork(int a,int b){
		this.myInterface.two(a,b);
	}
}
