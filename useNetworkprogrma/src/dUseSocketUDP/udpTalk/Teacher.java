package dUseSocketUDP.udpTalk;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new TalkReciver(8888,"学生")).start();
        new Thread(new TalkSender(9999, "192.168.0.13",7777)).start();
    }
}
