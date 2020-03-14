package fUseTcpSocketWeChat.mySqlUtil;

import fUseTcpSocketWeChat.tempUser.SerializationUser;
import fUseTcpSocketWeChat.tempUser.User;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        MySqlSolution sqlSolution = new MySqlSolution();
        for (int i = 1; i < 6; i++) {
            sqlSolution.insertUserBytes(new SerializationUser<User>().getObjectBytes(new User("user" + i, "1234566")));
        }
        byte[] bytes = new SerializationUser<User>().getObjectBytes(new User("user1", "123456"));
        ObjectInputStream f=new ObjectInputStream(new ByteArrayInputStream(bytes));
        User user=(User) f.readObject();
        System.out.println(user.getUserName());
        System.out.println(new String(bytes));
        Class s=sqlSolution.getClass();
        System.out.println(sqlSolution.selectUser(bytes));
    }
}
