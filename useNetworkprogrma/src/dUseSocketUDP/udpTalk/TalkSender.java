package dUseSocketUDP.udpTalk;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class TalkSender implements Runnable {
    private DatagramSocket datagramSocket;
    private int port;
    private String toIP;
    private int toPort;

    public TalkSender(int port, String toIP, int toPort) {
        this.port = port;
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String talk = null;
        while (true) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                talk = bufferedReader.readLine();
                byte[] datas = talk.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(datas, datas.length, InetAddress.getByName(toIP), toPort);
                datagramSocket.send(datagramPacket);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (talk.equals("bye")) {
                datagramSocket.close();
                break;
            }
        }

    }
}
