package base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Customer;
import base.dao.CustomerDaoImpl;

@WebServlet("/reg")
public class CustomerRegServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {

		Integer cid=Integer.parseInt(req.getParameter("cid"));
		String cname=req.getParameter("cname");
		Double csal=Double.parseDouble(req.getParameter("csal"));

		Customer c=new Customer();
		c.setCid(cid);c.setCname(cname);c.setCsal(csal);

		Integer id=new CustomerDaoImpl().saveCustmer(c);

		StringBuilder msg=new StringBuilder("Customer Detail Inserted with ID :").append(id);
		req.setAttribute("msg", msg);

		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
