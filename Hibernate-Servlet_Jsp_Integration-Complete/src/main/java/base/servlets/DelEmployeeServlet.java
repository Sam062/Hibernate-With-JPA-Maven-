package base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.dao.EmployeeDaoImpl;

@WebServlet("/del")
public class DelEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		new EmployeeDaoImpl().delEmp(Integer.parseInt(req.getParameter("eid")));

		req.setAttribute("msg", "Employee Details Removed.");
		req.setAttribute("listOfEmployees", new EmployeeDaoImpl().getAllEmp());
		req.getRequestDispatcher("data.jsp").forward(req, resp);

	}

}
