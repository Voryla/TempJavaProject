package com.zwk.aboutRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutRequest extends HttpServlet {
	public AboutRequest() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取Request请求行的内容
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		// 获取请求方式
		String method = req.getMethod();
		out.write("请求方式:" + method + "<br>");
		// 获取请求资源的相关内容
		String requestURI = req.getRequestURI();
		StringBuffer requestURL = req.getRequestURL();
		out.write("URI:" + requestURI + "<br>");
		out.write("URL:" + requestURL.toString() + "<br>");
		// 获取web应用名称
		String requestContextPath = req.getContextPath();
		out.write("web应用名称:" + requestContextPath + "<br>");
		// 地址后的参数字符串
		String queryString = req.getQueryString();
		out.write("地址后的参数字符串:" + queryString + "<br>");
		// 获取客户端的ip地址
		String ip = req.getRemoteAddr();
		out.write("ClientIp地址:" + ip + "<br>");

		// 乱码问题
		// get/post 都适用 iso8859-1格式是默认的解码格式 过程先使用iso8859-1编码获得utf-8的iso8859-1格式再使用utf-8解码
		String deCodenew = new String(req.getParameter("userName").getBytes("iso8859-1"), "utf-8");
		// 仅post使用
		req.setCharacterEncoding("utf-8");

		// 2.获取请求头的内容
		// 获取指定头名称的内容
		req.getHeader("headerName");
		// 获取所有头的名称 返回集合
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			// 获取名称
			String name = headerNames.nextElement();
			System.out.print(name);
			// 使用request.getHeader(headerName)获取相应头的内容
			String value = req.getHeader(name);
			System.out.println(value);
		}

		// 3.小案例：防盗链，防止他人的网站使用a标签盗用我网站的内容，对何处转跳进行判断
		// 获取访问的上一层链接，关键字 referer
		String header = req.getHeader("referer");
		// 如果是从本网站的a标签跳转的页面
		if (header != null && header.startsWith("http://localhost")) {
			// 展现内容
			System.out.println("展示内容");
		} else {
			System.out.println("不展示内容");
		}
		// 4.获取post/get传递的数据
		// 当一个key有多个value对应时使用
		String[] values = req.getParameterValues("name");
		// 当一个key对应一个value时使用
		String value = req.getParameter("name");
		// 获取所有请求参数的名称
		Enumeration<String> allNames = req.getParameterNames();
		// 获取参数并转化为Map
		Map<String, String[]> stringHashtable = req.getParameterMap();
		for (Map.Entry<String, String[]> entry : stringHashtable.entrySet()) {
			System.out.println(entry.getKey());
			for (String val : entry.getValue()) {
				System.out.println(val);
			}
		}

		// ServletContext整个web项目均可使用
		String s = (String) this.getServletContext().getAttribute("a");
		out.println("bbbbb");

		// 5.请求转发,如果当前servlet使用了getWriter()转发的servlet要使用output的话就会出现互斥现象
		// 解决方案调用转发前使用response.reset()方法清除response的缓存数据
		resp.reset();										//也可以转发至其他jsp等web项目资源
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/getImage");
		requestDispatcher.forward(req, resp);

		// 获取web应用名称，注意！只要项目中用的web应用名称请使用该方法动态获取使用+与其他资源名相连接
		req.getContextPath();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
