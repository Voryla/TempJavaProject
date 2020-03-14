package com.zwk.loadLog4jServlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

/**
 * 关于log4j在web项目中的设置
 * 1.在src目录中添加log4j.properties配置文件
 * 2.在项目和web/WEB-INF中添加lib文件夹添加log4j-1.2.16.jar(重点！！切记)
 * 3.创建log4j加载Servlet在web.xml中添加<servlet>在其中添加<init-param>
 * 来保存log4j配置文件在项目中的路径，设置<load-on-startup>1</load-on-startup>优先启动
 * 4.在servlet类中重写init方法，使用方法中ServletConfig参数调用本servlet的<init-param>参数
 * 得到log4j配置文件在项目中的路径，再使用ServletContext.getRealPath("/");获取项目根目录
 * 拼接字符串判断文件是否存在，如果存在PropertyConfigurator.configure(拼接后的路径字符串);
 * 不存在使用BasicConfigurator.configure();
 */
public class LoadLog4jServlet extends HttpServlet {
	public LoadLog4jServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String log4jInWebPath = config.getInitParameter("log4jInWebPath");
		if (log4jInWebPath == null) {
			BasicConfigurator.configure();
		} else {
			String webAppPath = config.getServletContext().getRealPath("/");
			String path = webAppPath + log4jInWebPath;
			if (new File(path).exists()) {
				PropertyConfigurator.configure(path);
				System.out.println("Log4j加载成功");
				this.getServletConfig().getServletContext().setAttribute("a", "bbbbbb");
			} else {
				BasicConfigurator.configure();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
