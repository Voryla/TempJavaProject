import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Main {
    public static void main(String[] args){
        Timer timer=new Timer();
        //延时后每隔多少秒执行任务  会一直重复执行
        timer.schedule(new MyTask(),20000,1000);
        //定时执行
        Date date=new Date();
        date.setTime(new Date().getTime()+2000);
        timer.schedule(new MyTask(),date);

        //时间格式化输出
        SimpleDateFormat formatDate=new SimpleDateFormat("yy-mm-dd hh:mm:ss");
        String dateString=formatDate.format(date);
        System.out.println(dateString);
    }
}
