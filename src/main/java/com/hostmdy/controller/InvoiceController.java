package com.hostmdy.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Invoice;
import com.hostmdy.model.InvoiceDAO;
import com.hostmdy.model.Petrol;
import com.hostmdy.model.PetrolDAO;
import com.hostmdy.model.User;
import com.hostmdy.model.UserDAO;

/**
 * Servlet implementation class InvoiceController
 */
public class InvoiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/petrolWeb")
	private DataSource dataSource;

	private InvoiceDAO invoiceDAO;
	
	private PetrolDAO petrolDAO;

	@Override
	public void init() throws ServletException {
		invoiceDAO = new InvoiceDAO(dataSource);
		petrolDAO = new PetrolDAO(dataSource);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvoiceController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			String mode = request.getParameter("mode");
			if (mode == null) {
				mode = "LIST";
			}
			switch (mode) {
			case "LIST":
				showInvoice(request, response);
				break;
			case "CREATE":
				createInvoice(request, response);
			default:
				showInvoice(request, response);
				break;
			}
		} else {
			response.sendRedirect("login");
		}
	}

	private void showInvoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Invoice> invoiceList = invoiceDAO.getAllInvoice();
		request.setAttribute("invoiceList", invoiceList);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("invoice.jsp");
		dispatch.forward(request, response);
	}

	private void createInvoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request);
//		String username = request.getParameter("username");
//		String email = request.getParameter("email");
		String petrol_type = request.getParameter("petrol_type");
		Integer id=Integer.parseInt(petrol_type);
		System.out.println(petrol_type);
		Double qty = Double.parseDouble(request.getParameter("amount"));
//		Double total_price = Double.parseDouble(request.getParameter("total_price"));
//		String rawDate = request.getParameter("date");
//		LocalDate date = LocalDate.parse(rawDate);
		Petrol petrol = petrolDAO.getPetrolListById(id);
		System.out.println(petrol.toString());
		Double uni_price= petrol.getUnit_price();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user.getUsername());
		Double total_price = uni_price * qty;
		Invoice invoice = new Invoice(user.getUsername(), user.getEmail(), petrol.getPetrol_type(), qty, total_price, LocalDate.now());
		System.out.println("Invoice is"+invoice.toString());
		int rowUpdated = invoiceDAO.createInvoice(invoice);
		System.out.println("Row Update ="+rowUpdated);
		if (rowUpdated > 0) {
			showUserInvoice(request, response,invoice);
		}else {
			request.setAttribute("errorTitle", "Fail To Create");
			request.setAttribute("errorMessage", "Please Check Your Data Again");
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
		}
	}

	

	private void showUserInvoice(HttpServletRequest request, HttpServletResponse response, Invoice invoice) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("invoice", invoice);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("userInvoice.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
