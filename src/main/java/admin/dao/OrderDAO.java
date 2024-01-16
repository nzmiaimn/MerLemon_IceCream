package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import admin.db.ConnectionManager;
import admin.model.CartBean;
import admin.model.OrderBean;

public class OrderDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static java.sql.Statement stmt = null;
	static ResultSet rs = null;
	private int cartId, staffId, orderId;
	
	// addOrder

				public void addOrder(OrderBean orderbean) {

					staffId = orderbean.getStaffId();
					cartId = orderbean.getCartId();
					
					try {
						// call getConnection() method
						con = ConnectionManager.getConnection();

						// 3. create statement
						ps = con.prepareStatement("INSERT INTO order(staffId, cartId)VALUES(?,?)");
						ps.setInt(1, staffId);
						ps.setInt(2, cartId);

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
				public static List<OrderBean> getAllOrders() {
					List<OrderBean> orders = new ArrayList<OrderBean>();

					try {
						// call getConnection() method
						con = ConnectionManager.getConnection();

						// 3. create statement
						stmt = con.createStatement();
						String sql = "SELECT * FROM order ORDER BY orderId";

						// 4. execute query
						rs = stmt.executeQuery(sql);

						while (rs.next()) { // process result
							OrderBean o = new OrderBean();
							o.setOrderId(rs.getInt("orderId"));
							o.setStaffId(rs.getInt("staffId"));
							o.setOrderId(rs.getInt("orderId"));
							orders.add(o);
						}

						// 5. close connection
						con.close();

					} catch (Exception e) {
						e.printStackTrace();

					}

					return orders;
				}

				// get cart by id

				public static OrderBean getOrderById(int id) {
					OrderBean o = new OrderBean();
					try {
						// call getConnection() method
						con = ConnectionManager.getConnection();

						// 3. create statement
						ps = con.prepareStatement("SELECT * FROM order WHERE orderId=?");
						ps.setInt(1, id);

						// 4. execute query
						rs = ps.executeQuery();
						if (rs.next()) {
							o.setOrderId(rs.getInt("orderId"));
							o.setCartId(rs.getInt("cartId"));
							o.setStaffId(rs.getInt("staffId"));
						}
						// 5. close connection
						con.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
					return o;
				}

}
