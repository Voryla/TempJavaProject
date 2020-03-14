package com.zwk.learn.learn;

import org.junit.Test;

public class InterfaceDefaultImpl implements InterfaceDefault {
	@Override
	public void fun() {
		System.out.println("实现接口中fun方法！");
	}

	@Test
	public void testMethod() {
		InterfaceDefault interfaceDefault = new InterfaceDefaultImpl();
		interfaceDefault.fun();
		interfaceDefault.defaultMethod();
		InterfaceDefault.getString("sd");
	}
}
