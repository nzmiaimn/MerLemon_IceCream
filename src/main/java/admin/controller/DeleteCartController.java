package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import admin.dao.CartDAO;
import admin.model.CartBean;

/**
 * Servlet implementation class DeleteCartController
 */
public class DeleteCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCartController() {
		super();
		dao = new CartDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		CartBean c = new CartBean();

		dao.deleteCart(Integer.parseInt(request.getParameter("id")));
		
		response.sendRedirect(request.getContextPath() + "/ViewMenuController");
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
