package base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Employee;
import base.dao.EmployeeDaoImpl;

@WebServlet("/add")
public class EmployeeRegServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		String ename=req.getParameter("ename");
		
		Employee e=new Employee();
		e.setEid(Integer.parseInt(req.getParameter("eid").trim()));
		e.setEname(ename.trim());
		e.setEsal(Double.parseDouble(req.getParameter("esal").trim()));
		
		Integer id=new EmployeeDaoImpl().saveEmp(e);
		
		req.setAttribute("msg", "Emplyee "+ename+" details Added.");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
