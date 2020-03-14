package com.zwk.myServer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyServletUseInterface implements Servlet {

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
		PrintWriter out=httpServletResponse.getWriter();
		out.write("<h1>Hello Use Interface<h1/>");
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init Running in MyServletUseInterface");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
