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

@WebServlet("/data")
public class CustomerDataServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {

		List<Customer> list=new CustomerDaoImpl().getAllCustomers();
		req.setAttribute("list", list);

		req.getRequestDispatcher("data.jsp").forward(req, resp);
	}

}
