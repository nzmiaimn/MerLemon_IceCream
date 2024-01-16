package admin.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import admin.db.ConnectionManager;
import admin.model.AdminBean;

public class AdminDAO {

	static Connection con = null;
	static PreparedStatement ps = null;
	static java.sql.Statement stmt = null;
	static ResultSet rs = null;
	private int staffId;
	private String username, password;
	
	

	
	// addStaff

		public void addStaff(AdminBean bean) {

			username = bean.getUsername();
			password = bean.getPassword();

			try {
				// call getConnection() method
				con = ConnectionManager.getConnection();

				// 3. create statement
				ps = con.prepareStatement("INSERT INTO staff(username, password)VALUES(?,?)");
				ps.setString(1, username);
				ps.setString(2, password);

				// 4. execute query
				ps.executeUpdate();
				System.out.println("Successfully inserted");

				// 5. close connection
				con.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	//get all staffs
		public static List<AdminBean> getAllStaffs() {
			List<AdminBean> staffs = new ArrayList<AdminBean>();

			try {
				// call getConnection() method
				con = ConnectionManager.getConnection();

				// 3. create statement
				stmt = con.createStatement();
				String sql = "SELECT * FROM staff ORDER BY staffId";

				// 4. execute query
				rs = stmt.executeQuery(sql);

				while (rs.next()) { // process result
					AdminBean s = new AdminBean();
					s.setStaffId(rs.getInt("staffId"));
					s.setUsername(rs.getString("username"));
					s.setPassword(rs.getString("password"));
					staffs.add(s);
				}

				// 5. close connection
				con.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

			return staffs;
		}

		// get staff by id

		public static AdminBean getStaffById(int id) {
			AdminBean s = new AdminBean();
			try {
				// call getConnection() method
				con = ConnectionManager.getConnection();

				// 3. create statement
				ps = con.prepareStatement("SELECT * FROM staff WHERE staffId=?");
				ps.setInt(1, id);

				// 4. execute query
				rs = ps.executeQuery();
				if (rs.next()) {
					s.setStaffId(rs.getInt("staffId"));
					s.setUsername(rs.getString("username"));
					s.setPassword(rs.getString("password"));
				}
				// 5. close connection
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return s;
		}
		
		public static int getIdStaff(String username) {
			AdminBean s = new AdminBean();
			int id =0;
			try {
				// call getConnection() method
				con = ConnectionManager.getConnection();

				// 3. create statement
				ps = con.prepareStatement("SELECT * FROM staff WHERE username=?");
				ps.setString(1, username);

				// 4. execute query
				rs = ps.executeQuery();
				if (rs.next()) {
					id = rs.getInt("staffId");
					s.setUsername(rs.getString("username"));
					s.setPassword(rs.getString("password"));
				}
				// 5. close connection
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return id;
		}

		// delete staff
		public void deleteStaff(int id) {
			try {
				// call getConnection() method
				con = ConnectionManager.getConnection();

				// 3. create statement
				ps = con.prepareStatement("DELETE FROM staff WHERE staffId=?");
				ps.setInt(1, id);

				// 4. execute query
				ps.executeUpdate();

				// 5. close connection
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// update staff

		public void updateStaff(AdminBean bean) {

			staffId = bean.getStaffId();
			username = bean.getUsername();
			password = bean.getPassword();

			try {
				// call getConnection() method
				con = ConnectionManager.getConnection();

				// 3. create statement
				ps = con.prepareStatement("UPDATE staff SET username=?, password=? WHERE staffId=?");
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setInt(3, staffId);

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


		


