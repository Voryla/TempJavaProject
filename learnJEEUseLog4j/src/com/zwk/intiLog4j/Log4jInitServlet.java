package com.zwk.intiLog4j;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

@WebServlet("/initLog4jServlet")
public class Log4jInitServlet extends HttpServlet {
	public Log4jInitServlet(){super();}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 获取初始化参数得到配置文件在项目中的路径
		String log4jLocation=config.getInitParameter("log4jInitFile");
		ServletContext servletContext=config.getServletContext();
		if(log4jLocation==null){
			System.err.println("*** 没有 log4j-properties-location 初始化的文件, 所以使用 BasicConfigurator初始化");
			BasicConfigurator.configure();
		}else {
			// 得到根目录的绝对路径
			String webAppPath=servletContext.getRealPath("/");
			// 拼接根目录的绝对路径和配置文件路径
			String log4jProp=webAppPath+log4jLocation;
			File log4jFile=new File(log4jProp);
			if(log4jFile.exists()){
				System.out.println("使用: " + log4jProp+"初始化日志设置信息");
				PropertyConfigurator.configure(log4jProp);
			}else {
				System.err.println("*** " + log4jProp + " 文件没有找到， 所以使用 BasicConfigurator初始化");
				BasicConfigurator.configure();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
