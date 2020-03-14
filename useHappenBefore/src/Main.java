/**
 * @author zwk
 * Volatile 关键字作用 1.防止编译器改变代码执行顺序2.保证原子性 3.实现可见性
 */
public class Main {
    public static void main(String[] args) {
        Main.UseVolatile useVolatile = new Main().new UseVolatile();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                useVolatile.add();
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        useVolatile.println();
    }

    class UseVolatile {
        volatile int a = 0;

        public void add() {
            a++;
        }

        public void println() {
            System.out.println("a = " + a);
        }
    }
}