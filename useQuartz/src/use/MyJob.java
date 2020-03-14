package use;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            System.out.println("执行-->>" + i);
        }
    }
}
