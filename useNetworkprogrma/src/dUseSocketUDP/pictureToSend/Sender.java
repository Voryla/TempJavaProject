package dUseSocketUDP.pictureToSend;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] datas = new PictureSolution().pictureToByte("C:/Users/ZWK/Desktop/b.jpg");
        int sendLength=32768;
        int len = datas.length / sendLength;
        int js=0;
        for (int i = 0; i < len; i++) {
            js++;
            if(i+1>=len){
                len=datas.length-(i*sendLength);
                DatagramPacket datagramPacket = new DatagramPacket(datas, i * sendLength, sendLength, InetAddress.getLocalHost(), 8888);
                datagramSocket.send(datagramPacket);
                break;
            }
            DatagramPacket datagramPacket = new DatagramPacket(datas, i * sendLength, sendLength, InetAddress.getLocalHost(), 8888);
            datagramSocket.send(datagramPacket);
        }
        System.out.println(js);
        datagramSocket.close();
    }
}
