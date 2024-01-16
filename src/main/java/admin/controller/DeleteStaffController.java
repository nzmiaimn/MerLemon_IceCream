package admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import admin.dao.AdminDAO;

/**
 * Servlet implementation class DeleteStaffController
 */
public class DeleteStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStaffController() {
        super();
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteStaff(id);
		request.setAttribute("staffs", AdminDAO.getAllStaffs());
		RequestDispatcher view = request.getRequestDispatcher("staff.jsp");
		view.forward(request, response);
	}

	

}
