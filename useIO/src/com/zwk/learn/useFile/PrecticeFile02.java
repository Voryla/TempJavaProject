package com.zwk.learn.useFile;

import java.io.*;

/**
 *文件字节输出流
 * 1.创建源
 * 2.选择流
 * 3.操作流
 * 4.释放资源
 */
public class PrecticeFile02 {
    public static void main(String[] args){
        File src=new File("C:/Users/LWK/Desktop/hello.txt");
        OutputStream outputStream=null;
        InputStreamReader inputStreamReader=null;
        try{
            outputStream=new FileOutputStream(src);
            outputStream.write(new String("Come with me happy dass嗜睡y").getBytes());
            outputStream.flush();
            inputStreamReader =new InputStreamReader(new FileInputStream(src));
            char[] datas=new char[5];
            int len=-1;
            while ((len=inputStreamReader.read(datas))!=-1){
                System.out.println(datas);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != inputStreamReader) {
                    inputStreamReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
