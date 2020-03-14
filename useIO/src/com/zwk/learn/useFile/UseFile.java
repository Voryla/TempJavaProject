package com.zwk.learn.useFile;

import java.io.File;
import java.io.IOException;

public class UseFile {
    public static void main(String[]args){
        String path="C:/Users/LWK/Desktop/abc.png";
        //创建File对象的方式一
        File useFile=new File(path);
        System.out.println(useFile.length());
        //创建File对象的方式二,只要两个字符串能够拼接成正确路径即可
        useFile=new File("C:","Users/LWK/Desktop/abc.png");
        System.out.println(useFile.length());
        //创建File对象的方式三，父对象+子目录
        File newFile=new File(new File("C:/"),"Users/LWK/Desktop/abc.png");
        System.out.println(newFile.length());
        //创建新文件，前提是文件的上一级是存在的如果上一级不存在则创建失败
        File f =new File("C:/Users/LWK/Desktop/f.png");
        try {
            System.out.println("是否创建成功："+f.createNewFile());
        }catch (IOException e){
            e.printStackTrace();
        }

        //查看路径
        File myFile=new File("C:/Users/LWK/Desktop/f.png");
        //获取文件名称
        System.out.println("名称： "+myFile.getName());
        //获取路径  如果是相对路径就显示相对路径，如果是绝对路径就显示绝对路径
        System.out.println("路径： "+myFile.getPath());
        //获取绝对路径
        System.out.println("绝对路径： "+myFile.getAbsolutePath());
        //获取父路径，只是将该文件的上一层起取出来
        System.out.println("父路径：  "+myFile.getParent());
        //查看文件是否存在
        System.out.println("是否存在:"+myFile.exists());
        //查看是否为文件
        System.out.println("是否为文件:"+myFile.isFile());
        //查看是否为文件夹
        System.out.println("是否为文件夹:"+myFile.isDirectory());
        //获得盘符
        File[] roots=myFile.listRoots();
        for (File r:roots){
            System.out.println(r.getPath());
        }
        getAllFile(new File("C:/Users/LWK/Desktop/ab"),0);


    }
    /**
     * 遍历所有文件
     * @param file
     */
    public static void getAllFile(File file,int count){
        for (File f:file.listFiles()) {
            if (f.isDirectory()) {
                System.out.println(f.getPath());
                getAllFile(f,count);
            } else {
                System.out.println(f.getName());
                count+=f.length();
            }
        }//1612 416 417
        System.out.println(count);
    }
}
