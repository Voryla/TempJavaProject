package com.zwk.servlets;

import com.zwk.mySqlAction.MySqlManager;
import com.zwk.mySqlAction.MySqlSolution;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUserLogin extends HttpServlet {
	MySqlSolution sqlSolution;
	ResultSet resultSet;
	int count=0;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sqlSolution = new MySqlSolution(new MySqlManager(
				"localhost", "root", "123456",
				"servletLogin"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		// 解决中文乱码问题
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		sqlSolution.connectionMysql();
		try {
			String sqlCommand = ("SELECT * FROM users WHERE name='" + user + "' AND pwd='" + pwd + "'");
			sqlSolution.doSqlCommand(sqlCommand);
			resultSet = sqlSolution.getResultSet();
			boolean isLogin = false;
			// resultSet需要使用while(resultSet.next())游标来得到数据
			while (resultSet.next()) {
				isLogin = user.equals(resultSet.getString("name"));
			}
			if (isLogin) {
				resp.getWriter().write("<h1>登陆成功</h1>");
				//计数
				count++;
			} else {
				resp.getWriter().write("<h1>登陆失败</h1>");
			}
		} catch (SQLException e) {

		} finally {
			resp.getWriter().write("<h1>"+count+"</h1>");
			sqlSolution.closeMySql();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req,resp);
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
