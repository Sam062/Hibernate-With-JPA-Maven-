package base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class EmployeeReg extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empID=req.getParameter("eid");
		String empName=req.getParameter("ename");
		String empSal=req.getParameter("esal");

		Integer eid=Integer.parseInt(empID);
		Double esal=Double.parseDouble(empSal);

		Employee e=new Employee();
		e.setEid(eid);
		e.setEname(empName);
		e.setEsal(esal);

		IEmployeeDao edo=new EmployeeDaoImpl();
		Integer id=edo.saveEmp(e);

		String msg="Employee saved with id :"+id;
		req.setAttribute("msg", msg);

		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
}
