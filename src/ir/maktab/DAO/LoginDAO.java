package ir.maktab.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ir.maktab.model.User;

public class LoginDAO {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/paint";

	private static final String USER = "root";
	private static final String PASS = "";
	
	public User getUser(String usrName, String pass) {
		Connection conn = null;
		Statement stmt = null;
		User user = null;
		String uName = null;
		int id;
		String passWoord = null;
		
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			String sql = "SELECT * FROM users WHERE user_name='" + usrName + "' AND password='"+ pass + "'";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				id = rs.getInt("id");
				uName = rs.getString("user_name");
				passWoord = rs.getString("password");
				 user = new User(id,uName,passWoord);
				
			}

			
		} catch (Exception e) {

		} finally {

			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return user!=null?user:null;

		
	}
}
