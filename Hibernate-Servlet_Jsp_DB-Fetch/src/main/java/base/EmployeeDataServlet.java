package base;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/all")
public class EmployeeDataServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IEmployeeDao ido=new EmployeeDaoImpl();
		List<Employee> emps=ido.getAllEmp();

		//Sending data to UI as Attribute
		req.setAttribute("list", emps);

		//Goto UI page : Data.jsp
		RequestDispatcher rd=req.getRequestDispatcher("Data.jsp");
		rd.forward(req, resp);
	}
}
