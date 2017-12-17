package ir.maktab.DAO;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpDAO {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/paint";

	private static final String USER = "root";
	private static final String PASS = "";
	
	public void addUser(int id,String user,String pass) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps=null;
		String sql=null;
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			 sql = "INSERT INTO users (id,user_name,password) " + "VALUES(?,?,?)";
			 ps=conn.prepareStatement(sql);
			    ps.setInt(1, id);
		        ps.setObject(2, user);
		        ps.setString(3, pass);
		        ps.executeUpdate();
			//stmt.executeUpdate(sql);

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

		
	}
	
}
