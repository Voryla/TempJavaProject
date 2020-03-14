package com.zwk.learn.practiceIOEveryday;

import java.io.*;

public class OneDay {
    public static void main(String [] args){
        try (InputStreamReader inputStream=new InputStreamReader(new FileInputStream(new File("C:/Users/LWK/DeskTop/abc.txt")),"UTF-8")){
            int len=-1;
            char[] chars=new char[1024];
            while ((len=inputStream.read(chars))!=-1){
                System.out.println(new String(chars,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
