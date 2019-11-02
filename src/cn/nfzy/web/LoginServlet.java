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
		//����������ύ����������
  		String username=request.getParameter("username");
  		String password=request.getParameter("password");
  		System.out.println("�û���"+username+",�����ǣ�"+password);
  		
  		//���õ������ݷ�װ��user������
  		user user=new user();
  		user.setUsername(username);
  		user.setPassword(password);
  		//ȥ����service�ӿ���ɵ�¼��֤
  		UserService userser=new UserServiceImpl();
  		int rsin=userser.findByName(user);
        String message="";
  		switch(rsin) {
  		case 0:
  			message="û�и��û�";
  			request.getRequestDispatcher("login.jsp").forward(request, response);
  			break;
  		case 1:
  			message=username;
  			request.setAttribute("username", message);
  	  		request.getRequestDispatcher("main.jsp").forward(request, response);
  			break;
  		case 2:
  			message="�������";
  			request.getRequestDispatcher("login.jsp").forward(request, response);
  			break;
  		}
  		
  		

  	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
