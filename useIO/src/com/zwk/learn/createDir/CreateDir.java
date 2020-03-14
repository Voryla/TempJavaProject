package com.zwk.learn.createDir;

import java.io.File;

public class CreateDir {
    public static void main(String[] args){

        String dirName="C:\\Users\\LWK\\Desktop\\新建文件夹\\bb";
        File f=new File(dirName);
        //在路径中查找已经存在的目录并在已存在的目录最后一级下创建不存在的所有目录
        f.mkdirs();
        //在路径中查找已经存在的目录并在仅当路径的最后一级为不存在目录时才可以创建
        //f.mkdir();
        dirList();
        deleteFile(f);
    }
    public static void dirList(){
        String dirname="C:\\Users\\LWK\\Desktop";
        File f=new File(dirname);
        if (f.isDirectory()){
            System.out.println("目录："+dirname);
            String[] s=f.list();
            for (int i = 0; i < s.length; i++) {
                File f1=new File(dirname+"\\"+s[i]);
                if (f1.isDirectory()){
                    System.out.println(s[i]+"是一个目录");
                }else {
                    System.out.println(s[i]+"是一个文件");
                }
            }
        }else {
            System.out.println(dirname+"不是一个目录");
        }
    }

    /**
     * 需要一级一级的删除文件，无法删除包含有文件的目录
     * @param folder
     */
    public static void deleteFile(File folder){
        File[]files=folder.listFiles();
        if(files!=null){
            for(File f:files){
                if(f.isDirectory()){
                    deleteFile(f);
                }else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
