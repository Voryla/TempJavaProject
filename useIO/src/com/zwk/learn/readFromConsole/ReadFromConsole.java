package com.zwk.learn.readFromConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromConsole {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c;
        String value;
        System.out.println("输入字符，按下‘q’键退出。");
        do {
            /*
            1、一定要读取到有效字符后才可以结束输入。
            2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
            3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
            next() 不能得到带有空格的字符串。如果输入abc d  将只会得到abc空格及后边的字符并不会接收
            */
            c = (char) br.read();

            //读取一行
            /*
            1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
            2、可以获得空白。
            */
            value=br.readLine();
            System.out.println();
            System.out.println(c);
        } while (c != 'q');
        System.out.println("JDK5之后的读取控制台输入");
        Scanner scan =new Scanner(System.in);
        String read=scan.next();
        //String read=scan.nextLine();
        System.out.println("输入的数据是："+read);
    }
}
