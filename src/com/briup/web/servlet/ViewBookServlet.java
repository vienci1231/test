package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Book;
import com.briup.service.IBookService;
import com.briup.service.impl.BookServiceImpl;
/**
 * @author matingting
 * 查询单本书籍信息
 */
@WebServlet("/view")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接收前台传递的书籍id
		String id = request.getParameter("id");
		//2.调用service获取到这个id所对应的书籍信息
		IBookService service = new BookServiceImpl();
		//String-----int
		Book book = service.findBookById(Integer.parseInt(id));
		//3.将书籍信息保存
		request.getSession().setAttribute("book", book);
		//4.跳转到viewBook.jsp页面 显示书籍的详细信息
		request.getRequestDispatcher("/WEB-INF/viewBook.jsp").
					forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
