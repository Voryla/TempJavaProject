package use;

/**
 * @author zwk
 * ThreadLocal 创建一块内存空间,没当有线程使用ThreadLocal时在此内存空间内单独划出一块单独的数据副本给该线程。
 * 多个线程之间数据不会互相影响
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    MyThreadLocal.set("--->>"+Thread.currentThread().getName()+"  "+j);
                    System.out.println(MyThreadLocal.get().toString());
                }
            }).start();
        }
    }
}

class MyThreadLocal {
    //创建方式一 lambda表达式设置初始值
    private static ThreadLocal<StringBuilder> threadLocal = ThreadLocal.withInitial(() -> new StringBuilder("init"));
    // 创建方式二
    private static ThreadLocal<StringBuilder> threadLocal1 = new ThreadLocal<>() {
        @Override
        protected StringBuilder initialValue() {
            return new StringBuilder(333);
        }
    };

    public static StringBuilder get() {
        return threadLocal.get();
    }

    public static <T> void set(T value) {
        threadLocal.set(threadLocal.get().append(value));
    }
}
