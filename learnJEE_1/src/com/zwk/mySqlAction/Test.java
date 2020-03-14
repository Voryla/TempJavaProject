package com.zwk.mySqlAction;

import java.sql.ResultSet;

public class Test {
	@org.junit.Test
	public void test()throws Exception{
		MySqlSolution sqlSolution=new MySqlSolution(new MySqlManager(
				"localhost","root","123456",
				"servletLogin"));
		sqlSolution.connectionMysql();
		sqlSolution.doSqlCommand("SELECT * FROM users");
		ResultSet resultSet=sqlSolution.getResultSet();
		while (resultSet.next()) {
			//通过字段检索
			String name = resultSet.getString("name");
			//输出数
			System.out.println(name);
		}
		sqlSolution.closeMySql();
	}
}