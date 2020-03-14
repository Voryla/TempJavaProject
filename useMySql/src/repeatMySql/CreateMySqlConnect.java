package repeatMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMySqlConnect {
    private final static String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    private static String url=null;
    private String user=null;
    private String pwd=null;
    private Connection connection=null;
    private volatile Statement statement=null;
    private String databaseName;
    public CreateMySqlConnect(String mysqlAddress,String databaseName,String user,String pwd){
        this.user=user;
        this.pwd=pwd;
        this.databaseName=databaseName;
        url="jdbc:mysql://"+mysqlAddress+":3306/"+databaseName+"?serverTimezone=GMT&CharacterEncoding=utf-8&useSSL=false";
    }
    /**
     * 注册JDBC驱动
     * 连接数据库
     * 创建声明
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Statement connectionMySql()throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        connection= DriverManager.getConnection(url,user,pwd);
        statement=connection.createStatement();
        return statement;
    }
    public boolean closeConnection(){
        try {
            this.statement.close();
            this.connection.close();
            return true;
        }catch (SQLException e){
            return false;
        }
    }
}
