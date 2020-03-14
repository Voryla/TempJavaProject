package com.zwk.learn.fileCopy.bufferedStream;

import java.io.*;

public class UseBufferedStream {
    public static void main(String[] args){
        long currTime=System.currentTimeMillis();
        File src=new File("C:/Users/LWK/Desktop/学习路线.txt");
        File src1=new File("C:/Users/LWK/Desktop/学习路线1.txt");
        try(InputStream is=new BufferedInputStream(new FileInputStream(src));
            OutputStream os=new BufferedOutputStream(new FileOutputStream(src1));) {
            byte[] datas=new byte[1024*10];
            int len=-1;
            while ((len=is.read(datas))!=-1){
                os.write(datas);
                os.flush();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long time=System.currentTimeMillis();
        System.out.println(time-currTime);
    }
}
