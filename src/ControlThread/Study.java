package ControlThread;

public class Study implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            i++;
            System.out.println("I'm studying" + i);
        }
    }

    public void shutDown() {
        this.flag = false;
        System.out.println("线程结束");
    }
}
