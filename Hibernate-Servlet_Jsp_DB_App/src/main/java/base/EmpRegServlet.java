package base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.dao.EmployeeDaoImpl;
import base.dao.IEmployeeDao;
@WebServlet("/reg")
public class EmpRegServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//Read form data
		String empId=req.getParameter("eid");
		String empName=req.getParameter("ename");
		String empSal=req.getParameter("esal");

		int eid=Integer.parseInt(empId);
		double esal=Double.parseDouble(empSal);

		Employee e=new Employee();
		e.setEid(eid);
		e.setEname(empName);
		e.setEsal(esal);

		IEmployeeDao ied=new EmployeeDaoImpl();
		Integer id=ied.saveStudent(e);
		
		// Construct message and send to UI
		String msg="DATA Inserted with ID :"+id;
		req.setAttribute("msg", msg);

		// Move to JSP Page using Dispatcher
		RequestDispatcher rd=req.getRequestDispatcher("EmployeeReg.jsp");
		rd.forward(req, resp);
	}
}
