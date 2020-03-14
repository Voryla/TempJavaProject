package dUseSocketUDP.uDPSendAndRecive;

import java.io.IOException;
import java.net.*;

/**
 * 使用udp发送数据
 */
public class UseUDPSend {
    public static void main(String[] args) throws IOException {
        //创建Udp Socket对象用以发送数据
        //port:指定Socket发送数据时使用的端口
        DatagramSocket sendDataSocket = new DatagramSocket(10003);
        //创建数据并使用DatagramPacket打包
        String value = "hell udp";
        //port:指定发送数据到目标主机的哪个端口
        DatagramPacket datagramPacket = new DatagramPacket(value.getBytes(),
                value.length(), InetAddress.getLocalHost(), 10002);
        //发送数据
        sendDataSocket.send(datagramPacket);
        //释放资源
        sendDataSocket.close();

    }
}
