package admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.http.HttpSession;

import admin.dao.AdminDAO;
import admin.db.ConnectionManager;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null;
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession Session = request.getSession();
		try {
			con = ConnectionManager.getConnection();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			PreparedStatement ps = con.prepareStatement("SELECT username FROM staff WHERE username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			 
			String username2 = String.valueOf(AdminDAO.getIdStaff(username));
			System.out.println("id : " + username2);
			if (rs.next() && username.contains("admin")) {
				Session.setAttribute("staffId", username2);
				RequestDispatcher rd = request.getRequestDispatcher("home.html");
				rd.forward(request, response);
			} else {
				Session.setAttribute("staffId", username2);
//				RequestDispatcher rd = request.getRequestDispatcher("ViewMenuController.java");
//				rd.forward(request, response);
				response.sendRedirect("http://localhost:8080/Merlemon_IceCream/ViewMenuController");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
