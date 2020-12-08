package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.ShopCar;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

/**
 *登陆功能
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接收前台的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//2.调用service完成逻辑处理
		ICustomerService service = new CustomerServiceImpl();
		
		String path = "";
		HttpSession session = request.getSession();
		
		//3.根据service的逻辑处理反馈给前台不同的响应
		try {
			Customer customer = service.login(name, password);
			//创建购物车对象
			ShopCar car = new ShopCar();
			session.setAttribute("car", car);
			//将用户的登陆信息保存，作为用户是否登陆的判断依据
			session.setAttribute("customer", customer);
			path="/WEB-INF/index.jsp";
		} catch (Exception e) {
			session.setAttribute("msg", e.getMessage());
			path="/WEB-INF/login.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
