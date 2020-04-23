package base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Employee;
import base.dao.EmployeeDaoImpl;

@WebServlet("/edit")
public class ShowEditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {

		Employee e=new EmployeeDaoImpl().getOneEmp(Integer.parseInt(req.getParameter("eid")));

		req.setAttribute("emp", e);
		req.getRequestDispatcher("edit.jsp").forward(req, resp);
	}
}
