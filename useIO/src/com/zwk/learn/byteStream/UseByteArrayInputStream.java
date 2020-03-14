package com.zwk.learn.byteStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UseByteArrayInputStream {
    /**
     * 字节数组
     * @param args
     */
    public static void main(String[] args){
        InputStream byteArrayInput=null;
        byte[] src="talk is cheap show me the code".getBytes();
        try {
            byteArrayInput=new ByteArrayInputStream(src);
            byte []read=new byte[200];
            int len=-1;
            while ((len=byteArrayInput.read(read))!=-1){
                System.out.println(new String(read,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
