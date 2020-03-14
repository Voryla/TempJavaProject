package com.zwk.learn.fileCopy;

import java.io.*;

public class FilesCopy {
    public static void main(String[] args){
        FilesCopy filesCopy=new FilesCopy();
        filesCopy.FilesCopy(new File("C:/Users/LWK/Desktop/aaa"),new File("C:/Users/LWK/Desktop/bbb"));
    }
    public void FilesCopy(File sourceFile, File newFile) {
        BufferedInputStream inputStreamReader=null;
        BufferedOutputStream outputStreamWriter=null;
        try {
            if(!newFile.exists()){
                newFile.mkdirs();
            }
            //获得源目录下的所有文件名（文件夹，文件）
            String[] fileNames = sourceFile.list();
            //根据当前目录依次索引所有文件
            for (String src : fileNames) {
                File createDir;
                //保存当前源目录
                File tempFile=new File(sourceFile.getAbsolutePath()+"/"+src);
                //在目的目录创建相同的目录
                createDir=new File(newFile.getAbsolutePath()+"/"+src);
                    if (tempFile.isDirectory()) {
                        createDir.mkdir();
                        FilesCopy(tempFile,createDir);
                    }else
                    {
                        inputStreamReader =new BufferedInputStream(new FileInputStream(tempFile));
                        outputStreamWriter=new BufferedOutputStream(new FileOutputStream(createDir));
                        //每次接收2m数据
                        byte[] elements=new byte[1024*1024];
                        int len=-1;
                        while ((len=inputStreamReader.read(elements))!=-1){
                            System.out.println(elements);
                            outputStreamWriter.write(elements,0,len);
                            outputStreamWriter.flush();
                        }
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != outputStreamWriter) {
                    outputStreamWriter.close();
                }
                if (null != inputStreamReader) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
