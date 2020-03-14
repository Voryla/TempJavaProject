package com.zwk.learn.javaOnlyValuePassing;

import org.junit.Test;

/**
 * 方法并没有改变存储在变量 s1 和 s2 中的对象引用。
 * swap方法的参数x和y被初始化为两个对象引用的拷贝，这个方法交换的是这两个拷贝
 *
 * 总结
 * Java程序设计语言对对象采用的不是引用调用，实际上，对象引用是按 值传递的。
 *
 * 下面再总结一下Java中方法参数的使用情况：
 *
 * 一个方法不能修改一个基本数据类型的参数（即数值型或布尔型）。
 * 一个方法可以改变一个对象参数的状态。
 * 一个方法不能让对象参数引用一个新的对象。
 */
public class JavaOnlyValuePassing {
	@Test
	public void javaOnlyValuePassingTest() {
		Student s1 = new Student("小赵");
		Student s2 = new Student("小马");
		swap(s1, s2);
		System.out.println("s1"+s1.getStudentName());
		System.out.println("s2"+s2.getStudentName());
	}

	public static void swap(Student x, Student y) {
		Student temp=x;
		x=y;
		y=temp;
		System.out.println("s1"+x.getStudentName());
		System.out.println("s2"+y.getStudentName());
	}
}

class Student {
	private Student() {
	}

	private String studentName;

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentName() {
		return studentName;
	}
}