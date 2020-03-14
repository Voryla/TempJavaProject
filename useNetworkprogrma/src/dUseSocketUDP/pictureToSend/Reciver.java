package dUseSocketUDP.pictureToSend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Reciver {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        byte[] datas = new byte[32768];
        DatagramPacket datagramPacket = new DatagramPacket(datas, 32768);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("C:/Users/ZWK/Desktop/w.jpg")));
        System.out.println(datas.length);
        Thread.sleep(2000);
        for (int i = 0; i < 6; i++) {
            datagramSocket.receive(datagramPacket);
            bufferedOutputStream.write(datas, 0, datas.length);
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        datagramSocket.close();
    }
}
