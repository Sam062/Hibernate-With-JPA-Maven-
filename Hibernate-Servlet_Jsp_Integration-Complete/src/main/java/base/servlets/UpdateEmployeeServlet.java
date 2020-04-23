package base.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Employee;
import base.dao.EmployeeDaoImpl;
import base.dao.IEmployeeDAO;

@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		Employee e=new Employee();
		e.setEid(Integer.parseInt(req.getParameter("eid")));
		e.setEname(req.getParameter("ename"));
		e.setEsal(Double.parseDouble(req.getParameter("esal")));

		IEmployeeDAO ied=new EmployeeDaoImpl();
		ied.updateEmp(e);

		req.setAttribute("msg", "Employee "+e.getEname()+" details Updated.");

		List<Employee> list=ied.getAllEmp();
		req.setAttribute("listOfEmployees", list);
		
		req.getRequestDispatcher("data.jsp").forward(req, resp);
	}
}
