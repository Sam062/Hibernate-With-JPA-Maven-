package base.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import base.EmployeeAdhar;
import base.dao.EmployeeDaoImpl;

@WebServlet("/update")
public class UpdateEmpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {

		Integer eid=Integer.parseInt(req.getParameter("eid"));
		System.out.println(eid);
		
		EmployeeAdhar ea=new EmployeeAdhar();
		ea.setEmpID(eid);
		ea.setEmpName(req.getParameter("ename"));
		ea.setAddress(req.getParameter("addr"));
		ea.setDepartment(req.getParameter("dept"));
		ea.setEmpSal(Double.parseDouble(req.getParameter("esal")));
		ea.setGender(req.getParameter("gen"));
		ea.setMobileNo(req.getParameter("mob"));
		
		//for Date---------------------------------------------
		java.util.Date d=null;;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			d = sdf.parse(req.getParameter("dob"));
		} catch (ParseException e) {
			System.out.println("----------------- DATE COULDN'T PARSE ------------");
			e.printStackTrace();
		}
		ea.setDob(d);//Date ends----------------------------
		
		StringBuilder msg=new EmployeeDaoImpl().updateEmp(ea);
		req.setAttribute("msg", msg);
		
		List<EmployeeAdhar> list=new EmployeeDaoImpl().getAllEmp();
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("data.jsp").forward(req, resp);
	}
}
