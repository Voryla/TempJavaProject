package cUseSocket.oneToOneLogin;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 为Socket 客户端和服务端提供发送和接收数据的支持
 */
public class SocketSolution {
    public static String socketGetMessage(Socket socket)throws IOException{
        StringBuilder info = new StringBuilder();
        InputStream inputStream = socket.getInputStream();
        byte[] data = new byte[1024];
        int len;
        while ((len = inputStream.read(data)) != -1) {
            info.append(new String(data, 0, len, "UTF-8"));
        }
        socket.shutdownInput();
        return info.toString();
    }
    public static boolean socketSendMessage(Socket socket,String message)throws IOException {
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        socket.shutdownOutput();
        return true;
    }
}
