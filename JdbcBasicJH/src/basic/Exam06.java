package basic;

import java.sql.*;

public class Exam06 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			
			String title = "수정한 제목";
			String writer = "수정한 글쓴이";
			String content = "수정한 내용";
			int num = 11;
			
			String sql = "update t86_board "
					+ "	set title = ?, writer = ?, content = ?"
					+ " where no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			pstmt.setInt(4, num);
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "행이 수행됨");
							
			
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
