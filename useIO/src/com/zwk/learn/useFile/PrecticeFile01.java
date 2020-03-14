package com.zwk.learn.useFile;

import java.io.*;

/**
 * 文件字节输入流
 * 1.创建源
 * 2.选择流
 * 3.操作流（读）
 * 4.释放资源
 */
public class PrecticeFile01 {
    public static void main(String[] args){
        //1.创建源
        File src=new File("D:/JavaProject/StreamFileIO/src/com/zwk/useFile/hello.txt");
        InputStream inputStream=null;
        try{
            //2.选择流
            inputStream=new FileInputStream(src);
            byte[] data=new byte[3];
            int len=-1;
            //3.操作流
            while ((len=inputStream.read(data))!=-1){
                String sr=new String(data,0,len);
                System.out.println(sr);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            //4.释放资源
            if(null!=inputStream){
                try {
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
