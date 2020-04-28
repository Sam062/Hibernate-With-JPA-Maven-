package base.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.EmployeeAdhar;
import base.dao.EmployeeDaoImpl;

@WebServlet("/data")
public class AllDataFetchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		List<EmployeeAdhar> list=new EmployeeDaoImpl().getAllEmp();

		req.setAttribute("list", list);
		req.getRequestDispatcher("data.jsp").forward(req, resp);
	}
}
