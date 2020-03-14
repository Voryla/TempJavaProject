package cUseSocket.oneToOneLogin;

import java.io.*;
import java.net.Socket;

public class MyClient {
    private static Socket clientSocket = null;

    /**
     * 连接服务器
     *
     * @param address
     * @param point
     * @return
     * @throws IOException
     */
    public boolean connectServer(String address, int point) throws IOException {
        clientSocket = new Socket(address, point);
        return clientSocket.isConnected();
    }

    /**
     * 获取输入流，接收服务器传来的消息
     *
     * @return
     * @throws IOException
     */
    public String getServerMessage() throws IOException {
        return SocketSolution.socketGetMessage(clientSocket);
    }

    /**
     * 获取输出流，向服务器发送消息
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        SocketSolution.socketSendMessage(clientSocket, message);
    }

    /**
     * 关闭资源
     *
     * @return
     */
    public boolean closeConnect() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
