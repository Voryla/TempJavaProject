package com.zwk.learn.learn;

/**
 * 在接口中可以使用关键字 default修饰方法 改方法可在接口中存在方法体
 * 接口的实现类可以调用和重写该方法，类似于抽象类中可有实现方法
 *
 * 1.接口的方法默认是 public，所有方法在接口中不能有实现(Java 8 开始接口方法可以有默认实现），
 * 	 而抽象类可以有非抽象的方法。
 * 2.接口中的实例变量默认是 final 类型的，而抽象类中则不一定。
 * 3.一个类可以实现多个接口，但最多只能实现一个抽象类。
 * 4.一个类实现接口的话要实现接口的所有方法，而抽象类不一定。
 * 5.接口不能用 new 实例化，但可以声明，但是必须引用一个实现该接口的对象。
 * 从设计层面来说，抽象是对类的抽象，是一种模板设计，而接口是对行为的抽象，是一种行为的规范。
 * 备注：在JDK8中，接口也可以定义静态方法，可以直接用接口名调用。
 * 实现类和实现是不可以调用的。如果同时实现两个接口，接口中定义了一样的默认方法，则必须重写，不然会报错。
 */
public interface InterfaceDefault {
	void fun();
	default void defaultMethod() {
		System.out.println("method in interface!");
	}

	//加不加都行
	@SuppressWarnings("unchecked")
	static void getString(String str) {
		System.out.println(str);
	}
}
