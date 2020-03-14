package com.zwk.learn.byteStream;

import java.io.*;

public class UseByteArraySteamOperationImg {
    public static void main(String[] args) {
        byteArraytoFile(filetoByteArray(new File("C:/Users/LWK/Desktop/cat.jpg")), new File("C:/Users/LWK/Desktop/copyCat.jpg"));
    }

    /**
     * 从图片到流FileInput
     * 从流到字节数组ByteArrayOutput
     * @param src
     * @return
     */
    public static byte[] filetoByteArray(File src) {
        try (FileInputStream fileInputStream=new FileInputStream(src);
             ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream() ){
            byte datas [] = new byte[1024 * 1024];
            int len = -1;
            while ((len = fileInputStream.read(datas)) != -1) {
                byteArrayOutputStream.write(datas, 0, len);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 1.读取字节数组
     * 2.从字节数组再到图片
     * @param byteArray
     * @param path
     */
    public static void byteArraytoFile(byte[] byteArray, File path) {
        ByteArrayInputStream byteArrayInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {

            byteArrayInputStream = new ByteArrayInputStream(byteArray);
            fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(byteArrayInputStream.readAllBytes());
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fileOutputStream) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
