package bUseURL;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadForURL {
    public static void main(String[] args) throws Exception {
        //downloadForURL("https://www.jd.com");
        bowserDownloadForURL("https://www.dianping.com");
    }

    //不加修饰的直接下载网页，适用于服务器允许的情况
    public static void downloadForURL(String spec) throws Exception {
        URL url = new URL(spec);
        InputStream inputStream = url.openStream();
        downloadSolution(inputStream, "C:/Users/ZWK/DeskTop/downloadHtml.txt");
    }

    //由于一些服务器拒绝直接下载网页，该方法模拟浏览器下载网页
    public static void bowserDownloadForURL(String spec) throws Exception {
        URL url = new URL(spec);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", " Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.26 Safari/537.36");
        InputStream inputStream = httpURLConnection.getInputStream();
        downloadSolution(inputStream, "C:/Users/ZWK/DeskTop/downloadHtml.txt");
    }

    //保存下载文件
    public static void downloadSolution(InputStream inputStream, String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(new File(fileName)), "UTF-8"
                )
        );
        char[] datas = new char[1024];
        int len = -1;
        while (-1 != (len = bufferedReader.read(datas))) {
            bufferedWriter.write(datas, 0, len);
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}
