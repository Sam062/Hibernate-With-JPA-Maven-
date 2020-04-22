package base.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Customer;
import base.dao.CustomerDaoImpl;

@WebServlet("/update")
public class CustomerUpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Integer cid=Integer.parseInt(req.getParameter("cid"));
		String cname=req.getParameter("cname");
		Double csal=Double.parseDouble(req.getParameter("csal"));

		Customer c=new Customer();
		c.setCid(cid);c.setCname(cname);c.setCsal(csal);

		StringBuilder msg=new CustomerDaoImpl().updateCustomer(c);
		req.setAttribute("msg", msg);

		List<Customer> list=new CustomerDaoImpl().getAllCustomers();
		req.setAttribute("list", list);
		req.getRequestDispatcher("data.jsp").forward(req, resp);
	}

}
