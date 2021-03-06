package base.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.EmployeeAdhar;
import base.dao.EmployeeDaoImpl;

@WebServlet("/reg")
public class EmployeeRegServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		
		java.util.Date d=null;;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("FORM DATE IS :---------------"+req.getParameter("dob"));
		try {
			d = sdf.parse(req.getParameter("dob"));
			System.out.println(d);
		} catch (ParseException e) {
			System.out.println("DATE NOT PARSED :- "+req.getParameter("dob"));
			e.printStackTrace();
		}

		EmployeeAdhar ea=new EmployeeAdhar();
		ea.setEmpName(req.getParameter("ename"));
		ea.setAddress(req.getParameter("addr"));
		ea.setDepartment(req.getParameter("dept"));
		ea.setEmpSal(Double.parseDouble(req.getParameter("esal")));
		ea.setGender(req.getParameter("gen"));
		ea.setMobileNo(req.getParameter("mob"));
		ea.setDob(d);

		Integer id=new EmployeeDaoImpl().insertEmp(ea);

		req.setAttribute("msg", "Employee Details Inserted : "+id);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
