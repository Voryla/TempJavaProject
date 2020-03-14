package UseThread;

public class Racer implements Runnable{
    private static String winner;
    private static int steps=1;
    @Override
    public void run() {
        for (int i=steps;i<=100;steps++){
            boolean flag=gameOver();
            if (flag){
                System.out.println(winner);
                break;
            }
            System.out.println(Thread.currentThread().getName()+steps);
        }
    }
    private boolean gameOver(){
       if(winner!=null){
           return true;
       }else {
           if (steps==100){
               winner=Thread.currentThread().getName();
           }
       }
       return false;
    }
}
