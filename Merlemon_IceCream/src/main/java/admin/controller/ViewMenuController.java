package admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import admin.dao.AdminDAO;
import admin.dao.CartDAO;
import admin.dao.MenuDAO;

/**
 * Servlet implementation class ViewMenuController
 */
public class ViewMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewMenuController() {
		super();
		dao = new AdminDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("carts", CartDAO.getAllCarts());
		request.setAttribute("menus", MenuDAO.getAllMenus());
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

}
