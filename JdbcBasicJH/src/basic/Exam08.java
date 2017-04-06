package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employee.EmployeeVO;

public class Exam08 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<EmployeeVO> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			String sql = "select employee_id, last_name, salary, department_id, email "
					+ " from employees ";
			
			pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				EmployeeVO ev = new EmployeeVO();
				ev.setEmployeeId(rs.getInt("employee_id"));
				ev.setLastName(rs.getString("last_name"));
				ev.setSalary(rs.getInt("salary"));
				ev.setDepartmentId(rs.getInt("department_id"));
				ev.seteMail(rs.getString("email"));
				list.add(ev);
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
			for (EmployeeVO emp : list) {
				System.out.println(emp.getLastName() + "\t" + emp.getSalary());
			}
		}
	}
}
