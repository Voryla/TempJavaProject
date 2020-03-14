package com.zwk.learn.objectStream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UseObjectStreamByteArray {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写入到内存中
        ByteArrayOutputStream bais= new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(bais);
        objectOutputStream.writeUTF("How? How Do you find me?");
        objectOutputStream.writeObject(new Temp());
        objectOutputStream.flush();
        objectOutputStream.close();
        //从刚才的写入获得Byte字节
        byte[] datas=bais.toByteArray();
        ObjectInputStream objectInputStream=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String valueStr=objectInputStream.readUTF();
        System.out.println("字符串:  "+valueStr);
        Temp temp=(Temp) objectInputStream.readObject();
        System.out.println(temp.name+" "+temp.money);
        objectInputStream.close();
    }
}
//想要序列化类就要实现Serializable接口 就像一个标识
class Temp implements Serializable{
    //隐藏
    transient String  name="zwk";
    double money=3333;

    public double getMoney() {
        return money;
    }
}
