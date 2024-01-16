package admin.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.db.ConnectionManager;
import admin.model.AdminBean;
import admin.model.CartBean;

public class CartDAO {

	static Connection con = null;
	static PreparedStatement ps = null;
	static PreparedStatement ps2 = null;
	static java.sql.Statement stmt = null;
	static ResultSet rs = null;
	static ResultSet rs2 = null;
	private String menuName;
	private int cartId, quantity, menuId;
	private double totalPrice;

	// addCart

	public void addCart(CartBean cartbean) {

		quantity = cartbean.getQuantity();
		totalPrice = cartbean.getTotalPrice();
		menuId = cartbean.getMenuId();

		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();
//					generated id return
//					RETURN_GENERATED_KEYS = 
			// 3. create statement
			ps = con.prepareStatement("INSERT INTO cart(menuName)VALUES(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, menuName);

			// 4. execute query
			int id = 0;
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected == 0) {
				System.out.println("Creating cart failed, no rows affected.");
			}

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = generatedKeys.getInt(1);
				} else {
					System.out.println("Creating cart failed, no ID obtained.");
				}
			}

			ps2 = con.prepareStatement("INSERT INTO menu_cart(menuId, cartId) VALUES(?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps2.setInt(1, menuId);
			ps2.setInt(2, id); // Fix: Set the second parameter

			ps2.executeUpdate();

			System.out.println("Successfully inserted");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// get all carts
	public static List<CartBean> getAllCarts() {
		List<CartBean> carts = new ArrayList<CartBean>();

		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM menu_cart ORDER BY cartId";
//					String sql2 = "SELECT * FROM menu_cart ORDER BY cartId";

			// 4. execute query
			rs = stmt.executeQuery(sql);
//					rs2 = stmt.executeQuery(sql2);

			while (rs.next()) { // process result
				CartBean c = new CartBean();
				c.setCartId(rs.getInt("cartId"));
//						c.setQuantity(rs.getInt("quantity"));
//						c.setTotalPrice(rs.getDouble("totalPrice"));
				c.setMenuId(rs.getInt("menuId"));
				carts.add(c);
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return carts;
	}

	// get cart by id

	public static CartBean getCartById(int id) {
		CartBean c = new CartBean();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			ps = con.prepareStatement("SELECT * FROM cart WHERE cartId=?");
			ps.setInt(1, id);

			// 4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {
				c.setCartId(rs.getInt("cartId"));
				c.setQuantity(rs.getInt("quantity"));
				c.setTotalPrice(rs.getDouble("totalPrice"));
				c.setMenuId(rs.getInt("menuId"));
			}
			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public void deleteCart(int id) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			ps = con.prepareStatement("DELETE FROM menu_cart WHERE cartId = ?");

			ps.setInt(1, id);

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Record with id " + id + " deleted successfully.");
			} else {
				System.out.println("No record found with id " + id + ". Deletion failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle exceptions appropriately
		}
	}

}
