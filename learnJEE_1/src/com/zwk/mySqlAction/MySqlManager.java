package com.zwk.mySqlAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlManager {
	private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String url = null;
	private String user = null;
	private String pwd = null;
	private String databaseName = null;
	private volatile Statement statement = null;
	private boolean isConnection = false;
	private Connection connection = null;

	public boolean isConnection() {
		return isConnection;
	}

	private static ThreadLocal<MySqlManager> threadLocal = new ThreadLocal<MySqlManager>();

	private MySqlManager() {
	}

	public MySqlManager(String mySqlIpAddress,
						String user, String pwd,
						String databaseName) {
		this.user = user;
		this.pwd = pwd;
		this.databaseName = databaseName;
		url = "jdbc:mysql://" + mySqlIpAddress + ":3306/" + databaseName +
				"?serverTimezone=GMT&characterEncoding=utf-8&useSSL=false";
	}

	public void connectionMySql() {
		try {
			Class.forName(JDBC_DRIVER);
			this.connection = DriverManager.getConnection(url, user, pwd);
			this.statement = connection.createStatement();
			this.isConnection = !connection.isClosed();
		} catch (ClassNotFoundException e) {
			System.out.println("clss没有找到");
		} catch (SQLException e2) {
			System.out.println("sql 错误");
		}
	}

	public Statement getStatement() {
		return statement;
	}

	public boolean closeMySqlConnection() {
		try {
			this.statement.close();
			this.connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
