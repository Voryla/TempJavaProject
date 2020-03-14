import java.util.TimerTask;

/**
 * 使用定时器需要继承TimerTask抽象类并重写run方法
 */
public class MyTask extends TimerTask {
    int count=0;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"调度"+count++);
    }
}
