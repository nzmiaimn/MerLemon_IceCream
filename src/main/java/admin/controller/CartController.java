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
import admin.model.AdminBean;
import admin.model.CartBean;
import admin.model.MenuBean;

/**
 * Servlet implementation class CartController
 */
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
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
		request.setAttribute("carts", CartDAO.getAllCarts());
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CartBean c = new CartBean();
		MenuBean m = new MenuBean();
//		c.setQuantity(Integer.parseInt(request.getParameter("quantity")));
//		c.setTotalPrice(Double.parseDouble(request.getParameter("totalPrice")));
		c.setMenuId(Integer.parseInt(request.getParameter("menuId")));
		c.setMenuName(request.getParameter("menuName"));

		dao.addCart(c); // invoke method addCart() in CartDAO

//		request.setAttribute("carts", CartDAO.getAllCarts());
//		RequestDispatcher rd = request.getRequestDispatcher("ViewMenuController.java");
//		rd.forward(request, response);
//		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//		view.forward(request, response);
		response.sendRedirect("http://localhost:8080/Merlemon_IceCream/ViewMenuController");

		double totalPrice = 0.0;

		totalPrice = m.getMenuPrice() * c.getQuantity();
	}

}
