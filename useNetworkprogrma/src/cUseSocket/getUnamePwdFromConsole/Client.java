package cUseSocket.getUnamePwdFromConsole;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名");
        String userName=bufferedReader.readLine();
        System.out.println("请输入密码");
        String pwd=bufferedReader.readLine();

        PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
        printWriter.println(userName);
        printWriter.println(pwd);

        BufferedReader read=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(read.readLine());
        socket.close();
    }
}
