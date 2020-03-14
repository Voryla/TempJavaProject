package com.zwk.learn.stringJoiner;

import java.util.StringJoiner;

public class Main {
    public static void main(String[] args){
        StringJoiner stringJoiner=new StringJoiner("-");
        stringJoiner.add("Hollis");
        stringJoiner.add("zwk");
        stringJoiner.add("赵文凯");
        System.out.println(stringJoiner.toString());

        //
        StringJoiner stringJoiner1=new StringJoiner(":","[","]");
        stringJoiner1.add("Hollis").add("zwk").add("赵文凯");
        System.out.println(stringJoiner1);
    }
}
