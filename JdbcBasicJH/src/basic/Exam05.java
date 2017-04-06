package basic;

import java.sql.*;

public class Exam05 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			
			String title = "입력받은 제목";
			String writer = "입력받은 글쓴이";
			String content = "입력받은 내용";
			
//			String sql = "insert into t86_board( "
//					+ "   no, title, writer, content) "
//					+ " values (s86_board_no.nextval, '" + title + "','" + writer + "', '" + content + "')";

			String sql = "insert into t86_board(no, title, writer, content) "
					+ " values(s86_board_no.nextval, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			// 실행전에 ? 값을 설정해줘야 한다
			// 앞에 숫자는 물음표의 위치값, 뒤에는 변수
			int index = 0;
			pstmt.setString(++index, title); 
			pstmt.setString(++index, writer);
			pstmt.setString(++index, content);
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개의 행 변경됨");
			
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
