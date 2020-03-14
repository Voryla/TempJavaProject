package com.zwk.learn.dataStream;

import java.io.*;

public class UseDataStreamToByteArray {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(new BufferedOutputStream(baos));
        dataOutputStream.writeUTF("hello");
        dataOutputStream.writeBoolean(true);
        dataOutputStream.flush();
        dataOutputStream.close();
        byte [] datas=baos.toByteArray();

        ByteArrayInputStream bais=new ByteArrayInputStream(datas);
        DataInputStream dataInputStream=new DataInputStream(new BufferedInputStream(bais));
        System.out.println(dataInputStream.readUTF()+dataInputStream.readBoolean());
    }
}
