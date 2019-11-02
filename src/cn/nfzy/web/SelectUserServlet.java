package cn.nfzy.web;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nfzy.domain.user;
import cn.nfzy.service.UserService;
import cn.nfzy.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class SelectUserServlet
 */
@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询所有用户
		//调用Service
		UserService us=new UserServiceImpl();
		List<user> list=us.SelectUser();
		request.setAttribute("list", list);
		list.forEach(li->System.out.println(li));
		
		request.getRequestDispatcher("selectuser.jsp").forward(request, response);
		
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
