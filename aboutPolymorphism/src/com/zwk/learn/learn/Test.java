package com.zwk.learn.learn;

// 多态：子类对象指向父类引用
// 调用顺序this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)
// 调用顺序为：  1.当调用的方法为子类重写父类的方法那么就调用子类的方法
//			    2.当调用的方法为子类没有的重写父类的方法那么调用父类的该方法
//			    3.当调用的方法其中的参数在子类和父类中均没有实现，
//			    那么先查看子类中是否重写了父类中具有该参数对象的父类参数的方法，
//				如果重写了那么调用子类该方法，没有重写即调用父类该方法

class A {
	public String show(D obj) {
		return ("A and D");
	}

	public String show(A obj) {
		return ("A and A");
	}

}

class B extends A {
	public String show(B obj) {
		return ("B and B");
	}

	public String show(A obj) {
		return ("B and A");
	}
}

class C extends B {

}

class D extends B {

}

public class Test {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();

		System.out.println("1--" + a1.show(b));
		System.out.println("2--" + a1.show(c));
		System.out.println("3--" + a1.show(d));
		System.out.println("4--" + a2.show(b));
		System.out.println("5--" + a2.show(c));
		System.out.println("6--" + a2.show(d));
		System.out.println("7--" + b.show(b));
		System.out.println("8--" + b.show(c));
		System.out.println("9--" + b.show(d));
	}
}