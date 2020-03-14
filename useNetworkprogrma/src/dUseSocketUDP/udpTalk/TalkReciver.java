package dUseSocketUDP.udpTalk;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReciver implements Runnable {
    private DatagramSocket datagramSocket;
    private int port;
    private String from;

    public TalkReciver(int port, String from) {
        try {
            this.port = port;
            this.from = from;
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        byte[] datas = new byte[1024];
        String data = null;
        while (true) {
            try {
                DatagramPacket datagramPacket = new DatagramPacket(datas, 0, datas.length);
                datagramSocket.receive(datagramPacket);
                data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println(from + ":" + data);

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (data.equals("bye")) {
                datagramSocket.close();
                break;
            }
        }

    }
}
