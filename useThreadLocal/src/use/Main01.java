package use;

public class Main01 {
    public static void main(String[] args) {
        //运行到此行时 在新建Thread并传入实现Runnable接口的类时候此时当前线程还为main
        //当.start()执行后当前线程为新建的线程
        new Thread(new MyRun()).start();
    }
}

class MyRun implements Runnable {
    public MyRun() {
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
