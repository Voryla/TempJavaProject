package bUseJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 在每一个注册@Test的方法执行前后都会有标识@Before和@After执行
 *
 * */
public class UseJunit2 {
    @Before
    public void before(){
        System.out.println("before");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @After
    public void after(){
        System.out.println("After");
    }
}
