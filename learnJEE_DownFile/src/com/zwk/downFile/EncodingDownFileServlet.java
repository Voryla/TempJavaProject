package com.zwk.downFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 解决中文名称文件下载问题
 */
public class EncodingDownFileServlet extends HttpServlet {
	public EncodingDownFileServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取a标签传入的参数，得到文件名
		String fileName=req.getParameter("fileName");

		// 2.给资源设置后缀名，参数为字符串即将给定一个文件名(加后缀名的)设置文件类型。
		// 或者传入后缀名字符串如：".jpg"
		resp.setContentType(this.getServletContext().getMimeType(fileName));

		// 设置响应头对中文名进行URL格式编码,否则浏览器在下载时不能正常的解析文件的中文名(重点)
		String fileNameEncoder= URLEncoder.encode(fileName,"utf-8");

		// 3.设置响应头 文件将只能下载，浏览器不再解析文件
		resp.setHeader("Content-Disposition","attachment;filename="+fileNameEncoder);

		// 4.获取文件的路径，可为网站路径
		// 也可为本地路径(当为本地路径时即不能采用ServletContext获取，而是自己向办法得到路径)
		String fileLocationPath=this.getServletContext().getRealPath("/fileSource/"+fileName);

		BufferedInputStream in=new BufferedInputStream(new FileInputStream(fileLocationPath));
		BufferedOutputStream out=new BufferedOutputStream(resp.getOutputStream());
		int len=0;
		byte[] bytes=new byte[1024];
		while (0<(len=in.read(bytes))){
			out.write(bytes,0,len);
		}
		in.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req,resp);
	}
}
