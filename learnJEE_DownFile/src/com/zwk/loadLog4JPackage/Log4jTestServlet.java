package com.zwk.loadLog4JPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class Log4jTestServlet extends HttpServlet {
	public Log4jTestServlet(){super();}
	private static Logger logger=Logger.getLogger(Log4jTestServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.error("测试成功");
		logger.info("测试成功");
		logger.debug("测试成功");
	}
}
