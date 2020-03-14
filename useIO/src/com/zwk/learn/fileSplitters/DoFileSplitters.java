package com.zwk.learn.fileSplitters;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DoFileSplitters {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile(new File("C:/Users/LWK/Desktop/abc.txt"), "r");){
            int len=-1;
            byte[] flush=new byte[1024];
            int readSize=1026;
            while (-1!=(len=raf.read(flush))){
                if(readSize>len){
                    System.out.print(new String(flush,0,1024));
                    readSize-=1024;
                }else {
                    System.out.println(new String(flush,0,readSize-1));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
