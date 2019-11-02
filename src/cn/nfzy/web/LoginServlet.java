package cn.nfzy.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nfzy.domain.user;
import cn.nfzy.service.UserService;
import cn.nfzy.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收浏览器提交过来的数据
  		String username=request.getParameter("username");
  		String password=request.getParameter("password");
  		System.out.println("用户："+username+",密码是："+password);
  		
  		//将得到的数据封装到user对象中
  		user user=new user();
  		user.setUsername(username);
  		user.setPassword(password);
  		//去调用service接口完成登录验证
  		UserService userser=new UserServiceImpl();
  		int rsin=userser.findByName(user);
        String message="";
  		switch(rsin) {
  		case 0:
  			message="没有该用户";
  			request.getRequestDispatcher("login.jsp").forward(request, response);
  			break;
  		case 1:
  			message=username;
  			request.setAttribute("username", message);
  	  		request.getRequestDispatcher("main.jsp").forward(request, response);
  			break;
  		case 2:
  			message="密码错误";
  			request.getRequestDispatcher("login.jsp").forward(request, response);
  			break;
  		}
  		
  		

  	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
