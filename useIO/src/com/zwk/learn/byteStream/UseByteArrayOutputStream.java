package com.zwk.learn.byteStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UseByteArrayOutputStream {
    public static void main(String[] args){
        //要使用toByteArray()方法所以不使用多态
        ByteArrayOutputStream byteArrayOutputStream=null;
        try{
            byteArrayOutputStream=new ByteArrayOutputStream();
            byteArrayOutputStream.write(new String("talk is cheap show me the code").getBytes());
            byte[] datas=byteArrayOutputStream.toByteArray();
            for (byte value:datas){
                System.out.print((char)value);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
