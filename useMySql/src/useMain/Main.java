package useMain;

import java.sql.*;

public class Main {
    //JDBC 驱动名及数据库URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //ServerTimezone=GMT;  zone要小写
    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?ServerTimezone=GMT&characterEncoding=utf-8&useSSL=false";
    //数据库的与户名和密码
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        //连接数据库引用
        Connection conn = null;
        //执行数据库命令对象 statement：陈述；声明
        Statement stmt = null;
        try {
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);
            //打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //执行查询
            System.out.println("实例化statement对象");
            stmt = conn.createStatement();
            String sqlCommand = "SELECT id,name,url FROM websites";
            ResultSet rs = stmt.executeQuery(sqlCommand);
            while (rs.next()) {
                //通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
                //输出数据
                System.out.print("ID:"+id);
                System.out.print(", 站点名称:"+name);
                System.out.print(", 站点URL:"+url);
                System.out.print("\n");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
