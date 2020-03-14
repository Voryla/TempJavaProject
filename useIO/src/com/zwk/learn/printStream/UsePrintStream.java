package com.zwk.learn.printStream;

import java.io.*;

public class UsePrintStream {
    public static void main(String[] args) {
        //因为System.out本身就PrintStream流对象
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);
        ps.flush();
        try {
            //第二个参数为是否自动刷新,默认值为false 如果不设置为ture 即要关闭PrintStream流才会显示
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("C:/Users/LWK/Desktop/abc.txt")),true);
            ps.print("出发");
            ps.println(false);
            //需要将流关闭后才能写入文件,也可以设置PrintStream实例化时的第二个参数，设置为ture 即自动刷新文件
            ps.close();

            //第二个参数为是否自动刷新,默认值为false 如果不设置为ture 即要关闭PrintStream流才会显示
            PrintStream psOut=new PrintStream(new BufferedOutputStream(new FileOutputStream("C:/Users/LWK/Desktop/abc.txt")),true);
            //重定向输出，输出目的地薇PrintSteam的实体对象，可为文件，设置后所以控制台输出均输入至目的文件，除非重新定向至控制台
            System.setOut(psOut);
            System.out.println("输入到文件了吗");
            System.out.println("输入到文件了吗");

            //重定向至控制台输出,千万注意第二个参数防止无法及时刷新又没有关闭导致的无法打印
            PrintStream psToConsole=new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true);
            System.setOut(psToConsole);
            System.out.println("又在控制台显示了");

            //PrintWriter 与PrintStream功能相同
            PrintWriter pw=new PrintWriter(new BufferedOutputStream(new FileOutputStream("C:/Users/LWK/Desktop/abc.txt")),true);
            pw.print("这是PrintWriter的使用");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
