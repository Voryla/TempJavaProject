package cUseSocket.getUnamePwdFromConsole;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket clientSocket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String userName = bufferedReader.readLine();
        String pwd = bufferedReader.readLine();
        boolean flag = false;
        if (userName.equals("admin") && pwd.equals("123456")) {
            flag = true;
        } else {
            flag = false;
        }
        //PrintWriter 获取OutputStreamWriter(获取socket连接的主机名)
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
        //写入数据并换行
        printWriter.println(flag ? "登陆成功" : "登陆失败");
        clientSocket.close();
    }
}
