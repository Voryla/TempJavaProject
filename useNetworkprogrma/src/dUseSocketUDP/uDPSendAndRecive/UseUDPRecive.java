package dUseSocketUDP.uDPSendAndRecive;

import java.io.IOException;
import java.net.*;

/**
 * 使用udp接收数据
 */
public class UseUDPRecive {
    public static void main(String[] args) throws IOException {
        //创建Udp Socket对象用以接收数据
        //port:指定接收数据的端口与发送端DatagramPacket端口相同
        DatagramSocket reciveDataSocket = new DatagramSocket(10002);
        //创建数据数组用以存放数据
        byte[] value = new byte[1024];
        //接收数据数据会存放在上面的数组中，也可以使用DatagramPacket获得数据和其他一些关于发送端的属性
        reciveDataSocket.receive(new DatagramPacket(value, value.length));
        //释放资源
        reciveDataSocket.close();
        //将byte数组转化为字符串方式1
        System.out.println(new String(value));

        //将byte数组转化为字符串方式2
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            stringBuilder.append((char) value[i]);
        }
        System.out.println(stringBuilder.toString());
    }
}
