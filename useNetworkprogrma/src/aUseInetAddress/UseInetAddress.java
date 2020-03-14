package aUseInetAddress;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UseInetAddress {
    public static void main(String[] args)throws UnknownHostException {
        InetAddress inetAddress=InetAddress.getLocalHost();
        inetAddress.getHostName();
        String hostName=inetAddress.getHostName();
        String getIp=inetAddress.getHostAddress();
        System.out.println(getIp);
        System.out.println(hostName);
        InetAddress inetAddress1=InetAddress.getByName("其他主机名");
        InetAddress inetAddress2=InetAddress.getByName("Ip地址");
    }
}
