package cUseSocket.oneToOneLogin;

import java.io.IOException;

public class UserSocketClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                MyClient myClient = new MyClient();
                System.out.println(myClient.connectServer("192.168.0.168", 1168));
                myClient.sendMessage("zwk");
                System.out.println(myClient.getServerMessage());
                myClient.closeConnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
