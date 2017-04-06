package advance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Exam04 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			String tableName = "t86_board";
			String sql = "select * from t86_board " + tableName;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			// ResultSet에 대한 MetaData 접근
			ResultSetMetaData rsmd = rs.getMetaData();

			// 조회된 컬럼의 카운트 얻기
			int columnCount = rsmd.getColumnCount();
			System.out.println("조회된 컬럼 카운트 : " + columnCount);
			for (int i = 1; i <= columnCount; i++) {
				rs.next();
				String cName = rsmd.getColumnName(i);
				String cTypeName = rsmd.getColumnTypeName(i);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(pstmt, null);
			ConnectionPool.releaseConnection(con);
		}
	}
}
