package UseCallable.src;

import java.util.concurrent.Callable;

public class RacerA implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "运行完毕";
    }
}
