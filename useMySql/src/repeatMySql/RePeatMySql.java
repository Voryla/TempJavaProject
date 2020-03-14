package repeatMySql;

import java.sql.ResultSet;
import java.sql.Statement;

public class RePeatMySql {
    public static void main(String[] args) throws Exception {
        CreateMySqlConnect createMySqlConnect = new CreateMySqlConnect("192.168.0.168"
                ,"Runboon", "root", "123456");
        Statement myStatement = createMySqlConnect.connectionMySql();
        String sqlCommand = "SELECT * FROM websites";
        //执行查询语句
        myStatement.execute(sqlCommand);
        ResultSet rs = myStatement.getResultSet();
        while (rs.next()) {
            //通过字段检索
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String url = rs.getString("url");
            //输出数据
            System.out.print("ID:" + id);
            System.out.print(", 站点名称:" + name);
            System.out.print(", 站点URL:" + url);
            System.out.print("\n");
        }
        System.out.println(createMySqlConnect.closeConnection());
    }
}
