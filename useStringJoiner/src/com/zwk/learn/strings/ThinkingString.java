package com.zwk.learn.strings;

import org.junit.Test;

/**
 * 线程安全性
 * String 中的对象是不可变的，也就可以理解为常量，线程安全。
 * AbstractStringBuilder 是 StringBuilder 与 StringBuffer 的公共父类，
 * 定义了一些字符串的基本操作，如 expandCapacity、append、insert、indexOf 等公共方法。
 * StringBuffer 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。
 * StringBuilder 并没有对方法进行加同步锁，所以是非线程安全的。 　　
 *
 * 性能
 * 每次对 String 类型进行改变的时候，都会生成一个新的 String 对象，
 * 然后将指针指向新的 String 对象。StringBuffer 每次都会对 StringBuffer 对象本身进行操作，
 * 而不是生成新的对象并改变对象引用。
 * 相同情况下使用 StringBuilder 相比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升，
 * 但却要冒多线程不安全的风险。
 *
 * 对于三者使用的总结：
 *
 * 操作少量的数据: 适用String
 * 单线程操作字符串缓冲区下操作大量数据: 适用StringBuilder
 * 多线程操作字符串缓冲区下操作大量数据: 适用StringBuffer
 */
public class ThinkingString {
	@Test
	public void testMethod(){
		System.out.println("操作少量字符数据使用String");
		String str="字符串";
		str+="字符串的每次+操作都会创建一个新的字符串，然后将新字符串对象指向引用";
		System.out.println("多线程操作字符串缓冲区下操作大量数据：适用于StringBuffer");
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("StringBuffer线程安全速度比StringBuilder慢");
		System.out.println("单线程操作字符串缓冲区下操作大量数据：适用于StringBuilder");
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("StringBuilder线程不安全但速度比StringBuffer快");
	}
}
