package use;

/**
 * @author zwk
 * ThreadLocal 子类 InheritableThreadLocal
 * 子线程继承开辟该子线程的线程的数据
 */
public class Main02 {
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("mainData");
        System.out.println(threadLocal.get());
        //该子线程继承其上一层线程(mian)的数据
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(threadLocal.get());
            threadLocal.set("Thread-0 Data");
            //该子线程继承其上一层线程(Thread-0)的数据
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println(threadLocal.get());
            }).start();
        }).start();
    }
}

