package com.zwk.learn.learn.example;

import org.junit.jupiter.api.Test;

public class Tests {
	@Test
	public void test(){
		WE we=new WE();
		we.addInterfaceImpl((a, b) ->{
			a=3;
			b=5;
			System.out.println(a+b);
		});
		we.doWork(3,5);
	}
}
