package com.zwk.loadLog4JPackage;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class LoadLog4JServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String log4jInWebProjectPath = config.getInitParameter("log4jInWebProjectPath");
		if (log4jInWebProjectPath != null) {
			String projectPath = config.getServletContext().getRealPath("/") + log4jInWebProjectPath;

			if (new File(projectPath).exists()) {
				PropertyConfigurator.configure(projectPath);
				System.out.println("存在log4j配置文件:log4j加载成功");
			} else {
				System.out.println("不存在log4j配置文件log4j加载失败");
				BasicConfigurator.configure();
			}
		} else {
			BasicConfigurator.configure();
			System.out.println("web.xml中没有log4j配置文件的路径值");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
