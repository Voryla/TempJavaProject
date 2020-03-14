package cUseSocket.oneToOneLogin;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    private MyServer() {
    }
    private static volatile MyServer myServer = null;
    private static ServerSocket serverSocket = null;
    private static volatile Socket currentSocket = null;



    /**
     * 单例模式，懒汉模式双重锁,获取实例
     *
     * @param port
     * @return 对象实例
     * @throws IOException
     */
    public static MyServer getInstance(int port) throws IOException {
        if (myServer == null) {
            //这里锁的是类名
            synchronized (MyServer.class) {
                if (myServer == null) {
                    myServer = new MyServer();
                    serverSocket = new ServerSocket(port);
                }
            }
        }
        return myServer;
    }

    /**
     * 监听客户端
     *
     * @return currentSocket
     * @throws IOException
     */
    public Socket appept() throws IOException {
        while (true) {
            currentSocket = serverSocket.accept();
            if (currentSocket.isConnected())
                break;
        }
        return currentSocket;
    }

    /**
     * //获取输入流，并读取客户端信息
     *
     * @return Message
     * @throws IOException
     */

    public String getMessage() throws IOException {
       return SocketSolution.socketGetMessage(currentSocket);
    }

    /**
     * //获取输出流，响应客户端的请求
     *
     * @param socket
     * @param message
     * @return
     * @throws IOException
     */
    public boolean sendMessage(Socket socket, String message) throws IOException {
        if (socket == currentSocket || socket == null) {
            socket=currentSocket;
            return SocketSolution.socketSendMessage(socket,message);
        } else return false;
    }

    /**
     * 关闭连接
     *
     * @return CloseState
     * @throws IOException
     */
    public boolean closeConnect() {
        if (!serverSocket.isClosed()) {
            try {
                currentSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
}
