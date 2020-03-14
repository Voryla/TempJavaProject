package bUseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UseURLReadWeb {
    public static void main(String[] args)throws MalformedURLException, IOException {
        //URL地址需要加http
        URL url=new URL("http://www.baidu.com");
        //通过URL实例的openStream方法获取资源的字节输入流
        InputStream is=url.openStream();
        //将字节流输入转化为字符输入流，如果不指定编码，中文可能会出现乱码
        InputStreamReader isRead=new InputStreamReader(is,"UTF-8");
        //为字符流添加缓冲，提高读取效率
        BufferedReader br=new BufferedReader(isRead);
        //读取数据
        String data=br.readLine();
        while (data!=null){
            System.out.println(data);
            data=br.readLine();
        }
        br.close();
        isRead.close();
        is.close();
    }
}
