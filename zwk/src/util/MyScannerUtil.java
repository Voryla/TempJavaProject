package util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class MyScannerUtil {
    public static void main(String[] args){
        System.out.println(readInt("输入整数"));
    }
    //推荐使用第一种
    public static int readInt(String hint){
        System.out.print(hint);
        return new Scanner(System.in).nextInt();
    }
    //第二种需要控制想要的数值
    public static String readString(String hint)throws IOException {
        System.out.print(hint);
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
