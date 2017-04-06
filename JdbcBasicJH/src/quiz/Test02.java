/*
 * 	번호를 입력하세요 : _3
 *  --------------------
 *  게시물이 존재하지 않습니다.
 *  --------------------
 *  
 *  번호를 입력하세요 : _7
 *  --------------------
 *  번호 : 7
 *  제목 : 홍기
 *  글쓴이 : ㅁㅁㅁ
 *  내용: ㅇㄴㄹㅇㄴㄹㄴ
 *  --------------------
 */
package quiz;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		while (true) {
			System.out.print("번호를 입력하세요 : ");
			int num = Integer.parseInt(sc.nextLine());
			if (num == -1) {
				System.out.println("종료합니다");
				break;
			}
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
				String sql = "select * from t86_board where no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				ResultSet rs = pstmt.executeQuery();
				System.out.println("-------------------------------");
				if (rs.next()) {
					System.out.printf("번호 \t: %d\n", rs.getInt("no"));
					System.out.printf("제목 \t: %s\n", rs.getString("title"));
					System.out.printf("글쓴이 \t: %s\n", rs.getString("writer"));
					System.out.printf("내용 \t: %s\n", rs.getString("content"));
					System.out.printf("등록일시 \t: %s\n",
							new SimpleDateFormat("yy/MM/dd hh:mm:ss").format(rs.getTimestamp("reg_date")));
				} else {
					System.out.println("게시물이 존재하지 않습니다.");
				}
				System.out.println("-------------------------------");

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
}
