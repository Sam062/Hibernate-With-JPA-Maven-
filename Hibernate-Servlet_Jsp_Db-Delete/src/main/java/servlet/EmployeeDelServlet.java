package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Employee;
import base.dao.EmployeeDaoImpl;

@WebServlet("/del")
public class EmployeeDelServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		
		String a=req.getParameter("eid");
		System.out.println("EID WITHOUT PARSING"+a);
		Integer eid=Integer.parseInt(a);
		System.out.println("EID E+AFTER PARSING IS "+eid);
		String msg=new EmployeeDaoImpl().delEmp(eid);
		
		req.setAttribute("msg", msg);
		List<Employee> list=new EmployeeDaoImpl().getAllEmp();
		req.setAttribute("list", list);
		req.getRequestDispatcher("data.jsp").forward(req, resp);
	}

}
