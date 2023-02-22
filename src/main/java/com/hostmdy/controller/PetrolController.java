package com.hostmdy.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Invoice;
import com.hostmdy.model.InvoiceDAO;
import com.hostmdy.model.Petrol;
import com.hostmdy.model.PetrolDAO;
import com.hostmdy.model.User;

/**
 * Servlet implementation class PetrolController
 */
public class PetrolController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/petrolWeb")
	private DataSource dataSource;

	private PetrolDAO petrolDAO;

	private InvoiceDAO invoiceDAO;

	@Override
	public void init() throws ServletException {
		petrolDAO = new PetrolDAO(dataSource);
		invoiceDAO = new InvoiceDAO(dataSource);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PetrolController() {
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
//		if (mode == null) {
//			mode = "LIST";
//			switch (mode) {
//			case "LIST":
//				showPage(request, response);
//				break;
//			default:
//				showPage(request, response);
//				break;
//			}
//		}
		if (user != null) {
			String mode = request.getParameter("mode");

			if (mode == null) {
				mode = "LIST";
			}

			switch (mode) {
			case "LIST":
				showPage(request, response);
				break;
			case "CREATE":
				createPetrol(request, response);
				break;
			case "LOAD":
				loadPetrol(request, response);
				break;
			case "LOADALL":
				loadAllPetrol(request, response);
				break;
			case "UPDATE":
				updatePetrol(request, response);
				break;
			case "DELETE":
				deletePetrol(request, response);
				break;
			case "PAGE":
				loadPage(request, response);
				break;
			case "SHOP":
				showPetrolType(request, response);
				break;
			default:
				showPage(request, response);
				break;
			}
		}
	}


	private void showPetrolType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Petrol> petrolList = petrolDAO.getAllPetrol();
		request.setAttribute("petrolList", petrolList);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		RequestDispatcher dispatch = request.getRequestDispatcher("shoppetrol.jsp");
		dispatch.forward(request, response);

	}

	private void showPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Petrol> petrolList = petrolDAO.getAllPetrol();
		request.setAttribute("petrolList", petrolList);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
		dispatch.forward(request, response);
	}

	private void createPetrol(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String petrol_type = request.getParameter("petrol_type");
		Double quantity = Double.parseDouble(request.getParameter("quantity"));
		Double unit_price = Double.parseDouble(request.getParameter("unit_price"));
		Boolean instock = Boolean.parseBoolean(request.getParameter("instock"));

		Petrol petrol = new Petrol(petrol_type, quantity, unit_price, instock);

		int rowUpdated = petrolDAO.createPetrol(petrol);

		if (rowUpdated > 0) {
			loadAllPetrol(request, response);
		} else {
			request.setAttribute("errorTitle", "Fail To Create");
			request.setAttribute("errorMessage", "Please Check Your Data Again");
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			request.setAttribute("user", user);

			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void updatePetrol(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String petrol_type = request.getParameter("petrol_type");
		Double quantity = Double.parseDouble(request.getParameter("quantity"));
		Double unit_price = Double.parseDouble(request.getParameter("unit_price"));
		Boolean instock = Boolean.parseBoolean(request.getParameter("instock"));

		Petrol petrol = new Petrol(id, petrol_type, quantity, unit_price, instock);

		int rowUpdated = petrolDAO.updatePetrol(petrol);

		if (rowUpdated > 0) {
			loadAllPetrol(request, response);
		} else {
			request.setAttribute("errorTitle", "Fail To Create");
			request.setAttribute("errorMessage", "Please Check Your Data Again");
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			request.setAttribute("user", user);

			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void loadPetrol(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Petrol petrol = petrolDAO.getPetrolListById(id);
		request.setAttribute("petrol", petrol);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		RequestDispatcher dispatch = request.getRequestDispatcher("edit-petrol.jsp");
		dispatch.forward(request, response);
	}

	private void deletePetrol(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));

		int rowUpdated = petrolDAO.deletePetrol(id);

		if (rowUpdated > 0) {
			loadAllPetrol(request, response);
		} else {
			request.setAttribute("errorTitle", "Fail To Create");
			request.setAttribute("errorMessage", "Please Check Your Data Again");
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			request.setAttribute("user", user);

			RequestDispatcher dispatcher = request.getRequestDispatcher("error-page.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void loadPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		RequestDispatcher dispatch = request.getRequestDispatcher("add-petrol.jsp");
		dispatch.forward(request, response);
	}

	private void loadAllPetrol(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Petrol> petrolList = petrolDAO.getAllPetrol();
		request.setAttribute("petrolList", petrolList);

		List<Invoice> invoiceList = invoiceDAO.getAllInvoice();
		request.setAttribute("invoiceList", invoiceList);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		RequestDispatcher dispatch = request.getRequestDispatcher("dashboard.jsp");
		dispatch.forward(request, response);
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
