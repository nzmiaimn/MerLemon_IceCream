package admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.util.codec.binary.Base64;

import admin.dao.AdminDAO;
import admin.dao.MenuDAO;
import admin.model.MenuBean;

/**
 * Servlet implementation class UpdateMenuController
 */
@MultipartConfig
public class AddMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO adminDAO;
	private MenuDAO menuDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public AddMenuController() {
		super();
		adminDAO = new AdminDAO();
		menuDAO = new MenuDAO();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub		
		request.setAttribute("menus", MenuDAO.getAllMenus());
		RequestDispatcher view = request.getRequestDispatcher("listmenu.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MenuBean m = new MenuBean();
		HttpSession session = request.getSession();
		String menuName = request.getParameter("menuName");
		double menuPrice = Double.valueOf(request.getParameter("menuPrice"));
		System.out.println(session.getAttribute("staffId"));
		int staffId = Integer.parseInt((String) session.getAttribute("staffId"));
		Part imageS = request.getPart("imageS");

		InputStream imageInputStream = imageS.getInputStream();

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int bytesRead;
		while ((bytesRead = imageInputStream.read(buffer)) != -1) {
			byteArrayOutputStream.write(buffer, 0, bytesRead);
		}
		byte[] image = byteArrayOutputStream.toByteArray();
		imageInputStream.close();
		System.out.println("staff id : " + staffId);
		m.setMenuName(menuName);
		m.setMenuPrice(menuPrice);
		m.setImage(image);
		m.setStaffId(staffId);

		MenuBean addMenu = menuDAO.addMenu(m);
		request.setAttribute("addMenu", addMenu);

		response.sendRedirect(request.getContextPath() + "/listmenu.jsp");
	}



}
