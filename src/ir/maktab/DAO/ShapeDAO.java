package ir.maktab.DAO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ir.maktab.shape.MShape;

public class ShapeDAO {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/paint";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public void add(MShape sh,int id) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps=null;
		String sql=null;
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = new ObjectOutputStream(bos);
	        
	        oos.writeObject(sh);
	        oos.flush();
	        oos.close();
	        bos.close();
	        byte[] data = bos.toByteArray();
			
			 sql = "INSERT INTO shapes (user_id,shape,color) " + "VALUES(?,?,?)";
			 ps=conn.prepareStatement(sql);
			    ps.setInt(1, id);
		        ps.setObject(2, data);
		        ps.setString(3, "n");
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
    

	public ArrayList<MShape> get(int id) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=null;
		MShape sh = null;
		ArrayList<MShape> shapes = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		
			
			sql="SELECT * FROM shapes WHERE user_id='"+id+"'";
			 ps=conn.prepareStatement(sql);
		      rs=  ps.executeQuery();
		   
		      ByteArrayInputStream bais;

	            ObjectInputStream ins = null;
	            while(rs.next()) {
	            bais = new ByteArrayInputStream(rs.getBytes("shape"));

	            ins = new ObjectInputStream(bais);
	             sh = (MShape) ins.readObject();
	             shapes.add(sh);
	            }
	            ins.close();
	          
		        
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
		return shapes;
		

	}
}
