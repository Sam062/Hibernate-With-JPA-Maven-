package base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Customer;
import base.dao.CustomerDaoImpl;

@WebServlet("/edit")
public class CustomerShowEditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {

		Customer c=new CustomerDaoImpl().
				getOneCustomer(Integer.parseInt(req.getParameter("cid")));

		req.setAttribute("cob", c);

		req.getRequestDispatcher("edit.jsp").forward(req, resp);
	}

}
