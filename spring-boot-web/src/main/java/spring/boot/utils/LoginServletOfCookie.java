package spring.boot.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")//和web.xml配置冲突了
public class LoginServletOfCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getParameter("name");
		String password = (String) request.getParameter("password");
		System.out.println(name+"   "+password);
		Cookie cookie = new Cookie("jialei", "111111");
		cookie.setMaxAge(60);//设置60秒后被删除
		response.addCookie(cookie);
		Cookie[] cookies =  request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName()+"   "+cookies[i].getValue());
		}
		if("jialei".equals(name) && "123456".equals(password)) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
			//response.sendRedirect("success.jsp");
		}
	}

}
