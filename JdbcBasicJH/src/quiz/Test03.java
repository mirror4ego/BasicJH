package quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;
import util.ConnectionFactory;
import util.ConnectionPool;

public class Test03 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.print("테이블명 : ");
			String tableName = sc.nextLine();
			
			String sql = "select * from " + tableName;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			// ResultSet에 대한 MetaData 접근
			ResultSetMetaData rsmd = rs.getMetaData();
			// 조회된 컬럼의 카운트 얻기
			int columnCount = rsmd.getColumnCount();

			for (int i = 1 ; i <= columnCount; i++) {
				String cName = rsmd.getColumnName(i);
				System.out.print(cName+ "\t");
			}	
			System.out.println();
			while (rs.next()) {
				for (int i = 1 ; i <= columnCount; i++) {
					String cName = rsmd.getColumnName(i);
					System.out.print(rs.getString(cName)+ "\t");
				}			
				System.out.println();
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(pstmt, null);
			ConnectionPool.releaseConnection(con);
		}
	}
}
