package fUseTcpSocketWeChat.tempUser;

import java.io.*;

/**
 * 序列化对象工具类
 * @param <T>
 */
public class SerializationUser<T> {


    /**
     * 序列化对象
     * @param object
     * @return
     */
    public byte[] getObjectBytes(T object) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(object);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    /**
     * 反序列化对象
     * @param userBytes
     * @return
     */
    public T getObjectFromByte(byte[] userBytes) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(userBytes)))) {
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }
}
