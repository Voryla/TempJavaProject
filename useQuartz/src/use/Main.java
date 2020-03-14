package use;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class Main {
    public static void main(String[] args) throws Exception {
        Main go = new Main();
        go.run();
    }

    /**
     * Scheduler：调度程序
     * Detail：细节
     * Trigger：触发
     * Identity：身份
     * Interval：中间
     * Repeat：间隔
     * @throws Exception
     */
    public void run() throws Exception {
        //创建调度工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //取得调度实例
        Scheduler sched = sf.getScheduler();
        //设置时间
        //下一分钟开始的时候
        //Date runTime = evenMinuteDate(new Date());
        //程序执行后的下一秒
        Date runTime = evenSecondDateAfterNow();
        //构建任务细节
        JobDetail job = newJob(MyJob.class).withIdentity("job1", "group1").build();
        //设置触发器,设置时间
        //Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
        //多次执行，多次是指本身一次+count的总次数
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(1).withRepeatCount(2)).build();
        //添加任务，触发器到调度程序工作
        sched.scheduleJob(job, trigger);
        //执行任务
        sched.start();
        try {
            Thread.sleep(15L * 1000L);
        } catch (InterruptedException e) {
        }
        sched.shutdown(true);
    }
}
