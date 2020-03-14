package cUseSocket.oneToOneLogin;

import java.io.IOException;

public class UseSocketServer {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                MyServer myServer = MyServer.getInstance(1168);
                myServer.appept();
                String info = myServer.getMessage();
                if (info.equals("zwk")) {
                    System.out.println("我是服务器：客户端说" + info);
                    myServer.sendMessage(null, "ok");
                    System.out.println("我是服务器:我说。。。");
                    myServer.closeConnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
