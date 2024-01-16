package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import admin.db.ConnectionManager;
import admin.model.MenuBean;

public class MenuDAO {

	static Connection con = null;
	static PreparedStatement ps = null;
	static java.sql.Statement stmt = null;
	static ResultSet rs = null;
	private int staffId, menuId;
	private String menuName;
	private double menuPrice;
	private byte[] image;

	// addMenu

	public MenuBean addMenu(MenuBean menubean) {
		MenuBean m = null;

		menuName = menubean.getMenuName();
		menuPrice = menubean.getMenuPrice();
		image = menubean.getImage();
		staffId = menubean.getStaffId();

		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			ps = con.prepareStatement("INSERT INTO menu(menuName, menuPrice, image, staffId)VALUES(?,?,?,?)");
			ps.setString(1, menuName);
			ps.setDouble(2, menuPrice);
			ps.setBytes(3, image);
			ps.setInt(4, staffId);

			// 4. execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return m;
	}

	// get all menus
	public static List<MenuBean> getAllMenus() {
		List<MenuBean> menus = new ArrayList<MenuBean>();

		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM menu ORDER BY menuId";

			// 4. execute query
			rs = stmt.executeQuery(sql);

			while (rs.next()) { // process result
				MenuBean m = new MenuBean();
				m.setMenuId(rs.getInt("menuId"));
				m.setMenuName(rs.getString("menuName"));
				m.setMenuPrice(rs.getDouble("menuPrice"));
				String s = Base64.getEncoder().encodeToString(rs.getBytes("image"));
				m.setEncodedImage(s);
				m.setStaffId(rs.getInt("staffId"));
				menus.add(m);
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return menus;
	}

	// get menu by id

	public static MenuBean getMenuById(int id) {
		MenuBean m = new MenuBean();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			ps = con.prepareStatement("SELECT * FROM menu WHERE menuId=?");
			ps.setInt(1, id);

			// 4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {
				m.setMenuId(rs.getInt("menuId"));
				m.setMenuName(rs.getString("menuName"));
				m.setMenuPrice(rs.getDouble("menuPrice"));
				m.setImage(rs.getBytes("image"));
				m.setStaffId(rs.getInt("staffId"));
			}
			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	// delete menu
	public void deleteMenu(int id) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			ps = con.prepareStatement("DELETE FROM menu WHERE menuId=?");
			ps.setInt(1, id);

			// 4. execute query
			ps.executeUpdate();

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update menu

	public void updateMenu(MenuBean menubean) {

		menuId = menubean.getMenuId();
		menuName = menubean.getMenuName();
		menuPrice = menubean.getMenuPrice();
		image = menubean.getImage();
		staffId = menubean.getStaffId();

		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			ps = con.prepareStatement("UPDATE menu SET menuName=?, menuPrice=?, image=?, staffId=? WHERE menuId=?");
			ps.setString(1, menuName);
			ps.setDouble(2, menuPrice);
			ps.setBytes(3, image);
			ps.setInt(4, staffId);
			ps.setInt(5, menuId);

			// 4. execute query
			ps.executeUpdate();

			System.out.println("Successfully updated");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
