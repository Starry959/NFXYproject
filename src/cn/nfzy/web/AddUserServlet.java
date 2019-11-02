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
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;chatset=utf-8");
		
		String loginName=request.getParameter("loginName");
		String password=request.getParameter("password");
		System.out.println("ע����Ϣ��"+loginName+"---->"+password);
		
		user user=new user();
		user.setUsername(loginName);
		user.setPassword(password);
		
		UserService us=new UserServiceImpl();
		int rsin=us.insertUser(user);
		if(rsin!=0) {
			System.out.println("����ɹ���Ӱ����"+rsin+"������");
			response.getWriter().append(rsin+"");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
