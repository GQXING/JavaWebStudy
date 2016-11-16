package com.gqx.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//将同一个路径下的通名称的cookie删除掉
		////要注意的是只要cookie的名字相同就好就好，比如这里的cookie的名字叫做“age”,注意在上面的代码中我们也设置同样的“age”
		Cookie cookie=new Cookie("age", "XXX");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		System.out.println("删除成功！");
	}

}
