package com.zwk.learn.fileCopy;

import java.io.*;

public class FileCopy {
    public static void main(String[] args){
        File src=new File("C:/Users/ZWK/Desktop/hello.txt");
        FileCopy thisClass=new FileCopy();
        byte[] datas=thisClass.read(src);
        for(byte element:datas) {
            System.out.print((char)element);
        }
        File src1=new File("C:/Users/LWK/Desktop/hello2.txt");
        thisClass.write(datas,src1);
    }
    public byte[] read(File src){
        InputStreamReader inputStreamReader=null;
        StringBuffer stringBuffer=null;
        char[] chars=new char[2];
        try{
            inputStreamReader=new InputStreamReader(new FileInputStream(src),"UTF-8");
            int len=-1;
            stringBuffer=new StringBuffer();
            while ((len=inputStreamReader.read(chars))!=-1){
                stringBuffer.append(chars,0,len);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(null!=inputStreamReader){
                try{
                    inputStreamReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return stringBuffer.toString().getBytes();
    }
    public void write(byte[] datas,File src){
        OutputStreamWriter outputStreamWriter=null;
        try{
            outputStreamWriter=new OutputStreamWriter(new FileOutputStream(src),"utf-8");
            for (byte element:datas){
                outputStreamWriter.write((char)element);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(null!=outputStreamWriter){
                try {
                    outputStreamWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
