package UseThread;

public class Going {
    public static void main(String[] args) {
        Racer racer=new Racer();
        new Thread(racer,"乌龟").start();
        new Thread(racer,"兔子").start();
    }
}
