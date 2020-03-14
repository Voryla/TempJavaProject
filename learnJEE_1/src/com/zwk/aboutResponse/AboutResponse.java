package com.zwk.aboutResponse;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutResponse extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.设置Http相应行中的状态码(了解即可)
		resp.setStatus(200);

		// 2.设置响应头
		/**
		 * 1.addHeader(StringKey，Value)方法在响应头中添加一个键值对，如果添加同一键
		 * 那么类似于数组 name={"张三","李四"}
		 */
		resp.addHeader("name", "nameA");
		resp.addHeader("name", "nameB");
		/**
		 *  2.setHeader(StringKey,Value)方法在响应头中添加一个键值对，如果添加同一键
		 *  那么会覆盖前一个的内容
		 */
		resp.setHeader("myName", "zwk");
		resp.setHeader("myName", "mmr");

		// 3.设置字节码格式
		// 方式一
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		// 方式二
		resp.setContentType("text/html;charset=UTF-8");

		// 4.重定向
		/**
		 * 1.设置相应行状态码为302:重定向
		 * 2.设置请求头StringKey=Location value="tomcat的项目名/servlet名称与项目中web文件夹下的资源"
		 */
		resp.setStatus(302);
		// servlet
		resp.setHeader("Location", "/loginProject/useServletContext");
		// web下的资源名
		resp.setHeader("Location", "/loginProject/index.jsp");
		// 也可以是网址
		resp.setHeader("Location", "http://www.baidu.com");
		// Servlet封装好的重定向方法
		resp.sendRedirect("http://www.baidu.com");

		// 5.定时刷新,类似于重定向
		resp.setHeader("Refresh","3;http://www.baidu.com");
		// 6.当前包下有javaScript实现的计时跳转html
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
