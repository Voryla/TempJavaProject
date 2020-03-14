package ControlThread;

public class Going {
    public static void main(String[] args){
        Study study=new Study();
        new Thread(study).start();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"等待完毕-->即将结束线程");
        }catch (InterruptedException e){
        }
        study.shutDown();
    }
}
