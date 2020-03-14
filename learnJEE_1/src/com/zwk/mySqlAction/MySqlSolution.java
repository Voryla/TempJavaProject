package com.zwk.mySqlAction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlSolution {
	private MySqlManager mySqlManager = null;
	private ResultSet resultSet = null;

	public MySqlSolution(MySqlManager mySqlManager) {
		this.mySqlManager = mySqlManager;
	}
	public void connectionMysql(){
		if (!mySqlManager.isConnection()) {
			mySqlManager.connectionMySql();
			System.out.println("成功连接mysql！");
		}
	}
	public void doSqlCommand(String command) {
		Statement statement = this.mySqlManager.getStatement();

		try {

				this.resultSet = statement.executeQuery(command);
				System.out.println("执行了sql语句");
		} catch (SQLException e) {
			System.out.println("sqlCommand执行错误：请检查Sql语句");
		}
	}

	public ResultSet getResultSet() {
		return this.resultSet;
	}

	public void closeMySql() {
		if (!mySqlManager.isConnection()) {
			mySqlManager.closeMySqlConnection();
		}
	}
}
