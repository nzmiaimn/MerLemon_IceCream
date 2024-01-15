package admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import admin.dao.AdminDAO;
import admin.model.AdminBean;

import java.io.IOException;

/**
 * Servlet implementation class StaffController
 */
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("staffs", AdminDAO.getAllStaffs());
		RequestDispatcher view = request.getRequestDispatcher("staff.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminBean s = new AdminBean();
		s.setUsername(request.getParameter("username"));
		s.setPassword(request.getParameter("password"));
		
		
		dao.addStaff(s); //invoke method addStaff() in AdminDAO
		
		request.setAttribute("staffs", AdminDAO.getAllStaffs());
		RequestDispatcher view = request.getRequestDispatcher("staff.jsp");
		view.forward(request, response);
	}

}