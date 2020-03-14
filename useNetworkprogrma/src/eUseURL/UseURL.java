package eUseURL;

import java.net.MalformedURLException;
import java.net.URL;

public class UseURL {
    public static void main(String[] args) throws MalformedURLException {
        URL url=new URL("http://bilibili.com:80/video/av33232/?p=1#a");
        System.out.println("协议:"+url.getProtocol());
        System.out.println("主机名:"+url.getHost());
        System.out.println("端口:"+url.getPort());
        System.out.println("完整资源名:"+url.getFile());
        System.out.println("不带参资源名:"+url.getPath());
        System.out.println("锚点："+url.getRef());
    }
}
