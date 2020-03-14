package fUseTcpSocketWeChat.mySqlUtil;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlSolution {
    private CreateMySqlConnect createMySqlConnect;
    private Connection connection=null;
    private volatile Statement statement=null;
    public MySqlSolution()throws SQLException,ClassNotFoundException {
        createMySqlConnect=new CreateMySqlConnect("192.168.0.13","users","root","123456");
        statement=createMySqlConnect.connectionMySql();
    }
    public boolean selectUser(byte[] userBytes)throws SQLException{
        String sqlCommand="SELECT userCode FROM user WHERE userCode='"+new String(userBytes)+"'";
        statement.execute(sqlCommand);
        return statement.getResultSet().next();
    }
    public void insertUserBytes(byte[] userBytes)throws SQLException{
        String sqlCommand="INSERT INTO user(userCode) VALUES('"+new String(userBytes)+"')";
        statement.execute(sqlCommand);
    }

    public void closeConnect(){
        try {
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
