package UseCallable.src;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Doing {
    public static void main(String[] args)throws Exception{
        //方法一
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        Future<String> result=executorService.submit(new RacerA());
        String resultString=result.get();
        executorService.shutdownNow();
        System.out.println(resultString);
        //方法二
        FutureTask<String> futureTask=new FutureTask<>(new RacerA());
        new Thread(futureTask).start();
    }
}
