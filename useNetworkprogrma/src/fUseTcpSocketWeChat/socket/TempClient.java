package fUseTcpSocketWeChat.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TempClient {
    public static void main(String[] args)throws UnknownHostException, IOException {
        Socket socket=new Socket(InetAddress.getLocalHost(),9999);
        BufferedReader bufferedInputStream=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名");
        String uName=bufferedInputStream.readLine();
        System.out.println("请输入密码");
        String uPwd=bufferedInputStream.readLine();
        PrintWriter objectOutputStream=new PrintWriter(socket.getOutputStream());
        objectOutputStream.println(uName);
        objectOutputStream.println(uPwd);
        objectOutputStream.flush();
        while (true){
            String str=bufferedInputStream.readLine();
            objectOutputStream.println(str);
            objectOutputStream.flush();
        }
    }
}
