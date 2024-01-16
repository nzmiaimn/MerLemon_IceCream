package admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import admin.dao.AdminDAO;
import admin.model.AdminBean;

/**
 * Servlet implementation class ProfileController
 */
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO dao = new AdminDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int staffId = Integer.parseInt(request.getParameter("staffId"));
		request.setAttribute("s", AdminDAO.getStaffById(staffId));
		RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
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
		this.dao.updateStaff(s);
		request.setAttribute("staffs", AdminDAO.getAllStaffs());
		RequestDispatcher view = request.getRequestDispatcher("staff.jsp");
		view.forward(request, response);
	}

}
