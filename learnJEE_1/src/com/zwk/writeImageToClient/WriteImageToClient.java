package com.zwk.writeImageToClient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 向也面写入图片
 */
public class WriteImageToClient extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("C:/Users/ZWK/Pictures/Saved Pictures/Bing/rb.jpg")));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(resp.getOutputStream());
		int len = 0;
		byte[] bytes = new byte[1024];
		while (-1 != (len = bufferedInputStream.read(bytes))) {
			bufferedOutputStream.write(bytes, 0, len);
		}
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}

}
