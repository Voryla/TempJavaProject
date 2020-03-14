package com.zwk.learn.objectStream;

import java.io.*;

public class UseObjectStreamToFile {
    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:/Users/ZWK/Desktop/aa1.txt")));) {
            objectOutputStream.writeUTF("How How do you find me go away");
            //使用的是同一包下的类在上一个例子中的Temp类，同一个包内不能有同名类
            objectOutputStream.writeObject(new Temp());
            objectOutputStream.flush();
            objectOutputStream.close();
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("C:/Users/ZWK/Desktop/aa1.txt")));
            String valueStr = objectInputStream.readUTF();
            Temp temp = (Temp) objectInputStream.readObject();
            System.out.println(valueStr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
