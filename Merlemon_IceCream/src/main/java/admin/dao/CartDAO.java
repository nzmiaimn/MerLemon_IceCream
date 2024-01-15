package admin.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import admin.db.ConnectionManager;
import admin.model.AdminBean;
import admin.model.CartBean;

public class CartDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static java.sql.Statement stmt = null;
	static ResultSet rs = null;
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

					// 3. create statement
					ps = con.prepareStatement("INSERT INTO cart(menuId)VALUES(?)");
					ps.setInt(1, menuId);

					// 4. execute query
					ps.executeUpdate();
					System.out.println("Successfully inserted");

					// 5. close connection
					con.close();

				} catch (Exception e) {
					e.printStackTrace();

				}
			}

			//get all carts
			public static List<CartBean> getAllCarts() {
				List<CartBean> carts = new ArrayList<CartBean>();

				try {
					// call getConnection() method
					con = ConnectionManager.getConnection();

					// 3. create statement
					stmt = con.createStatement();
					String sql = "SELECT * FROM cart ORDER BY cartId";

					// 4. execute query
					rs = stmt.executeQuery(sql);

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
			
	

}
