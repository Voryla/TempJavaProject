package fUseTcpSocketWeChat.tempUser;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String pwd;
    private boolean token = false;

    public User() {
    }

    public User(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public String getPwd() {
        return pwd;
    }

    public boolean gettoken() {
        return token;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setToken(boolean token) {
        this.token = token;
    }
}
