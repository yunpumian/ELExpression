package com.el;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

/**
 * @author 86152
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address address = new Address("成都市金堂县", "学府大道278号", "610499");
		Employee employee = new Employee("张三", "20181234@qq.com", "13800138000", address);
		request.setAttribute("employee", employee);

		RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
		rd.forward(request, response);
	}
}
