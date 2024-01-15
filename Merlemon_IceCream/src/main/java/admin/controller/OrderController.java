package admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


import admin.dao.OrderDAO;
import admin.model.CartBean;
import admin.model.MenuBean;
import admin.model.OrderBean;

/**
 * Servlet implementation class OrderController
 */
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        dao = new OrderDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("orders", OrderDAO.getAllOrders());
		RequestDispatcher view = request.getRequestDispatcher("order.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		OrderBean o = new OrderBean();
		CartBean c = new CartBean();
		MenuBean m = new MenuBean();
		
	//	int staffId = Integer.parseInt((String) session.getAttribute("staffId"));
		o.setCartId(Integer.parseInt(request.getParameter("orderId")));
		
		
		dao.addOrder(o); //invoke method addStaff() in AdminDAO
		
		request.setAttribute("orders", OrderDAO.getAllOrders());
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
		
		double totalPrice = 0.0;
		totalPrice = c.getQuantity()*m.getMenuPrice();

	}

}
