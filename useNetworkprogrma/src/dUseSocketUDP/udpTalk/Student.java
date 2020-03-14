package dUseSocketUDP.udpTalk;

public class Student {
    public static void main(String[] args) {
        new Thread(new TalkReciver(7777,"老师")).start();
        new Thread(new TalkSender(6666, "192.168.0.13",8888)).start();
    }
}
