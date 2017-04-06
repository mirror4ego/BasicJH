package basic;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Exam04 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			String sql = "select * from t86_board order by no desc";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getInt("no")+ "\t");
				System.out.print(rs.getString("title")+ "\t");
				System.out.print(rs.getString("writer")+ "\t");
				System.out.print(rs.getString("content")+ "\t");
				// 시간 정보를 유지하기 위해서는 getDate가 아닌 
				// getTimestamp
				System.out.print(new SimpleDateFormat("yy/MM/dd hh:mm:ss").format(rs.getTimestamp("reg_date"))+ " ");
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
