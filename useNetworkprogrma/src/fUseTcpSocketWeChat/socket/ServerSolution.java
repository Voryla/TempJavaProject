package fUseTcpSocketWeChat.socket;

import fUseTcpSocketWeChat.mySqlUtil.MySqlSolution;
import fUseTcpSocketWeChat.tempUser.SerializationUser;
import fUseTcpSocketWeChat.tempUser.User;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerSolution {
    private ServerSocket serverSocket;
    private volatile Integer clientKey = 0;
    private HashMap<Integer, Socket> clients;

    public ServerSolution(int port) throws Exception {
        serverSocket = new ServerSocket(port);
    }

    /**
     * 监听客户端的连接
     */
    public void acceptClient() {
        clients = new HashMap<>();
        //监听端口，多用户连接
        new Thread(() -> {
            while (true) {
                System.out.println("--->服务器：服务器监听已启动...");
                try {
                    Socket client = serverSocket.accept();
                    clients.put(++clientKey, client);
                    System.out.println("--->服务器：客户端" + clientKey + "连接成功!");
                    //每有一名客户端连接便为该客户端创建一个线程
                    reciveClientMessage(clientKey);
                    System.out.println(clientKey);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 接收客户端消息
     *
     * @param clientKey
     */
    public void reciveClientMessage(int clientKey) {
        new Thread(() -> {
            Socket socket = clients.get(clientKey);
            User user = new User();
            int len = -1;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                while (!user.gettoken()) {
                    if (socket == null) {
                        continue;
                    }
                    String uName = reader.readLine();
                    String uPwd = reader.readLine();
                    byte[] objectBytes = new SerializationUser<User>().getObjectBytes(new User(uName, uPwd));
                    if (new MySqlSolution().selectUser(objectBytes)) {
                        user.setUserName(uName);
                        user.setPwd(uPwd);
                        user.setToken(true);
                        System.out.println("--->服务器：" + uName + "用户登陆成功");
                    } else {
                        user.setToken(false);
                        System.out.println("登陆失败");
                    }
                }
                while (user.gettoken()) {
                    System.out.println("客户端："+user.getUserName() + "说" + reader.readLine());
                }
            } catch (Exception e) {
                clients.remove(clientKey);
            }
        }).start();
    }

    public void sendMessageToClients(String message) {
        new Thread(() -> {
            for (int i = 1; i <= clients.size(); i++) {
                Socket socket = clients.get(i);
                if (socket != null) {
                    try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream())) {
                        bufferedOutputStream.write(message.getBytes());
                    } catch (Exception e) {
                        clients.remove(i);
                        continue;
                    }
                }
            }
        }).start();
    }
}
