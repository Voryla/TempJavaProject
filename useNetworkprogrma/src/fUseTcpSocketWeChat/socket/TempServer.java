package fUseTcpSocketWeChat.socket;



/***
 * 多用户连接服务器
 * 实现多用户连接通信
 */
public class TempServer {
    public static void main(String[] args) throws Exception{
        ServerSolution serverSolution=new ServerSolution(9999);
        serverSolution.acceptClient();
    }
}
