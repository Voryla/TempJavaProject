package dUseSocketUDP.pictureToSend;

import java.io.*;

public class PictureSolution {
    public byte[] pictureToByte(String picturePath) throws IOException {
        BufferedInputStream imageInputStream = new BufferedInputStream(new FileInputStream(new File(picturePath)));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = -1;
        while (-1 != (len = imageInputStream.read(data))) {
            byteArrayOutputStream.write(data, 0, len);
        }
        byteArrayOutputStream.close();
        imageInputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public void byteToLoadPicture(byte[] bytes,String picturePath)throws IOException{
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(new File(picturePath+"/w.jpg")));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();
    }
}
