package com.zwk.learnServletContext;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取web应用的ServletContext，以及使用方法
 * ServletContext的作用
 * 1.获取web.xml中使用<context-param>标记的全局变量
 * 2.获取web应用下的任何资源的绝对路径（重要！！！）
 * 2.ServletContext是一个域对象
 */
public class GetServletContext extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 如果本类重写了init方法一定要在方法中调用
		// 父类的init方法并将本类init方法中的ServletConfig参数传入给父类init方法
		// super.init(config);
		// 否则无法使用this.getServletConfig()方法会空指针异常
		super.init(config);
		// 获取ServletContext 的方法
		// 方式一:使用init方法的参数ServletConfig获取,只能在
		ServletContext context = config.getServletContext();
		ServletContext context1 = this.getServletConfig().getServletContext();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 解决中文乱码 两种方式
		resp.setContentType("text/html;charset=utf-8");
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		// 获取相应输出流
		PrintWriter printWriter = resp.getWriter();
		// 获取ServletContext 的方法
		// 方式二:使用继承自父类的getServletContext()方法获取
		// 注意！！！ 该方式获取时如果本类重写了init方法一定要在方法中调用
		// 父类的init方法并将本类init方法中的ServletConfig参数传入给父类init方法
		// super.init(config);
		ServletContext servletContext = this.getServletContext();

		// ServletContext的作用一
		// 获取context初始化全局变量指向web.xml中
		// 	  <context-param>
		//        <param-name>jdbcDriver</param-name>
		//        <param-value>com.mysql.cj.jdbc.Driver</param-value>
		//    </context-param>
		String jdbcDriver = servletContext.getInitParameter("jdbcDriver");
		printWriter.write("<h1>" + jdbcDriver + "</h1>");

		// ServletContext作用二：获取web应用下的任何资源的绝对路径
		// getRealPath()方法的参数为：相对于该web应用的相对地址，返回该资源的绝对路径
		// web应用为j2ee项目的web文件夹，当使用tomcat发布时会在该工程目录下的out文件夹中并以该项目命名
		String path = servletContext.getRealPath("笔记.txt");
		printWriter.write("<h1>" + path + "</h1>");

		// getResource()的参数是一个相对地址 获取相对于classes的绝对路径
		String getPathFromClasses = GetServletContext.class.getClassLoader().getResource("com/zwk/learnServletContext/1.html").getPath();
		printWriter.write("<h1>" + getPathFromClasses + "</h1>");

		// ServletContext的作用三：ServletContext域对象
		// 1.整个web项目中可以有多少个Servlet但只有一个ServletContext域对象
		// 2.ServletContext域对象的作用范围：整个web项目（所有web资源(Servlet、jsp等)都可以随意向ServletContext域对象，
		// 中存取数据，数据可以共享 ）
		// 存方法setAttribute(String,Object); 取出数据方法getAttribute(String)一般在其他web资源中取;
		servletContext.setAttribute("name", "zwk");
		servletContext.getAttribute("name");
		servletContext.removeAttribute("name");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
