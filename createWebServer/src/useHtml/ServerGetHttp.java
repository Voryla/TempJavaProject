package useHtml;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerGetHttp {
    private ServerSocket serverSocket;

    @Test
    public void doSolution() throws IOException{
        startServer();
    }

    public void startServer() throws IOException {
        serverSocket = new ServerSocket(8888);
        Socket getClient=serverSocket.accept();
        InputStream inputStream=getClient.getInputStream();
        byte[] bytes=new byte[4096];
        int len=inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        inputStream.close();
    }
    public void stopServer()throws IOException{
        if(!serverSocket.isClosed()){
            serverSocket.close();
        }
    }
}
