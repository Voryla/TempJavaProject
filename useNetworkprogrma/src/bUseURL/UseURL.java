package bUseURL;

import java.net.MalformedURLException;
import java.net.URL;

//formed形成,Malformed畸形的，难看的
public class UseURL {
    public static void main(String[] args) throws MalformedURLException {
        //从 String表示中创建一个 URL对象。
        URL baidu = new URL("http://www.biadu.com");
        //通过在指定的上下文中解析给定的规范来创建一个URL。
        URL url = new URL(baidu, "/index.html?user=tom#test");
        String urlActivity = url.getQuery();
        String urlProtocol = url.getProtocol();
        String urlHost = url.getHost();
        int urlPort = url.getPort();
        String urlPath = url.getPath();
        String urlFile = url.getFile();
        String urlRef = url.getRef();
        System.out.println("协议" + urlProtocol + "\n"
                + "是否存在URL  " + urlActivity + "\n"
                + "主机" + urlHost + "\n"
                + "端口" + urlPort + "\n"
                + "文件路径" + urlPath + "\n"
                + "文件名" + urlFile + "\n"
                + "相对路径，就是锚点，即#后的内容" + urlRef + "\n"
        );
        System.out.println(baidu.getHost());
    }
}
