package com.zwk.learn.useCommonsIo;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class Use {
    public static void main(String [] args){
        long len=FileUtils.sizeOf(new File("C:/Users/LWK/Desktop/JDK9.CHM"));
        System.out.println(len);
    }
}
