package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("부서아이디 : ");
		int inputNum = Integer.parseInt(sc.nextLine());
		printDepartment(inputNum);
		
	}
	
	public static void printDepartment (int inputNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			String sql = "select department_name, manager_id "
					+ " from departments"
					+ " where department_id = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, inputNum);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.printf("입력하신 부서아이디(%d) 에 해당하는\n", inputNum);
				System.out.printf("부서명 :: %s\n", rs.getString("department_name"));
				System.out.printf("부서장 아이디 :: %d\n", rs.getInt("manager_id"));
			} else {
				System.out.printf("입력하신 부서아이디(%d) 에 해당하는 부서명은 없습니다.\n",inputNum);
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
