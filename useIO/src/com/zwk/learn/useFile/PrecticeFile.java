package com.zwk.learn.useFile;

import java.io.*;

public class PrecticeFile {
    public static void main(String[] args){
     /*   File src=new File("C:/Users/LWK/Desktop/hello.txt");
        PrecticeFile precticeFile=new PrecticeFile();
        precticeFile.write(src);
        System.out.println(precticeFile.read(src));*/
        File src1=new File("C:/Users/LWK/Desktop/hello.txt");
        try {
            InputStream inputStream = new FileInputStream(src1);
            byte[] datas=inputStream.readAllBytes();
            for(byte value:datas){
                System.out.println((char)value);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public StringBuffer read(File src){
        InputStream inputStream=null;
        InputStreamReader inputStreamReader=null;
        StringBuffer stringBuffer=null;
        try{
            inputStream=new FileInputStream(src);
            inputStreamReader=new InputStreamReader(inputStream,"utf-8");
            stringBuffer=new StringBuffer();
            while (inputStreamReader.ready()){
                stringBuffer.append((char) inputStreamReader.read());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (null != inputStreamReader) {
                    inputStreamReader.close();
                }
                if(null!= inputStream){
                    inputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return stringBuffer;
    }
    public void write(File src) {
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStream = new FileOutputStream(src);
            outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
            outputStreamWriter.write("赵文凯");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭的顺序从后往前
                if (null!=outputStreamWriter) {
                    outputStreamWriter.close();
                }
                if (null!=outputStream){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}