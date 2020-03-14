package com.zwk.mySqlAction;

import org.junit.Test;

public class Test1 {
	@Test
	public void main() {
		System.out.println(roop(1000));
	}

	public int roop(int a) {
		if (a == 1) {
			return a;
		} else return a + roop(a - 1);
	}
}
