package base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Student;
import base.dao.StudentDaoImpl;
@WebServlet("/reg")
public class StudentRegServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Integer sid=Integer.parseInt(req.getParameter("sid"));
		String sname=req.getParameter("sname");
		Double sfee=Double.parseDouble(req.getParameter("sfee"));
		
		Student std=new Student();
		std.setSid(sid);
		std.setSname(sname);
		std.setSfee(sfee);
		
		Integer id=new StudentDaoImpl().saveStudent(std);
		
		req.setAttribute("msg", "Student Info added with ID "+id);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);;
		
	}

}
