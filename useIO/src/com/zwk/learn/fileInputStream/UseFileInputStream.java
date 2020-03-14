package com.zwk.learn.fileInputStream;

import java.io.*;

public class UseFileInputStream {
    public static void main(String[] args) throws IOException{
        UseFileInputStream thisClass=new UseFileInputStream();
        thisClass.fileStreamTest2();
    }

    /**
     * 该方法写入文件不会产生乱码，但读取时会产生乱码
     */
    public void fileStreamTest1()throws IOException {
        String str="你说吧";
        byte bwrite[]=str.getBytes();
        File f=new File("C:\\Users\\LWK\\Desktop\\hello.txt");
        //如果有该文件就读取到文件流中，没有文件就会创建一个指定文件，再读取到流中
        OutputStream os=new FileOutputStream(f);
        for (int i=0;i<bwrite.length;i++){
            os.write(bwrite[i]);
        }
        os.close();
        InputStream is=new FileInputStream(f);
        int size=is.available();
        for (int j = 0; j < size; j++) {
            System.out.print((char)is.read());
        }
        is.close();
    }
    /**
     * 解决中文乱码问题
     */
    public void fileStreamTest2()throws IOException{
        File f=new File("C:\\Users\\LWK\\Desktop\\hello.txt");
        FileOutputStream fop=new FileOutputStream(f);
        OutputStreamWriter writer=new OutputStreamWriter(fop,"UTF-8");
        writer.append("hello! 是我");
        writer.append("\r\n");
        writer.close();
        FileInputStream fip=new FileInputStream(f);
        InputStreamReader reader=new InputStreamReader(fip,"UTF-8");
        StringBuffer strBuffer=new StringBuffer();
        while (reader.ready()){
            strBuffer.append((char) reader.read());
        }
        reader.close();
        System.out.print(strBuffer.toString());
    }


}
